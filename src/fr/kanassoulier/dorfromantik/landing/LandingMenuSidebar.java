package fr.kanassoulier.dorfromantik.landing;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.kanassoulier.dorfromantik.Game;

public class LandingMenuSidebar extends JPanel {
  public static final int WIDTH = 300;

  public LandingMenuSidebar() {
    super();

    this.setBackground(new Color(71, 71, 252));
    this.setBounds(Game.WINDOW_WIDTH - LandingMenuSidebar.WIDTH, 0, LandingMenuSidebar.WIDTH, Game.WINDOW_HEIGHT - 35);
    this.setLayout(new BorderLayout(10, 10));
    this.setBorder(new EmptyBorder(15, 15, 15, 30));

    this.add(new LandingMenuLeaderboard());
    this.add(new LandingMenuGameButtonContainer(), BorderLayout.SOUTH);
  }
}
