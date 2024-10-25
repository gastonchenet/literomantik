package fr.kanassoulier.dorfromantik.landing;

import java.awt.Color;

import fr.kanassoulier.dorfromantik.components.KButton;
import fr.kanassoulier.dorfromantik.enums.KButtonType;

public class LandingMenuControlButton extends KButton {
  public long seed;
  public LandingMenuLeaderboard leaderboard;

  public LandingMenuControlButton(String text, KButtonType type) {
    super(text, type);

    switch (type) {
      case SEED:
        this.setFont(this.getFont().deriveFont(12f));
        this.setPadding(5, 5, 5, 5);
        this.setBackground(new Color(255, 255, 255, 50));
        this.setHoverBackground(new Color(255, 255, 255, 40));
        this.setForeground(Color.WHITE);
        break;

      default:
        this.setBackground(Color.WHITE);
        this.setHoverBackground(new Color(255, 255, 255, 225));
        break;
    }

    this.addActionListener(new LandingMenuControlButtonListener(this, this.leaderboard, this.seed));
  }

  public LandingMenuControlButton(String text, KButtonType type, LandingMenuLeaderboard leaderboard, long seed) {
    this(text, type);

    this.leaderboard = leaderboard;
    this.seed = seed;
  }
}
