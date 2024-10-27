package fr.kanassoulier.literomantik.game;

import java.awt.event.KeyEvent;

import fr.kanassoulier.literomantik.end.EndMenu;
import fr.kanassoulier.literomantik.gui.PauseWindow;

import java.awt.event.KeyAdapter;

/**
 * Classe permettant de gérer les événements de clavier du jeu
 * 
 * @version 1.0
 * @author Gaston Chenet
 */
public class GameKeyListener extends KeyAdapter {
	private Game game;

	/**
	 * Constructeur de GameKeyListener
	 * 
	 * @param game La partie en cours
	 */
	public GameKeyListener(Game game) {
		this.game = game;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			if (this.game.isFinished()) {
				new EndMenu(this.game).setVisible(true);
			} else {
				new PauseWindow(this.game).setVisible(true);
			}
		}
	}
}
