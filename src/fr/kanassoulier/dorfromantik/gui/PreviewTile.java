package fr.kanassoulier.dorfromantik.gui;

import java.awt.Point;

import javax.swing.Timer;

import fr.kanassoulier.dorfromantik.Options;
import fr.kanassoulier.dorfromantik.game.Board;
import fr.kanassoulier.dorfromantik.game.Game;
import fr.kanassoulier.dorfromantik.game.Tile;

public class PreviewTile extends Tile {
  private Timer animationTimer;
  private Point boardPosition;

  public PreviewTile(Board board) {
    super(board, 140, Game.WINDOW_HEIGHT - 120, Options.PREVIEW_TILE_SIZE);
    this.setCenter(140, Game.WINDOW_HEIGHT - 120);
  }

  public void stopAnimation() {
    this.getBoard().displayTile(this, this.boardPosition);

    this.animationTimer.stop();
    this.animationTimer = null;

    this.setRadius(Options.PREVIEW_TILE_SIZE);
    this.setCenter(140, Game.WINDOW_HEIGHT - 120);

    this.repaint();
  }

  public void setAnimationDelay(int delay) {
    this.animationTimer.setDelay(delay);
  }

  public int getAnimationDelay() {
    return this.animationTimer.getDelay();
  }

  public void animateTo(Point boardPosition, Point target) {
    this.boardPosition = boardPosition;

    if (this.animationTimer != null && this.animationTimer.isRunning()) {
      this.animationTimer.stop();
    }

    this.animationTimer = new Timer(1, new PreviewTileTimerListener(this, target));
    this.animationTimer.start();
  }
}
