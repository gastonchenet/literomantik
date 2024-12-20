package fr.kanassoulier.literomantik.game;

import fr.kanassoulier.literomantik.Options;

/**
 * Une cellule vide.
 * 
 * @version 1.0
 * @author Gaston Chenet
 */
public class EmptyCell extends Cell {
  /**
   * Constructeur de la cellule vide.
   * 
   * @param board Le plateau de jeu.
   * @param x     Position x de la cellule.
   * @param y     Position y de la cellule.
   */
  public EmptyCell(Board board, int x, int y) {
    super(board, x, y, Options.CELL_RADIUS);
  }
}
