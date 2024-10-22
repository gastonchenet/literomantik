package fr.kanassoulier.dorfromantik.utils;

import java.util.Arrays;
import java.util.HashMap;

import fr.kanassoulier.dorfromantik.enums.Biome;
import fr.kanassoulier.dorfromantik.enums.TileSide;
import fr.kanassoulier.dorfromantik.game.Board;
import fr.kanassoulier.dorfromantik.game.Cell;
import fr.kanassoulier.dorfromantik.game.PlaceableTile;

/**
 * Classe permettant de calculer le score d'un plateau
 * 
 * @author Maxence Raymond
 * @author Gaston Chenet
 * @version 1.0
 */
public final class ScoreLogic {
  /**
   * Grouper les poches d'un biome spécifique à partir d'une tuile.
   * 
   * @param tile          La tuile à analyser.
   * @param biome         Le biome à chercher.
   * @param visited       Les tuiles déjà visitées.
   * @param currentPocket L'identifiant de la poche actuelle.
   * @return Les tuiles visitées et leur poche.
   */
  private static HashMap<String, Integer> groupPocket(
      PlaceableTile tile, Biome biome,
      HashMap<String, Integer> visited,
      int currentPocket) {

    String discriminator = tile.getDiscriminator();

    if (visited.containsKey(discriminator)) {
      return visited;
    }

    visited.put(discriminator, tile.hasBiome(biome) ? currentPocket : -1);

    for (TileSide side : TileSide.values()) {
      Cell neighbor = tile.getNeighbor(side);
      String neighborDiscriminator = neighbor.getDiscriminator();

      if (neighbor == null || !(neighbor instanceof PlaceableTile)
          || visited.containsKey(neighborDiscriminator)) {
        continue;
      }

      if (tile.getBiome(side) != biome || !tile.match(side)) {
        if (!((PlaceableTile) neighbor).hasBiome(biome)) {
          visited.put(neighborDiscriminator, -1);
        }

        continue;
      }

      HashMap<String, Integer> pockets = ScoreLogic.groupPocket((PlaceableTile) neighbor, biome, visited,
          currentPocket);
      visited.putAll(pockets);
    }

    return visited;
  }

  /**
   * Fonction publique permettant de calculer le score d'un plateau
   * 
   * @param plateau Le plateau à évaluer
   * @return le score de ce plateau
   */
  public static int calculate(Board plateau) {
    int score = 0;

    for (Biome biome : Biome.values()) {
      HashMap<String, Integer> pockets = new HashMap<>();
      int lastBiome = 0;

      for (Object component : plateau.getComponents()) {
        if (!(component instanceof PlaceableTile))
          continue;

        PlaceableTile tile = (PlaceableTile) component;

        if (pockets.containsKey(tile.getDiscriminator()))
          continue;

        int visitedCount = pockets.size();

        ScoreLogic.groupPocket(tile, biome, pockets, lastBiome);

        if (visitedCount < pockets.size()) {
          lastBiome++;
        }
      }

      for (int value : pockets.values()) {
        lastBiome = Integer.max(lastBiome, value);
      }

      int[] pocketSizes = new int[lastBiome + 1];
      Arrays.fill(pocketSizes, 0);

      for (int pocket : pockets.values()) {
        if (pocket < 0)
          continue;

        pocketSizes[pocket]++;
      }

      for (int size : pocketSizes) {
        score += (int) Math.pow(size, 2);
      }
    }

    return score;
  }
}
