package fr.kanassoulier.dorfromantik.game;

import fr.kanassoulier.dorfromantik.end.EndMenu;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EscapeKeyGameListener extends KeyAdapter implements ActionListener {

	private Game game;

	public EscapeKeyGameListener(Game game) {
		this.game = game;
	}

	public void actionPerformed(ActionEvent e) {

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
