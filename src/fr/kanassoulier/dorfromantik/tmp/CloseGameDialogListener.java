package fr.kanassoulier.dorfromantik.tmp;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JDialog;

public class CloseGameDialogListener implements WindowListener {
  private Database database;
  private JDialog dialog;

  public CloseGameDialogListener(JDialog dialog, Database database) {
    this.dialog = dialog;
    this.database = database;
  }

  @Override
  public void windowClosing(WindowEvent e) {
    this.dialog.setVisible(true);
  }

  @Override
  public void windowActivated(WindowEvent e) {
  } // premier plan

  @Override
  public void windowClosed(WindowEvent e) {
    this.database.closeDatabase();
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
