package fr.kanassoulier.dorfromantik.landing;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import fr.kanassoulier.dorfromantik.components.KButton;
import fr.kanassoulier.dorfromantik.enums.KButtonType;

public class LandingMenuGameButtonContainer extends JPanel {
  public LandingMenuGameButtonContainer() {
    super();

    this.setLayout(new GridBagLayout());

    KButton startButton = new KButton("Commencer la partie", KButtonType.PLAY);
    startButton.setBackground(Color.WHITE);
    startButton.setHoverBackground(new Color(255, 255, 255, 225));
    startButton.addActionListener(new LandingMenuControlButtonListener(startButton));

    KButton settingsButton = new KButton("Paramètres", KButtonType.SETTINGS);
    settingsButton.setBackground(Color.WHITE);
    settingsButton.setHoverBackground(new Color(255, 255, 255, 225));
    settingsButton.addActionListener(new LandingMenuControlButtonListener(settingsButton));

    KButton leaveButton = new KButton("Quitter", KButtonType.QUIT);
    leaveButton.setBackground(Color.WHITE);
    leaveButton.setHoverBackground(new Color(255, 255, 255, 225));
    leaveButton.addActionListener(new LandingMenuControlButtonListener(leaveButton));

    GridBagConstraints gbc = new GridBagConstraints();

    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.insets = new Insets(4, 4, 4, 4);

    gbc.weightx = 0.1f;
    gbc.gridwidth = 2;
    gbc.gridx = 0;
    gbc.gridy = 1;
    this.add(startButton, gbc);

    gbc.gridwidth = 1;
    gbc.gridx = 0;
    gbc.gridy = 0;
    this.add(settingsButton, gbc);

    gbc.gridx = 1;
    gbc.gridy = 0;
    this.add(leaveButton, gbc);

    this.setOpaque(false);
  }
}
