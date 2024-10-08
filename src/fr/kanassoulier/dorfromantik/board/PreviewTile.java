package fr.kanassoulier.dorfromantik.board;

import fr.kanassoulier.dorfromantik.Game;
import fr.kanassoulier.dorfromantik.Options;
import fr.kanassoulier.dorfromantik.enums.Biome;
import fr.kanassoulier.dorfromantik.enums.TileSide;

public class PreviewTile extends Tile {
  public PreviewTile(Board board) {
    super(board, 140, Game.WINDOW_HEIGHT - 120, Options.PREVIEW_TILE_SIZE);
  }

  public Biome[] getBiomes() {
    Biome[] biomes = new Biome[TileSide.values().length];

    for (TileSide side : TileSide.values()) {
      biomes[side.ordinal()] = this.getBiome(side);
    }

    return biomes;
  }
}
