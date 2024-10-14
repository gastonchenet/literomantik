package fr.kanassoulier.dorfromantik.board;

import fr.kanassoulier.dorfromantik.Options;

/**
 * Une cellule vide.
 * 
 * @version 1.0
 * @author Gaston Chenet
 */
public class EmptyCell extends Cell {
  public EmptyCell(Board board, int x, int y) {
    super(board, x, y, Options.CELL_RADIUS);
  }
}
