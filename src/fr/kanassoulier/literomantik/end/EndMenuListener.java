package fr.kanassoulier.literomantik.end;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class EndMenuListener implements WindowListener {
  private EndMenu dialog;

  public EndMenuListener(EndMenu dialog) {
    this.dialog = dialog;
  }

  @Override
  public void windowClosing(WindowEvent e) {
    this.dialog.dispose();
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
