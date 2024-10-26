package fr.kanassoulier.dorfromantik.landing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;

import fr.kanassoulier.dorfromantik.end.EndGameInfos;
import fr.kanassoulier.dorfromantik.utils.Database;
import fr.kanassoulier.dorfromantik.utils.FontLoader;

/**
 * Classe permettant la création et l'affichage du Leaderboard
 * 
 * @version 2.0
 * @author Gaston Chenet, Marco Orfao
 */
public class LandingMenuLeaderboard extends JPanel {

	private boolean statement;
	public JPanel containerPanel;

	/**
	 * constructeur de la classe
	 */
	public LandingMenuLeaderboard() {
		super();

		this.statement = false;

		this.setOpaque(false);
	}

	/**
	 * 
	 * @param statement
	 */
	public void setStatement(boolean statement) {
		this.statement = statement;
	}

	/**
	 * 
	 * @return
	 */
	public boolean getStatement() {
		return this.statement;
	}

	/**
	 * 
	 * @return
	 */
	public JPanel getContainerPanel() {
		return this.containerPanel;
	}

	/**
	 * 
	 * @param seed
	 * @param menu
	 */
	public void makeLeaderboard(long seed, LandingMenu landingMenu) {
		this.containerPanel = new JPanel(new GridBagLayout());
		this.containerPanel.setOpaque(false);

		Database data = new Database();

		GridBagConstraints gbc = new GridBagConstraints();

		EndGameInfos[] infoArray;
		infoArray = data.getInfoDatabase(seed);

		for (int i = 0; i < data.getSize(seed); i++) {
			JLabel username = new JLabel(infoArray[i].getUsername());
			username.setForeground(Color.WHITE);
			username.setFont(FontLoader.LEXEND_REGULAR.deriveFont(28f));
			gbc.gridy = i;

			gbc.anchor = GridBagConstraints.WEST;
			gbc.gridx = 0;
			if (i >= 1) {
				gbc.insets = new Insets(5, 2, 5, 10);
			} else {
				gbc.insets = new Insets(50, 2, 5, 10);
			}
			this.containerPanel.add(username, gbc);

			JLabel score = new JLabel(infoArray[i].toString(infoArray[i].getScore()));
			score.setForeground(Color.WHITE);
			score.setFont(FontLoader.LEXEND_REGULAR.deriveFont(28f));

			gbc.anchor = GridBagConstraints.EAST;
			gbc.gridx = 1;
			if (i >= 1) {
				gbc.insets = new Insets(5, 10, 5, 2);
			} else {
				gbc.insets = new Insets(50, 10, 5, 2);
			}
			this.containerPanel.add(score, gbc);
		}
		this.add(this.containerPanel);

		landingMenu.repaint();

		data.closeDatabase();
	}

	public void removePanel() {
		this.removeAll();
		this.repaint();
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
