package fr.kanassoulier.literomantik.landing;

import javax.swing.JDialog;
import javax.swing.border.EmptyBorder;

import fr.kanassoulier.literomantik.Options;
import fr.kanassoulier.literomantik.components.KButton;
import fr.kanassoulier.literomantik.components.KCheckBox;
import fr.kanassoulier.literomantik.components.KSlider;
import fr.kanassoulier.literomantik.enums.KButtonType;
import fr.kanassoulier.literomantik.enums.SoundChannel;
import fr.kanassoulier.literomantik.utils.FontLoader;
import fr.kanassoulier.literomantik.utils.ImageLoader;
import fr.kanassoulier.literomantik.utils.SoundPlayer;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.Color;
import java.awt.Dialog;

/**
 * Interface graphique servant à modifier les paramètres pour la partie
 * 
 * @version 1.3
 * @author Maxence Raymond, Gaston Chenet
 */
public class Settings extends JDialog {
	private KSlider musicVolumeSlider;
	private KSlider eventVolumeSlider;
	private KCheckBox muteButton;

	/**
	 * Constructeur du dialogue Parameters
	 * 
	 * @param dialog endroit sur laquelle la modalite se base
	 */
	public Settings(Window dialog) {
		super(dialog, "Parametres", Dialog.ModalityType.APPLICATION_MODAL);

		this.setIconImage(ImageLoader.APP_ICON);
		this.setSize(300, 280);

		JPanel content = new JPanel();

		content.setBackground(Color.WHITE);
		content.setLayout(new GridBagLayout());
		content.setBorder(new EmptyBorder(10, 10, 10, 10));

		JLabel title = new JLabel("Parametres de son");
		title.setFont(FontLoader.LEXEND_BOLD.deriveFont(26f));
		title.setBorder(new EmptyBorder(0, 0, 25, 0));

		JLabel musicVolumeLabel = new JLabel("Volume de la musique :");
		JLabel eventVolumeLabel = new JLabel("Volume des effets sonores :");

		musicVolumeLabel.setFont(FontLoader.LEXEND_REGULAR.deriveFont(14f));
		eventVolumeLabel.setFont(FontLoader.LEXEND_REGULAR.deriveFont(14f));

		this.musicVolumeSlider = new KSlider(0, 100);
		this.eventVolumeSlider = new KSlider(0, 100);
		this.muteButton = new KCheckBox("Couper tous les sons");
		this.muteButton.setChecked(Options.MUTED);

		KButton validateButton = new KButton("Sauvegarder", KButtonType.SAVE);
		validateButton.setPadding(10, 26, 10, 26);
		validateButton.setForeground(Color.WHITE);
		validateButton.setBackground(new Color(71, 71, 252));
		validateButton.setHoverBackground(new Color(50, 50, 201));
		validateButton.addActionListener(new SettingsButtonListener(KButtonType.YES, this));

		KButton cancelButton = new KButton("Annuler", KButtonType.CANCEL);
		cancelButton.setPadding(10, 26, 10, 26);
		cancelButton.setHoverBackground(new Color(230, 230, 230));
		cancelButton.addActionListener(new SettingsButtonListener(KButtonType.CANCEL, this));

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		content.add(title);

		gbc.gridy = 1;
		content.add(musicVolumeLabel, gbc);

		gbc.gridy = 2;
		gbc.insets = new Insets(0, 0, 10, 0);
		content.add(this.musicVolumeSlider, gbc);

		gbc.gridy = 3;
		gbc.insets = new Insets(0, 0, 0, 0);
		content.add(eventVolumeLabel, gbc);

		gbc.gridy = 4;
		gbc.insets = new Insets(0, 0, 10, 0);
		content.add(this.eventVolumeSlider, gbc);

		gbc.gridy = 5;
		content.add(this.muteButton, gbc);

		JPanel buttons = new JPanel();
		buttons.setOpaque(false);
		buttons.setLayout(new FlowLayout(FlowLayout.RIGHT));

		buttons.add(validateButton);
		buttons.add(cancelButton);

		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		content.add(buttons, gbc);

		this.setContentPane(content);
		this.setLocationRelativeTo(dialog);

		this.musicVolumeSlider.setValue(Options.MUSIC_VOLUME, true);
		this.eventVolumeSlider.setValue(Options.SOUND_VOLUME, true);
	}

	/**
	 * Extrait et met à jour les valeurs
	 */
	protected final void setValues() {
		int musicVolume = this.musicVolumeSlider.getValue();
		int eventVolume = this.eventVolumeSlider.getValue();

		Options.MUSIC_VOLUME = musicVolume;
		Options.SOUND_VOLUME = eventVolume;

		SoundPlayer.changeVolume(SoundChannel.MUSIC, musicVolume);
		SoundPlayer.changeVolume(SoundChannel.SOUND, eventVolume);

		Options.MUTED = this.muteButton.isChecked();
		SoundPlayer.setMuted(this.muteButton.isChecked());

		this.dispose();
	}
}
