package fr.kanassoulier.literomantik.components;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Classe permettant de gérer les événements de souris sur un KTextFieldSubmit
 */
public class KTextFieldSubmitListener implements MouseListener {
  private boolean mouseOver = false;
  private KTextFieldSubmit button;

  /**
   * Constructeur de KTextFieldSubmitListener
   * 
   * @param button Le bouton à écouter
   */
  public KTextFieldSubmitListener(KTextFieldSubmit button) {
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
