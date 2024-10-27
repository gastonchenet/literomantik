package fr.kanassoulier.literomantik.components;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Classe permettant de gérer les événements de souris sur un KCheckBoxContent
 * 
 * @version 1.0
 * @author Gaston Chenet
 */
public class KCheckBoxContentListener implements MouseListener {
  private KCheckBoxContent content;
  private boolean mouseOver = false;

  /**
   * Constructeur de KCheckBoxContentListener
   * 
   * @param content Le contenu de la case à cocher à écouter
   */
  public KCheckBoxContentListener(KCheckBoxContent content) {
    this.content = content;
  }

  /**
   * Permet de savoir si la souris est sur le contenu de la case à cocher
   * 
   * @return true si la souris est sur le contenu de la case à cocher, false sinon
   */
  public boolean isMouseOver() {
    return this.mouseOver;
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    this.content.setChecked(!this.content.isChecked());
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    this.mouseOver = true;
  }

  @Override
  public void mouseExited(MouseEvent e) {
    this.mouseOver = false;
  }

  @Override
  public void mousePressed(MouseEvent e) {
  }

  @Override
  public void mouseReleased(MouseEvent e) {
  }
}
