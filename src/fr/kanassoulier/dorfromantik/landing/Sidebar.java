package fr.kanassoulier.dorfromantik.landing;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.kanassoulier.dorfromantik.Game;

public class Sidebar extends JPanel {
  public static final int WIDTH = 300;

  public Sidebar() {
    super();

    this.setBackground(new Color(71, 71, 252));
    this.setBounds(Game.WINDOW_WIDTH - Sidebar.WIDTH, 0, Sidebar.WIDTH, Game.WINDOW_HEIGHT - 35);
    this.setLayout(new BorderLayout(10, 10));
    this.setBorder(new EmptyBorder(10, 10, 10, 25));

    this.add(new Leaderboard());
    this.add(new GameManagerButtons(), BorderLayout.SOUTH);
  }
}
