package fr.kanassoulier.dorfromantik.tmp;

import javax.swing.JButton;

import java.awt.Polygon;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.geom.Rectangle2D;
import java.awt.Dimension;
import java.awt.RenderingHints;

import fr.kanassoulier.dorfromantik.utils.Hexagon;

/**
 * Classe permettant la création et le dessin d'un bouton de forme hexagonale
 * 
 * @version 1.0
 * @author Marco Orfao
 */
public class HexagonButton extends JButton {
  private Polygon hexagon;
  private Color buttonColor;
  private Color buttonColorPressed;
  private String nom;

  /**
   * instanciation d'un bouton de forme hexagonale
   * 
   * @param nom         texte attribué au bouton
   * @param buttonColor couleur du bouton
   */
  public HexagonButton(String nom, Color buttonColor, Color buttonColorPressed) {
    super();

    this.hexagon = new Hexagon(50, 50, 50);

    this.setContentAreaFilled(false);
    this.setFocusPainted(false);
    this.setBorderPainted(false);

    this.nom = nom;
    this.buttonColor = buttonColor;
    this.buttonColorPressed = buttonColorPressed;

  }

  /**
   * redéfinition de la zone cliquable
   * 
   * @param x coordonnées sur l'axe des abscisses
   * @param y coordonnée sur l'axe des ordonnées
   */
  @Override
  public boolean contains(int x, int y) {
    return this.hexagon.contains(x, y);
  }

  /**
   * Dessine le bouton hexagonale instancié
   * 
   * @param g contexte graphique
   */
  protected void paintComponent(Graphics g) {

    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D) g;

    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    // Couleur de l'hexagone + couleur du changement d'état
    if (this.getModel().isPressed()) {
      g2d.setColor(this.buttonColorPressed);
    } else {
      g2d.setColor(this.buttonColor);
    }

    g2d.fillPolygon(this.hexagon);

    // Bordure de l'hexagone
    g2d.setColor(Color.BLACK);
    g2d.setStroke(new BasicStroke(3));
    g2d.drawPolygon(this.hexagon);

    // Texte du bouton
    FontMetrics fm = g2d.getFontMetrics();
    Rectangle2D r = fm.getStringBounds(this.nom, g2d);
    int x = (this.getWidth() - (int) r.getWidth()) / 2;
    int y = (this.getHeight() - (int) r.getHeight()) / 2 + fm.getAscent();
    g2d.setColor(Color.BLACK);
    g2d.drawString(this.nom, x, y);
  }

  /**
   * permet d'adapter l'affichage du bouton à la forme hexagonale
   */
  @Override
  public Dimension getPreferredSize() {
    return new Dimension(100, 100);
  }
}
