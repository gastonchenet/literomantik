package fr.kanassoulier.dorfromantik.board;

import java.awt.Point;

import javax.swing.JPanel;

import fr.kanassoulier.dorfromantik.enums.TileSide;
import fr.kanassoulier.dorfromantik.utils.Hexagon;

/**
 * Une cellule du plateau de jeu.
 * 
 * @version 1.0
 * @author Gaston Chenet
 */
public abstract class Cell extends JPanel {
  private Board board;
  private int x, y, radius;

  /**
   * Pour convertir empécher les angles négatifs et les angles supérieurs à 360°
   * 
   * @param angle
   * @return l'angle entre 0 et 360°
   */
  protected static double to360Degrees(double angle) {
    while (angle < 0) {
      angle += 360;
    }

    return angle % 360;
  }

  /**
   * Créer une cellule avec un centre et un rayon.
   * 
   * @param board  Le plateau de jeu
   * @param x      La coordonnée x du centre de la cellule
   * @param y      La coordonnée y du centre de la cellule
   * @param radius Le rayon de la cellule
   */
  protected Cell(Board board, int x, int y, int radius) {
    // On veut que le JPanel soit transparent pour ne pas cacher les autres éléments
    super(true);

    this.board = board;
    this.radius = radius;
    this.x = x;
    this.y = y;

    this.setBounds(x - radius, y - radius, radius * 2, radius * 2);
    this.setOpaque(false);
  }

  /**
   * Créer une cellule avec un centre et un rayon.
   * 
   * @param board  Le plateau de jeu
   * @param center Le centre de la cellule
   * @param radius Le rayon de la cellule
   */
  protected Cell(Board board, Point center, int radius) {
    this(board, center.x, center.y, radius);
  }

  /**
   * Récupérer le plateau de jeu.
   * 
   * @return le plateau de jeu
   */
  protected Board getBoard() {
    return this.board;
  }

  /**
   * Récupérer le centre de la cellule.
   * 
   * @return le centre de la cellule
   */
  public Point getCenter() {
    return new Point(this.x, this.y);
  }

  /**
   * Récupérer le rayon de la cellule.
   * 
   * @return le rayon de la cellule
   */
  public int getRadius() {
    return this.radius;
  }

  /**
   * Vérifier si un point est sur la cellule.
   */
  public boolean at(int x, int y) {
    return new Hexagon(this.x, this.y, this.radius).contains(x, y);
  }

  /**
   * Vérifier si un point est sur la cellule.
   */
  public boolean at(Point point) {
    return this.at(point.x, point.y);
  }

  /**
   * Récupérer le discriminant de la cellule.
   * 
   * @return le discriminant de la cellule
   */
  public String getDiscriminator() {
    Point center = this.getCenter();
    return center.x + "," + center.y;
  }

  /**
   * Récupérer le voisin d'une cellule.
   * 
   * @param side Le côté du voisin
   * @return le voisin
   */
  public Cell getNeighbor(TileSide side) {
    int x = this.x;
    int y = this.y;

    switch (side) {
      case NORTH:
        y -= this.radius * Math.sqrt(3);
        break;

      case NORTH_EAST:
        x += this.radius * 1.5;
        y -= this.radius * Math.sqrt(3) / 2;
        break;

      case SOUTH_EAST:
        x += this.radius * 1.5;
        y += this.radius * Math.sqrt(3) / 2;
        break;

      case SOUTH:
        y += this.radius * Math.sqrt(3);
        break;

      case SOUTH_WEST:
        x -= this.radius * 1.5;
        y += this.radius * Math.sqrt(3) / 2;
        break;

      case NORTH_WEST:
        x -= this.radius * 1.5;
        y -= this.radius * Math.sqrt(3) / 2;
        break;
    }

    return this.board.getCell(x, y);
  }
}
