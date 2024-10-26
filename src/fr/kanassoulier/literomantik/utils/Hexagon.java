package fr.kanassoulier.literomantik.utils;

import java.awt.Point;
import java.awt.Polygon;

/**
 * Classe représentant un hexagone
 * 
 * @version 1.0
 * @author Gaston Chenet
 */
public class Hexagon extends Polygon {
  /**
   * Constructeur d'un hexagone
   * 
   * @param x          Position x du centre de l'hexagone
   * @param y          Position y du centre de l'hexagone
   * @param radius     Rayon de l'hexagone
   * @param startAngle Angle de départ de l'hexagone
   */
  public Hexagon(int x, int y, int radius, double startAngle) {
    for (int i = 0; i < 6; i++) {
      double angleRad = Math.toRadians(i * 60 + startAngle);

      this.addPoint(
          (int) (x + radius * Math.cos(angleRad)),
          (int) (y + radius * Math.sin(angleRad)));
    }
  }

  /**
   * Constructeur d'un hexagone
   * 
   * @param center     Centre de l'hexagone
   * @param radius     Rayon de l'hexagone
   * @param startAngle Angle de départ de l'hexagone
   */
  public Hexagon(Point center, int radius, double startAngle) {
    this(center.x, center.y, radius, startAngle);
  }

  /**
   * Constructeur d'un hexagone
   * 
   * @param x      Position x du centre de l'hexagone
   * @param y      Position y du centre de l'hexagone
   * @param radius Rayon de l'hexagone
   */
  public Hexagon(int x, int y, int radius) {
    this(x, y, radius, 0);
  }

  /**
   * Constructeur d'un hexagone
   * 
   * @param center Centre de l'hexagone
   * @param radius Rayon de l'hexagone
   */
  public Hexagon(Point center, int radius) {
    this(center.x, center.y, radius, 0);
  }
}
