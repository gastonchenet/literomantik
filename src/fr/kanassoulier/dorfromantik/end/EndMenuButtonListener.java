package fr.kanassoulier.dorfromantik.end;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingUtilities;

import fr.kanassoulier.dorfromantik.components.KButton;
import fr.kanassoulier.dorfromantik.game.Game;
import fr.kanassoulier.dorfromantik.landing.LandingMenu;

public class EndMenuButtonListener implements ActionListener {
  private boolean mouseOver = false;
  private Game game;

  public EndMenuButtonListener(Game game) {
    this.game = game;
  }

  public boolean isMouseOver() {
    return this.mouseOver;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    KButton button = (KButton) e.getSource();
    SwingUtilities.getWindowAncestor(button).dispose();

    switch (button.getType()) {
      case PLAY:
        this.game.dispose();
        new Game(this.game.getSeed()).setVisible(true);
        break;

      case QUIT:
        this.game.dispose();
        break;

      case MENU:
        this.game.dispose();
        new LandingMenu().setVisible(true);
        break;

      default:
        break;
    }
  }
}
