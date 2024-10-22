package fr.kanassoulier.dorfromantik.landing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JPanel;
import javax.swing.JButton;

import fr.kanassoulier.dorfromantik.components.KButton;
import fr.kanassoulier.dorfromantik.end.EndGameInfos;
import fr.kanassoulier.dorfromantik.enums.KButtonType;
import fr.kanassoulier.dorfromantik.utils.Database;
import fr.kanassoulier.dorfromantik.utils.FontLoader;

/**
 * Classe permettant la création et l'affichage du Leaderboard
 * 
 * @version 1.1
 * @author Gaston Chenet
 * @author Marco Orfao
 */
public class LandingMenuLeaderboard extends JPanel {
  public LandingMenuLeaderboard() {
    super();

    this.setLayout(new GridBagLayout());

    GridBagConstraints gbc = new GridBagConstraints();

    KButton alphaButton = new KButton("alpha", KButtonType.SEED);
    KButton betaButton = new KButton("beta", KButtonType.SEED);
    KButton gammaButton = new KButton("gamma", KButtonType.SEED);
    KButton deltaButton = new KButton("delta", KButtonType.SEED);

    Database data = new Database();

    alphaButton.addActionListener(new LandingMenuLeaderboardButtonsListener(154275265, data));
    betaButton.addActionListener(new LandingMenuLeaderboardButtonsListener(534547947, data));
    gammaButton.addActionListener(new LandingMenuLeaderboardButtonsListener(874245424, data));
    deltaButton.addActionListener(new LandingMenuLeaderboardButtonsListener(951984768, data));

    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.insets.set(4, 4, 4, 4);
    gbc.weightx = 0.1f;
    gbc.anchor = GridBagConstraints.SOUTH;

    gbc.gridx = 0;
    gbc.gridy = 0;
    this.add(alphaButton, gbc);

    gbc.gridx = 0;
    gbc.gridy = 1;
    this.add(betaButton, gbc);

    gbc.gridx = 1;
    gbc.gridy = 0;
    this.add(gammaButton, gbc);

    gbc.gridx = 1;
    gbc.gridy = 1;
    this.add(deltaButton, gbc);

    this.setOpaque(false);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g.create();

    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

    RoundRectangle2D container = new RoundRectangle2D.Double(0, 0, this.getWidth(), this.getHeight(), 10, 10);

    g2d.setClip(container);
    g2d.setColor(new Color(0, 0, 0, 70));
    g2d.fillRect(0, 0, this.getWidth(), this.getHeight());

    g2d.setColor(new Color(0, 0, 0, 40));
    g2d.fillRect(0, 0, this.getWidth(), 44);

    g2d.setFont(FontLoader.LEXEND_REGULAR.deriveFont(16f));
    g2d.setColor(Color.WHITE);
    g2d.drawString("Tableau des scores", 10, 30);

    g2d.dispose();
  }
}
