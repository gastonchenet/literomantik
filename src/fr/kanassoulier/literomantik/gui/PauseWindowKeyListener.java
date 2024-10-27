package fr.kanassoulier.literomantik.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

/**
 * Classe permettant de gérer les événements de touche sur la fenêtre de pause
 * 
 * @version 1.0
 * @author Gaston Chenet
 */
public class PauseWindowKeyListener extends KeyAdapter {
	private PauseWindow pauseMenu;

	/**
	 * Constructeur de PauseWindowKeyListener
	 * 
	 * @param pauseMenu La fenêtre de pause
	 */
	public PauseWindowKeyListener(PauseWindow pauseMenu) {
		this.pauseMenu = pauseMenu;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			this.pauseMenu.dispose();
		}
	}
}
