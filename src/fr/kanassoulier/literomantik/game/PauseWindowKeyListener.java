package fr.kanassoulier.literomantik.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class PauseWindowKeyListener extends KeyAdapter {
	private PauseWindow pauseMenu;

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
