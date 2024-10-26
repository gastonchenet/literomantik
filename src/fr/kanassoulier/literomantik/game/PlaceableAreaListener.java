package fr.kanassoulier.literomantik.game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * L'implémentation des méthodes de Swing pour la classe PlaceableArea.
 * 
 * @version 1.1
 * @author Maxence Raymond, Gaston Chenet
 * @see PlaceableArea
 */
public class PlaceableAreaListener implements MouseListener, MouseMotionListener {
  private boolean mouseOver = false;
  private PlaceableArea area;

  public PlaceableAreaListener(PlaceableArea area) {
    this.area = area;
  }

  public boolean isMouseOver() {
    return this.mouseOver;
  }

  @Override
  public void mouseEntered(MouseEvent e) {
  }

  @Override
  public void mouseExited(MouseEvent e) {
    boolean oldMouseOver = this.mouseOver;
    this.mouseOver = false;

    if (oldMouseOver != this.mouseOver) {
      this.area.repaint();
    }
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    this.area.getBoard().placeTile(this.area);
  }

  @Override
  public void mousePressed(MouseEvent e) {
  }

  @Override
  public void mouseReleased(MouseEvent e) {
  }

  @Override
  public void mouseDragged(MouseEvent e) {
  }

  @Override
  public void mouseMoved(MouseEvent e) {
    boolean oldMouseOver = this.mouseOver;
    this.mouseOver = this.area.getHexagon().contains(e.getPoint());

    if (oldMouseOver != this.mouseOver) {
      this.area.repaint();
    }
  }
}
