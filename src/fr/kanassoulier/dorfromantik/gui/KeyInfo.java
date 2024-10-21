package fr.kanassoulier.dorfromantik.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JPanel;

import fr.kanassoulier.dorfromantik.enums.KeyboardKey;
import fr.kanassoulier.dorfromantik.utils.FontLoader;

/**
 * Expliquer l'utilisation des touches du clavier/la souris dans le jeu.
 * 
 * @version 1.0
 * @author Gaston Chenet
 */
public class KeyInfo extends JPanel {
  public KeyboardKey key;
  public String text;

  /**
   * Crée une information sur les touches du clavier/la souris utilisées dans le
   * jeu.
   * 
   * @param key  La touche du clavier
   * @param text Le texte associé à la touche
   * @param x    La coordonnée x du coin supérieur gauche
   * @param y    La coordonnée y du coin supérieur gauche
   */
  public KeyInfo(KeyboardKey key, String text, int x, int y) {
    this.key = key;
    this.text = text;

    this.setBounds(x, y, 250, 36);
    this.setOpaque(false);
  }

  /**
   * Crée une information sur les touches du clavier utilisées dans le jeu.
   * 
   * @param key   La touche du clavier
   * @param text  Le texte associé à la touche
   * @param point Le coin supérieur gauche
   */
  public KeyInfo(KeyboardKey key, String text, Point point) {
    this(key, text, point.x, point.y);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g.create();

    // Antialiasing pour rendre les formes plus lisses
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

    g2d.setFont(FontLoader.LEXEND_REGULAR.deriveFont(14f));

    // Dessin de la touche du clavier/la souris
    switch (this.key) {
      case MOUSE_LEFT_CLICK:
        g2d.setColor(new Color(40, 40, 40));
        g2d.fillRoundRect(0, 0, 30, 36, 10, 10);

        g2d.setColor(Color.WHITE);
        g2d.drawRoundRect(8, 8, 14, 20, 14, 14);
        g2d.clip(new RoundRectangle2D.Float(8, 8, 14, 20, 14, 14));

        g2d.fillRect(8, 8, 7, 10);

        g2d.setColor(new Color(40, 40, 40));
        g2d.fillRoundRect(14, 12, 2, 5, 2, 2);

        g2d.setColor(Color.WHITE);
        g2d.drawRoundRect(14, 12, 2, 5, 2, 2);
        g2d.setClip(null);

        g2d.setColor(new Color(40, 40, 40));
        g2d.drawString("Clic gauche", 38, 14);
        break;

      case MOUSE_WHEEL:
        g2d.setColor(new Color(40, 40, 40));
        g2d.fillRoundRect(0, 0, 30, 36, 10, 10);

        g2d.setColor(Color.WHITE);
        g2d.drawRoundRect(8, 8, 14, 20, 14, 14);
        g2d.drawRoundRect(14, 12, 2, 5, 2, 2);

        g2d.fillPolygon(
            new int[] { 12, 15, 18 },
            new int[] { 6, 2, 6 },
            3);

        g2d.fillPolygon(
            new int[] { 12, 15, 18 },
            new int[] { 30, 34, 30 },
            3);

        g2d.setColor(new Color(40, 40, 40));
        g2d.drawString("Molette", 38, 14);
        break;

      default:
        break;
    }

    g2d.setFont(g2d.getFont().deriveFont(12f));
    g2d.setColor(new Color(40, 40, 40, 160));
    g2d.drawString(this.text, 38, 30);

    g2d.dispose();
  }
}
