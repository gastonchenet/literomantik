package fr.kanassoulier.literomantik.gui;

import java.awt.event.ActionListener;

import fr.kanassoulier.literomantik.enums.KButtonType;
import fr.kanassoulier.literomantik.game.Game;
import fr.kanassoulier.literomantik.landing.LandingMenu;
import fr.kanassoulier.literomantik.utils.SoundPlayer;

import java.awt.event.ActionEvent;

/**
 * Classe permettant de gérer les événements de clic sur un bouton de la fenêtre
 * de pause
 * 
 * @version 1.0
 * @author Gaston Chenet
 */
public class PauseWindowButtonsListener implements ActionListener {
	private PauseWindow pauseMenu;
	private KButtonType type;
	private Game game;

	/**
	 * Constructeur de PauseWindowButtonsListener
	 * 
	 * @param pauseMenu Le menu de pause
	 * @param type      Le type de bouton
	 * @param game      La partie en cours
	 */
	public PauseWindowButtonsListener(PauseWindow pauseMenu, KButtonType type, Game game) {
		this.type = type;
		this.pauseMenu = pauseMenu;
		this.game = game;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (this.type) {
			case QUIT:
				this.game.dispose();
				SoundPlayer.kill();
				break;

			case MENU:
				new LandingMenu().setVisible(true);
				this.game.dispose();
				break;

			case CONTINUE:
				this.pauseMenu.dispose();
				break;

			case SETTINGS:
				new Settings(this.pauseMenu).setVisible(true);
				break;

			case PLAY:
				new Game(this.game.getSeed()).setVisible(true);
				this.game.dispose();
				break;

			default:
				throw new IllegalArgumentException("Unexpected value: " + this.type);
		}
	}
}
