package fr.kanassoulier.literomantik.landing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.kanassoulier.literomantik.components.KButton;
import fr.kanassoulier.literomantik.gui.Settings;

/**
 * Class lacking javadoc by its first author
 * 
 * @author Maxence Raymond, Marco Orfao, Gaston Chenet
 * @version 1.3
 */
public class LandingMenuControlButtonListener implements ActionListener {
	private LandingMenuControlButton button;
	private long seed;

	/**
	 * Le constructeur de LandingMenuControlButtonListener
	 * 
	 * @param button Le bouton à écouter
	 * @param seed   La graine du bouton
	 */
	public LandingMenuControlButtonListener(LandingMenuControlButton button, long seed) {
		this.button = button;
		this.seed = seed;
	}

	/**
	 * Le constructeur de LandingMenuControlButtonListener
	 * 
	 * @param button Le bouton à écouter
	 */
	public LandingMenuControlButtonListener(LandingMenuControlButton button) {
		this(button, 0);
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
				new Settings((JFrame) SwingUtilities.getWindowAncestor(this.button)).setVisible(true);
				break;

			case SEED:
				this.button.getSidebar().getLeaderboard().setLeaderboardStatement(true);
				this.button.getSidebar().getLeaderboard().makeLeaderboard(this.seed);
				break;

			default:
				throw new IllegalArgumentException("Invalid button type");
		}
	}
}
