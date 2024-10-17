package fr.kanassoulier.dorfromantik.gui;

import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.JLabel;

import fr.kanassoulier.dorfromantik.Game;
import fr.kanassoulier.dorfromantik.board.Board;
import fr.kanassoulier.dorfromantik.board.Cell;
import fr.kanassoulier.dorfromantik.board.PlaceableTile;
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

  private Gui gui;

  public Scoreboard(Gui gui) {
    super("0", JLabel.CENTER);

    this.gui = gui;

    this.setBounds(0, 0, Game.WINDOW_WIDTH, Scoreboard.HEIGHT);

    try {
      Font font = Font.createFont(Font.TRUETYPE_FONT, new File("./resources/fonts/Lexend-Bold.ttf")).deriveFont(30f);

      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      ge.registerFont(font);

      this.setFont(font);
    } catch (IOException | FontFormatException e) {
      e.printStackTrace();
    }
  }

  /**
   * Grouper les poches d'un biome spécifique à partir d'une tuile.
   * 
   * @param tile          La tuile à analyser.
   * @param biome         Le biome à chercher.
   * @param visited       Les tuiles déjà visitées.
   * @param currentPocket L'identifiant de la poche actuelle.
   * @return Les tuiles visitées et leur poche.
   */
  private HashMap<String, Integer> groupPocket(PlaceableTile tile, Biome biome, HashMap<String, Integer> visited,
      int currentPocket) {
    String discriminator = tile.getDiscriminator();

    if (visited.containsKey(discriminator)) {
      return visited;
    }

    visited.put(discriminator, tile.hasBiome(biome) ? currentPocket : -1);

    for (TileSide side : TileSide.values()) {
      Cell neighbor = tile.getNeighbor(side);
      String neighborDiscriminator = neighbor.getDiscriminator();

      if (neighbor == null || !(neighbor instanceof PlaceableTile) || visited.containsKey(neighborDiscriminator)) {
        continue;
      }

      if (tile.getBiome(side) != biome || !tile.matchesWith(side)) {
        if (!((PlaceableTile) neighbor).hasBiome(biome)) {
          visited.put(neighborDiscriminator, -1);
        }

        continue;
      }

      HashMap<String, Integer> pockets = this.groupPocket((PlaceableTile) neighbor, biome, visited, currentPocket);
      visited.putAll(pockets);
    }

    return visited;
  }

  /**
   * Mettre à jour le score du joueur.
   */
  public void updateScore() {
    int score = 0;
    Board board = this.gui.getGame().getBoard();

    for (Biome biome : Biome.values()) {
      HashMap<String, Integer> pockets = new HashMap<>();
      int lastBiome = 0;

      for (Component component : board.getComponents()) {
        if (!(component instanceof PlaceableTile))
          continue;

        PlaceableTile tile = (PlaceableTile) component;

        if (pockets.containsKey(tile.getDiscriminator()))
          continue;

        int visitedCount = pockets.size();

        this.groupPocket(tile, biome, pockets, lastBiome);

        if (visitedCount < pockets.size()) {
          lastBiome++;
        }
      }

      for (int value : pockets.values()) {
        lastBiome = Integer.max(lastBiome, value);
      }

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
