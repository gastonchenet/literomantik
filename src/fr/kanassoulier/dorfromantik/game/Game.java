package fr.kanassoulier.dorfromantik.game;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import fr.kanassoulier.dorfromantik.Options;
import fr.kanassoulier.dorfromantik.end.EndMenu;
import fr.kanassoulier.dorfromantik.gui.Gui;
import fr.kanassoulier.dorfromantik.utils.Database;
import fr.kanassoulier.dorfromantik.utils.ImageLoader;

/**
 * Classe contenant le jeu
 * 
 * @version 1.1
 * @author Gaston Chenet, Maxence Raymond
 */
public class Game extends JFrame {
	/**
	 * Titre de la fenêtre du jeu
	 */
	public static final String WINDOW_TITLE = "Dorfromantik";

	/**
	 * Dimensions de la fenêtre du jeu
	 */
	public static final int WINDOW_WIDTH = 1080, WINDOW_HEIGHT = 720;

	private Board board;
	private Gui gui;
	private Random randomizer;
	private Database database;
	private long seed;

	public static long toSeed(String seed) {
		if (seed == null || seed.isEmpty()) {
			return new Random().nextLong();
		}

		try {
			return Long.parseLong(seed);
		} catch (NumberFormatException e) {
			return seed.hashCode();
		}
	}

	/**
	 * Créer une instance du jeu
	 */
	public Game(long seed) {
		this.seed = seed;
		this.randomizer = new Random(seed);
		this.database = new Database();

		this.setTitle(Game.WINDOW_TITLE);
		this.setIconImage(ImageLoader.APP_ICON);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setSize(Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);

		this.board = new Board(this);
		this.gui = new Gui(this);

		this.add(this.gui, JLayeredPane.PALETTE_LAYER);
		this.add(this.board, JLayeredPane.DEFAULT_LAYER);

		this.addKeyListener(new GameKeyListener(this));
		this.addWindowListener(new CloseGameDialogListener(this));

		GameInteractionListener listener = new GameInteractionListener(this);
		this.addMouseMotionListener(listener);
		this.addMouseWheelListener(listener);
	}

	/**
	 * Obtenir le plateau de jeu
	 * 
	 * @return Le plateau de jeu
	 */
	public Board getBoard() {
		return this.board;
	}

	public Database getDatabase() {
		return this.database;
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

	public long getSeed() {
		return this.seed;
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

	public boolean isFinished() {
		return this.board.countTiles() >= Options.TURNS;
	}

	public void showEndMenu() {
		new EndMenu(this).setVisible(true);
	}
}
