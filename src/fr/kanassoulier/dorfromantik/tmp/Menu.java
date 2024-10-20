package fr.kanassoulier.dorfromantik.tmp;

import javax.swing.JFrame;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JLabel;

import fr.kanassoulier.dorfromantik.Game;

/**
 * Classe permettant la création de la fenêtre de menu
 * 
 * @version 1.0
 * @author Marco Orfao
 */
public class Menu extends JFrame {

    /**
     * instanciation de d'une fenêtre JFrame contenant le menu
     */
    public Menu() {
        this.setTitle(Game.WINDOW_TITLE);
        this.setIconImage("./resources/images/favicon.png");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        // Titre
        JLabel title = new JLabel("DORFROMANTIK");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        // gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 0.1;
        gbc.weighty = 0.1;
        gbc.insets = new Insets(0, 0, 0, 0);

        title.setFont(new Font("Sans Bold", Font.BOLD, 100));
        this.add(title, gbc);

        // Bouton Play
        HexagonButton play = new HexagonButton("Play", new Color(50, 205, 50), new Color(51, 255, 102));

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        // gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.weightx = 0.1;
        gbc.weighty = 0.1;
        gbc.insets = new Insets(0, 0, 0, 0);

        play.addActionListener(new PlayButtonActionListener(this));

        this.add(play, gbc);

        // Bouton Quit

        HexagonButton quit = new HexagonButton("Quit", new Color(228, 75, 48), new Color(204, 51, 0));

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        // gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.weightx = 0.1;
        gbc.weighty = 0.1;
        gbc.insets = new Insets(0, 0, 0, 0);

        quit.addActionListener(new QuitButtonActionListener(this));

        this.add(quit, gbc);

    }

    /**
     * Définir l'icône de la fenêtre du jeu
     * 
     * @param path Le chemin de l'icône
     */
    private void setIconImage(String path) {
        try {
            super.setIconImage(ImageIO.read(new File(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}