package fr.kanassoulier.dorfromantik.landing;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import fr.kanassoulier.dorfromantik.components.KButton;

public class LandingMenuControlButtonListener implements MouseListener {
  private KButton button;

  public LandingMenuControlButtonListener(KButton button) {
    this.button = button;
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    KButton button = (KButton) e.getSource();

    switch (button.getType()) {
      case PLAY:
        new SeedSelector((LandingMenu) SwingUtilities.getWindowAncestor(this.button)).setVisible(true);
        break;

      case QUIT:
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
  }

  @Override
  public void mouseExited(MouseEvent e) {
  }
}
