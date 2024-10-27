package fr.kanassoulier.literomantik.landing;

import java.awt.Color;

import fr.kanassoulier.literomantik.components.KButton;
import fr.kanassoulier.literomantik.enums.KButtonType;
import fr.kanassoulier.literomantik.utils.Seed;

/**
 * Classe permettant de créer un bouton de contrôle pour le menu de landing
 * 
 * @version 1.0
 * @author Gaston Chenet
 */
public class LandingMenuControlButton extends KButton {
	private LandingMenuSidebar sidebar;

	/**
	 * Constructeur de LandingMenuControlButton
	 * 
	 * @param text    Le texte du bouton
	 * @param type    Le type du bouton
	 * @param sidebar Le sidebar sur laquelle est le boutotn
	 * @param seed    La graine du bouton
	 */
	private LandingMenuControlButton(String text, KButtonType type, LandingMenuSidebar sidebar, long seed) {
		super(text, type);

		this.sidebar = sidebar;

		switch (type) {
			case SEED:
				this.setFont(this.getFont().deriveFont(12f));
				this.setPadding(5, 5, 5, 5);
				this.setBackground(new Color(255, 255, 255, 50));
				this.setHoverBackground(new Color(255, 255, 255, 40));
				this.setForeground(Color.WHITE);
				break;

			default:
				this.setBackground(Color.WHITE);
				this.setHoverBackground(new Color(255, 255, 255, 225));
				break;
		}

		this.addActionListener(new LandingMenuControlButtonListener(this, seed));
	}

	/**
	 * Constructeur de LandingMenuControlButton
	 * 
	 * @param text    Le texte du bouton
	 * @param type    Le type du bouton
	 * @param sidebar Le sidebar sur laquelle est le bouton
	 */
	public LandingMenuControlButton(String text, KButtonType type, LandingMenuSidebar sidebar) {
		this(text, type, sidebar, 0);
	}

	/**
	 * Constructeur de LandingMenuControlButton
	 * 
	 * @param seed    La graine du bouton
	 * @param type    Le type du bouton
	 * @param sidebar Le sidebar sur laquelle est le bouton
	 */
	public LandingMenuControlButton(Seed seed, KButtonType type, LandingMenuSidebar sidebar) {
		this(seed.name, type, sidebar, seed.value);
	}

	/**
	 * Permet de récupérer la sidebar
	 * 
	 * @return La sidebar
	 */
	public LandingMenuSidebar getSidebar() {
		return this.sidebar;
	}
}
