package fr.kanassoulier.dorfromantik.landing;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import java.awt.event.MouseEvent;

public class StartGameButton extends MainControlButton {
  public StartGameButton() {
    super("Commencer une partie");
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    new SeedSelector((JFrame) SwingUtilities.getWindowAncestor(this)).setVisible(true);
  }
}
