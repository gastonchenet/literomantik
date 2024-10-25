package fr.kanassoulier.dorfromantik.gui;

import java.awt.event.ActionListener;
import java.awt.Point;
import java.awt.event.ActionEvent;

public class PreviewTileTimerListener implements ActionListener {
  private PreviewTile previewTile;
  private Point target;

  public PreviewTileTimerListener(PreviewTile previewTile, Point target) {
    this.previewTile = previewTile;
    this.target = target;
  }

  private int easeOut(int start, int end, int current, int max) {
    return (int) (end - (end - start) * Math.pow(1 - (double) current / max, 2));
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    int x = this.previewTile.getX();
    int y = this.previewTile.getY();
    int targetX = this.target.x;
    int targetY = this.target.y;
    int dx = targetX - x;
    int dy = targetY - y;
    int max = 100;
    int current = this.previewTile.getAnimationDelay();
    if (current >= max) {
      this.previewTile.stopAnimation();
    } else {
      this.previewTile.setLocation(
          this.easeOut(x, targetX, current, max),
          this.easeOut(y, targetY, current, max));
      this.previewTile.setAnimationDelay(current + 1);
    }

    this.previewTile.repaint();
  }
}
