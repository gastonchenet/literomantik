package fr.kanassoulier.dorfromantik.game;

import fr.kanassoulier.dorfromantik.Options;
import fr.kanassoulier.dorfromantik.enums.Biome;
import fr.kanassoulier.dorfromantik.enums.TileSide;

/**
 * La tuile de prévisualisation.
 * 
 * @version 1.0
 * @author Gaston Chenet
 */
public class PreviewTile extends Tile {
  /**
   * Constructeur de la tuile de prévisualisation.
   * 
   * @param board Le plateau de jeu.
   */
  public PreviewTile(Board board) {
    super(board, 140, Game.WINDOW_HEIGHT - 120, Options.PREVIEW_TILE_SIZE);
  }

  /**
   * Récupérer les biomes de la tuile.
   * 
   * @return Les biomes de la tuile.
   */
  public Biome[] getBiomes() {
    Biome[] biomes = new Biome[TileSide.values().length];

    for (TileSide side : TileSide.values()) {
      biomes[side.ordinal()] = this.getBiome(side);
    }

    return biomes;
  }
}
