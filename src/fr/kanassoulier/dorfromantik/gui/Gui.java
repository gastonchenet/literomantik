package fr.kanassoulier.dorfromantik.gui;

import javax.swing.JLayeredPane;

import fr.kanassoulier.dorfromantik.Options;
import fr.kanassoulier.dorfromantik.enums.KeyboardKey;
import fr.kanassoulier.dorfromantik.game.Game;
import fr.kanassoulier.dorfromantik.game.Tile;

/**
 * La GUI du jeu
 * 
 * @version 1.0
 * @author Gaston Chenet
 */
public class Gui extends JLayeredPane {
  private Scoreboard scoreboard;
  private TileStack tileStack;
  private Tile previewTile;
  private Game game;

  /**
   * Constructeur de la GUI.
   * 
   * @param game La classe de jeu.
   */
  public Gui(Game game) {
    super();

    this.game = game;
    this.scoreboard = new Scoreboard(this);
    this.tileStack = new TileStack(this);

    this.setLayout(null);
    this.setBounds(0, 0, Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT);

    this.previewTile = new Tile(game.getBoard(), 140, Game.WINDOW_HEIGHT - 120, Options.PREVIEW_TILE_SIZE);
    this.add(this.previewTile);
    this.add(this.tileStack);
    this.add(this.scoreboard);

    this.add(new KeyInfo(KeyboardKey.MOUSE_LEFT_CLICK, "Placer la tuile", Game.WINDOW_WIDTH - 250, 20));
    this.add(new KeyInfo(KeyboardKey.MOUSE_WHEEL, "Tourner la tuile", Game.WINDOW_WIDTH - 250, 64));

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
  public Tile getPreviewTile() {
    return this.previewTile;
  }
}
