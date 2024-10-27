package fr.kanassoulier.literomantik.end;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Classe permettant de gérer les événements de fenêtre sur un EndMenu
 * 
 * @version 1.0
 * @author Gaston Chenet
 */
public class EndMenuListener implements WindowListener {
  private EndMenu dialog;

  /**
   * Constructeur de EndMenuListener
   * 
   * @param dialog La fenêtre à écouter
   */
  public EndMenuListener(EndMenu dialog) {
    this.dialog = dialog;
  }

  @Override
  public void windowClosing(WindowEvent e) {
    this.dialog.dispose();
  }

  @Override
  public void windowActivated(WindowEvent e) {
  }

  @Override
  public void windowClosed(WindowEvent e) {
  }

  @Override
  public void windowDeactivated(WindowEvent e) {
  }

  @Override
  public void windowDeiconified(WindowEvent e) {
  }

  @Override
  public void windowIconified(WindowEvent e) {
  }

  @Override
  public void windowOpened(WindowEvent e) {
  }
}
