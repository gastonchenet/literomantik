package fr.kanassoulier.dorfromantik.components;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InlineFieldSubmitListener implements MouseListener {
  private boolean mouseOver = false;
  private InlineFieldSubmit button;

  public InlineFieldSubmitListener(InlineFieldSubmit button) {
    this.button = button;
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
}
