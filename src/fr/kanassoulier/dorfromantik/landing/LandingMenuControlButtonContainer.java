package fr.kanassoulier.dorfromantik.landing;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
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
	public LandingMenuSidebar sidebar;

	/**
	 * constructeur de la classe, instancie les boutons et les affiches dans le menu
	 */
	public LandingMenuControlButtonContainer(LandingMenu landingMenu,
			LandingMenuSidebar sidebar, LandingMenuLeaderboard leaderboard) {
		super();

		this.sidebar = sidebar;
		this.setLayout(new GridBagLayout());

		KButton startButton = new LandingMenuControlButton(landingMenu, leaderboard, "Commencer la partie",
				KButtonType.PLAY,
				this.sidebar);
		KButton settingsButton = new LandingMenuControlButton(landingMenu, leaderboard, "Paramètres",
				KButtonType.SETTINGS,
				this.sidebar);
		KButton leaveButton = new LandingMenuControlButton(landingMenu, leaderboard, "Quitter",
				KButtonType.QUIT, this.sidebar);

		KButton alphaButton = new LandingMenuControlButton(landingMenu, leaderboard, "alpha", KButtonType.SEED,
				this.sidebar,
				154275265);
		KButton betaButton = new LandingMenuControlButton(landingMenu, leaderboard, "beta", KButtonType.SEED,
				this.sidebar,
				534547947);
		KButton gammaButton = new LandingMenuControlButton(landingMenu, leaderboard, "gamma", KButtonType.SEED,
				this.sidebar,
				874245424);
		KButton deltaButton = new LandingMenuControlButton(landingMenu, leaderboard, "delta", KButtonType.SEED,
				this.sidebar,
				951984768);

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
