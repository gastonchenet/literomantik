package fr.kanassoulier.dorfromantik.gui;

import java.awt.event.ActionListener;

import java.awt.Point;
import java.awt.event.ActionEvent;

public class PreviewTileTimerListener implements ActionListener {
  private static int END_TILE_RADIUS = 24;
  private static double SPEED = 2d;
  private static double EASING_FACTOR = 0.2d;

  private PreviewTile previewTile;
  private Point targetPosition;

  public PreviewTileTimerListener(PreviewTile previewTile, Point targetPosition) {
    this.previewTile = previewTile;
    this.targetPosition = targetPosition;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Point currentPos = this.previewTile.getCenter();
    int radius = this.previewTile.getRadius();

    double dx = this.targetPosition.x - currentPos.x;
    double dy = this.targetPosition.y - currentPos.y;
    double distance = Math.sqrt(dx * dx + dy * dy);

    if (distance <= 5) {
      this.previewTile.stopAnimation();
      return;
    }

    double newX = currentPos.x + dx * SPEED * EASING_FACTOR;
    double newY = currentPos.y + dy * SPEED * EASING_FACTOR;
    double newRadius = radius + (END_TILE_RADIUS - radius) * EASING_FACTOR;

    this.previewTile.setRadius((int) newRadius);
    this.previewTile.setCenter(new Point((int) newX, (int) newY));
  }
}
