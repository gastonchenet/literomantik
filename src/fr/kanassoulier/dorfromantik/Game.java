package fr.kanassoulier.dorfromantik;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

import fr.kanassoulier.dorfromantik.board.Board;
import fr.kanassoulier.dorfromantik.gui.Gui;

public class Game extends JFrame implements MouseMotionListener {
  private static final String WINDOW_TITLE = "Dorfromantik";

  public static final int WINDOW_WIDTH = 1080;
  public static final int WINDOW_HEIGHT = 720;

  private int mouseX = Game.WINDOW_WIDTH / 2;
  private int mouseY = Game.WINDOW_HEIGHT / 2;

  private Board board = new Board(this);
  private Gui gui = new Gui(this);

  public Game() {
    this.setTitle(Game.WINDOW_TITLE);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.setLayout(null);
    this.add(this.gui);
    this.add(this.board);
    this.addMouseMotionListener(this);
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
