package fr.kanassoulier.dorfromantik.landing;

import java.io.IOException;
import java.awt.Color;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JLabel;

import fr.kanassoulier.dorfromantik.Game;
import fr.kanassoulier.dorfromantik.utils.FontLoader;

import javax.imageio.ImageIO;

/**
 * Classe permettant la création de la fenêtre de menu
 * 
 * @version 1.1
 * @author Marco Orfao, Gaston Chenet
 */
public class LandingMenu extends JFrame {
  /**
   * instanciation de d'une fenêtre JFrame contenant le menu
   */
  public LandingMenu() {
    this.setTitle(Game.WINDOW_TITLE);
    this.setIconImage("./resources/images/favicon.png");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.setLayout(null);
    this.getContentPane().setBackground(Color.WHITE);

    JLabel pageTitle = new JLabel("DORFROMANTIK", JLabel.CENTER);
    pageTitle.setFont(FontLoader.LILITA_ONE_REGULAR.deriveFont(55f));
    pageTitle.setBounds(0, 50, Game.WINDOW_WIDTH - Sidebar.WIDTH, 50);

    this.add(pageTitle);
    this.add(new Sidebar());
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