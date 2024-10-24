package fr.kanassoulier.dorfromantik.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class EscapeKeyPauseMenuListener extends KeyAdapter {

	private PauseWindow pauseMenu;

	public EscapeKeyPauseMenuListener(PauseWindow pauseMenu) {
		this.pauseMenu = pauseMenu;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			this.pauseMenu.dispose();
		}
	}
}
