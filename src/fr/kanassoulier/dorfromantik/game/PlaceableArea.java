package fr.kanassoulier.dorfromantik.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;

import fr.kanassoulier.dorfromantik.Options;
import fr.kanassoulier.dorfromantik.utils.Hexagon;

/**
 * Une zone où l'on peut placer une tuile
 * 
 * @version 1.1
 * @author Gaston Chenet
 * @author Maxence Raymond
 */
public class PlaceableArea extends Tile {
  private static final float RADIUS_MULTIPLIER = 0.4f, HOVER_RADIUS_MULTIPLIER = 0.6f;

  private boolean mouseOver = false;

  /**
   * Crée une zone où l'on peut placer une tuile
   * 
   * @param board Le plateau de jeu
   * @param x     La coordonnée x du centre de la zone
   * @param y     La coordonnée y du centre de la zone
   */
  public PlaceableArea(Board board, int x, int y) {
    super(board, x, y, Options.CELL_RADIUS);
    this.addMouseListener(new PlaceableAreaListener(this));
  }

  /**
   * Crée une zone où l'on peut placer une tuile
   * 
   * @param board  Le plateau de jeu
   * @param center Le centre de la zone
   * @param biomes Les biomes de la zone
   */
  public PlaceableArea(Board board, Point center) {
    this(board, center.x, center.y);
  }

  /**
   * Récupérer l'hexagone de la zone
   * 
   * @return l'hexagone de la zone
   */
  private Hexagon getHexagon() {
    int radius = this.getRadius();

    return new Hexagon(radius, radius,
        (int) Math.round(
            radius
                * (this.mouseOver ? PlaceableArea.HOVER_RADIUS_MULTIPLIER * 1.1f : PlaceableArea.RADIUS_MULTIPLIER)));
  }

  /**
   * Permet de modifier l'attribut quand la souris survole l'élément
   * 
   * @param entree la valeur modifiée
   */
  void setMouseOver(boolean entree) {
    this.mouseOver = entree;
    this.repaint();
  }

  /**
   * Indique au gestionnaire de placer la tuile
   */
  void placeTile() {
    this.getBoard().placeTile(this);
  }

  /**
   * Savoir si la souris est sur la zone
   * 
   * @return Vrai si la souris est sur la zone, faux sinon
   */
  public boolean isMouseOver() {
    return this.mouseOver;
  }

  @Override
  public void paintComponent(Graphics g) {
    this.setBiomes(this.getBoard().getGame().getGui().getPreviewTile().getBiomes());

    Graphics2D g2d = (Graphics2D) g.create();

    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    if (mouseOver) {
      super.paintComponent(g, PlaceableArea.HOVER_RADIUS_MULTIPLIER);
      g2d.setColor(new Color(255, 255, 255, 100));
      g2d.fillPolygon(this.getHexagon());
    } else {
      g2d.setColor(new Color(215, 215, 215));
      g2d.fillPolygon(this.getHexagon());

      g2d.dispose();
    }
  }
}
