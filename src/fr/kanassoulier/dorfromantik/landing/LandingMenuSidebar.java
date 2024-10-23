package fr.kanassoulier.dorfromantik.landing;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.kanassoulier.dorfromantik.game.Game;

/**
 * Classe qui sert à créer la partie droite du menu et instancie ses composants
 * 
 * @version 1.1
 * @author Gaston Chenet, Marco Orfao
 */
public class LandingMenuSidebar extends JPanel {

	/**
	 * variable globale qui contient la taille prédéfinie de la partie droite du
	 * menu
	 */
	public static final int WIDTH = 300;

	/**
	 * Constructeur de la classe qui instancie les différents composants
	 */
	public LandingMenuSidebar() {
		super();

		this.setBackground(new Color(71, 71, 252));
		this.setBounds(Game.WINDOW_WIDTH - LandingMenuSidebar.WIDTH, 0, LandingMenuSidebar.WIDTH, Game.WINDOW_HEIGHT - 35);
		this.setLayout(new BorderLayout(10, 10));
		this.setBorder(new EmptyBorder(15, 15, 15, 30));

		LandingMenuLeaderboard leaderboard = new LandingMenuLeaderboard();

		this.add(new LandingMenuControlButtonContainer(leaderboard), BorderLayout.SOUTH);

		this.add(leaderboard, BorderLayout.CENTER);
	}
}
