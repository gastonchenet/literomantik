package fr.kanassoulier.literomantik.gui;

import javax.swing.JLayeredPane;

import fr.kanassoulier.literomantik.enums.KeyboardKey;
import fr.kanassoulier.literomantik.game.Game;

/**
 * La GUI du jeu
 * 
 * @version 1.0
 * @author Gaston Chenet
 */
public class Gui extends JLayeredPane {
  private Scoreboard scoreboard;
  private ScoreUpdate scoreUpdate;
  private TileStack tileStack;
  private PreviewTile previewTile;
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
    this.scoreUpdate = new ScoreUpdate(this);
    this.tileStack = new TileStack(this);

    this.setLayout(null);
    this.setBounds(0, 0, Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT);

    this.previewTile = new PreviewTile(this, game.getBoard());
    this.add(this.previewTile);
    this.add(this.tileStack);
    this.add(this.scoreboard);
    this.add(this.scoreUpdate);

    this.add(new KeyInfo(KeyboardKey.ESCAPE, "Mettre en pause", Game.WINDOW_WIDTH - 250, 20));
    this.add(new KeyInfo(KeyboardKey.MOUSE_LEFT_CLICK, "Placer la tuile", Game.WINDOW_WIDTH - 250, 64));
    this.add(new KeyInfo(KeyboardKey.MOUSE_WHEEL, "Tourner la tuile", Game.WINDOW_WIDTH - 250, 108));

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
   * Récupérer le score update.
   * 
   * @return Le score update.
   */
  public ScoreUpdate getScoreUpdate() {
    return this.scoreUpdate;
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
