package fr.kanassoulier.dorfromantik.gui;

import javax.swing.JLayeredPane;

import fr.kanassoulier.dorfromantik.Game;
import fr.kanassoulier.dorfromantik.board.PreviewTile;

/**
 * La GUI du jeu
 * 
 * @version 1.0
 * @author Gaston Chenet
 */
public class Gui extends JLayeredPane {
  private Scoreboard scoreboard = new Scoreboard(this);
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

  /**
   * Récupérer la classe de jeu.
   * 
   * @return La classe de jeu.
   */
  public Game getGame() {
    return this.game;
  }

  /**
   * Récupérer le scoreboard.
   * 
   * @return Le scoreboard.
   */
  public Scoreboard getScoreboard() {
    return this.scoreboard;
  }

  /**
   * Récupérer la tuile de prévisualisation.
   * 
   * @return La tuile de prévisualisation.
   */
  public PreviewTile getPreviewTile() {
    return this.previewTile;
  }
}
