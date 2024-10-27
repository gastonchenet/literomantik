package fr.kanassoulier.literomantik.landing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import fr.kanassoulier.literomantik.components.KTextFieldInput;
import fr.kanassoulier.literomantik.game.Game;

/**
 * Classe permettant de gérer les événements de clic sur le bouton de validation
 * du SeedSelector
 * 
 * @version 1.0
 * @author Gaston Chenet
 */
public class SeedSelectorSubmitListener implements ActionListener {
  private KTextFieldInput textField;
  private LandingMenu menu;

  /**
   * Constructeur de SeedSelectorSubmitListener
   * 
   * @param textField Le champ de texte contenant la graine
   * @param menu      Le menu de landing
   */
  public SeedSelectorSubmitListener(KTextFieldInput textField, LandingMenu menu) {
    this.textField = textField;
    this.menu = menu;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    SwingUtilities.getWindowAncestor(this.textField).dispose();
    this.menu.dispose();
    new Game(Game.toSeed(this.textField.getText())).setVisible(true);
  }
}
