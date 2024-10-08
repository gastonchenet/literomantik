package fr.kanassoulier.dorfromantik;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import fr.kanassoulier.dorfromantik.board.Board;
import fr.kanassoulier.dorfromantik.gui.Gui;

public class Game extends JFrame implements MouseMotionListener {
  private static final String WINDOW_TITLE = "Dorfromantik";

  public static final int WINDOW_WIDTH = 1080, WINDOW_HEIGHT = 720;

  private int mouseX = Game.WINDOW_WIDTH / 2, mouseY = Game.WINDOW_HEIGHT / 2;
  private Board board = new Board(this);
  private Gui gui = new Gui(this);

  public Game() {
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
  }

  private void setIcon(String path) {
    try {
      this.setIconImage(ImageIO.read(new File(path)));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public Board getBoard() {
    return this.board;
  }

  public Gui getGui() {
    return this.gui;
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
