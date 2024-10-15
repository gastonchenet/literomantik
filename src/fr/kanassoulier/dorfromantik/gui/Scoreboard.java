package fr.kanassoulier.dorfromantik.gui;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.JLabel;

import fr.kanassoulier.dorfromantik.Game;
import fr.kanassoulier.dorfromantik.board.Cell;
import fr.kanassoulier.dorfromantik.board.Tile;
import fr.kanassoulier.dorfromantik.enums.Biome;
import fr.kanassoulier.dorfromantik.enums.TileSide;

/**
 * Le scoreboard du jeu ainsi que son affichage.
 * 
 * @version 1.0
 * @author Gaston Chenet
 */
public class Scoreboard extends JLabel {
  /**
   * La hauteur du scoreboard.
   */
  private static final int HEIGHT = 50;

  public Scoreboard() {
    super("0", JLabel.CENTER);

    this.setBounds(0, 0, Game.WINDOW_WIDTH, Scoreboard.HEIGHT);

    try {
      Font font = Font.createFont(Font.TRUETYPE_FONT, new File("./resources/fonts/Lexend.ttf")).deriveFont(30f);

      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      ge.registerFont(font);

      this.setFont(font);
    } catch (IOException | FontFormatException e) {
      e.printStackTrace();
    }
  }

  private HashMap<String, Integer> getPockets(Tile tile, Biome biome, HashMap<String, Integer> visited,
      int currentPocket) {
    String discriminator = tile.getDiscriminator();

    if (visited.containsKey(discriminator)) {
      return visited;
    }

    boolean hasBiome = tile.hasBiome(biome);

    if (hasBiome) {
      visited.put(discriminator, currentPocket);

      for (TileSide side : TileSide.values()) {
        if (tile.matchesWith(side)) {
          Cell neighbor = tile.getNeighbor(side);

          if (neighbor instanceof Tile) {
            visited.putAll(this.getPockets((Tile) neighbor, biome, visited, currentPocket));
          }
        }
      }
    } else {
      visited.put(discriminator, -1);
    }

    for (TileSide side : TileSide.values()) {
      if (tile.getBiome(side) == biome && tile.matchesWith(side))
        continue;

      Cell neighbor = tile.getNeighbor(side);
      String neighborDiscriminator = neighbor.getDiscriminator();

      if (visited.containsKey(neighborDiscriminator)) {
        continue;
      }

      if (neighbor instanceof Tile) {
        visited.putAll(this.getPockets((Tile) neighbor, biome, visited, currentPocket + (hasBiome ? 1 : 0)));
      }
    }

    return visited;
  }

  private HashMap<String, Integer> getPockets(Tile tile, Biome biome) {
    return this.getPockets(tile, biome, new HashMap<>(), 0);
  }

  /**
   * Mettre à jour le score du joueur.
   * 
   * @param rootTile La tuile racine du plateau
   */
  public void updateScore(Tile tile) {
    System.out.println("-----------------------------");
    int score = 0;

    for (Biome biome : Biome.values()) {
      HashMap<String, Integer> pockets = this.getPockets(tile, biome);
      int lastBiome = 0;

      for (int value : pockets.values()) {
        lastBiome = Integer.max(lastBiome, value);
      }

      System.out.println(biome + " " + Arrays.asList(pockets) + " " + lastBiome);

      int[] pocketSizes = new int[lastBiome + 1];
      Arrays.fill(pocketSizes, 0);

      for (int pocket : pockets.values()) {
        if (pocket < 0)
          continue;

        pocketSizes[pocket]++;
      }

      for (int size : pocketSizes) {
        score += (int) Math.pow(size, 2);
      }
    }

    this.setText(Integer.toString(score));
  }
}
