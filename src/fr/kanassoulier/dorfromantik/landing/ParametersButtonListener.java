package fr.kanassoulier.dorfromantik.landing;

import java.awt.event.*;

/**
 * Controleur concernant l'affichage de l'ecran de parametres
 * 
 * @version 1.0
 * @author Maxence Raymond
 */
public class ParametersButtonListener implements ActionListener {
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
    private Parameters instance;
    private int type;

    /**
     * Constructeur unique pour la classe
     * 
     * @param type     Soit de type VALIDATE ou CANCEL
     * @param instance L'instance de parametres sur lesquelles invoquer les methodes
     */
    public ParametersButtonListener(int type, Parameters instance) {
        if (!(type == ParametersButtonListener.VALIDATE || type == ParametersButtonListener.CANCEL)) {
            throw new IllegalArgumentException("Type must be either VALIDATE or CANCEL");
        }
        this.instance = instance;
        this.type = type;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.type == ParametersButtonListener.VALIDATE) {
            this.instance.confirm();
        } else {
            this.instance.exit();
        }
    }
}