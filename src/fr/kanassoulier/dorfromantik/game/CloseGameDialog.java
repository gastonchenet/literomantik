package fr.kanassoulier.dorfromantik.game;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.kanassoulier.dorfromantik.components.KButton;
import fr.kanassoulier.dorfromantik.enums.KButtonType;
import fr.kanassoulier.dorfromantik.utils.FontLoader;

/**
 * Permet d'effectuer certaines actions à la fermeture du programme
 * 
 * @version 1.0
 * @author Marco Orfao
 */
public class CloseGameDialog extends JDialog {
  /**
   * Constructeur du GameWindowListener
   * 
   * @param window La fenêtre de jeu
   */
  public CloseGameDialog(Game game) {
    super(game, "Quitter Dorfromantik", true);

    this.setSize(350, 130);
    this.setLocationRelativeTo(game);
    this.setResizable(false);

    JPanel content = new JPanel();
    this.setContentPane(content);

    content.setLayout(new GridBagLayout());
    content.setBorder(new EmptyBorder(10, 10, 10, 10));

    KButton yesButton = new KButton("Oui", KButtonType.YES);
    yesButton.setBackground(new Color(220, 220, 220));
    yesButton.setHoverBackground(new Color(210, 210, 210));
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
  }
}
