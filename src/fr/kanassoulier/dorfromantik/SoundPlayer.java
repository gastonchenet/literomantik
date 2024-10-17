package fr.kanassoulier.dorfromantik;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import fr.kanassoulier.dorfromantik.enums.SoundChannel;

/**
 * Permet de jouer des sons dans le jeu.
 * 
 * @version 1.0
 * @author Gaston Chenet
 */
public class SoundPlayer {

  /**
   * Normalise le volume entre 0 et 100 en dBFS.
   * 
   * @param volume Le volume à normaliser.
   * @param min    La valeur minimale du volume.
   * @param max    La valeur maximale du volume.
   * @return Le volume normalisé.
   */
  private static float normalizeVolume(int volume, int min, int max) {
    // Le volume est entre min et max, on le convertit en dBFS (de -80 à 6)
    return (float) volume / 100f * (float) (max - min) / 100f * 86f - 80f;
  }

  /**
   * Normalise le volume entre 0 et 100 en dBFS.
   * 
   * @param volume Le volume à normaliser.
   * @return Le volume normalisé.
   */
  public static float normalizeVolume(int volume) {
    return SoundPlayer.normalizeVolume(volume, 0, 100);
  }

  /**
   * Joue un son.
   * 
   * @param soundPath Le chemin du son
   * @param channel   Le canal sur lequel jouer le son
   */
  public static void play(String soundPath, SoundChannel channel) {
    try {
      AudioInputStream sound = AudioSystem.getAudioInputStream(new File("resources/sounds/" + soundPath + ".wav"));
      Clip clip = AudioSystem.getClip();
      clip.open(sound);
      FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

      switch (channel) {
        case MUSIC:
          gainControl.setValue(SoundPlayer.normalizeVolume(Options.MUSIC_VOLUME, 0, 80));
          clip.loop(Clip.LOOP_CONTINUOUSLY);
          break;

        default:
          gainControl.setValue(SoundPlayer.normalizeVolume(Options.SOUND_VOLUME));
          clip.start();
          break;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
