package fr.kanassoulier.dorfromantik.landing;

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
	public LandingMenuLeaderboard leaderboard;

	/**
	 * constructeur de la classe, instancie les boutons et les affiches dans le menu
	 */
	public LandingMenuControlButtonContainer(LandingMenuLeaderboard leaderboard) {
		super();

		this.leaderboard = leaderboard;
		this.setLayout(new GridBagLayout());

		KButton startButton = new LandingMenuControlButton("Commencer la partie", KButtonType.PLAY);
		KButton settingsButton = new LandingMenuControlButton("Paramètres", KButtonType.SETTINGS);
		KButton leaveButton = new LandingMenuControlButton("Quitter", KButtonType.QUIT);

		KButton alphaButton = new LandingMenuControlButton("alpha", KButtonType.SEED, this.leaderboard, 154275265);
		KButton betaButton = new LandingMenuControlButton("beta", KButtonType.SEED, this.leaderboard, 534547947);
		KButton gammaButton = new LandingMenuControlButton("gamma", KButtonType.SEED, this.leaderboard, 874245424);
		KButton deltaButton = new LandingMenuControlButton("delta", KButtonType.SEED, this.leaderboard, 951984768);

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
}
