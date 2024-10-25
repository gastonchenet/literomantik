package fr.kanassoulier.dorfromantik.game;

import fr.kanassoulier.dorfromantik.end.EndMenu;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class GameKeyListener extends KeyAdapter {
	private Game game;

	public GameKeyListener(Game game) {
		this.game = game;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			if (this.game.isFinished()) {
				new EndMenu(this.game).setVisible(true);
			} else {
				new PauseWindow(this.game, "Pause", true);
			}
		}
	}
}
