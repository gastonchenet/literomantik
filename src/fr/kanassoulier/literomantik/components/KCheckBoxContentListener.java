package fr.kanassoulier.literomantik.components;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class KCheckBoxContentListener implements MouseListener {
  private KCheckBoxContent content;
  private boolean mouseOver = false;

  public KCheckBoxContentListener(KCheckBoxContent content) {
    this.content = content;
  }

  public boolean isMouseOver() {
    return this.mouseOver;
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    this.content.setChecked(!this.content.isChecked());
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    this.mouseOver = true;
  }

  @Override
  public void mouseExited(MouseEvent e) {
    this.mouseOver = false;
  }

  @Override
  public void mousePressed(MouseEvent e) {
  }

  @Override
  public void mouseReleased(MouseEvent e) {
  }
}
