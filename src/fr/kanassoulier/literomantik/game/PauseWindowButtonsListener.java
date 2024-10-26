package fr.kanassoulier.literomantik.game;

import java.awt.event.ActionListener;

import fr.kanassoulier.literomantik.enums.KButtonType;
import fr.kanassoulier.literomantik.landing.LandingMenu;
import fr.kanassoulier.literomantik.utils.SoundPlayer;

import java.awt.event.ActionEvent;

public class PauseWindowButtonsListener implements ActionListener {

	private PauseWindow pauseMenu;
	private KButtonType type;
	private Game gameWindow;

	public PauseWindowButtonsListener(PauseWindow pauseMenu, KButtonType type, Game gameWindow) {
		this.type = type;
		this.pauseMenu = pauseMenu;
		this.gameWindow = gameWindow;
	}

	public void actionPerformed(ActionEvent e) {
		switch (this.type) {
			case QUIT:
				this.gameWindow.dispose();
				SoundPlayer.kill();
				break;

			case MENU:
				new LandingMenu().setVisible(true);
				this.gameWindow.dispose();
				break;

			case CONTINUE:
				this.pauseMenu.dispose();
				break;

			default:
				throw new IllegalArgumentException("Unexpected value: " + this.type);
		}
	}
}
