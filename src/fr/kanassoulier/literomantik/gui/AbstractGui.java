package fr.kanassoulier.literomantik.gui;

import javax.swing.JLayeredPane;

import fr.kanassoulier.literomantik.game.Game;

public class AbstractGui extends JLayeredPane {
	public AbstractGui() {
		super();
	}

	public AbstractGui(Game game) {

	}

	public AbstractPreviewTile getPreviewTile() {
		return null;
	}

	public Scoreboard getScoreboard() {
		return null;
	}

}
