package fr.kanassoulier.literomantik.end;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.kanassoulier.literomantik.components.KTextField;
import fr.kanassoulier.literomantik.game.Game;
import fr.kanassoulier.literomantik.utils.FontLoader;
import fr.kanassoulier.literomantik.utils.ScoreLogic;

public class EndMenu extends JDialog {
	public EndMenu(Game game) {
		super(game, "Fin de la partie", true);

		this.setSize(400, 330);
		this.setLocationRelativeTo(game);
		this.setResizable(false);

		this.addWindowListener(new EndMenuListener(this));

		JPanel content = new JPanel();
		this.setContentPane(content);

		content.setLayout(new GridLayout(0, 1));
		content.setBackground(Color.WHITE);
		content.setBorder(new EmptyBorder(10, 10, 10, 10));

		JLabel endTitle = new JLabel("Fin de la partie", JLabel.CENTER);
		endTitle.setFont(FontLoader.LEXEND_BOLD.deriveFont(30f));

		int score = ScoreLogic.calculate(game.getBoard());
		JLabel endScore = new JLabel("Score : " + score, JLabel.CENTER);
		endScore.setFont(FontLoader.LEXEND_REGULAR.deriveFont(18f));
		endScore.setBorder(new EmptyBorder(24, 0, 14, 0));

		JLabel endSeed = new JLabel("Seed : " + game.getSeed(), JLabel.CENTER);
		endSeed.setForeground(Color.GRAY);
		endSeed.setFont(FontLoader.LEXEND_REGULAR.deriveFont(14f));
		endSeed.setBorder(new EmptyBorder(24, 0, 14, 0));

		JLabel endStatus = new JLabel("Non enregistré", JLabel.CENTER);
		endStatus.setFont(FontLoader.LEXEND_REGULAR.deriveFont(12f));
		endStatus.setForeground(Color.RED);
		endStatus.setBorder(new EmptyBorder(15, 0, 0, 0));

		JLabel endUsername = new JLabel("Pour vous enregistrer, entrez votre nom :", JLabel.LEFT);
		endUsername.setForeground(Color.GRAY);
		endUsername.setFont(FontLoader.LEXEND_REGULAR.deriveFont(14f));
		endUsername.setBorder(new EmptyBorder(15, 10, 0, 0));

		KTextField usernameField = new KTextField();
		usernameField.setBorder(new EmptyBorder(0, 0, 5, 0));

		boolean status = false;
		usernameField.getSubmit()
				.addActionListener(new EndGameTextFieldListener(usernameField, score, game.getSeed(), status, endStatus));

		EndMenuButtonsRow buttons = new EndMenuButtonsRow(game);

		content.add(endTitle);
		content.add(endSeed);
		content.add(endScore);
		content.add(endUsername);
		content.add(usernameField);
		content.add(endStatus);
		content.add(buttons);
	}
}
