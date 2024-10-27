package fr.kanassoulier.literomantik.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe permettant de gérer l'animation de la mise à jour du score
 * 
 * @version 1.0
 * @author Gaston Chenet
 */
public class ScoreUpdateTimerListener implements ActionListener {
  private ScoreUpdate scoreUpdate;
  private double deltaY = 0;

  /**
   * Constructeur de ScoreUpdateTimerListener
   * 
   * @param scoreUpdate La mise à jour du score
   */
  public ScoreUpdateTimerListener(ScoreUpdate scoreUpdate) {
    this.scoreUpdate = scoreUpdate;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    this.deltaY += 2;

    this.scoreUpdate.setVerticalAxis((int) this.deltaY);
    this.scoreUpdate.setOpacity((int) Math.max(0, 255 - 5.1 * this.deltaY));

    if (this.deltaY >= 50) {
      this.scoreUpdate.getTimer().stop();
    }
  }
}
