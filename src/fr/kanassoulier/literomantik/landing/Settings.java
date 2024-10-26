package fr.kanassoulier.literomantik.landing;

import javax.swing.JDialog;
import javax.swing.JSlider;

import fr.kanassoulier.literomantik.Options;
import fr.kanassoulier.literomantik.components.KButton;
import fr.kanassoulier.literomantik.enums.KButtonType;
import fr.kanassoulier.literomantik.enums.SoundChannel;
import fr.kanassoulier.literomantik.utils.FontLoader;
import fr.kanassoulier.literomantik.utils.ImageLoader;
import fr.kanassoulier.literomantik.utils.SoundPlayer;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Dialog;

/**
 * Interface graphique servant à modifier les paramètres pour la partie
 * 
 * @version 1.2
 * @author Maxence Raymond
 */
public class Settings extends JDialog {
	private JSlider musicVolumeSlider;
	private JSlider eventVolumeSlider;
	private JCheckBox muteButton;

	/**
	 * Constructeur du dialogue Parameters
	 * 
	 * @param menu endroit sur laquelle la modalite se base
	 */
	public Settings(LandingMenu menu) {
		super(menu, "Parametres", Dialog.ModalityType.APPLICATION_MODAL);

		this.setIconImage(ImageLoader.APP_ICON);
		this.setLayout(new BorderLayout());

		this.musicVolumeSlider = new JSlider(0, 100, Options.MUSIC_VOLUME);
		this.eventVolumeSlider = new JSlider(0, 100, Options.SOUND_VOLUME);
		this.muteButton = new JCheckBox("Couper tout les sons");

		if (Options.MUTED) {
			this.muteButton.setSelected(true);
		}

		JPanel mainJPanel = new JPanel(new GridLayout(3, 1));

		mainJPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		JPanel top = new JPanel();
		top.add(new JLabel("Volume de la musique :"));
		top.add(this.musicVolumeSlider);

		JPanel middle = new JPanel();
		middle.add(new JLabel("Volume des effets sonores :"));
		middle.add(this.eventVolumeSlider);

		JLabel title = new JLabel("Parametres de son");
		title.setFont(FontLoader.LEXEND_REGULAR);

		mainJPanel.add(top);
		mainJPanel.add(middle);
		mainJPanel.add(this.muteButton);

		this.add(title, BorderLayout.NORTH);

		KButton validateButton = new KButton("Valider", KButtonType.SAVE);
		validateButton.addActionListener(new SettingsButtonListener(SettingsButtonListener.VALIDATE, this));
		KButton cancelButton = new KButton("Annuler", KButtonType.CANCEL);
		cancelButton.addActionListener(new SettingsButtonListener(SettingsButtonListener.CANCEL, this));
		JPanel finalButtons = new JPanel(new FlowLayout(FlowLayout.LEADING));

		finalButtons.add(validateButton);
		finalButtons.add(cancelButton);

		this.add(finalButtons, BorderLayout.SOUTH);
		this.add(mainJPanel, BorderLayout.CENTER);

		this.pack();
		this.setLocationRelativeTo(menu);
		this.setVisible(true);
	}

	/**
	 * Extrait et met à jour les valeurs
	 */
	protected final void setValues() {
		if (this.muteButton.isSelected()) {
			Options.MUTED = true;
			SoundPlayer.deactivateSound(true);
		} else {
			Options.MUTED = false;
			SoundPlayer.deactivateSound(false);
		}

		int musicVolume = this.musicVolumeSlider.getValue();
		int eventVolume = this.eventVolumeSlider.getValue();

		Options.MUSIC_VOLUME = musicVolume;
		Options.SOUND_VOLUME = eventVolume;

		SoundPlayer.changeVolume(SoundChannel.MUSIC, musicVolume);
		SoundPlayer.changeVolume(SoundChannel.SOUND, eventVolume);

		this.exit();
	}

	/**
	 * Demande confirmation avant de mettre à jour les valeurs
	 */
	public void confirm() {
		int retour = JOptionPane.showConfirmDialog(this, new JLabel("Valider les changements ?"),
				"Confirmation requise", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

		if (retour == JOptionPane.OK_OPTION) {
			this.setValues();
		}

		this.exit();
	}

	/**
	 * Ferme la fenêtre
	 */
	public void exit() {
		this.dispose();
	}
}
