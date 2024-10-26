package fr.kanassoulier.dorfromantik.landing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import javax.swing.JFrame;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import fr.kanassoulier.dorfromantik.components.KButton;
import fr.kanassoulier.dorfromantik.end.EndGameInfos;
import fr.kanassoulier.dorfromantik.utils.Database;
import fr.kanassoulier.dorfromantik.utils.FontLoader;

/**
 * Class lacking javadoc by its first author
 * 
 * @author Maxence Raymond, Marco Orfao
 * @version 1.2
 */
public class LandingMenuControlButtonListener implements ActionListener {

	private KButton button;
	private JPanel leaderboard;
	private long seed;
	private JFrame menuWindow;

	/**
	 * controleur de la classe
	 * 
	 * @param button      bouton de contrôle
	 * @param leaderboard leaderboard
	 */
	public LandingMenuControlButtonListener(KButton button, JPanel leaderboard, long seed) {
		this.button = button;
		this.leaderboard = leaderboard;
		this.seed = seed;
	}

	public LandingMenuControlButtonListener(JFrame menuWindow, KButton button, JPanel leaderboard, long seed) {
		this.button = button;
		this.leaderboard = leaderboard;
		this.seed = seed;
		this.menuWindow = menuWindow;
	}

	/**
	 * controleur de la classe
	 * 
	 * @param button bouton de contrôle
	 */
	public LandingMenuControlButtonListener(KButton button) {
		this.button = button;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		KButton button = (KButton) e.getSource();

		switch (button.getType()) {
			case PLAY:
				new SeedSelector((LandingMenu) SwingUtilities.getWindowAncestor(this.button)).setVisible(true);
				break;

			case QUIT:
				SwingUtilities.getWindowAncestor(this.button).dispose();
				break;

			case SETTINGS:
				new Settings((LandingMenu) SwingUtilities.getWindowAncestor(this.button));
				break;

			case SEED:
				Database data = new Database();

				GridBagConstraints gbc = new GridBagConstraints();

				EndGameInfos[] infoArray;
				infoArray = data.getInfoDatabase(this.seed);

				for (int i = 0; i < data.getSize(this.seed); i++) {

					JLabel username = new JLabel(infoArray[i].getUsername());
					username.setForeground(Color.WHITE);
					username.setFont(FontLoader.LEXEND_REGULAR.deriveFont(16f));
					username.setBorder(BorderFactory.createLineBorder(Color.BLACK));
					gbc.gridy = i;

					gbc.anchor = GridBagConstraints.WEST;
					gbc.gridx = 0;
					gbc.insets = new Insets(5, 2, 5, 10);
					this.leaderboard.add(username, gbc);

					JLabel score = new JLabel(infoArray[i].toString(infoArray[i].getScore()));
					score.setForeground(Color.WHITE);
					score.setFont(FontLoader.LEXEND_REGULAR.deriveFont(16f));
					score.setBorder(BorderFactory.createLineBorder(Color.BLACK));

					gbc.anchor = GridBagConstraints.EAST;
					gbc.gridx = 1;
					gbc.insets = new Insets(5, 10, 5, 2);
					this.leaderboard.add(score, gbc);
				}

				this.menuWindow.revalidate();
				this.menuWindow.repaint();

				data.closeDatabase();
				break;

			default:
				throw new IllegalArgumentException("Invalid button type");
		}
	}
}
