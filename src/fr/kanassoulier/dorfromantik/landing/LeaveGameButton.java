package fr.kanassoulier.dorfromantik.landing;

import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

public class LeaveGameButton extends MainControlButton {
  public LeaveGameButton() {
    super("Quitter");
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    SwingUtilities.getWindowAncestor(this).dispose();
  }
}
