package fr.kanassoulier.dorfromantik.landing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;

import java.awt.GridBagConstraints;

import fr.kanassoulier.dorfromantik.components.KButton;
import fr.kanassoulier.dorfromantik.end.EndGameInfos;
import fr.kanassoulier.dorfromantik.utils.Database;

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
				new Parameters(SwingUtilities.getWindowAncestor(this.button));
				break;

			case SEED:
				Database data = new Database();

				GridBagConstraints gbc = new GridBagConstraints();

				EndGameInfos[] infoArray;
				infoArray = data.getInfoDatabase(this.seed);

				for (int i = 0; i < 10; i++) {

					JLabel username = new JLabel(infoArray[i].getUsername());
					gbc.gridx = 0;
					gbc.gridy = i;
					this.leaderboard.add(username, gbc);

					JLabel score = new JLabel(infoArray[i].toString(infoArray[i].getScore()));
					gbc.gridx = 1;
					gbc.gridy = i;
					this.leaderboard.add(score, gbc);
				}

				data.closeDatabase();

			default:
				throw new IllegalArgumentException("Invalid button type");
		}
	}
}
