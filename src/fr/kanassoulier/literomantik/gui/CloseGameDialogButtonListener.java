package fr.kanassoulier.literomantik.gui;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import fr.kanassoulier.literomantik.components.KButton;
import fr.kanassoulier.literomantik.enums.KButtonType;
import fr.kanassoulier.literomantik.game.Game;
import fr.kanassoulier.literomantik.utils.SoundPlayer;

public class CloseGameDialogButtonListener implements MouseListener {
	private boolean mouseOver = false;
	private KButton button;
	private Game game;

	public CloseGameDialogButtonListener(KButton button, Game game) {
		this.button = button;
		this.game = game;
	}

	public boolean isMouseOver() {
		return this.mouseOver;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		KButton button = (KButton) e.getSource();
		SwingUtilities.getWindowAncestor(button).dispose();

		if (this.button.getType() == KButtonType.YES) {
			this.game.dispose();
			SoundPlayer.kill();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.mouseOver = true;
		this.button.repaint();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		this.mouseOver = false;
		this.button.repaint();
	}
}
