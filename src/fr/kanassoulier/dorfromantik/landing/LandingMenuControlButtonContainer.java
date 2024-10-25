package fr.kanassoulier.dorfromantik.landing;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import fr.kanassoulier.dorfromantik.components.KButton;
import fr.kanassoulier.dorfromantik.enums.KButtonType;

/**
 * Classe permettant d'intégrer a la partie droite du menu les boutons de
 * contrôle du menu
 * 
 * @version 2.0
 * @author Gaston Chenet & Marco Orfao
 */
public class LandingMenuControlButtonContainer extends JPanel {

	JPanel leaderboard;

	/**
	 * constructeur de la classe, instancie les boutons et les affiches dans le menu
	 */
	public LandingMenuControlButtonContainer(JPanel leaderboard) {
		super();

		this.leaderboard = leaderboard;

		this.setLayout(new GridBagLayout());

		KButton startButton = makeButton("Commencer la partie", KButtonType.PLAY);
		startButton.addActionListener(new LandingMenuControlButtonListener(startButton));

		KButton settingsButton = makeButton("Paramètres", KButtonType.SETTINGS);
		settingsButton.addActionListener(new LandingMenuControlButtonListener(settingsButton));

		KButton leaveButton = makeButton("Quitter", KButtonType.QUIT);
		leaveButton.addActionListener(new LandingMenuControlButtonListener(leaveButton));

		KButton alphaButton = makeButton("alpha", KButtonType.SEED);
		alphaButton.addActionListener(new LandingMenuControlButtonListener(alphaButton, this.leaderboard, 154275265));

		KButton betaButton = makeButton("beta", KButtonType.SEED);
		betaButton.addActionListener(new LandingMenuControlButtonListener(betaButton, this.leaderboard, 534547947));

		KButton gammaButton = makeButton("gamma", KButtonType.SEED);
		gammaButton.addActionListener(new LandingMenuControlButtonListener(gammaButton, this.leaderboard, 874245424));

		KButton deltaButton = makeButton("delta", KButtonType.SEED);
		deltaButton.addActionListener(new LandingMenuControlButtonListener(deltaButton, this.leaderboard, 951984768));

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets.set(3, 3, 24, 3);
		gbc.weightx = 0.1f;

		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(alphaButton, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		this.add(betaButton, gbc);

		gbc.gridx = 2;
		gbc.gridy = 0;
		this.add(gammaButton, gbc);

		gbc.gridx = 3;
		gbc.gridy = 0;
		this.add(deltaButton, gbc);

		gbc.insets.set(3, 3, 3, 3);
		gbc.weightx = 0.1f;
		gbc.gridwidth = 4;
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(startButton, gbc);

		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(settingsButton, gbc);

		gbc.gridx = 2;
		gbc.gridy = 1;
		this.add(leaveButton, gbc);

		this.setOpaque(false);
	}

	/**
	 * méthode permettant d'instancier un KButton et lui attribue un style
	 * 
	 * @param nom  nom du bouton
	 * @param type type de bouton
	 * @return le bouton instancié
	 */
	public KButton makeButton(String nom, KButtonType type) {
		if (type == KButtonType.SEED) {

			KButton button = new KButton(nom, KButtonType.SEED);

			button.setFont(button.getFont().deriveFont(12f));
			button.setPadding(5, 5, 5, 5);
			button.setBackground(new Color(255, 255, 255, 50));
			button.setHoverBackground(new Color(255, 255, 255, 40));
			button.setForeground(Color.WHITE);

			return button;

		} else {

			KButton button = new KButton(nom, type);

			button.setBackground(Color.WHITE);
			button.setHoverBackground(new Color(255, 255, 255, 225));

			return button;
		}
	}
}
