package fr.kanassoulier.literomantik.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import fr.kanassoulier.literomantik.utils.FontLoader;

/**
 * Classe permettant de créer un champ de texte stylisé
 * 
 * @version 1.0
 * @author Gaston Chenet
 */
public class KTextFieldInput extends JTextField {
  /**
   * Constructeur de KTextFieldInput
   * 
   * @param text Le texte du champ de texte
   */
  public KTextFieldInput(String text) {
    super(text);

    this.setBorder(new EmptyBorder(6, 12, 6, 12));
    this.setFont(FontLoader.LEXEND_REGULAR.deriveFont(14f));
  }

  /**
   * Constructeur de KTextFieldInput
   */
  public KTextFieldInput() {
    this("");
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g.create();

    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    int width = this.getWidth();
    int height = this.getHeight();

    g2d.setColor(new Color(200, 200, 200));
    g2d.drawRoundRect(0, 0, width - 1, height - 1, height, height);

    g2d.dispose();
  }
}
