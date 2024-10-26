package fr.kanassoulier.dorfromantik.landing;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

import fr.kanassoulier.dorfromantik.game.Game;
import fr.kanassoulier.dorfromantik.utils.FontLoader;
import fr.kanassoulier.dorfromantik.utils.ImageLoader;

/**
 * Classe permettant la création de la fenêtre de menu
 * 
 * @version 1.1
 * @author Marco Orfao, Gaston Chenet
 */
public class LandingMenu extends JFrame {

	/**
	 * constructeur de la classe LandingMenu, elle instancie une fenêtre JFrame
	 * contenant le menu
	 */
	public LandingMenu() {
		this.setTitle(Game.WINDOW_TITLE);
		super.setIconImage(ImageLoader.APP_ICON);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.WHITE);

		JLabel pageTitle = new JLabel("DORFROMANTIK", JLabel.CENTER);
		pageTitle.setFont(FontLoader.LILITA_ONE_REGULAR.deriveFont(55f));
		pageTitle.setBounds(0, 50, Game.WINDOW_WIDTH - LandingMenuSidebar.WIDTH, 50);

		this.add(pageTitle);
		this.add(new LandingMenuSidebar(this));
	}
}