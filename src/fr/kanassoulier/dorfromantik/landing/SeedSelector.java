package fr.kanassoulier.dorfromantik.landing;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.kanassoulier.dorfromantik.components.KTextField;

public class SeedSelector extends JDialog {
  public SeedSelector(LandingMenu menu) {
    super(menu, "Choix de la graine", true);

    this.setSize(340, 216);
    this.setLocationRelativeTo(menu);
    this.setResizable(false);

    JPanel content = new JPanel();
    this.setContentPane(content);

    content.setLayout(new GridBagLayout());
    content.setBackground(Color.WHITE);
    content.setBorder(new EmptyBorder(10, 10, 10, 10));

    SeedSelectorButton alphaSeed = new SeedSelectorButton(menu, "Alpha", 154275265);
    SeedSelectorButton betaSeed = new SeedSelectorButton(menu, "Beta", 534547947);
    SeedSelectorButton gammaSeed = new SeedSelectorButton(menu, "Gamma", 874245424);
    SeedSelectorButton deltaSeed = new SeedSelectorButton(menu, "Delta", 951984768);
    KTextField seedArea = new KTextField();

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.insets.set(4, 4, 4, 4);

    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.weightx = 0.5f;
    content.add(alphaSeed, gbc);

    gbc.gridx = 1;
    gbc.gridy = 0;
    gbc.weightx = 0.5f;
    content.add(betaSeed, gbc);

    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.weightx = 0.5f;
    content.add(gammaSeed, gbc);

    gbc.gridx = 1;
    gbc.gridy = 1;
    gbc.weightx = 0.5f;
    content.add(deltaSeed, gbc);

    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.gridwidth = 2;
    gbc.weightx = 1.0f;
    content.add(seedArea, gbc);
  }
}
