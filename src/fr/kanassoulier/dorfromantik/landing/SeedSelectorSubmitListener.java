package fr.kanassoulier.dorfromantik.landing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import fr.kanassoulier.dorfromantik.components.KTextFieldInput;
import fr.kanassoulier.dorfromantik.game.Game;

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
