package fr.kanassoulier.dorfromantik.enums;

import java.awt.Color;
import java.util.Random;

public enum Biome {
  SEA, FIELD, PLAIN, FOREST, MOUNTAIN;

  public static Biome getRandomBiome() {
    Biome[] biomes = Biome.values();
    Random random = new Random();

    return biomes[random.nextInt(biomes.length)];
  }

  public Color[] getBiomeColors() {
    switch (this) {
      case SEA:
        return new Color[] { new Color(30, 143, 218), new Color(63, 169, 245), new Color(0, 113, 188) };
      case FIELD:
        return new Color[] { new Color(237, 224, 33), new Color(252, 238, 33), new Color(220, 205, 0) };
      case PLAIN:
        return new Color[] { new Color(120, 200, 120), new Color(140, 220, 140), new Color(100, 180, 100) };
      case FOREST:
        return new Color[] { new Color(20, 120, 70), new Color(40, 140, 90), new Color(0, 100, 50) };
      case MOUNTAIN:
        return new Color[] { new Color(120, 120, 120), new Color(140, 140, 140), new Color(100, 100, 100) };
      default:
        throw new IllegalArgumentException("Unknown Biome: " + this);
    }
  }
}
