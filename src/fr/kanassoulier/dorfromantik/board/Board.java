package fr.kanassoulier.dorfromantik.board;

import java.awt.Component;
import java.awt.Point;

import javax.swing.JPanel;

import fr.kanassoulier.dorfromantik.Game;
import fr.kanassoulier.dorfromantik.Options;

public class Board extends JPanel {
  private static final int BOARD_RADIUS = Options.TURNS * Options.CELL_RADIUS * 2;

  private Game game;

  private int x = Game.WINDOW_WIDTH / 2;
  private int y = Game.WINDOW_HEIGHT / 2;

  public Board(Game game) {
    super();

    this.game = game;

    // L'utilisateur ne doit pas atteindre le bout de la map même en faisant une
    // ligne equivalente au nombre de tours
    this.setBounds(this.x - Board.BOARD_RADIUS, this.y - Board.BOARD_RADIUS,
        Board.BOARD_RADIUS * 2, Board.BOARD_RADIUS * 2);

    this.setLayout(null);

    this.add(new PlaceableTile(this, Board.BOARD_RADIUS, Board.BOARD_RADIUS));
  }

  public Game getGame() {
    return this.game;
  }

  public Cell getCell(int x, int y) {
    for (Component component : this.getComponents()) {
      Cell cell = (Cell) component;

      if (cell.at(x, y))
        return cell;
    }

    return (Cell) new EmptyCell(this, x, y);
  }

  public Cell getCell(Point point) {
    return this.getCell(point.x, point.y);
  }

  public void placeTile(PlaceableArea area) {
    this.remove(area);

    PreviewTile previewTile = this.game.getGui().getPreviewTile();
    PlaceableTile tile = new PlaceableTile(previewTile, area.getCenter());

    this.add(tile);
    this.game.getGui().getScoreboard().updateScore(tile.getMatches());

    previewTile.refill();
    this.game.repaint();
  }

  public void moveBoard(double deltaX, double deltaY) {
    this.x += Math.round(deltaX);
    this.y += Math.round(deltaY);

    this.setBounds(
        this.x - Board.BOARD_RADIUS,
        this.y - Board.BOARD_RADIUS,
        Board.BOARD_RADIUS * 2,
        Board.BOARD_RADIUS * 2);

    this.game.repaint();
  }
}