package fr.kanassoulier.dorfromantik.gui;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;

import fr.kanassoulier.dorfromantik.Game;
import fr.kanassoulier.dorfromantik.utils.ScoreLogic;

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

    try {
      Font font = Font.createFont(Font.TRUETYPE_FONT, new File("./resources/fonts/Lexend-Bold.ttf")).deriveFont(30f);

      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      ge.registerFont(font);

      this.setFont(font);
    } catch (IOException | FontFormatException e) {
      e.printStackTrace();
    }
  }

  /**
   * Mettre à jour le score du joueur.
   */
  public void updateScore() {
    int score = ScoreLogic.startCounting(this.gui.getGame().getBoard());
    this.setText(Integer.toString(score));
  }
}
