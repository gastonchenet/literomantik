package fr.kanassoulier.dorfromantik.end;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.SwingUtilities;

import fr.kanassoulier.dorfromantik.Game;

public class EndMenuListener implements WindowListener {
  private EndMenu dialog;
  private Game game;

  public EndMenuListener(EndMenu dialog, Game game) {
    this.dialog = dialog;
    this.game = game;
  }

  @Override
  public void windowClosing(WindowEvent e) {
    SwingUtilities.getWindowAncestor(this.dialog).dispose();
    this.game.dispose();
  }

  @Override
  public void windowActivated(WindowEvent e) {
  } // premier plan

  @Override
  public void windowClosed(WindowEvent e) {
  } // après fermeture

  @Override
  public void windowDeactivated(WindowEvent e) {
  } // arrière-plan

  @Override
  public void windowDeiconified(WindowEvent e) {
  } // restauration

  @Override
  public void windowIconified(WindowEvent e) {
  } // minimisation

  @Override
  public void windowOpened(WindowEvent e) {
  } // après ouverture
}
