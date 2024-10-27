package fr.kanassoulier.literomantik.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import fr.kanassoulier.literomantik.enums.KButtonType;
import fr.kanassoulier.literomantik.utils.FontLoader;

/**
 * Classe permettant de créer un bouton stylisé
 * 
 * @version 1.0
 * @author Gaston Chenet
 */
public class KButton extends JButton {
	private KButtonType type;
	private KButtonListener listener;
	private Color hoverBackground;
	private Insets padding;

	/**
	 * Constructeur de KButton
	 * 
	 * @param text Le texte du bouton
	 * @param type Le type du bouton
	 */
	public KButton(String text, KButtonType type) {
		super(text);

		this.type = type;

		this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.setContentAreaFilled(false);

		this.setPadding(10, 5, 10, 5);
		this.setBorder(new EmptyBorder(this.getPadding()));
		this.setFont(FontLoader.LEXEND_REGULAR.deriveFont(14f));
		this.setHoverBackground(this.getBackground());

		this.listener = new KButtonListener(this);
		this.addMouseListener(this.listener);
	}

	/**
	 * Constructeur de KButton
	 * 
	 * @param text Le texte du bouton
	 */
	public KButton(KButtonType type) {
		this("", type);
	}

	/**
	 * Constructeur de KButton
	 */
	public KButtonType getType() {
		return this.type;
	}

	/**
	 * Permet de changer le type du bouton
	 * 
	 * @param padding
	 */
	public void setPadding(Insets padding) {
		this.padding = padding;
		this.setBorder(new EmptyBorder(this.padding));
	}

	/**
	 * Permet de changer le padding du bouton
	 * 
	 * @return padding
	 */
	public void setPadding(int top, int left, int bottom, int right) {
		this.padding = new Insets(top, left, bottom, right);
		this.setBorder(new EmptyBorder(this.padding));
	}

	/**
	 * Permet de récupérer le padding du bouton
	 * 
	 * @return padding
	 */
	public Insets getPadding() {
		return this.padding;
	}

	/**
	 * Permet de changer la couleur de fond du bouton au survol
	 * 
	 * @param hoverBackground
	 */
	public void setHoverBackground(Color hoverBackground) {
		this.hoverBackground = hoverBackground;
	}

	/**
	 * Permet de récupérer la couleur de fond du bouton au survol
	 * 
	 * @return hoverBackground
	 */
	public Color getHoverBackground() {
		return this.hoverBackground;
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.setColor(this.listener.isMouseOver() ? this.getHoverBackground() : this.getBackground());
		g2d.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), 10, 10);

		g2d.dispose();
		super.paintComponent(g);
	}
}
