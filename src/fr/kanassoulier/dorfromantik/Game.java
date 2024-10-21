package fr.kanassoulier.dorfromantik;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import fr.kanassoulier.dorfromantik.board.Board;
import fr.kanassoulier.dorfromantik.board.PlaceableArea;
import fr.kanassoulier.dorfromantik.board.Tile;
import fr.kanassoulier.dorfromantik.enums.SoundChannel;
import fr.kanassoulier.dorfromantik.gui.Gui;
import fr.kanassoulier.dorfromantik.tmp.Database;
import fr.kanassoulier.dorfromantik.utils.SoundPlayer;
import fr.kanassoulier.dorfromantik.tmp.CloseGameDialog;
import fr.kanassoulier.dorfromantik.tmp.CloseGameDialogListener;

/**
 * Classe contenant le jeu
 * 
 * @version 1.0
 * @author Gaston Chenet
 */
public class Game extends JFrame implements MouseMotionListener, MouseWheelListener {
  /**
   * Titre de la fenêtre du jeu
   */
  public static final String WINDOW_TITLE = "Dorfromantik";

  /**
   * Dimensions de la fenêtre du jeu
   */
  public static final int WINDOW_WIDTH = 1080, WINDOW_HEIGHT = 720;

  private int mouseX = Game.WINDOW_WIDTH / 2, mouseY = Game.WINDOW_HEIGHT / 2;
  private long lastRotation = 0;
  private Board board;
  private Gui gui;
  private Random randomizer;
  private Database database;

  /**
   * Créer une instance du jeu
   */
  public Game(long seed) {
    this.randomizer = new Random(seed);
    this.board = new Board(this);
    this.gui = new Gui(this);
    this.database = new Database();

    this.setTitle(Game.WINDOW_TITLE);
    this.setIconImage("./resources/images/favicon.png");
    this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    this.setSize(Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.setLayout(null);

    this.add(this.gui, JLayeredPane.PALETTE_LAYER);
    this.add(this.board, JLayeredPane.DEFAULT_LAYER);

    CloseGameDialog closeGameDialog = new CloseGameDialog(this);
    this.addWindowListener(new CloseGameDialogListener(closeGameDialog, this.database));

    this.addMouseMotionListener(this);
    this.addMouseWheelListener(this);

    SoundPlayer.play("music", SoundChannel.MUSIC);
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

  /**
   * Obtenir le plateau de jeu
   * 
   * @return Le plateau de jeu
   */
  public Board getBoard() {
    return this.board;
  }

  /**
   * Obtenir la GUI du jeu
   * 
   * @return La GUI du jeu
   */
  public Gui getGui() {
    return this.gui;
  }

  /**
   * Obtenir un nombre aléatoire
   * 
   * @return Un nombre aléatoire
   */
  public int getRandomInt() {
    return this.randomizer.nextInt();
  }

  /**
   * Obtenir un nombre aléatoire
   * 
   * @param bound La borne du nombre aléatoire
   * @return Un nombre aléatoire
   */
  public int getRandomInt(int bound) {
    return this.randomizer.nextInt(bound);
  }

  @Override
  public void mouseWheelMoved(MouseWheelEvent e) {
    int rotation = e.getWheelRotation();
    PlaceableArea area = null;

    for (Component component : this.board.getComponents()) {
      if (component instanceof PlaceableArea && ((PlaceableArea) component).isMouseOver()) {
        area = (PlaceableArea) component;
      }
    }

    if (area == null) {

    } else {
      if (System.currentTimeMillis() - this.lastRotation < Tile.MIN_SCROLL_OFFSET)
        return; // Empecher de tourner trop vite la tuile de preview (pour les pavés tactiles
                // qui scrollent trop vite)

      this.gui.getPreviewTile().rotate(rotation > 0);
      this.lastRotation = System.currentTimeMillis();
      area.repaint();
    }

  }

  @Override
  public void mouseDragged(MouseEvent e) {
    int newX = e.getX();
    int newY = e.getY();

    int deltaX = newX - this.mouseX;
    int deltaY = newY - this.mouseY;

    this.board.moveBoard(deltaX * 0.75, deltaY * 0.75);

    this.mouseX = newX;
    this.mouseY = newY;
  }

  @Override
  public void mouseMoved(MouseEvent e) {
    this.mouseX = e.getX();
    this.mouseY = e.getY();
  }
}
