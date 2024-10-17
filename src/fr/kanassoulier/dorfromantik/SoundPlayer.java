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
   * @return Le volume normalisé.
   */
  private static float normalizeVolume(int volume) {
    // Le volume est entre 0 et 100, on le convertit en dBFS (de -80 à 6)
    return (float) volume / 100f * 86f - 80f;
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
          gainControl.setValue(SoundPlayer.normalizeVolume(Options.MUSIC_VOLUME));
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
