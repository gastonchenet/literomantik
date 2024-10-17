package fr.kanassoulier.dorfromantik.board;

import java.awt.Point;

import fr.kanassoulier.dorfromantik.Options;
import fr.kanassoulier.dorfromantik.enums.Biome;
import fr.kanassoulier.dorfromantik.enums.TileSide;

/**
 * Une tuile qui peut être placée sur le plateau.
 * 
 * @version 1.0
 * @author Gaston Chenet
 */
public class PlaceableTile extends Tile {
  /**
   * Crée une tuile à placer avec des biomes spécifiques.
   * 
   * @param board  Le plateau de jeu.
   * @param x      La coordonnée x du centre de la tuile
   * @param y      La coordonnée y du centre de la tuile
   * @param biomes Les biomes de la tuile
   */
  public PlaceableTile(Board board, int x, int y, Biome... biomes) {
    super(board, x, y, Options.CELL_RADIUS, biomes);
    this.fillNeighbors();
  }

  /**
   * Crée une tuile à placer avec des biomes spécifiques.
   * 
   * @param board  Le plateau de jeu.
   * @param center Le centre de la tuile
   * @param biomes Les biomes de la tuile
   */
  public PlaceableTile(Board board, Point center, Biome... biomes) {
    this(board, center.x, center.y, biomes);
  }

  /**
   * Crée une tuile à placer avec des biomes spécifiques.
   * 
   * @param board Le plateau de jeu.
   * @param x     La coordonnée x du centre de la tuile
   * @param y     La coordonnée y du centre de la tuile
   */
  public PlaceableTile(Board board, int x, int y) {
    super(board, x, y, Options.CELL_RADIUS);
    this.fillNeighbors();
  }

  /**
   * Crée une tuile à placer avec des biomes spécifiques.
   * 
   * @param board  Le plateau de jeu.
   * @param center Le centre de la tuile
   */
  public PlaceableTile(Board board, Point center) {
    this(board, center.x, center.y);
  }

  /**
   * Crée une tuile à placer à partir d'une tuile de prévisualisation.
   * 
   * @param previewTile La tuile de prévisualisation.
   * @param center      Le centre de la tuile.
   */
  public PlaceableTile(PreviewTile previewTile, Point center) {
    this(previewTile.getBoard(), center, previewTile.getBiomes());
  }

  /**
   * Remplir les voisins vides d'une tuile à placer.
   */
  private void fillNeighbors() {
    for (TileSide side : TileSide.values()) {
      Cell neighbour = this.getNeighbor(side);

      if (neighbour instanceof EmptyCell) {
        Board board = this.getBoard();
        board.add(new PlaceableArea(board, neighbour.getCenter()));
      }
    }
  }

  /**
   * Le nombre de côtés qui correspondent au biome opposé d'un voisin.
   */
  public int getMatches() {
    int matches = 0;

    for (TileSide side : TileSide.values()) {
      if (this.matchesWith(side))
        matches++;
    }

    return matches;
  }
}
