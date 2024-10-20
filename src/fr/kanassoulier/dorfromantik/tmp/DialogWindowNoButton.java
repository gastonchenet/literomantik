package fr.kanassoulier.dorfromantik.tmp;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDialog;

/**
 * Classe interargissant avec la fenêtre modale
 * 
 * @version 1.0
 * @author Marco Orfao
 */
public class DialogWindowNoButton implements ActionListener {
  /**
   * Fenetre modale
   */
  private JDialog dialogWin;

  /**
   * Constructeur du DialogWindowNoButton
   * 
   * @param dialogWin La fenêtre modale
   */
  public DialogWindowNoButton(JDialog dialogWin) {
    this.dialogWin = dialogWin;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    this.dialogWin.dispose();
  }
}
