package fr.kanassoulier.literomantik.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

/**
 * Classe permettant de créer un curseur stylisé pour un slider
 * 
 * @version 1.0
 * @author Gaston Chenet
 */
public class KSliderThumb extends JPanel {
  /**
   * La largeur du curseur
   */
  public static final int WIDTH = 4;

  private KSlider slider;

  /**
   * Constructeur de KSliderThumb
   * 
   * @param slider Le slider auquel le curseur est associé
   */
  public KSliderThumb(KSlider slider) {
    this.setSize(KSliderThumb.WIDTH, KSlider.HEIGHT);
    this.setBackground(new Color(71, 71, 252));
    this.addMouseMotionListener(new KSliderThumbListener(this));

    this.slider = slider;
    this.setOpaque(false);
  }

  /**
   * Permet de récupérer le slider associé au curseur
   * 
   * @return Le slider associé au curseur
   */
  public KSlider getSlider() {
    return this.slider;
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g.create();

    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    g2d.setColor(this.getBackground());
    g2d.fillRoundRect(0, 0, KSliderThumb.WIDTH, KSlider.HEIGHT, KSliderThumb.WIDTH, KSliderThumb.WIDTH);

    g2d.dispose();
  }
}
