package fr.kanassoulier.dorfromantik.landing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import fr.kanassoulier.dorfromantik.enums.LandingMenuButton;
import fr.kanassoulier.dorfromantik.utils.FontLoader;

public class LandingMenuControlButton extends JButton {
  private LandingMenuButton type;
  public LandingMenuControlButtonListener listener;

  public LandingMenuControlButton(String text, LandingMenuButton type) {
    super(text);

    this.type = type;

    this.setBorderPainted(false);
    this.setFocusPainted(false);
    this.setContentAreaFilled(false);

    this.setBorder(new EmptyBorder(10, 0, 10, 0));
    this.setFont(FontLoader.LEXEND_REGULAR.deriveFont(14f));

    this.listener = new LandingMenuControlButtonListener(this);
    this.addMouseListener(this.listener);
  }

  public LandingMenuButton getType() {
    return this.type;
  }

  @Override
  public void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D) g.create();

    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    if (this.listener.isMouseOver()) {
      g2d.setColor(new Color(255, 255, 255, 225));
    } else {
      g2d.setColor(Color.WHITE);
    }

    g2d.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), 10, 10);

    g2d.dispose();
    super.paintComponent(g);
  }
}
