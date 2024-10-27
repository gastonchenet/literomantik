package fr.kanassoulier.literomantik.gui;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.kanassoulier.literomantik.enums.KButtonType;
import fr.kanassoulier.literomantik.game.Game;
import fr.kanassoulier.literomantik.utils.FontLoader;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;

/**
 * Classe permettant de créer une fenêtre de pause
 * 
 * @version 1.0
 * @author Gaston Chenet
 */
public class PauseWindow extends JDialog {
	public PauseWindow(Game game) {
		super(game, "Pause", true);

		this.setResizable(false);

		JPanel content = new JPanel();
		content.setBackground(Color.WHITE);
		content.setBorder(new EmptyBorder(10, 10, 10, 10));
		content.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();

		JLabel pauseTitle = new JLabel("Pause", JLabel.CENTER);
		pauseTitle.setFont(FontLoader.LEXEND_BOLD.deriveFont(36f));
		pauseTitle.setForeground(Color.BLACK);
		pauseTitle.setBorder(new EmptyBorder(15, 0, 0, 0));

		PauseWindowButton continueButton = new PauseWindowButton("Continuer", KButtonType.CONTINUE, this, game);
		PauseWindowButton restartButton = new PauseWindowButton("Recommencer", KButtonType.PLAY, this, game);
		PauseWindowButton settingsButton = new PauseWindowButton("Paramètres", KButtonType.SETTINGS, this, game);
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
		content.add(pauseTitle, gbc);

		gbc.insets = new Insets(20, 5, 5, 5);

		gbc.gridx = 0;
		gbc.gridy = 1;
		content.add(continueButton, gbc);

		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 3;
		content.add(settingsButton, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		content.add(restartButton, gbc);

		gbc.gridx = 0;
		gbc.gridy = 5;
		content.add(menuButton, gbc);

		gbc.gridx = 0;
		gbc.gridy = 6;
		content.add(quitButton, gbc);

		this.setContentPane(content);
		this.pack();
		this.setLocationRelativeTo(game);
	}
}
