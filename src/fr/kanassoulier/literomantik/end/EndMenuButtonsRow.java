package fr.kanassoulier.literomantik.end;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import fr.kanassoulier.literomantik.components.KButton;
import fr.kanassoulier.literomantik.enums.KButtonType;
import fr.kanassoulier.literomantik.game.Game;

public class EndMenuButtonsRow extends JPanel {
  public EndMenuButtonsRow(Game game) {
    super();

    this.setOpaque(false);
    this.setLayout(new GridBagLayout());

    KButton leaveButton = new KButton("Quitter", KButtonType.QUIT);
    leaveButton.setBackground(new Color(220, 220, 220));
    leaveButton.setHoverBackground(new Color(210, 210, 210));
    leaveButton.addActionListener(new EndMenuButtonListener(game));

    KButton menuButton = new KButton("Menu", KButtonType.MENU);
    menuButton.setBackground(new Color(220, 220, 220));
    menuButton.setHoverBackground(new Color(210, 210, 210));
    menuButton.addActionListener(new EndMenuButtonListener(game));

    KButton restartButton = new KButton("Rejouer", KButtonType.PLAY);
    restartButton.setForeground(Color.WHITE);
    restartButton.setBackground(new Color(71, 71, 252));
    restartButton.setHoverBackground(new Color(50, 50, 201));
    restartButton.addActionListener(new EndMenuButtonListener(game));

    GridBagConstraints gbc = new GridBagConstraints();

    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.weightx = 0.1f;
    gbc.insets = new Insets(10, 4, 16, 4);

    gbc.gridx = 0;
    this.add(leaveButton, gbc);

    gbc.gridx = 1;
    this.add(menuButton, gbc);

    gbc.gridx = 2;
    this.add(restartButton, gbc);
  }
}
