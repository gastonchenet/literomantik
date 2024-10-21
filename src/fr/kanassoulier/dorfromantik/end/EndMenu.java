package fr.kanassoulier.dorfromantik.end;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.kanassoulier.dorfromantik.Game;
import fr.kanassoulier.dorfromantik.utils.FontLoader;
import fr.kanassoulier.dorfromantik.utils.ScoreLogic;

public class EndMenu extends JDialog {
  public EndMenu(Game game) {
    super(game, "Fin de la partie", true);

    this.setLocationRelativeTo(game);
    this.setSize(400, 200);
    this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
    this.setResizable(false);

    this.addWindowListener(new EndMenuListener(this, game));

    JPanel content = new JPanel();
    this.setContentPane(content);

    content.setLayout(new GridLayout(0, 1));
    content.setBackground(Color.WHITE);
    content.setBorder(new EmptyBorder(10, 10, 10, 10));

    JLabel endTitle = new JLabel("Fin de la partie", JLabel.CENTER);
    endTitle.setFont(FontLoader.LILITA_ONE_REGULAR.deriveFont(24f));

    JLabel endScore = new JLabel("Score : " + ScoreLogic.calculate(game.getBoard()), JLabel.CENTER);
    endScore.setFont(FontLoader.LEXEND_REGULAR.deriveFont(18f));

    JLabel endStatus = new JLabel("Non enregistré", JLabel.CENTER);
    endStatus.setFont(FontLoader.LEXEND_REGULAR.deriveFont(12f));
    endStatus.setForeground(Color.RED);

    EndMenuButtonsRow buttons = new EndMenuButtonsRow(game);

    content.add(endTitle);
    content.add(endScore);
    content.add(endStatus);
    content.add(buttons);
  }
}
