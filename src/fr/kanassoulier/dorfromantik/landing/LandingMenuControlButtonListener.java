package fr.kanassoulier.dorfromantik.landing;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class LandingMenuControlButtonListener implements MouseListener {
  private LandingMenuControlButton button;
  private boolean mouseOver = false;

  public LandingMenuControlButtonListener(LandingMenuControlButton button) {
    this.button = button;
  }

  public boolean isMouseOver() {
    return this.mouseOver;
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    LandingMenuControlButton button = (LandingMenuControlButton) e.getSource();

    switch (button.getType()) {
      case START_GAME:
        new SeedSelector((JFrame) SwingUtilities.getWindowAncestor(this.button)).setVisible(true);
        break;

      case LEAVE_GAME:
        SwingUtilities.getWindowAncestor(this.button).dispose();
        break;

      case SETTINGS:
        break;

      default:
        throw new IllegalArgumentException("Invalid button type");
    }
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
