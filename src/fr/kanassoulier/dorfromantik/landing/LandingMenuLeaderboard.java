package fr.kanassoulier.dorfromantik.landing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JPanel;
import fr.kanassoulier.dorfromantik.utils.FontLoader;

/**
 * Classe permettant la création et l'affichage du Leaderboard
 * 
 * @version 1.1
 * @author Gaston Chenet, Marco Orfao
 */
public class LandingMenuLeaderboard extends JPanel {

	/**
	 * constructeur de la classe
	 */
	public LandingMenuLeaderboard() {
		super();

		this.setOpaque(false);
	}

	/**
	 * réécriture de la méthode paintComponent pour dessiner le tableau des scores
	 * 
	 * @param g objet de type Graphics
	 */
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
