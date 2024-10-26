package fr.kanassoulier.literomantik.landing;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Controleur concernant l'affichage de l'ecran de parametres
 * 
 * @version 1.0
 * @author Maxence Raymond
 */
public class SettingsButtonListener implements ActionListener {
  /**
   * Pour un bouton servant a valider
   */
  public static final int VALIDATE = 0;
  /**
   * Pour un bouton servant a annuler
   */
  public static final int CANCEL = 1;

  /**
   * L'instance a utiliser pour les methodes a invoquer
   */
  private Settings instance;
  private int type;

  /**
   * Constructeur unique pour la classe
   * 
   * @param type     Soit de type VALIDATE ou CANCEL
   * @param instance L'instance de parametres sur lesquelles invoquer les methodes
   */
  public SettingsButtonListener(int type, Settings instance) {
    if (!(type == SettingsButtonListener.VALIDATE || type == SettingsButtonListener.CANCEL)) {
      throw new IllegalArgumentException("Type must be either VALIDATE or CANCEL");
    }

    this.instance = instance;
    this.type = type;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (this.type == SettingsButtonListener.VALIDATE) {
      this.instance.confirm();
    } else {
      this.instance.exit();
    }
  }
}