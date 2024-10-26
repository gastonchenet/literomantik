package fr.kanassoulier.dorfromantik.landing;

import java.awt.Color;
import javax.swing.JFrame;

import fr.kanassoulier.dorfromantik.components.KButton;
import fr.kanassoulier.dorfromantik.enums.KButtonType;

public class LandingMenuControlButton extends KButton {
	public long seed;
	public LandingMenuSidebar sidebar;

	public LandingMenuControlButton(LandingMenu landingMenu, LandingMenuLeaderboard leaderboard, String text,
			KButtonType type,
			LandingMenuSidebar sidebar) {
		super(text, type);

		this.sidebar = sidebar;

		switch (type) {
			case SEED:
				this.setFont(this.getFont().deriveFont(12f));
				this.setPadding(5, 5, 5, 5);
				this.setBackground(new Color(255, 255, 255, 50));
				this.setHoverBackground(new Color(255, 255, 255, 40));
				this.setForeground(Color.WHITE);
				break;

			default:
				this.setBackground(Color.WHITE);
				this.setHoverBackground(new Color(255, 255, 255, 225));
				break;
		}
		this.addActionListener(
				new LandingMenuControlButtonListener(landingMenu, leaderboard, this, this.sidebar, this.seed));
	}

	public LandingMenuControlButton(LandingMenu landingMenu, LandingMenuLeaderboard leaderboard, String text,
			KButtonType type,
			LandingMenuSidebar sidebar,
			long seed) {
		this(landingMenu, leaderboard, text, type, sidebar);
		this.sidebar = sidebar;
		this.seed = seed;
		this.addActionListener(
				new LandingMenuControlButtonListener(landingMenu, leaderboard, this, this.sidebar, this.seed));
	}
}
