package fr.kanassoulier.dorfromantik.gui;

import javax.swing.JPanel;

import fr.kanassoulier.dorfromantik.Game;
import fr.kanassoulier.dorfromantik.board.PreviewTile;

public class Gui extends JPanel {
  private Scoreboard scoreboard = new Scoreboard();
  private PreviewTile previewTile;

  public Gui(Game game) {
    super(true);

    this.setLayout(null);

    this.setBounds(0, 0, Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT);

    this.previewTile = new PreviewTile(game.getBoard());
    this.add(this.previewTile);
    this.add(this.scoreboard);
    this.setOpaque(false);
  }

  public Scoreboard getScoreboard() {
    return this.scoreboard;
  }

  public PreviewTile getPreviewTile() {
    return this.previewTile;
  }
}
