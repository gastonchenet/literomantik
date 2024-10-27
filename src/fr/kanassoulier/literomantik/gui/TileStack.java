package fr.kanassoulier.literomantik.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;

import javax.swing.JComponent;
import javax.swing.JLabel;

import fr.kanassoulier.literomantik.Options;
import fr.kanassoulier.literomantik.game.Game;
import fr.kanassoulier.literomantik.utils.FontLoader;

/**
 * La pile de tuiles restantes
 * 
 * @version 1.0
 * @author Gaston Chenet
 */
public class TileStack extends JComponent {
  /**
   * Les dimensions de l'objet
   */
  private static final int STACK_WIDTH = 70, TILE_HEIGHT = 6;

  private Gui gui;
  private JLabel remaining;

  /**
   * Crée une pile de tuiles
   * 
   * @param gui L'interface graphique
   */
  public TileStack(Gui gui) {
    this.gui = gui;

    this.setBounds(0, 0, TileStack.STACK_WIDTH, Game.WINDOW_HEIGHT);
    this.setOpaque(false);
    this.setLayout(null);

    this.remaining = new JLabel(Integer.toString(this.getTilesLeft()), JLabel.CENTER);

    this.updateTilesLeft();

    this.remaining.setFont(FontLoader.LEXEND_BOLD);

    this.add(this.remaining);
  }

  /**
   * Permet de récupérer le nombre de tuiles restantes
   * 
   * @return Le nombre de tuiles restantes
   */
  private int getTilesLeft() {
    return Options.TURNS - this.gui.getGame().getBoard().countTiles();
  }

  /**
   * Met à jour le nombre de tuiles restantes
   */
  private void updateTilesLeft() {
    int tilesLeft = this.getTilesLeft();

    this.remaining.setText(Integer.toString(tilesLeft));
    this.remaining.setBounds(0, Game.WINDOW_HEIGHT - tilesLeft * TileStack.TILE_HEIGHT - 90, TileStack.STACK_WIDTH - 3,
        20);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g.create();
    int tilesLeft = this.getTilesLeft();

    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    g2d.setStroke(new BasicStroke(2));

    for (int i = 0; i < tilesLeft; i++) {
      Polygon polygon = new Polygon();

      int ybase = Game.WINDOW_HEIGHT - i * TileStack.TILE_HEIGHT - 65;

      polygon.addPoint(15, ybase);
      polygon.addPoint(25, ybase + 5);
      polygon.addPoint(40, ybase + 5);
      polygon.addPoint(50, ybase);

      polygon.addPoint(50, ybase + TileStack.TILE_HEIGHT);
      polygon.addPoint(40, ybase + TileStack.TILE_HEIGHT + 5);
      polygon.addPoint(25, ybase + TileStack.TILE_HEIGHT + 5);
      polygon.addPoint(15, ybase + TileStack.TILE_HEIGHT);

      g2d.setColor(new Color(160, 160, 160));
      g2d.fillPolygon(polygon);

      g2d.setColor(Color.BLACK);
      g2d.drawPolygon(polygon);

      if (i == tilesLeft - 1) {
        polygon.reset();

        polygon.addPoint(15, ybase);
        polygon.addPoint(25, ybase + 5);
        polygon.addPoint(40, ybase + 5);
        polygon.addPoint(50, ybase);
        polygon.addPoint(40, ybase - 5);
        polygon.addPoint(25, ybase - 5);

        g2d.setColor(new Color(200, 200, 200));
        g2d.fillPolygon(polygon);

        g2d.setColor(Color.BLACK);
        g2d.drawPolygon(polygon);
      }
    }

    g2d.dispose();
    this.updateTilesLeft();
  }
}
