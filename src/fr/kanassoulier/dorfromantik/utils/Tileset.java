package fr.kanassoulier.dorfromantik.utils;

import java.util.Random;

/**
 * Classe contenant le tileset
 */
public class Tileset {
  private Random randomizer;

  /**
   * Constructeur de la classe Tileset
   * 
   * @param seed La seed permettant de générer des tuiles aléatoires
   */
  public Tileset(long seed) {
    this.randomizer = new Random(seed);
  }

  /**
   * Constructeur de la classe Tileset
   */
  public Tileset() {
    this.randomizer = new Random(System.currentTimeMillis());
  }

  /**
   * Récupérer le générateur de nombres aléatoires
   * 
   * @return Le générateur de nombres aléatoires
   */
  public Random getRandomizer() {
    return this.randomizer;
  }
}