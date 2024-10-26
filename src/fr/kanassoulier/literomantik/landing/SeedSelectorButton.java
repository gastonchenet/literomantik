package fr.kanassoulier.literomantik.landing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import fr.kanassoulier.literomantik.utils.FontLoader;

public class SeedSelectorButton extends JButton {
  private SeedSelectorButtonListener listener;
  public long seed;
  public String text;
  public boolean mouseOver = false;

  public SeedSelectorButton(LandingMenu menu, String text, long seed) {
    this.text = text;
    this.seed = seed;

    this.setBorderPainted(false);
    this.setFocusPainted(false);
    this.setContentAreaFilled(false);
    this.setBorder(new EmptyBorder(25, 0, 25, 0));

    this.listener = new SeedSelectorButtonListener(this, menu, seed);
    this.addMouseListener(this.listener);
  }

  @Override
  public void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D) g.create();
    super.paintComponent(g);

    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

    if (this.listener.isMouseOver()) {
      g2d.setColor(new Color(240, 240, 240));
    } else {
      g2d.setColor(Color.WHITE);
    }

    g2d.fillRoundRect(0, 0, this.getWidth() - 2, this.getHeight() - 2, 10, 10);

    g2d.setColor(new Color(200, 200, 200));
    g2d.drawRoundRect(0, 0, this.getWidth() - 2, this.getHeight() - 2, 10, 10);

    g2d.setColor(new Color(71, 71, 252));
    g2d.setFont(FontLoader.LEXEND_BOLD.deriveFont(16f));
    g2d.drawString(this.text, 10, 22);

    g2d.setColor(new Color(150, 150, 150));
    g2d.setFont(FontLoader.LEXEND_REGULAR.deriveFont(12f));
    g2d.drawString(Long.toString(this.seed), 10, 38);

    g2d.dispose();
  }
}
