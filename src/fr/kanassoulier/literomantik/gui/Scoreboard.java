package fr.kanassoulier.literomantik.gui;

import javax.swing.JLabel;

import fr.kanassoulier.literomantik.game.Game;
import fr.kanassoulier.literomantik.utils.FontLoader;
import fr.kanassoulier.literomantik.utils.ScoreLogic;

/**
 * L'affichage du scoreboard du jeu
 * 
 * @version 1.1
 * @author Gaston Chenet, Maxence Raymond
 */
public class Scoreboard extends JLabel {
  /**
   * La hauteur du scoreboard.
   */
  private static final int HEIGHT = 50;

  private Gui gui;
  private int score = 0;

  public Scoreboard(Gui gui) {
    super("0", JLabel.CENTER);

    this.gui = gui;

    this.setBounds(0, 0, Game.WINDOW_WIDTH, Scoreboard.HEIGHT);
    this.setFont(FontLoader.LEXEND_BOLD);

    this.updateScore(false);
  }

  /**
   * Mettre à jour le score du joueur.
   */
  public void updateScore(Boolean showScoreUpdate) {
    int oldScore = this.score;

    this.score = ScoreLogic.calculate(this.gui.getGame().getBoard());
    this.setText(Integer.toString(this.score));

    if (showScoreUpdate) {
      this.gui.getScoreUpdate().setText("+" + (this.score - oldScore));
    }
  }
}
