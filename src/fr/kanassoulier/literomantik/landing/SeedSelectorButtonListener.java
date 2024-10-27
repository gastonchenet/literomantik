package fr.kanassoulier.literomantik.landing;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import fr.kanassoulier.literomantik.game.Game;
import fr.kanassoulier.literomantik.utils.Seed;

/**
 * Classe permettant de gérer les événements de souris sur un SeedSelectorButton
 * 
 * @version 1.0
 * @author Gaston Chenet
 */
public class SeedSelectorButtonListener implements MouseListener {
  private boolean mouseOver = false;
  private SeedSelectorButton button;
  private LandingMenu menu;
  private Seed seed;

  /**
   * Constructeur de SeedSelectorButtonListener
   * 
   * @param button Le bouton à écouter
   * @param menu   Le menu de landing
   * @param seed   La graine du bouton
   */
  public SeedSelectorButtonListener(SeedSelectorButton button, LandingMenu menu, Seed seed) {
    this.button = button;
    this.menu = menu;
    this.seed = seed;
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
    SwingUtilities.getWindowAncestor(this.button).dispose();
    this.menu.dispose();
    new Game(this.seed.value).setVisible(true);
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
