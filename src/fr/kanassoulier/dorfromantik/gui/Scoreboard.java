package fr.kanassoulier.dorfromantik.gui;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;

import fr.kanassoulier.dorfromantik.Game;

public class Scoreboard extends JLabel {
  private static final int HEIGHT = 50;

  private int score = 0;

  public Scoreboard() {
    super("0", JLabel.CENTER);

    this.setBounds(0, 0, Game.WINDOW_WIDTH, Scoreboard.HEIGHT);

    try {
      Font font = Font.createFont(Font.TRUETYPE_FONT, new File("./resources/fonts/Lexend.ttf")).deriveFont(30f);

      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      ge.registerFont(font);

      this.setFont(font);
    } catch (IOException | FontFormatException e) {
      e.printStackTrace();
    }
  }

  /**
   * Mettre à jour le score du joueur.
   * 
   * @param matches Le nombre de tuiles adjacentes qui correspondent.
   */
  public void updateScore(int matches) {
    this.score += (int) Math.pow(matches, 2);
    this.setText(Integer.toString(this.score));
  }
}
