package fr.kanassoulier.literomantik.landing;

import java.awt.Color;

import fr.kanassoulier.literomantik.components.KButton;
import fr.kanassoulier.literomantik.enums.KButtonType;

public class LandingMenuControlButton extends KButton {
	private LandingMenuSidebar sidebar;

	public LandingMenuControlButton(String text, KButtonType type, LandingMenuSidebar sidebar, long seed) {
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

		this.addActionListener(new LandingMenuControlButtonListener(this, seed));
	}

	public LandingMenuControlButton(String text, KButtonType type, LandingMenuSidebar sidebar) {
		this(text, type, sidebar, 0);
	}

	public LandingMenuSidebar getSidebar() {
		return this.sidebar;
	}
}
