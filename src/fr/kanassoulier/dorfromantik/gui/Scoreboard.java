package fr.kanassoulier.dorfromantik.gui;

import javax.swing.JLabel;

import fr.kanassoulier.dorfromantik.utils.ScoreLogic;
import fr.kanassoulier.dorfromantik.game.Game;
import fr.kanassoulier.dorfromantik.utils.FontLoader;

/**
 * L'affichage du scoreboard du jeu
 * 
 * @version 1.1
 * @author Gaston Chenet
 * @author Maxence Raymond
 */
public class Scoreboard extends JLabel {
  /**
   * La hauteur du scoreboard.
   */
  private static final int HEIGHT = 50;

  private Gui gui;

  public Scoreboard(Gui gui) {
    super("0", JLabel.CENTER);

    this.gui = gui;

    this.setBounds(0, 0, Game.WINDOW_WIDTH, Scoreboard.HEIGHT);
    this.setFont(FontLoader.LEXEND_BOLD);
  }

  /**
   * Mettre à jour le score du joueur.
   */
  public void updateScore() {
    int score = ScoreLogic.calculate(this.gui.getGame().getBoard());
    this.setText(Integer.toString(score));
  }
}
