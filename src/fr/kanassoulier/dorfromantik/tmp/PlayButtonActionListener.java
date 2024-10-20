package fr.kanassoulier.dorfromantik.tmp;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

import fr.kanassoulier.dorfromantik.Game;

/**
 * Classe permettant d'exécuter certaines actions en cas d'interaction avec le
 * bouton "Play" du menu
 * 
 * @version 1.0
 * @author Marco Orfao
 */
public class PlayButtonActionListener implements ActionListener {

    private JFrame menuWindow;

    /**
     * Constructeur de la classe
     * 
     * @param menuWindow fenêtre contenant le menu
     */
    public PlayButtonActionListener(JFrame menuWindow) {
        this.menuWindow = menuWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new Game().setVisible(true);
        this.menuWindow.setVisible(false);
    }

}
