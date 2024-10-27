package fr.kanassoulier.literomantik.landing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.kanassoulier.literomantik.end.EndGameInfo;
import fr.kanassoulier.literomantik.utils.Database;
import fr.kanassoulier.literomantik.utils.FontLoader;

/**
 * Classe permettant la création et l'affichage du Leaderboard
 * 
 * @version 2.0
 * @author Gaston Chenet, Marco Orfao
 */
public class LandingMenuLeaderboard extends JPanel {
	public static final int LEADERBOARD_SIZE = 15;
	private boolean statement = false;

	/**
	 * constructeur de la classe
	 */
	public LandingMenuLeaderboard() {
		super();

		this.setLayout(null);
		this.setOpaque(false);
	}

	public void makeLeaderboard(long seed) {
		this.removeAll();

		Database db = new Database();
		EndGameInfo[] infoArray = db.getRowsFromSeed(seed);

		int width = this.getWidth();
		int height = 32;

		for (int i = 0; i < infoArray.length; i++) {
			if (infoArray[i] == null) {
				break;
			}

			JPanel row = new JPanel();
			row.setLayout(null);
			row.setOpaque(false);
			row.setBounds(0, i * height + 50, width, height);

			JLabel position = new JLabel((i + 1) + ".", JLabel.LEFT);
			position.setForeground(new Color(255, 255, 255, 180));
			position.setFont(FontLoader.LEXEND_REGULAR.deriveFont(16f));
			position.setBounds(10, 0, width - 20, height);

			int positionWidth = position.getFontMetrics(position.getFont()).stringWidth(position.getText());

			JLabel username = new JLabel(infoArray[i].getUsername(), JLabel.LEFT);
			username.setForeground(Color.WHITE);
			username.setFont(FontLoader.LEXEND_REGULAR.deriveFont(16f));
			username.setBounds(15 + positionWidth, 0, width - 20, height);

			JLabel score = new JLabel(Integer.toString(infoArray[i].getScore()), JLabel.RIGHT);
			score.setForeground(Color.WHITE);
			score.setFont(FontLoader.LEXEND_BOLD.deriveFont(16f));
			score.setBounds(10, 0, width - 20, height);

			row.add(position);
			row.add(username);
			row.add(score);
			this.add(row);
		}

		db.close();
		this.revalidate();
		this.repaint();
	}

	public void setLeaderboardStatement(boolean statement) {
		this.statement = statement;
		this.revalidate();
		this.repaint();
	}

	public boolean getLeaderboardStatement() {
		return this.statement;
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

		if (!this.statement) {
			g2d.setFont(FontLoader.LEXEND_BOLD.deriveFont(16f));
			g2d.setColor(Color.WHITE);
			g2d.drawString("Choisissez une seed", this.getWidth() / 6, this.getHeight() / 2);
		}

		g2d.setFont(FontLoader.LEXEND_BOLD.deriveFont(16f));
		g2d.setColor(Color.WHITE);
		g2d.drawString("Tableau des scores", 10, 30);

		g2d.dispose();
	}
}
