package fr.kanassoulier.dorfromantik.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScoreUpdateTimerListener implements ActionListener {
  private ScoreUpdate scoreUpdate;
  private double deltaY = 0;

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
