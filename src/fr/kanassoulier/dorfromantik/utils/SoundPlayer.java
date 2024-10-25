package fr.kanassoulier.dorfromantik.utils;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.UnsupportedAudioFileException;

import fr.kanassoulier.dorfromantik.Options;
import fr.kanassoulier.dorfromantik.enums.SoundChannel;

/**
 * Permet de jouer des sons dans le jeu.
 * 
 * @version 1.2
 * @author Gaston Chenet, Maxence Raymond
 */
public class SoundPlayer {
	private static FloatControl musicControl;
	private static Clip musicClip;

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
			AudioInputStream sound = SoundPlayer.getInputStream(soundPath);
			Clip clip = AudioSystem.getClip();
			clip.open(sound);
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

			switch (channel) {
				case MUSIC:
					gainControl.setValue(SoundPlayer.normalizeVolume(Options.MUTED ? 0 : Options.MUSIC_VOLUME, 0, 80));
					SoundPlayer.musicControl = gainControl;
					if (SoundPlayer.musicClip != null) {
						// ensuring a smooth rollover between them
						clip.setFramePosition(SoundPlayer.musicClip.getFramePosition());
						SoundPlayer.musicClip.stop();
					}
					SoundPlayer.musicClip = clip;
					clip.loop(Clip.LOOP_CONTINUOUSLY);
					break;

				default:
					gainControl.setValue(SoundPlayer.normalizeVolume(Options.MUTED ? 0 : Options.SOUND_VOLUME));
					clip.start();
					break;
			}
		} catch (Exception e) {
			System.err.println("Incapacité à lancer sur le channel : " + channel);
			e.printStackTrace();
		}
	}

	/**
	 * Gère le chargement de l'audio et les erreurs de fichier
	 * 
	 * @param soundPath Le nom du fichier à charger
	 * @return Le flux d'entrée audio
	 * @throws UnsupportedAudioFileException
	 */
	private static AudioInputStream getInputStream(String soundPath) throws UnsupportedAudioFileException {
		try {
			return AudioSystem.getAudioInputStream(Thread.currentThread().getContextClassLoader()
					.getResource("resources/sounds/" + soundPath + ".wav"));
		} catch (IOException e) {
			System.err.println("Fichier son inaccessible");
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Coupe ou réactive le son de la musique
	 * 
	 * @param state yes to mute the program, no to reactivate the sound
	 */
	public static void deactivateSound(boolean state) {
		try {
			if (state) {
				SoundPlayer.musicControl.setValue(SoundPlayer.normalizeVolume(0));
			} else {
				SoundPlayer.musicControl.setValue(SoundPlayer.normalizeVolume(Options.MUSIC_VOLUME, 0, 80));
			}
		} catch (NullPointerException e) {
			// It's okay, it means the music player wasn't launched yet
		}
	}
}
