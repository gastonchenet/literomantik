package fr.kanassoulier.dorfromantik.landing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import fr.kanassoulier.dorfromantik.components.KButton;

public class LandingMenuControlButtonListener implements ActionListener {
  private KButton button;

  public LandingMenuControlButtonListener(KButton button) {
    this.button = button;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
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
}
