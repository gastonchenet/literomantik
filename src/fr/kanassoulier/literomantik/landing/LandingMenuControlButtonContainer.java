package fr.kanassoulier.literomantik.landing;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import fr.kanassoulier.literomantik.components.KButton;
import fr.kanassoulier.literomantik.enums.KButtonType;
import fr.kanassoulier.literomantik.utils.Database;
import fr.kanassoulier.literomantik.utils.Seed;

/**
 * Classe permettant d'intégrer a la partie droite du menu les boutons de
 * contrôle du menu
 * 
 * @version 2.0
 * @author Gaston Chenet & Marco Orfao
 */
public class LandingMenuControlButtonContainer extends JPanel {
	/**
	 * constructeur de la classe, instancie les boutons et les affiches dans le menu
	 */
	public LandingMenuControlButtonContainer(LandingMenuSidebar sidebar) {
		super();

		this.setLayout(new GridBagLayout());

		KButton startButton = new LandingMenuControlButton("Commencer la partie", KButtonType.PLAY, sidebar);
		KButton settingsButton = new LandingMenuControlButton("Paramètres", KButtonType.SETTINGS, sidebar);
		KButton leaveButton = new LandingMenuControlButton("Quitter", KButtonType.QUIT, sidebar);

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets.set(3, 3, 24, 3);
		gbc.weightx = 0.1f;
		gbc.gridy = 0;
		gbc.gridx = 0;

		Database db = new Database();

		for (Seed seed : db.getDefaultSeeds()) {
			KButton seedButton = new LandingMenuControlButton(seed, KButtonType.SEED, sidebar);
			this.add(seedButton, gbc);
			gbc.gridx++;
		}

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
		db.close();
	}
}
