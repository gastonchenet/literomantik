package fr.kanassoulier.literomantik.components;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Classe permettant de gérer les événements de souris sur un KSliderThumb
 * 
 * @version 1.0
 * @author Gaston Chenet
 */
public class KSliderThumbListener implements MouseMotionListener {
  private KSliderThumb thumb;

  /**
   * Constructeur de KSliderThumbListener
   * 
   * @param thumb Le curseur à écouter
   */
  public KSliderThumbListener(KSliderThumb thumb) {
    this.thumb = thumb;
  }

  @Override
  public void mouseDragged(MouseEvent e) {
    int trackWidth = this.thumb.getSlider().getWidth() - KSliderThumb.WIDTH;
    int trackX = (int) Math.max(Math.min(this.thumb.getX() + e.getX(), trackWidth), 0);

    this.thumb.setLocation(trackX, 0);

    int value = this.thumb.getSlider().getMin()
        + (int) ((double) trackX / trackWidth * (this.thumb.getSlider().getMax() - this.thumb.getSlider().getMin()));

    value = value - value % this.thumb.getSlider().getStep();

    this.thumb.getSlider().setValue(value);
  }

  @Override
  public void mouseMoved(MouseEvent e) {
  }
}
