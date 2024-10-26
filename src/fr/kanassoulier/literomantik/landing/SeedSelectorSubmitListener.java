package fr.kanassoulier.literomantik.landing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import fr.kanassoulier.literomantik.components.KTextFieldInput;
import fr.kanassoulier.literomantik.game.Game;

public class SeedSelectorSubmitListener implements ActionListener {
  private KTextFieldInput textField;
  private LandingMenu menu;

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
