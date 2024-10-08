package fr.kanassoulier.dorfromantik.gui;

import javax.swing.JLayeredPane;

import fr.kanassoulier.dorfromantik.Game;
import fr.kanassoulier.dorfromantik.board.PreviewTile;

public class Gui extends JLayeredPane {
  private Scoreboard scoreboard = new Scoreboard();
  private TileStack tileStack = new TileStack(this);
  private PreviewTile previewTile;
  private Game game;

  public Gui(Game game) {
    super();

    this.game = game;

    this.setLayout(null);
    this.setBounds(0, 0, Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT);

    this.previewTile = new PreviewTile(game.getBoard());
    this.add(this.previewTile);
    this.add(this.tileStack);
    this.add(this.scoreboard);
    this.setOpaque(false);
  }

  public Game getGame() {
    return this.game;
  }

  public Scoreboard getScoreboard() {
    return this.scoreboard;
  }

  public PreviewTile getPreviewTile() {
    return this.previewTile;
  }
}
