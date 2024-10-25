package fr.kanassoulier.dorfromantik.game;

import java.awt.Color;

import fr.kanassoulier.dorfromantik.components.KButton;
import fr.kanassoulier.dorfromantik.enums.KButtonType;

public class PauseWindowButton extends KButton {
  public PauseWindowButton(String text, KButtonType type, PauseWindow window, Game game) {
    super(text, type);

    this.setBackground(Color.WHITE);
    this.setHoverBackground(new Color(255, 255, 255, 225));
    this.setPadding(10, 80, 10, 80);
    this.addActionListener(new PauseWindowButtonsListener(window, type, game));
  }
}
