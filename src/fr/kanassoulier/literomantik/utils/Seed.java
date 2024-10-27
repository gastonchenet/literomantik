package fr.kanassoulier.literomantik.utils;

/**
 * Classe permettant de stocker une graine
 */
public class Seed {
  public String name;
  public long value;

  /**
   * Constructeur de Seed
   * 
   * @param name  Le nom de la graine
   * @param value La valeur de la graine
   */
  public Seed(String name, long value) {
    this.name = name;
    this.value = value;
  }
}
