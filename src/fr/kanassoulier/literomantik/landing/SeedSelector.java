package fr.kanassoulier.literomantik.landing;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import fr.kanassoulier.literomantik.components.KTextField;
import fr.kanassoulier.literomantik.utils.Database;
import fr.kanassoulier.literomantik.utils.FontLoader;
import fr.kanassoulier.literomantik.utils.Seed;

/**
 * Classe permettant de sélectionner une graine pour la partie
 * 
 * @version 1.0
 * @author Gaston Chenet
 */
public class SeedSelector extends JDialog {
  /**
   * Constructeur de SeedSelector
   * 
   * @param menu Le menu de landing
   */
  public SeedSelector(LandingMenu menu) {
    super(menu, "Choix de la graine", true);

    this.setResizable(false);

    JPanel content = new JPanel();
    content.setLayout(new GridBagLayout());
    content.setBackground(Color.WHITE);
    content.setBorder(new EmptyBorder(10, 10, 10, 10));

    JLabel selectSeedLabel = new JLabel("Sélectionner un pack de tuiles");
    selectSeedLabel.setFont(FontLoader.LEXEND_BOLD.deriveFont(16f));

    Database db = new Database();
    Seed[] seeds = db.getDefaultSeeds();

    KTextField seedArea = new KTextField();
    seedArea.getSubmit().addActionListener(new SeedSelectorSubmitListener(seedArea.getInput(), menu));

    JLabel customSeedLabel = new JLabel("Seed personnalisée :");
    customSeedLabel.setFont(FontLoader.LEXEND_REGULAR.deriveFont(12f));
    customSeedLabel.setBorder(new EmptyBorder(8, 0, 0, 0));

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.insets.set(4, 4, 4, 4);

    gbc.gridwidth = 2;
    gbc.weightx = 1.0f;
    gbc.gridx = 0;
    gbc.gridy = 0;
    content.add(selectSeedLabel, gbc);

    gbc.gridwidth = 1;
    gbc.weightx = 0.5f;

    for (int i = 0; i < seeds.length; i++) {
      gbc.gridx = i % 2;
      gbc.gridy = i / 2 + 1;

      content.add(new SeedSelectorButton(menu, seeds[i]), gbc);
    }

    gbc.gridwidth = 2;
    gbc.weightx = 1.0f;
    gbc.gridx = 0;
    gbc.gridy = seeds.length / 2 + 1;
    content.add(customSeedLabel, gbc);

    gbc.gridx = 0;
    gbc.gridy = seeds.length / 2 + 2;
    content.add(seedArea, gbc);

    this.setContentPane(content);
    this.pack();
    this.setLocationRelativeTo(menu);
  }
}
