package fr.kanassoulier.literomantik.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;

import fr.kanassoulier.literomantik.Options;
import fr.kanassoulier.literomantik.utils.Hexagon;

/**
 * Une zone où l'on peut placer une tuile
 * 
 * @version 1.1
 * @author Gaston Chenet, Maxence Raymond
 */
public class PlaceableArea extends Tile {
  /**
   * Multiplieur du rayon de la zone
   */
  private static final float RADIUS_MULTIPLIER = 0.4f, HOVER_RADIUS_MULTIPLIER = 0.6f;

  private PlaceableAreaListener listener;

  /**
   * Crée une zone où l'on peut placer une tuile
   * 
   * @param board Le plateau de jeu
   * @param x     La coordonnée x du centre de la zone
   * @param y     La coordonnée y du centre de la zone
   */
  public PlaceableArea(Board board, int x, int y) {
    super(board, x, y, Options.CELL_RADIUS);

    this.listener = new PlaceableAreaListener(this);
    this.addMouseListener(this.listener);
    this.addMouseMotionListener(this.listener);
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
  public Hexagon getHexagon() {
    int radius = this.getRadius();

    return new Hexagon(radius, radius,
        (int) Math.round(
            radius
                * (this.listener.isMouseOver() ? PlaceableArea.HOVER_RADIUS_MULTIPLIER * 1.1f
                    : PlaceableArea.RADIUS_MULTIPLIER)));
  }

  /**
   * Récupérer le listener de la zone
   * 
   * @return le listener de la zone
   */
  public PlaceableAreaListener getListener() {
    return this.listener;
  }

  @Override
  public void paintComponent(Graphics g) {
    this.setBiomes(this.getBoard().getGame().getGui().getPreviewTile().getBiomes());

    Graphics2D g2d = (Graphics2D) g.create();

    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    if (this.listener.isMouseOver()) {
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
