package fr.kanassoulier.dorfromantik.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import fr.kanassoulier.dorfromantik.Game;
import fr.kanassoulier.dorfromantik.Options;

/**
 * La pile de tuiles restantes
 * 
 * @version 1.0
 * @author Gaston Chenet
 */
public class TileStack extends JPanel {
  private static final int TILE_HEIGHT = 6;

  private Gui gui;

  public TileStack(Gui gui) {
    super(true);

    this.gui = gui;

    this.setBounds(0, 0, 70, Game.WINDOW_HEIGHT);
    this.setOpaque(false);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g.create();

    int tilesLeft = Options.TURNS - this.gui.getGame().getBoard().countTiles();

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
  }
}
