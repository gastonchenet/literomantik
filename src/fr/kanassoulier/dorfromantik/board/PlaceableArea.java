package fr.kanassoulier.dorfromantik.board;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import fr.kanassoulier.dorfromantik.Options;
import fr.kanassoulier.dorfromantik.utils.Hexagon;

public class PlaceableArea extends Cell implements MouseMotionListener, MouseListener {
  private static final float RADIUS_MULTIPLIER = 0.4f;
  private static final float HOVER_RADIUS_MULTIPLIER = 0.6f;

  private boolean mouseOver = false;

  public PlaceableArea(Board board, int x, int y) {
    super(board, x, y, Options.CELL_RADIUS);

    this.addMouseMotionListener(this);
    this.addMouseListener(this);
  }

  public PlaceableArea(Board board, Point center) {
    this(board, center.x, center.y);
  }

  private Hexagon getHexagon() {
    int radius = this.getRadius();

    return new Hexagon(radius, radius,
        (int) Math.round(
            radius * (this.mouseOver ? PlaceableArea.HOVER_RADIUS_MULTIPLIER : PlaceableArea.RADIUS_MULTIPLIER)));
  }

  @Override
  public void mouseDragged(MouseEvent e) {
  }

  @Override
  public void mouseMoved(MouseEvent e) {
    this.mouseOver = this.getHexagon().contains(e.getPoint());
    this.repaint();
  }

  @Override
  public void mouseClicked(MouseEvent e) {
  }

  @Override
  public void mouseEntered(MouseEvent e) {
  }

  @Override
  public void mouseExited(MouseEvent e) {
    this.mouseOver = false;
    this.repaint();
  }

  @Override
  public void mousePressed(MouseEvent e) {
    if (!this.mouseOver)
      return;

    this.getBoard().placeTile(this);
  }

  @Override
  public void mouseReleased(MouseEvent e) {
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g.create();

    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.setColor(new Color(215, 215, 215));
    g2d.fillPolygon(this.getHexagon());

    g2d.dispose();
  }
}
