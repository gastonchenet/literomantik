package fr.kanassoulier.dorfromantik.tmp;

import java.awt.FlowLayout;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * Permet d'effectuer certaines actions à la fermeture du programme
 * 
 * @version 1.0
 * @author Marco Orfao
 */
public class GameWindowListener implements WindowListener {

    /**
     * Fenetre de jeu
     */
    private JFrame window;

    /**
     * Base de donnée
     */
    private DataBase dataBase;

    /**
     * Constructeur du GameWindowListener
     * 
     * @param dataBase la base de donnée
     * @param window   La fenêtre de jeu
     */
    public GameWindowListener(JFrame window, DataBase dataBase) {
        this.window = window;
        this.dataBase = dataBase;
    }

    @Override
    public void windowClosing(WindowEvent evenement) {
        JDialog dialogWin = new JDialog(this.window, "Quitter Dorfromantik", true);
        dialogWin.setSize(300, 100);
        dialogWin.setLocationRelativeTo(this.window);
        dialogWin.setLayout(new FlowLayout());

        JLabel txtLabel = new JLabel("Êtes-vous sûr de vouloir fermer le jeu ? ");

        JButton yButton = new JButton("oui");
        JButton nButton = new JButton("non");

        yButton.addActionListener(new DialogWindowYesButton(dialogWin, this.window));
        nButton.addActionListener(new DialogWindowNoButton(dialogWin));

        dialogWin.add(txtLabel);
        dialogWin.add(yButton);
        dialogWin.add(nButton);
        dialogWin.setVisible(true);
    }

    public void windowActivated(WindowEvent evenement) {
    } // premier plan

    public void windowClosed(WindowEvent evenement) {
        this.dataBase.closeDataBase();
    } // après fermeture

    public void windowDeactivated(WindowEvent evenement) {
    } // arrière-plan

    public void windowDeiconified(WindowEvent evenement) {
    } // restauration

    public void windowIconified(WindowEvent evenement) {
    } // minimisation

    public void windowOpened(WindowEvent evenement) {
    } // après ouverture

}
