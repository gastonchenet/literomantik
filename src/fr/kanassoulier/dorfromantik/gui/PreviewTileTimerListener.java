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

  @Override
  public void actionPerformed(ActionEvent e) {
    Point center = this.previewTile.getCenter();
    float velocity = 2.0f;

    int x = center.x;
    int y = center.y;

    if (center.x < this.target.x) {
      x += velocity;
    } else if (center.x > this.target.x) {
      x -= velocity;
    }

    if (center.y < this.target.y) {
      y += velocity;
    } else if (center.y > this.target.y) {
      y -= velocity;
    }

    if (Math.abs(center.x - this.target.x) <= velocity) {
      x = this.target.x;
    }

    if (Math.abs(center.y - this.target.y) <= velocity) {
      y = this.target.y;
    }

    this.previewTile.setCenter(new Point(x, y));

    if (x == this.target.x && y == this.target.y) {
      this.previewTile.stopAnimation();
    }

    this.previewTile.repaint();
  }
}
