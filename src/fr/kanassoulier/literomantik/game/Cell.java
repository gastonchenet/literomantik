package fr.kanassoulier.literomantik.game;

import java.awt.Point;

import javax.swing.JComponent;

import fr.kanassoulier.literomantik.enums.TileSide;
import fr.kanassoulier.literomantik.utils.Hexagon;

/**
 * Une cellule du plateau de jeu.
 * 
 * @version 1.0
 * @author Gaston Chenet
 */
public abstract class Cell extends JComponent {
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
    this.board = board;
    this.radius = radius;
    this.x = x;
    this.y = y;

    this.setBounds(x - radius,
        y - radius,
        radius * 2,
        radius * 2);

    // On veut que le JPanel soit transparent pour ne pas cacher les autres éléments
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
   * Définir le centre de la cellule.
   * 
   * @param center Le centre de la cellule
   */
  public void setCenter(Point center) {
    this.x = center.x;
    this.y = center.y;

    int radius = this.getRadius();

    this.setBounds(center.x - radius,
        center.y - radius,
        radius * 2,
        radius * 2);
  }

  /**
   * Définir le centre de la cellule.
   * 
   * @param x Axe x
   * @param y Axe y
   */
  public void setCenter(int x, int y) {
    this.setCenter(new Point(x, y));
  }

  /**
   * Récupérer le centre de la cellule dans le viewport.
   * 
   * @return le centre de la cellule dans le viewport
   */
  public Point getViewportCenter() {
    return new Point(
        this.board.getCenter().x + (this.x - this.board.getWidth() / 2),
        this.board.getCenter().y + (this.y - this.board.getHeight() / 2));
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
   * Définir le rayon de la cellule.
   * 
   * @param radius Rayon de la cellule
   */
  public void setRadius(int radius) {
    this.radius = radius;
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
