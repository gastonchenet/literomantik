package fr.kanassoulier.dorfromantik.utils;

import fr.kanassoulier.dorfromantik.Options;

/**
 * Classe contenant le tileset
 */
public class Tileset {
  /**
   * Normaliser la seed
   * 
   * @param seed La seed à normaliser
   * @return La seed normalisée
   */
  public static long normalizeSeed(long seed) {
    return seed % (Long.MAX_VALUE - Options.TURNS);
  }

  private long seed;

  public Tileset(long seed) {
    this.seed = seed;
  }

  public Tileset() {
    this(System.currentTimeMillis());
  }

  /**
   * Définir la seed du tileset
   * @param seed La seed du tileset
   * 
   * @return L'instance du tileset
   */
  public void setSeed(long seed) {
    this.seed = seed;
  }

  /**
   * Récupérer la seed du tileset
   * 
   * @return La seed du tileset
   */
  public long getSeed() {
    return this.seed;
  }
}