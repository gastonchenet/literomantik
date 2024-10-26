package fr.kanassoulier.literomantik;

import fr.kanassoulier.literomantik.enums.SoundChannel;
import fr.kanassoulier.literomantik.landing.LandingMenu;
import fr.kanassoulier.literomantik.utils.Environment;
import fr.kanassoulier.literomantik.utils.SoundPlayer;

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
    SoundPlayer.play("music", SoundChannel.MUSIC);

    new LandingMenu().setVisible(true);
  }
}
