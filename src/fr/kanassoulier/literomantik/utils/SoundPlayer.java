package fr.kanassoulier.literomantik.utils;

import java.io.IOException;
import java.util.HashMap;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.UnsupportedAudioFileException;

import fr.kanassoulier.literomantik.Options;
import fr.kanassoulier.literomantik.enums.SoundChannel;

/**
 * Permet de jouer des sons dans le jeu.
 * 
 * @version 1.3
 * @author Gaston Chenet, Maxence Raymond
 */
public class SoundPlayer {
	private static HashMap<SoundChannel, SoundPlayer> channels = new HashMap<>();

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

	public static void changeVolume(SoundChannel channel, int volume) {
		SoundPlayer player = SoundPlayer.channels.get(channel);
		if (player == null)
			return;

		FloatControl gainControl = (FloatControl) player.clip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(SoundPlayer.normalizeVolume(volume));
	}

	/**
	 * Joue un son.
	 * 
	 * @param soundPath Le chemin du son
	 * @param channel   Le canal sur lequel jouer le son
	 */
	public static void play(String soundPath, SoundChannel channel) {
		try {
			SoundPlayer player = SoundPlayer.channels.get(channel);

			if (player == null) {
				AudioInputStream sound = SoundPlayer.getInputStream(soundPath);
				Clip clip = AudioSystem.getClip();
				clip.open(sound);

				FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
				player = new SoundPlayer(channel, clip, gainControl);
				SoundPlayer.channels.put(channel, player);
			}

			switch (channel) {
				case MUSIC:
					player.control.setValue(SoundPlayer.normalizeVolume(Options.MUTED ? 0 : Options.MUSIC_VOLUME, 0, 80));
					player.clip.loop(Clip.LOOP_CONTINUOUSLY);
					break;

				default:
					player.control.setValue(SoundPlayer.normalizeVolume(Options.MUTED ? 0 : Options.SOUND_VOLUME));
					player.clip.start();
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
	 * @param state L'état du son
	 */
	public static void setMuted(boolean state) {
		for (SoundPlayer player : SoundPlayer.channels.values()) {
			if (player == null)
				return;

			switch (player.channel) {
				case MUSIC:
					player.control.setValue(SoundPlayer.normalizeVolume(state ? 0 : Options.MUSIC_VOLUME, 0, 80));
					break;

				default:
					player.control.setValue(SoundPlayer.normalizeVolume(state ? 0 : Options.SOUND_VOLUME));
					break;
			}
		}
	}

	public static void kill() {
		for (SoundPlayer player : SoundPlayer.channels.values()) {
			player.clip.stop();
			player.clip.close();
		}
	}

	private SoundChannel channel;
	private Clip clip;
	private FloatControl control;

	public SoundPlayer(SoundChannel channel, Clip clip, FloatControl control) {
		this.channel = channel;
		this.clip = clip;
		this.control = control;
	}
}
