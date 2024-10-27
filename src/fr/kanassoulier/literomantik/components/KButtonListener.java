package fr.kanassoulier.literomantik.components;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Classe permettant de gérer les événements de souris sur un KButton
 * 
 * @version 1.0
 * @author Gaston Chenet
 */
public class KButtonListener implements MouseListener {
  private KButton button;
  private boolean mouseOver = false;

  /**
   * Constructeur de KButtonListener
   * 
   * @param button Le bouton à écouter
   */
  public KButtonListener(KButton button) {
    this.button = button;
  }

  /**
   * Permet de savoir si la souris est sur le bouton
   * 
   * @return true si la souris est sur le bouton, false sinon
   */
  public boolean isMouseOver() {
    return this.mouseOver;
  }

  @Override
  public void mouseClicked(MouseEvent e) {
  }

  @Override
  public void mousePressed(MouseEvent e) {
  }

  @Override
  public void mouseReleased(MouseEvent e) {
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    this.button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    this.mouseOver = true;
    this.button.repaint();
  }

  @Override
  public void mouseExited(MouseEvent e) {
    this.button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    this.mouseOver = false;
    this.button.repaint();
  }
}
