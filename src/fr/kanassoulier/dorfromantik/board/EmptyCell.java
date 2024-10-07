package fr.kanassoulier.dorfromantik.board;

import fr.kanassoulier.dorfromantik.Options;

public class EmptyCell extends Cell {
  public EmptyCell(Board board, int x, int y) {
    super(board, x, y, Options.CELL_RADIUS);
  }
}
