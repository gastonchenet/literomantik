package fr.kanassoulier.dorfromantik.game;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;

import fr.kanassoulier.dorfromantik.components.KButton;
import fr.kanassoulier.dorfromantik.enums.KButtonType;
import fr.kanassoulier.dorfromantik.utils.FontLoader;

public class PauseWindow extends JDialog {

	private JFrame window;

	public PauseWindow(JFrame window, String title, Boolean modal) {
		super(window, title, modal);

		this.window = window;

		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		this.setSize(400, 330);
		this.setLocationRelativeTo(window);
		this.setResizable(false);

		JLabel pauseTitle = new JLabel("Pause", JLabel.CENTER);
		pauseTitle.setFont(FontLoader.LEXEND_REGULAR.deriveFont(45f));
		pauseTitle.setForeground(Color.BLACK);
		pauseTitle.setBorder(new EmptyBorder(15, 0, 0, 0));

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		gbc.insets = new Insets(5, 5, 5, 5);
		this.add(pauseTitle, gbc);

		KButton continueButton = new KButton("Continuer", KButtonType.CONTINUE);
		continueButton.setBackground(Color.WHITE);
		continueButton.setHoverBackground(new Color(255, 255, 255, 225));
		continueButton.setOpaque(false);
		continueButton.setPadding(5, 15, 5, 15);
		continueButton.addKeyListener(new EscapeKeyPauseMenuListener(this));
		continueButton.addActionListener(new PauseWindowButtonsListener(this, continueButton.getType(), this.window));

		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(75, 5, 5, 5);
		this.add(continueButton, gbc);

		KButton menuButton = new KButton("Menu", KButtonType.MENU);
		menuButton.setBackground(Color.WHITE);
		menuButton.setHoverBackground(new Color(255, 255, 255, 225));
		menuButton.setOpaque(false);
		menuButton.setPadding(5, 15, 5, 15);
		menuButton.addActionListener(new PauseWindowButtonsListener(this, menuButton.getType(), this.window));

		gbc.gridx = 1;
		gbc.gridy = 4;
		this.add(menuButton, gbc);

		KButton quitButton = new KButton("Quitter", KButtonType.QUIT);
		quitButton.setBackground(Color.WHITE);
		quitButton.setHoverBackground(new Color(255, 255, 255, 225));
		quitButton.setOpaque(false);
		quitButton.setPadding(5, 15, 5, 15);
		quitButton.addActionListener(new PauseWindowButtonsListener(this, quitButton.getType(), this.window));

		gbc.gridx = 2;
		gbc.gridy = 4;
		this.add(quitButton, gbc);

		this.setVisible(true);

	}
}
