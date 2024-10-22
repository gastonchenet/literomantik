package fr.kanassoulier.dorfromantik.components;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class KTextFieldSubmit extends JButton {
  private KTextFieldSubmitListener listener;

  public KTextFieldSubmit() {
    super();

    this.setFocusPainted(false);
    this.setContentAreaFilled(false);
    this.setBorder(new EmptyBorder(14, 14, 14, 14));

    this.listener = new KTextFieldSubmitListener(this);
    this.addMouseListener(this.listener);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g.create();

    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    int width = this.getWidth();
    int height = this.getHeight();

    g2d.setColor(this.listener.isMouseOver() ? new Color(50, 50, 201) : new Color(71, 71, 252));
    g2d.fillOval(0, 0, width, height);

    g2d.setColor(Color.WHITE);
    g2d.setStroke(new BasicStroke(2));
    g2d.drawLine(8, 15, 11, 18);
    g2d.drawLine(12, 19, 19, 10);

    g2d.dispose();
  }
}
