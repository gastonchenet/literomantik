package fr.kanassoulier.literomantik.components;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;

public class KCheckBoxContent extends JButton {
  private boolean checked = false;
  private KCheckBoxContentListener listener;

  public KCheckBoxContent() {
    this.setContentAreaFilled(false);
    this.setBorderPainted(false);
    this.setFocusPainted(false);
    this.setSize(20, 20);

    this.listener = new KCheckBoxContentListener(this);
    this.addMouseListener(this.listener);
  }

  public boolean isChecked() {
    return this.checked;
  }

  public void setChecked(boolean checked) {
    this.checked = checked;
    this.repaint();
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g.create();

    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    int width = this.getWidth();
    int height = this.getHeight();

    if (this.checked) {
      g2d.setColor(this.listener.isMouseOver() ? new Color(50, 50, 201) : new Color(71, 71, 252));
      g2d.fillOval(0, 0, width, height);

      g2d.setColor(Color.WHITE);
      g2d.setStroke(new BasicStroke(2));
      g2d.drawLine(6, 11, 8, 13);
      g2d.drawLine(9, 13, 13, 7);
    } else {
      g2d.setColor(new Color(190, 190, 190));
      g2d.drawOval(0, 0, width - 1, height - 1);
    }

    g2d.dispose();
  }
}
