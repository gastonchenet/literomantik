package fr.kanassoulier.literomantik.gui;

import java.awt.Color;

import fr.kanassoulier.literomantik.components.KButton;
import fr.kanassoulier.literomantik.enums.KButtonType;
import fr.kanassoulier.literomantik.game.Game;

/**
 * Classe permettant de créer un bouton pour la fenêtre de pause
 * 
 * @version 1.0
 * @author Gaston Chenet
 */
public class PauseWindowButton extends KButton {
	/**
	 * Constructeur de PauseWindowButton
	 * 
	 * @param text   Le texte du bouton
	 * @param type   Le type du bouton
	 * @param window La fenêtre de pause
	 * @param game   La partie en cours
	 */
	public PauseWindowButton(String text, KButtonType type, PauseWindow window, Game game) {
		super(text, type);

		this.setHoverBackground(new Color(230, 230, 230));
		this.setPadding(10, 80, 10, 80);
		this.addActionListener(new PauseWindowButtonsListener(window, type, game));
	}
}
