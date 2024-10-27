package fr.kanassoulier.literomantik.end;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingUtilities;

import fr.kanassoulier.literomantik.components.KButton;
import fr.kanassoulier.literomantik.game.Game;
import fr.kanassoulier.literomantik.landing.LandingMenu;

/**
 * Classe permettant de gérer l'écouteur des boutons du menu de fin de partie
 * 
 * @version 1.0
 * @author Gaston Chenet
 */
public class EndMenuButtonListener implements ActionListener {
  private boolean mouseOver = false;
  private Game game;

  /**
   * Constructeur de EndMenuButtonListener
   * 
   * @param game La partie en cours
   */
  public EndMenuButtonListener(Game game) {
    this.game = game;
  }

  /**
   * Permet de savoir si la souris est sur le bouton
   * 
   * @return true si la souris est sur le bouton, false sinon
   */
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
