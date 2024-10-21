package fr.kanassoulier.dorfromantik.end;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import fr.kanassoulier.dorfromantik.Game;
import fr.kanassoulier.dorfromantik.enums.ButtonType;
import fr.kanassoulier.dorfromantik.utils.FontLoader;

public class EndMenuButton extends JButton {
  private EndMenuButtonListener listener;
  private ButtonType type;

  public EndMenuButton(Game game, String text, ButtonType type) {
    super(text);

    this.type = type;

    this.setBorderPainted(false);
    this.setFocusPainted(false);
    this.setContentAreaFilled(false);

    this.setBorder(new EmptyBorder(10, 0, 10, 0));
    this.setForeground(Color.BLACK);
    this.setFont(FontLoader.LEXEND_REGULAR.deriveFont(14f));

    this.listener = new EndMenuButtonListener(this, game);
    this.addMouseListener(listener);
    this.addActionListener(listener);
  }

  public ButtonType getType() {
    return this.type;
  }

  @Override
  public void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D) g.create();

    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    if (this.listener.isMouseOver()) {
      g2d.setColor(new Color(210, 210, 210));
    } else {
      g2d.setColor(new Color(220, 220, 220));
    }

    g2d.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), 10, 10);

    g2d.dispose();
    super.paintComponent(g);
  }
}
