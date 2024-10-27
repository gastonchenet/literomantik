package fr.kanassoulier.literomantik.landing;

import java.awt.event.ActionListener;

import fr.kanassoulier.literomantik.enums.KButtonType;

import java.awt.event.ActionEvent;

/**
 * Controleur concernant l'affichage de l'ecran de parametres
 * 
 * @version 1.1
 * @author Maxence Raymond, Gaston Chenet
 */
public class SettingsButtonListener implements ActionListener {
	/**
	 * L'instance a utiliser pour les methodes a invoquer
	 */
	private Settings instance;
	private KButtonType type;

	/**
	 * Constructeur unique pour la classe
	 * 
	 * @param type     Soit de type VALIDATE ou CANCEL
	 * @param instance L'instance de parametres sur lesquelles invoquer les methodes
	 */
	public SettingsButtonListener(KButtonType type, Settings instance) {
		if (!(type == KButtonType.YES || type == KButtonType.CANCEL)) {
			throw new IllegalArgumentException("Type must be either YES or CANCEL");
		}

		this.instance = instance;
		this.type = type;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.type == KButtonType.YES) {
			this.instance.setValues();
		} else {
			this.instance.dispose();
		}
	}
}