package fr.kanassoulier.dorfromantik.landing;

import javax.swing.*;
import java.awt.*;

import fr.kanassoulier.dorfromantik.Options;
import fr.kanassoulier.dorfromantik.utils.FontLoader;
import fr.kanassoulier.dorfromantik.utils.SoundPlayer;

/**
 * Interface graphique servant à modifier les paramètres pour la partie
 * 
 * @version 1.0
 * @author Maxence Raymond
 */
public class Parameters extends JDialog {
    private JSlider musicVolumeSlider;
    private JSlider eventVolumeSlider;
    private JCheckBox muteButton;

    /**
     * Constructeur du dialogue Parameters
     * 
     * @param menu endroit sur laquelle la modalite se base
     */
    public Parameters(Window menu) {
        super(menu, "Parametres", Dialog.ModalityType.APPLICATION_MODAL);
        this.setLayout(new BorderLayout());
        this.musicVolumeSlider = new JSlider(0, 100, Options.MUSIC_VOLUME);
        this.eventVolumeSlider = new JSlider(0, 100, Options.SOUND_VOLUME);
        this.muteButton = new JCheckBox("Couper tout les sons");
        if (Options.MUTED) {
            this.muteButton.setSelected(true);
        }

        JPanel mainJPanel = new JPanel(new GridLayout(3, 1));
        JPanel top = new JPanel();
        top.add(new JLabel("Volume de la musique :"));
        JPanel middle = new JPanel();
        middle.add(new JLabel("Volume des effets sonores :"));
        top.add(this.musicVolumeSlider);
        mainJPanel.add(top);
        middle.add(this.eventVolumeSlider);
        mainJPanel.add(middle);
        mainJPanel.add(this.muteButton);

        JLabel titre = new JLabel("Parametres de son");
        titre.setFont(FontLoader.LEXEND_REGULAR);
        this.add(titre, BorderLayout.NORTH);

        JButton validateButton = new JButton("Valider");
        validateButton.addActionListener(new ParametersButtonListener(ParametersButtonListener.VALIDATE, this));
        JButton cancelButton = new JButton("Annuler");
        cancelButton.addActionListener(new ParametersButtonListener(ParametersButtonListener.CANCEL, this));
        JPanel finalButtons = new JPanel(new FlowLayout(FlowLayout.LEADING));
        finalButtons.add(validateButton);
        finalButtons.add(cancelButton);
        this.add(finalButtons, BorderLayout.SOUTH);

        this.add(mainJPanel, BorderLayout.CENTER);
        mainJPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        this.pack();
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
        Options.MUSIC_VOLUME = this.musicVolumeSlider.getValue();
        Options.SOUND_VOLUME = this.eventVolumeSlider.getValue();
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
