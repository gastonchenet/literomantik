package fr.kanassoulier.dorfromantik.board;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

import fr.kanassoulier.dorfromantik.enums.Biome;
import fr.kanassoulier.dorfromantik.enums.TileSide;
import fr.kanassoulier.dorfromantik.utils.Hexagon;

public abstract class Tile extends Cell {
  private HashMap<TileSide, Biome> biomes = new HashMap<TileSide, Biome>();

  public Tile(Board board, int x, int y, int radius, Biome... biomes) {
    super(board, x, y, radius);

    TileSide[] sides = TileSide.values();

    for (int i = 0; i < sides.length; i++) {
      this.biomes.put(sides[i], biomes[i]);
    }
  }

  public Tile(Board board, int x, int y, int radius) {
    super(board, x, y, radius);
    this.refill();
  }

  /**
   * Remplit la tuile avec des biomes aléatoires
   */
  public void refill() {
    Random random = new Random();
    Biome[] biomes = Biome.values();
    TileSide[] sides = TileSide.values();

    this.biomes.clear();

    Biome firstBiome = biomes[random.nextInt(biomes.length)];
    // Retirer le biome déjà choisi
    biomes = Arrays.stream(biomes).filter(biome -> biome != firstBiome).toArray(Biome[]::new);
    Biome secondBiome = biomes[random.nextInt(biomes.length)];

    int firstBiomeSize = random.nextInt(biomes.length + 1);
    int firstBiomeOffset = random.nextInt(sides.length);

    for (int i = 0; i < sides.length; i++) {
      TileSide side = sides[(i + firstBiomeOffset) % sides.length];
      Biome biome = i < firstBiomeSize ? firstBiome : secondBiome;

      this.biomes.put(side, biome);
    }
  }

  public Tile(Board board, Point center, int radius, Biome... biomes) {
    this(board, center.x, center.y, radius, biomes);
  }

  public Tile(Board board, Point center, int radius) {
    this(board, center.x, center.y, radius);
  }

  public Biome getBiome(TileSide side) {
    return this.biomes.get(side);
  }

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

    // On considère un taux d'erreur de 1 degré
    int floorSide = (int) Math.floor(Cell.to360Degrees(angle - 1) / 60);
    int ceilSide = (int) Math.floor(Cell.to360Degrees(angle + 1) / 60);

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

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    int radius = this.getRadius();
    Hexagon hexagon = new Hexagon(radius, radius, radius);

    // Antialiasing pour rendre les hexagones plus jolis
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.setClip(hexagon);

    double fillHexRadius = radius / Math.sqrt(3) / 3;

    // Solution peu élégante pour dessiner les hexagones, mais elle fonctionne et ne
    // prend pas trop de place

    this.hexRow(g2d, radius * 0.5, radius - radius * Math.sqrt(3) / 2, fillHexRadius, 4);
    this.hexRow(g2d, 0, radius - radius * Math.sqrt(3) / 3, fillHexRadius, 6);
    this.hexRow(g2d, -radius * 0.5, radius - radius * Math.sqrt(3) / 6, fillHexRadius, 8);
    this.hexRow(g2d, -radius, radius, fillHexRadius, 10);
    this.hexRow(g2d, -radius * 0.5, radius + radius * Math.sqrt(3) / 6, fillHexRadius, 8);
    this.hexRow(g2d, 0, radius + radius * Math.sqrt(3) / 3, fillHexRadius, 6);
    this.hexRow(g2d, radius * 0.5, radius + radius * Math.sqrt(3) / 2, fillHexRadius, 4);

    g2d.setClip(null);

    g2d.setStroke(new BasicStroke(3));
    g2d.setColor(Color.BLACK);
    g2d.drawPolygon(hexagon);

    g2d.dispose();
  }
}
