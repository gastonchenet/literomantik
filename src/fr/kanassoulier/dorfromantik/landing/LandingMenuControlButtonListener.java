package fr.kanassoulier.dorfromantik.landing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

import fr.kanassoulier.dorfromantik.components.KButton;

/**
 * Class lacking javadoc by its first author
 * 
 * @author Maxence Raymond, Marco Orfao
 * @version 1.2
 */
public class LandingMenuControlButtonListener implements ActionListener {

	private KButton button;
	private LandingMenuSidebar sidebar;
	private long seed;
	private LandingMenu landingMenu;
	private LandingMenuLeaderboard leaderboard;

	/**
	 * controleur de la classe
	 * 
	 * @param button      bouton de contrôle
	 * @param leaderboard leaderboard
	 */
	public LandingMenuControlButtonListener(KButton button, LandingMenuLeaderboard leaderboard,
			LandingMenuSidebar sidebar, long seed) {
		this.button = button;
		this.sidebar = sidebar;
		this.seed = seed;
		this.leaderboard = leaderboard;
	}

	public LandingMenuControlButtonListener(LandingMenu landingMenu, LandingMenuLeaderboard leaderboard, KButton button,
			LandingMenuSidebar sidebar,
			long seed) {
		this.button = button;
		this.sidebar = sidebar;
		this.seed = seed;
		this.landingMenu = landingMenu;
		this.leaderboard = leaderboard;
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
				LandingMenuLeaderboard leaderboard = new LandingMenuLeaderboard();
				if (leaderboard.getStatement() == false) {
					leaderboard.makeLeaderboard(this.seed, this.landingMenu);
					this.leaderboard.setStatement(true);
					break;
				} else {
					this.leaderboard.removePanel();
					this.landingMenu.repaint();

					// this.leaderboard = new LandingMenuLeaderboard();
					// this.sidebar.add(this.leaderboard, BorderLayout.CENTER);
					// this.leaderboard.makeLeaderboard(this.seed, this.menuWindow);
					// this.menuWindow.revalidate();
					// this.menuWindow.repaint();

					break;
				}

			default:
				throw new IllegalArgumentException("Invalid button type");
		}
	}
}
