package fr.kanassoulier.dorfromantik;

import fr.kanassoulier.dorfromantik.landing.LandingMenu;
import fr.kanassoulier.dorfromantik.utils.Environment;

/**
 * Classe principale du jeu
 * 
 * @version 1.0
 * @author Gaston Chenet
 */
public class Main {
  /**
   * Méthode principale du jeu
   * 
   * @param args Les arguments passés au programme
   */
  public static void main(String[] args) {
    Environment.load();
    new LandingMenu().setVisible(true);
  }
}
