package fr.kanassoulier.literomantik.game;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import fr.kanassoulier.literomantik.enums.KButtonType;
import fr.kanassoulier.literomantik.utils.FontLoader;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;

public class PauseWindow extends JDialog {
	public PauseWindow(Game game, String title, Boolean modal) {
		super(game, title, modal);

		this.setSize(270, 285);
		this.setLocationRelativeTo(game);
		this.setResizable(false);

		this.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();

		JLabel pauseTitle = new JLabel("Pause", JLabel.CENTER);
		pauseTitle.setFont(FontLoader.LEXEND_BOLD.deriveFont(36f));
		pauseTitle.setForeground(Color.BLACK);
		pauseTitle.setBorder(new EmptyBorder(15, 0, 0, 0));

		PauseWindowButton continueButton = new PauseWindowButton("Continuer", KButtonType.CONTINUE, this, game);
		PauseWindowButton menuButton = new PauseWindowButton("Menu", KButtonType.MENU, this, game);
		PauseWindowButton quitButton = new PauseWindowButton("Quitter", KButtonType.QUIT, this, game);

		quitButton.setForeground(Color.WHITE);
		quitButton.setBackground(new Color(224, 31, 41));
		quitButton.setHoverBackground(new Color(224, 31, 41, 225));

		continueButton.addKeyListener(new PauseWindowKeyListener(this));

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 5, 5);

		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(pauseTitle, gbc);

		gbc.insets = new Insets(20, 5, 5, 5);

		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(continueButton, gbc);

		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(menuButton, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		this.add(quitButton, gbc);

		this.setVisible(true);
	}
}
