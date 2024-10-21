package fr.kanassoulier.dorfromantik.landing;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import fr.kanassoulier.dorfromantik.enums.ButtonType;

public class LandingMenuGameButtonContainer extends JPanel {
  public LandingMenuGameButtonContainer() {
    super();

    this.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();

    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.insets = new Insets(4, 4, 4, 4);

    gbc.weightx = 0.1f;
    gbc.gridwidth = 2;
    gbc.gridx = 0;
    gbc.gridy = 1;
    this.add(new LandingMenuControlButton("Commencer la partie", ButtonType.PLAY), gbc);

    gbc.gridwidth = 1;
    gbc.gridx = 0;
    gbc.gridy = 0;
    this.add(new LandingMenuControlButton("Paramètres", ButtonType.SETTINGS), gbc);

    gbc.gridx = 1;
    gbc.gridy = 0;
    this.add(new LandingMenuControlButton("Quitter", ButtonType.QUIT), gbc);

    this.setOpaque(false);
  }
}
