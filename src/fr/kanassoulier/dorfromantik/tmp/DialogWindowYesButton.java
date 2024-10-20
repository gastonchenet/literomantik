package fr.kanassoulier.dorfromantik.tmp;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * Classe interargissant avec la fenêtre modale
 * 
 * @version 1.0
 * @author Marco Orfao
 */
public class DialogWindowYesButton implements ActionListener {
  /**
   * Fenetre modale
   */
  private JDialog dialogWin;

  /**
   * Fenetre de jeu
   */
  private JFrame window;

  /**
   * Constructeur du DialogWindowYesButton
   * 
   * @param window    La fenêtre de jeu
   * @param dialogWin La fenêtre modale
   */
  public DialogWindowYesButton(JDialog dialogWin, JFrame window) {
    this.dialogWin = dialogWin;
    this.window = window;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    this.dialogWin.dispose();
    this.window.dispose();
  }
}
