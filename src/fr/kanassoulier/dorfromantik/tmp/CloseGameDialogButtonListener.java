package fr.kanassoulier.dorfromantik.tmp;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import fr.kanassoulier.dorfromantik.Game;

public class CloseGameDialogButtonListener implements ActionListener, MouseListener {
  private boolean positive, mouseOver = false;
  private CloseGameDialogButton button;
  private Game game;

  public CloseGameDialogButtonListener(CloseGameDialogButton button, Game game, boolean positive) {
    this.button = button;
    this.game = game;
    this.positive = positive;
  }

  public boolean isMouseOver() {
    return this.mouseOver;
  }

  @Override
  public void mouseClicked(MouseEvent e) {
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

  @Override
  public void actionPerformed(ActionEvent e) {
    CloseGameDialogButton button = (CloseGameDialogButton) e.getSource();

    SwingUtilities.getWindowAncestor(button).dispose();

    if (this.positive) {
      this.game.dispose();
    }
  }
}
