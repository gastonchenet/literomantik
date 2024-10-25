package fr.kanassoulier.dorfromantik.game;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;

import fr.kanassoulier.dorfromantik.enums.KButtonType;
import fr.kanassoulier.dorfromantik.landing.LandingMenu;

public class PauseWindowButtonsListener implements ActionListener {

	private PauseWindow pauseMenu;
	private KButtonType type;
	private JFrame gameWindow;

	public PauseWindowButtonsListener(PauseWindow pauseMenu, KButtonType type, JFrame gameWindow) {
		this.type = type;
		this.pauseMenu = pauseMenu;
		this.gameWindow = gameWindow;
	}

	public void actionPerformed(ActionEvent e) {
		if (this.type == KButtonType.QUIT) {
			this.gameWindow.dispose();
		} else if (this.type == KButtonType.MENU) {
			new LandingMenu().setVisible(true);
			this.gameWindow.dispose();
		} else if (this.type == KButtonType.CONTINUE) {
			this.pauseMenu.dispose();
		}
	}
}
