package fr.kanassoulier.literomantik.gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.kanassoulier.literomantik.components.KButton;
import fr.kanassoulier.literomantik.enums.KButtonType;
import fr.kanassoulier.literomantik.game.Game;
import fr.kanassoulier.literomantik.utils.FontLoader;

/**
 * Permet d'effectuer certaines actions à la fermeture du programme
 * 
 * @version 1.1
 * @author Marco Orfao, Gaston Chenet
 */
public class CloseGameDialog extends JDialog {
	/**
	 * Constructeur du GameWindowListener
	 * 
	 * @param window La fenêtre de jeu
	 */
	public CloseGameDialog(Game game) {
		super(game, "Quitter Dorfromantik", true);

		this.setResizable(false);

		JPanel content = new JPanel();
		content.setLayout(new GridBagLayout());
		content.setBorder(new EmptyBorder(10, 10, 10, 10));
		content.setBackground(Color.WHITE);

		KButton yesButton = new KButton("Oui", KButtonType.YES);
		yesButton.setHoverBackground(new Color(230, 230, 230));
		yesButton.addMouseListener(new CloseGameDialogButtonListener(yesButton, game));

		KButton noButton = new KButton("Non", KButtonType.NO);
		noButton.setForeground(Color.WHITE);
		noButton.setBackground(new Color(71, 71, 252));
		noButton.setHoverBackground(new Color(50, 50, 201));
		noButton.addMouseListener(new CloseGameDialogButtonListener(noButton, game));

		JLabel txtLabel = new JLabel("Êtes-vous sûr de vouloir fermer le jeu ?");
		txtLabel.setFont(FontLoader.LEXEND_REGULAR.deriveFont(15f));

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 5, 5);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.weightx = 1.0f;
		content.add(txtLabel, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.weightx = 0.5f;
		content.add(yesButton, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.weightx = 0.5f;
		content.add(noButton, gbc);

		this.setContentPane(content);
		this.pack();
		this.setLocationRelativeTo(game);
	}
}
