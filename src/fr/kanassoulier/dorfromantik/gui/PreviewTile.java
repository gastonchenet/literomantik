package fr.kanassoulier.dorfromantik.gui;

import java.awt.Point;

import javax.swing.Timer;

import fr.kanassoulier.dorfromantik.Options;
import fr.kanassoulier.dorfromantik.game.Board;
import fr.kanassoulier.dorfromantik.game.Game;
import fr.kanassoulier.dorfromantik.game.Tile;

public class PreviewTile extends Tile {
  private Timer animationTimer;

  public PreviewTile(Board board) {
    super(board, 140, Game.WINDOW_HEIGHT - 120, Options.PREVIEW_TILE_SIZE);
  }

  public void stopAnimation() {
    this.animationTimer.stop();
  }

  public void setAnimationDelay(int delay) {
    this.animationTimer.setDelay(delay);
  }

  public int getAnimationDelay() {
    return this.animationTimer.getDelay();
  }

  public void animateTo(Point target) {
    this.animationTimer = new Timer(1, new PreviewTileTimerListener(this, target));
    this.animationTimer.start();
  }

  public void animateTo(int x, int y) {
    this.animateTo(new Point(x, y));
  }
}
