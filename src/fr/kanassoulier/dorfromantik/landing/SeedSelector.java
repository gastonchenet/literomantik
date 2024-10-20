package fr.kanassoulier.dorfromantik.landing;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class SeedSelector extends JDialog {
  private long seed = -1;

  public SeedSelector(JFrame window) {
    super(window, "Choix de la graine", true);

    this.setSize(300, 200);
    this.setLayout(new GridBagLayout());
    this.setLocationRelativeTo(window);

    this.getContentPane().setBackground(Color.WHITE);

    TilePackButton alphaSeed = new TilePackButton("Alpha", 154275265);
    TilePackButton betaSeed = new TilePackButton("Beta", 534547947);
    TilePackButton gammaSeed = new TilePackButton("Gamma", 874245424);
    TilePackButton deltaSeed = new TilePackButton("Delta", 951984768);
    JTextArea seedArea = new JTextArea();
    JButton selectButton = new JButton("Sélectionner");

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.weightx = 0.5f;
    gbc.insets.set(4, 4, 4, 4);

    gbc.gridx = 0;
    gbc.gridy = 0;
    this.add(alphaSeed, gbc);

    gbc.gridx = 1;
    gbc.gridy = 0;
    this.add(betaSeed, gbc);

    gbc.gridx = 0;
    gbc.gridy = 1;
    this.add(gammaSeed, gbc);

    gbc.gridx = 1;
    gbc.gridy = 1;
    this.add(deltaSeed, gbc);

    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.gridwidth = 2;
    this.add(seedArea, gbc);

    gbc.gridx = 1;
    gbc.gridy = 3;
    gbc.gridwidth = 1;
    this.add(selectButton, gbc);
  }
}
