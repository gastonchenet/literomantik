package fr.kanassoulier.dorfromantik.landing;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SeedSelector extends JDialog {
  public SeedSelector(JFrame window) {
    super(window, "Choix de la graine", true);

    this.setSize(300, 200);
    this.setLocationRelativeTo(window);

    JPanel content = new JPanel();
    content.setLayout(new GridBagLayout());
    content.setBackground(Color.WHITE);
    content.setBorder(new EmptyBorder(10, 10, 10, 10));

    SeedSelectorButton alphaSeed = new SeedSelectorButton((LandingMenu) window, "Alpha", 154275265);
    SeedSelectorButton betaSeed = new SeedSelectorButton((LandingMenu) window, "Beta", 534547947);
    SeedSelectorButton gammaSeed = new SeedSelectorButton((LandingMenu) window, "Gamma", 874245424);
    SeedSelectorButton deltaSeed = new SeedSelectorButton((LandingMenu) window, "Delta", 951984768);
    JTextField seedArea = new JTextField();

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

    this.setContentPane(content);
  }
}
