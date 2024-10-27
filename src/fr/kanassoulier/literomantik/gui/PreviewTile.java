package fr.kanassoulier.literomantik.gui;

import java.awt.Point;

import javax.swing.Timer;

import fr.kanassoulier.literomantik.Options;
import fr.kanassoulier.literomantik.game.Board;
import fr.kanassoulier.literomantik.game.Game;
import fr.kanassoulier.literomantik.game.Tile;

/**
 * Classe de la tuile de prévisualisation
 * 
 * @version 1.0
 * @author Gaston Chenet
 */
public class PreviewTile extends Tile {
  private Timer animationTimer;
  private Point boardPosition;
  private Gui gui;

  /**
   * Le constructeur de PreviewTile
   * 
   * @param gui   Le GUI
   * @param board Le plateau de jeu
   */
  public PreviewTile(Gui gui, Board board) {
    super(board, 140, Game.WINDOW_HEIGHT - 120, Options.PREVIEW_TILE_SIZE);

    this.gui = gui;

    this.setCenter(140, Game.WINDOW_HEIGHT - 120);
  }

  /**
   * Permet de récupérer le GUI
   * 
   * @return Le GUI
   */
  public Gui getGui() {
    return this.gui;
  }

  /**
   * Permet de stopper l'animation
   */
  public void stopAnimation() {
    this.animationTimer.stop();
    this.animationTimer = null;

    this.setRadius(Options.PREVIEW_TILE_SIZE);
    this.setCenter(140, Game.WINDOW_HEIGHT - 120);

    this.getBoard().displayTile(this, this.boardPosition);
  }

  /**
   * Permet de définir le délai de l'animation
   * 
   * @param delay Le délai de l'animation
   */
  public void setAnimationDelay(int delay) {
    this.animationTimer.setDelay(delay);
  }

  /**
   * Permet de récupérer le délai de l'animation
   * 
   * @return Le délai de l'animation
   */
  public int getAnimationDelay() {
    return this.animationTimer.getDelay();
  }

  /**
   * Permet de définir la position du plateau
   * 
   * @param boardPosition La position du plateau
   * @param target        La cible de l'animation
   */
  public void animateTo(Point boardPosition, Point target) {
    this.boardPosition = boardPosition;

    if (this.animationTimer != null && this.animationTimer.isRunning()) {
      this.animationTimer.stop();
    }

    this.animationTimer = new Timer(10, new PreviewTileTimerListener(this, target));
    this.animationTimer.start();
  }
}
