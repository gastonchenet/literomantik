package fr.kanassoulier.literomantik.game;

import java.awt.Component;
import java.awt.Point;

import javax.swing.JLayeredPane;

import fr.kanassoulier.literomantik.Options;
import fr.kanassoulier.literomantik.enums.SoundChannel;
import fr.kanassoulier.literomantik.gui.PreviewTile;
import fr.kanassoulier.literomantik.gui.Scoreboard;
import fr.kanassoulier.literomantik.utils.SoundPlayer;

/**
 * Le plateau de jeu.
 * 
 * @version 1.1
 * @author Gaston Chenet
 */
public class Board extends JLayeredPane {
	/**
	 * Le rayon du plateau.
	 */
	private static final int BOARD_RADIUS = Options.TURNS * Options.CELL_RADIUS * 2;

	private Game game;
	private int x = Game.WINDOW_WIDTH / 2, y = Game.WINDOW_HEIGHT / 2;
	private boolean animating = false;

	/**
	 * Constructeur du plateau de jeu.
	 * 
	 * @param game La classe de jeu.
	 */
	public Board(Game game) {
		super();

		this.game = game;

		// L'utilisateur ne doit pas atteindre le bout de la map même en faisant une
		// ligne equivalente au nombre de tours
		this.setBounds(this.x - Board.BOARD_RADIUS, this.y - Board.BOARD_RADIUS,
				Board.BOARD_RADIUS * 2, Board.BOARD_RADIUS * 2);

		this.setLayout(null);
		this.setOpaque(false);
		this.add(new PlaceableTile(this, Board.BOARD_RADIUS, Board.BOARD_RADIUS));
	}

	public void refill() {
		this.removeAll();
		this.add(new PlaceableTile(this, Board.BOARD_RADIUS, Board.BOARD_RADIUS));
		this.repaint();
	}

	/**
	 * Récupérer la classe de jeu.
	 * 
	 * @return La classe de jeu.
	 */
	public Game getGame() {
		return this.game;
	}

	/**
	 * Récupérer le centre du plateau.
	 * 
	 * @return Le centre du plateau.
	 */
	public Point getCenter() {
		return new Point(this.x, this.y);
	}

	/**
	 * Récupérer une cellule du plateau.
	 * 
	 * @param x La coordonnée x de la cellule.
	 * @param y La coordonnée y de la cellule.
	 * @return La cellule du plateau.
	 */
	public Cell getCell(int x, int y) {
		for (Component component : this.getComponents()) {
			Cell cell = (Cell) component;

			if (cell.at(x, y))
				return cell;
		}

		return (Cell) new EmptyCell(this, x, y);
	}

	/**
	 * Récupérer une cellule du plateau.
	 * 
	 * @param point Les coordonnées de la cellule.
	 * @return La cellule du plateau.
	 */
	public Cell getCell(Point point) {
		return this.getCell(point.x, point.y);
	}

	/**
	 * Compter le nombre de tuiles sur le plateau.
	 * 
	 * @return Le nombre de tuiles sur le plateau.
	 */
	public int countTiles() {
		int count = 0;

		for (Component component : this.getComponents()) {
			if (component instanceof PlaceableTile)
				count++;
		}

		return count;
	}

	/**
	 * Placer une tuile sur le plateau.
	 * 
	 * @param area La zone où placer la tuile.
	 */
	public void placeTile(PlaceableArea area) {
		if (this.game.isFinished() || this.animating)
			return;

		this.remove(area);

		PreviewTile previewTile = this.game.getGui().getPreviewTile();
		previewTile.animateTo(area.getCenter(), area.getViewportCenter());
		this.animating = true;
	}

	/**
	 * Afficher une tuile sur le plateau.
	 * 
	 * @param previewTile La tuile à afficher.
	 * @param center      Le centre de la tuile.
	 */
	public void displayTile(PreviewTile previewTile, Point center) {
		this.animating = false;
		PlaceableTile tile = new PlaceableTile(previewTile, center);
		this.add(tile);

		tile.repaint();

		Scoreboard scoreboard = this.game.getGui().getScoreboard();
		scoreboard.updateScore(true);

		int matches = tile.matchCount();
		SoundPlayer.play("tiles/linked-" + matches, SoundChannel.SOUND);

		previewTile.refill();

		if (this.game.isFinished()) {
			for (Component component : this.getComponents()) {
				if (component instanceof PlaceableArea)
					this.remove(component);
			}

			this.game.showEndMenu();
		}
	}

	/**
	 * Déplacer le plateau.
	 * 
	 * @param deltaX Le déplacement en x.
	 * @param deltaY Le déplacement en y.
	 */
	public void moveBoard(double deltaX, double deltaY) {
		this.x += Math.round(deltaX);
		this.y += Math.round(deltaY);

		this.setBounds(
				this.x - Board.BOARD_RADIUS,
				this.y - Board.BOARD_RADIUS,
				Board.BOARD_RADIUS * 2,
				Board.BOARD_RADIUS * 2);
	}
}