package fr.kanassoulier.literomantik.gui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import fr.kanassoulier.literomantik.game.Game;

/**
 * Classe permettant de gérer les événements de fermeture de la fenêtre de jeu
 * 
 * @version 1.0
 * @author Gaston Chenet
 */
public class CloseGameDialogListener implements WindowListener {
	private Game game;

	/**
	 * Constructeur de CloseGameDialogListener
	 * 
	 * @param game La partie en cours
	 */
	public CloseGameDialogListener(Game game) {
		this.game = game;
	}

	@Override
	public void windowClosing(WindowEvent e) {
		new CloseGameDialog(this.game).setVisible(true);
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowClosed(WindowEvent e) {
		this.game.getDatabase().close();
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}
}
