package fr.kanassoulier.dorfromantik.tmp;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.kanassoulier.dorfromantik.Game;
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

    GridBagConstraints gbc = new GridBagConstraints();

    JLabel txtLabel = new JLabel("Êtes-vous sûr de vouloir fermer le jeu ?");
    txtLabel.setFont(FontLoader.LEXEND_REGULAR.deriveFont(15f));

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
    content.add(new CloseGameDialogButton(game, "Oui", true), gbc);

    gbc.gridx = 1;
    gbc.gridy = 1;
    gbc.gridwidth = 1;
    gbc.weightx = 0.5f;
    content.add(new CloseGameDialogButton(game, "Non", false), gbc);
  }
}
