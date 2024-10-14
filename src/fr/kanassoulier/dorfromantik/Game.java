package fr.kanassoulier.dorfromantik;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import fr.kanassoulier.dorfromantik.board.Board;
import fr.kanassoulier.dorfromantik.board.Tile;
import fr.kanassoulier.dorfromantik.gui.Gui;

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
  private static final String WINDOW_TITLE = "Dorfromantik";

  /**
   * Dimensions de la fenêtre du jeu
   */
  public static final int WINDOW_WIDTH = 1080, WINDOW_HEIGHT = 720;

  private int mouseX = Game.WINDOW_WIDTH / 2, mouseY = Game.WINDOW_HEIGHT / 2;
  private Board board = new Board(this);
  private Gui gui = new Gui(this);
  private long seed, lastRotation = 0;

  public Game(long seed) {
    this.seed = seed % (Long.MAX_VALUE - Options.TURNS);

    this.setTitle(Game.WINDOW_TITLE);
    this.setIcon("./resources/images/favicon.png");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.setLayout(null);
    this.add(this.gui, JLayeredPane.PALETTE_LAYER);
    this.add(this.board, JLayeredPane.DEFAULT_LAYER);

    this.addMouseMotionListener(this);
    this.addMouseWheelListener(this);
  }

  public Game() {
    this(System.currentTimeMillis());
  }

  /**
   * Définir l'icône de la fenêtre du jeu
   * 
   * @param path Le chemin de l'icône
   */
  private void setIcon(String path) {
    try {
      this.setIconImage(ImageIO.read(new File(path)));
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
   * Obtenir la graine de génération du jeu
   * 
   * @return La graine du génération jeu
   */
  public long getSeed() {
    return this.seed = (this.seed + 1) % (Long.MAX_VALUE - Options.TURNS);
  }

  @Override
  public void mouseWheelMoved(MouseWheelEvent e) {
    int rotation = e.getWheelRotation();

    if (System.currentTimeMillis() - this.lastRotation < Tile.MIN_SCROLL_OFFSET)
      return; // Empecher de tourner trop vite la tuile de preview (pour les pavés tactiles
              // qui scrollent trop vite)

    this.gui.getPreviewTile().rotate(rotation > 0);
    this.lastRotation = System.currentTimeMillis();
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
