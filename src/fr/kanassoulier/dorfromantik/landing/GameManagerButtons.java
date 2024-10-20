package fr.kanassoulier.dorfromantik.landing;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

public class GameManagerButtons extends JPanel {
  public GameManagerButtons() {
    super();

    this.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();

    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.insets = new Insets(4, 4, 4, 4);

    gbc.weightx = 0.1f;
    gbc.gridwidth = 2;
    gbc.gridx = 0;
    gbc.gridy = 1;
    this.add(new StartGameButton(), gbc);

    gbc.gridwidth = 1;
    gbc.gridx = 0;
    gbc.gridy = 0;
    this.add(new SettingsButton(), gbc);

    gbc.gridx = 1;
    gbc.gridy = 0;
    this.add(new LeaveGameButton(), gbc);

    this.setOpaque(false);
  }
}
