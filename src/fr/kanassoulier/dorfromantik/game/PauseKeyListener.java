package fr.kanassoulier.dorfromantik.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class PauseKeyListener extends KeyAdapter {
	private PauseWindow pauseMenu;

	public PauseKeyListener(PauseWindow pauseMenu) {
		this.pauseMenu = pauseMenu;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			this.pauseMenu.dispose();
		}
	}
}
