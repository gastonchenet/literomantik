package fr.kanassoulier.literomantik.landing;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import fr.kanassoulier.literomantik.game.Game;

public class SeedSelectorButtonListener implements MouseListener {
  private boolean mouseOver = false;
  private SeedSelectorButton button;
  private LandingMenu menu;
  private long seed;

  public SeedSelectorButtonListener(SeedSelectorButton button, LandingMenu menu, long seed) {
    this.button = button;
    this.menu = menu;
    this.seed = seed;
  }

  public boolean isMouseOver() {
    return this.mouseOver;
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    SwingUtilities.getWindowAncestor(this.button).dispose();
    this.menu.dispose();
    new Game(this.seed).setVisible(true);
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
