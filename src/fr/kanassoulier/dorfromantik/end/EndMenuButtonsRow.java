package fr.kanassoulier.dorfromantik.end;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import fr.kanassoulier.dorfromantik.Game;
import fr.kanassoulier.dorfromantik.enums.ButtonType;

public class EndMenuButtonsRow extends JPanel {
  public EndMenuButtonsRow(Game game) {
    super();

    this.setOpaque(false);
    this.setLayout(new GridBagLayout());

    GridBagConstraints gbc = new GridBagConstraints();

    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.weightx = 0.1f;
    gbc.insets = new Insets(10, 4, 16, 4);

    gbc.gridx = 2;
    this.add(new EndMenuButton(game, "Quitter", ButtonType.QUIT), gbc);

    gbc.gridx = 1;
    this.add(new EndMenuButton(game, "Menu", ButtonType.MENU), gbc);

    gbc.gridx = 0;
    this.add(new EndMenuButton(game, "Rejouer", ButtonType.PLAY), gbc);
  }
}
