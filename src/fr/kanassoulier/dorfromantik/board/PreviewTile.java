package fr.kanassoulier.dorfromantik.board;

import fr.kanassoulier.dorfromantik.Game;
import fr.kanassoulier.dorfromantik.enums.Biome;
import fr.kanassoulier.dorfromantik.enums.TileSide;

public class PreviewTile extends Tile {
  public PreviewTile(Board board) {
    super(board, 90, Game.WINDOW_HEIGHT - 120, 70);
  }

  public Biome[] getBiomes() {
    Biome[] biomes = new Biome[TileSide.values().length];

    for (TileSide side : TileSide.values()) {
      biomes[side.ordinal()] = this.getBiome(side);
    }

    return biomes;
  }
}
