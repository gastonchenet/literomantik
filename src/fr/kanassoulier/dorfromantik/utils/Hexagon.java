package fr.kanassoulier.dorfromantik.utils;

import java.awt.Polygon;

public class Hexagon extends Polygon {
  public Hexagon(int x, int y, int radius, double startAngle) {
    for (int i = 0; i < 6; i++) {
      double angleRad = Math.toRadians(i * 60 + startAngle);

      this.addPoint(
          (int) (x + radius * Math.cos(angleRad)),
          (int) (y + radius * Math.sin(angleRad)));
    }
  }

  public Hexagon(int x, int y, int radius) {
    this(x, y, radius, 0);
  }
}
