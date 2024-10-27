package fr.kanassoulier.literomantik.game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.util.Arrays;
import java.util.HashMap;

import fr.kanassoulier.literomantik.enums.Biome;
import fr.kanassoulier.literomantik.enums.TileSide;
import fr.kanassoulier.literomantik.utils.Hexagon;

/**
 * Une tuile du jeu
 * 
 * @version 1.0
 * @author Gaston Chenet
 */
public class Tile extends Cell {
  /**
   * Nombre de milisecondes entre chaque déclanchement du scroll event
   */
  public static final int MIN_SCROLL_OFFSET = 40;

  private HashMap<TileSide, Biome> biomes = new HashMap<TileSide, Biome>();

  /**
   * Crée une tuile avec des biomes spécifiques
   * 
   * @param board  Le plateau de jeu
   * @param x      La coordonnée x du centre de la tuile
   * @param y      La coordonnée y du centre de la tuile
   * @param radius Le rayon de la tuile
   * @param biomes Les biomes de la tuile
   */
  public Tile(Board board, int x, int y, int radius, Biome... biomes) {
    super(board, x, y, radius);

    TileSide[] sides = TileSide.values();

    for (int i = 0; i < sides.length; i++) {
      this.biomes.put(sides[i], biomes[i]);
    }
  }

  /**
   * Crée une tuile avec des biomes spécifiques
   * 
   * @param board  Le plateau de jeu
   * @param x      La coordonnée x du centre de la tuile
   * @param y      La coordonnée y du centre de la tuile
   * @param radius Le rayon de la tuile
   */
  public Tile(Board board, int x, int y, int radius) {
    super(board, x, y, radius);
    this.refill();
  }

  /**
   * Crée une tuile avec des biomes spécifiques
   * 
   * @param board  Le plateau de jeu
   * @param center Le centre de la tuile
   * @param radius Le rayon de la tuile
   * @param biomes Les biomes de la tuile
   */
  public Tile(Board board, Point center, int radius, Biome... biomes) {
    this(board, center.x, center.y, radius, biomes);
  }

  /**
   * Crée une tuile avec des biomes aléatoires
   * 
   * @param board  Le plateau de jeu
   * @param center Le centre de la tuile
   * @param radius Le rayon de la tuile
   */
  public Tile(Board board, Point center, int radius) {
    this(board, center.x, center.y, radius);
  }

  /**
   * Pour définir les biomes de la tuile
   * 
   * @param biomes Les biomes de la tuile
   */
  public void setBiomes(Biome... biomes) {
    TileSide[] sides = TileSide.values();

    for (int i = 0; i < sides.length; i++) {
      this.biomes.put(sides[i], biomes[i]);
    }
  }

  /**
   * Remplit la tuile avec des biomes aléatoires
   */
  public void refill() {
    Game game = this.getBoard().getGame();
    Biome[] biomes = Biome.values();
    TileSide[] sides = TileSide.values();

    this.biomes.clear();

    Biome firstBiome = biomes[game.getRandomInt(biomes.length)];
    // Retirer le biome déjà choisi
    biomes = Arrays.stream(biomes).filter(biome -> biome != firstBiome).toArray(Biome[]::new);
    Biome secondBiome = biomes[game.getRandomInt(biomes.length)];

    int firstBiomeSize = game.getRandomInt(biomes.length + 1);
    int firstBiomeOffset = game.getRandomInt(sides.length);

    for (int i = 0; i < sides.length; i++) {
      TileSide side = sides[(i + firstBiomeOffset) % sides.length];
      Biome biome = i < firstBiomeSize ? firstBiome : secondBiome;

      this.biomes.put(side, biome);
    }
  }

  /**
   * Récupère le biome d'un côté de la tuile
   * 
   * @param side Le côté de la tuile
   * @return Le biome
   */
  public Biome getBiome(TileSide side) {
    return this.biomes.get(side);
  }

  /**
   * Récupère le biome le plus présent sur la tuile
   * 
   * @return Le biome dominant
   */
  private Biome getDominantBiome() {
    TileSide[] sides = TileSide.values();

    int firstBiomeCount = 0;
    int lastBiomeCount = 0;

    Biome firstBiome = this.getBiome(sides[0]);
    Biome secondBiome = null;

    for (int i = 0; i < sides.length; i++) {
      Biome biome = this.getBiome(sides[i]);

      if (biome.equals(firstBiome)) {
        firstBiomeCount++;
      } else {
        secondBiome = biome;
        lastBiomeCount++;
      }
    }

    if (firstBiomeCount > lastBiomeCount) {
      return firstBiome;
    } else if (firstBiomeCount < lastBiomeCount) {
      return secondBiome;
    }

    return null;
  }

  /**
   * Récupère les biomes de la tuile
   * 
   * @return Les biomes de la tuile
   */
  public Biome[] getBiomes() {
    Biome[] biomes = new Biome[TileSide.values().length];

    for (TileSide side : TileSide.values()) {
      biomes[side.ordinal()] = this.getBiome(side);
    }

    return biomes;
  }

