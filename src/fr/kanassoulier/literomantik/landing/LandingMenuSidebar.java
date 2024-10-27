package fr.kanassoulier.literomantik.landing;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.kanassoulier.literomantik.game.Game;

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

	private LandingMenuLeaderboard leaderboard;

	/**
	 * Constructeur de la classe qui instancie les différents composants
	 */
	public LandingMenuSidebar(LandingMenu landingMenu) {
		super();

		this.setBackground(new Color(71, 71, 252));
		this.setBounds(Game.WINDOW_WIDTH - LandingMenuSidebar.WIDTH, 0, LandingMenuSidebar.WIDTH, Game.WINDOW_HEIGHT - 35);
		this.setLayout(new BorderLayout(10, 10));
		this.setBorder(new EmptyBorder(15, 15, 15, 30));

		this.leaderboard = new LandingMenuLeaderboard();

		this.add(new LandingMenuControlButtonContainer(this), BorderLayout.SOUTH);
		this.add(this.leaderboard, BorderLayout.CENTER);
	}

	public LandingMenuLeaderboard getLeaderboard() {
		return this.leaderboard;
	}
}
