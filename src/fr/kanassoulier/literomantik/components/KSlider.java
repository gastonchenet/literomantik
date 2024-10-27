package fr.kanassoulier.literomantik.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class KSlider extends JPanel {
  public static final int WIDTH = 200;
  public static final int HEIGHT = 14;
  public static final int TRACK_HEIGHT = 4;

  private KSliderThumb thumb;
  private int min, max, value, step;

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

  public KSlider(int min, int max, int value) {
    this(min, max, value, 1);
  }

  public KSlider(int min, int max) {
    this(min, max, min + (max - min) / 2);
  }

  public int getMin() {
    return this.min;
  }

  public int getMax() {
    return this.max;
  }

  public int getValue() {
    return this.value;
  }

  public int getStep() {
    return this.step;
  }

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

  public void setValue(int value) {
    this.value = value;
  }

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
