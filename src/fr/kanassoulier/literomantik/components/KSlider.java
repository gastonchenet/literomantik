package fr.kanassoulier.literomantik.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

/**
 * Classe permettant de créer un slider stylisé
 * 
 * @version 1.0
 * @author Gaston Chenet
 */
public class KSlider extends JPanel {
  /**
   * Dimensions du slider
   */
  public static final int WIDTH = 200, HEIGHT = 14, TRACK_HEIGHT = 4;

  private KSliderThumb thumb;
  private int min, max, value, step;

  /**
   * Constructeur de KSlider
   * 
   * @param min   Valeur minimale
   * @param max   Valeur maximale
   * @param value Valeur actuelle
   * @param step  Pas de la valeur
   */
  public KSlider(int min, int max, int value, int step) {
    this.min = min;
    this.max = max;
    this.value = value;
    this.step = step;

    this.setSize(KSlider.WIDTH, KSlider.HEIGHT);
    this.setLayout(null);
    this.setOpaque(false);
    this.setPreferredSize(new Dimension(KSlider.WIDTH, KSlider.HEIGHT));

    this.thumb = new KSliderThumb(this);
    this.add(this.thumb);
  }

  /**
   * Constructeur de KSlider
   * 
   * @param min   Valeur minimale
   * @param max   Valeur maximale
   * @param value Valeur actuelle
   */
  public KSlider(int min, int max, int value) {
    this(min, max, value, 1);
  }

  /**
   * Constructeur de KSlider
   * 
   * @param min Valeur minimale
   * @param max Valeur maximale
   */
  public KSlider(int min, int max) {
    this(min, max, min + (max - min) / 2);
  }

  /**
   * Permet de récupérer la valeur minimale
   * 
   * @return La valeur minimale
   */
  public int getMin() {
    return this.min;
  }

  /**
   * Permet de récupérer la valeur maximale
   * 
   * @return La valeur maximale
   */
  public int getMax() {
    return this.max;
  }

  /**
   * Permet de récupérer la valeur actuelle
   * 
   * @return La valeur actuelle
   */
  public int getValue() {
    return this.value;
  }

  /**
   * Permet de récupérer le pas de la valeur
   * 
   * @return Le pas de la valeur
   */
  public int getStep() {
    return this.step;
  }

  /**
   * Permet de changer la valeur actuelle
   * 
   * @param value     La nouvelle valeur
   * @param moveValue Si la valeur doit être déplacée
   */
  public void setValue(int value, boolean moveValue) {
    this.value = value;

    if (moveValue) {
      int trackWidth = this.getWidth() - KSliderThumb.WIDTH;
      int trackX = (int) Math.max(
          Math.min((double) (value - this.min) / (this.max - this.min) * trackWidth, trackWidth),
          0);

      this.thumb.setLocation(trackX, 0);
    }
  }

  /**
   * Permet de changer la valeur actuelle
   * 
   * @param value La nouvelle valeur
   */
  public void setValue(int value) {
    this.value = value;
  }

  /**
   * Permet de changer la couleur du slider
   * 
   * @param color La nouvelle couleur
   */
  public void setThumb(Color color) {
    this.thumb.setBackground(color);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g.create();

    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    g2d.setColor(this.getBackground());
    g2d.fillRoundRect(0, (KSlider.HEIGHT - KSlider.TRACK_HEIGHT) / 2, this.getWidth(), KSlider.TRACK_HEIGHT,
        KSlider.TRACK_HEIGHT, KSlider.TRACK_HEIGHT);

    g2d.dispose();
  }
}