  /**
   * Fait tourner la tuile
   * 
   * @param clockwise Sens de rotation
   */
  public void rotate(boolean clockwise) {
    TileSide[] sides = TileSide.values();
    HashMap<TileSide, Biome> newBiomes = new HashMap<TileSide, Biome>();

    for (int i = 0; i < sides.length; i++) {
      TileSide side = sides[i];
      TileSide newSide = clockwise ? sides[(i + 1) % sides.length] : sides[(i + sides.length - 1) % sides.length];
      newBiomes.put(newSide, this.biomes.get(side));
    }

    this.biomes = newBiomes;

    this.repaint();
  }

  /**
   * Vérifie si la tuile a un biome spécifique
   * 
   * @param biome Le biome à vérifier
   * @return Si la tuile a le biome
   */
  public boolean hasBiome(Biome biome) {
    for (TileSide side : TileSide.values()) {
      if (this.getBiome(side) == biome)
        return true;
    }

    return false;
  }

  /**
   * Récupère le côté d'un des hexagones de la tuile
   * 
   * @param x
   * @param y
   * @return Le côté de l'hexagone
   */
  private TileSide getSide(int x, int y) {
    int radius = this.getRadius();

    // 120 degrés pour décaler le 0 vers le haut
    TileSide[] sides = TileSide.values();
    double angle = Cell.to360Degrees(Math.toDegrees(Math.atan2(y - radius, x - radius)) + 120);

    // On considère un taux d'erreur de 2 degrés
    int floorSide = (int) Math.floor(Cell.to360Degrees(angle - 2) / 60);
    int ceilSide = (int) Math.floor(Cell.to360Degrees(angle + 2) / 60);

    if (floorSide == ceilSide) {
      return sides[floorSide];
    }

    Biome floorBiome = this.getBiome(sides[floorSide]);

    // L'arête dominante est celle qui fait partie du biome le plus au Sud

    Biome dominantBiome = this.getDominantBiome();

    if (dominantBiome == null && y > radius) {
      return TileSide.SOUTH;
    }

    if (dominantBiome == null && y < radius) {
      return TileSide.NORTH;
    }

    if (floorBiome.equals(dominantBiome)) {
      return sides[ceilSide];
    }

    return sides[floorSide];
  }

  /**
   * Dessine une rangée d'hexagones
   * 
   * @param g2d
   * @param rowX
   * @param rowY
   * @param radius  Le rayon de chaque hexagone
   * @param rowSize Le nombre d'hexagones dans la rangée
   */
  private void hexRow(Graphics2D g2d, double rowX, double rowY, double radius, int rowSize) {
    int gRadius = this.getRadius();

    for (int i = 0; i < rowSize; i++) {
      Color[] colors;

      int x = (int) Math.round(rowX + radius * Math.sqrt(3) * i);
      int y = (int) Math.round(rowY);

      if (x == Math.round(gRadius) && y == Math.round(gRadius)) {
        // Dans le schéma, le biome dominant est celui du centre

        Biome dominantBiome = this.getDominantBiome();

        if (dominantBiome == null) {
          colors = this.getBiome(TileSide.SOUTH).getBiomeColors();
        } else {
          colors = dominantBiome.getBiomeColors();
        }
      } else {
        colors = this.getBiome(this.getSide(x, y)).getBiomeColors();
      }

      g2d.setColor(colors[i % colors.length]);
      g2d.fillPolygon(new Hexagon(x, y, (int) Math.ceil(radius), 90));
    }
  }

  /**
   * Dessine la tuile
   * 
   * @param g     Le contexte graphique
   * @param scale L'échelle de la tuile
   */
  protected void paintComponent(Graphics g, float scale) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g.create();
    int radius = this.getRadius();
    Point center = new Point(radius, radius);
    radius = (int) (radius * scale);
    Hexagon hexagon = new Hexagon(center, radius);

    // Antialiasing pour rendre les hexagones plus jolis
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.setClip(hexagon);

    double fillHexRadius = radius / Math.sqrt(3) / 3;

    // Solution peu élégante pour dessiner les hexagones, mais elle fonctionne et ne
    // prend pas trop de place

    double paddingX = center.x - radius;
    double paddingY = center.y - radius;

    this.hexRow(g2d, paddingX + radius * 0.5, paddingY + radius - radius * Math.sqrt(3) / 2, fillHexRadius, 4);
    this.hexRow(g2d, paddingX, paddingY + radius - radius * Math.sqrt(3) / 3, fillHexRadius, 6);
    this.hexRow(g2d, paddingX - radius * 0.5, paddingY + radius - radius * Math.sqrt(3) / 6, fillHexRadius, 8);
    this.hexRow(g2d, paddingX - radius, paddingY + radius, fillHexRadius, 10);
    this.hexRow(g2d, paddingX - radius * 0.5, paddingY + radius + radius * Math.sqrt(3) / 6, fillHexRadius, 8);
    this.hexRow(g2d, paddingX, paddingY + radius + radius * Math.sqrt(3) / 3, fillHexRadius, 6);
    this.hexRow(g2d, paddingX + radius * 0.5, paddingY + radius + radius * Math.sqrt(3) / 2, fillHexRadius, 4);

    g2d.setClip(null);

    g2d.setStroke(new BasicStroke((int) radius / 15));
    g2d.setColor(Color.BLACK);
    g2d.drawPolygon(hexagon);

    g2d.dispose();
  }

  @Override
  public void paintComponent(Graphics g) {
    this.paintComponent(g, 1f);
  }
}
