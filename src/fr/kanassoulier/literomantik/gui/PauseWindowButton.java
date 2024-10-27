package fr.kanassoulier.literomantik.gui;

import java.awt.Color;

import fr.kanassoulier.literomantik.components.KButton;
import fr.kanassoulier.literomantik.enums.KButtonType;
import fr.kanassoulier.literomantik.game.Game;

public class PauseWindowButton extends KButton {
	public PauseWindowButton(String text, KButtonType type, PauseWindow window, Game game) {
		super(text, type);

		this.setHoverBackground(new Color(230, 230, 230));
		this.setPadding(10, 80, 10, 80);
		this.addActionListener(new PauseWindowButtonsListener(window, type, game));
	}
}
