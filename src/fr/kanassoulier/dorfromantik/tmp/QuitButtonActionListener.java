package fr.kanassoulier.dorfromantik.tmp;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

/**
 * Classe permettant d'exécuter certaines actions en cas d'interaction avec le
 * bouton "Quit" du menu
 * 
 * @version 1.0
 * @author Marco Orfao
 */
public class QuitButtonActionListener implements ActionListener {

    private JFrame menuWindow;

    /**
     * Constructeur de la classe
     * 
     * @param menuWindow fenêtre contenant le menu
     */
    public QuitButtonActionListener(JFrame menuWindow) {
        this.menuWindow = menuWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.menuWindow.dispose();
    }

}
