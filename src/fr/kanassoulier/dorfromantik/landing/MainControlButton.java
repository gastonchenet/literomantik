package fr.kanassoulier.dorfromantik.landing;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import fr.kanassoulier.dorfromantik.utils.FontLoader;

public abstract class MainControlButton extends JButton implements MouseListener {
  public boolean mouseOver = false;

  public MainControlButton(String text) {
    super(text);

    this.setBorderPainted(false);
    this.setFocusPainted(false);
    this.setContentAreaFilled(false);

    this.setBorder(new EmptyBorder(10, 0, 10, 0));
    this.setForeground(Color.BLACK);
    this.setFont(FontLoader.LEXEND_REGULAR.deriveFont(14f));

    this.addMouseListener(this);
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
    this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    this.mouseOver = true;
    this.repaint();
  }

  @Override
  public void mouseExited(MouseEvent e) {
    this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    this.mouseOver = false;
    this.repaint();
  }

  @Override
  public void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D) g.create();

    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    if (this.mouseOver) {
      g2d.setColor(new Color(255, 255, 255, 225));
    } else {
      g2d.setColor(Color.WHITE);
    }

    g2d.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), 10, 10);

    g2d.dispose();
    super.paintComponent(g);
  }
}
