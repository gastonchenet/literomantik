package fr.kanassoulier.literomantik.game;

import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;

import fr.kanassoulier.literomantik.Options;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.Component;

/**
 * Classe servant à gérer les interactions de l'utilisateur envers le jeu
 * 
 * @author Maxence Raymond, Gaston Chenet
 * @version 1.1
 */
public class GameInteractionListener implements MouseMotionListener, MouseWheelListener {
  private Game instance;

  private int mouseX;
  private int mouseY;
  private long lastRotation;

  /**
   * Constructeur pour le controleur d'interactions
   * 
   * @param instance L'instance du jeu
   */
  public GameInteractionListener(Game instance) {
    this.instance = instance;
    this.mouseX = this.instance.getWidth() / 2;
    this.mouseY = this.instance.getHeight() / 2;
    this.lastRotation = 0;
  }

  @Override
  public void mouseWheelMoved(MouseWheelEvent e) {
    int rotation = e.getWheelRotation();
    PlaceableArea area = null;

    for (Component component : this.instance.getBoard().getComponents()) {
      if (component instanceof PlaceableArea && ((PlaceableArea) component).getListener().isMouseOver()) {
        area = (PlaceableArea) component;
      }
    }
    if (area == null) {

    } else {
      if (System.currentTimeMillis() - this.lastRotation < Tile.MIN_SCROLL_OFFSET)
        return; // Empecher de tourner trop vite la tuile de preview (pour les pavés tactiles
                // qui scrollent trop vite)
      this.instance.getGui().getPreviewTile().rotate(rotation > 0);
      this.lastRotation = System.currentTimeMillis();
      this.instance.repaint();
    }
  }

  @Override
  public void mouseDragged(MouseEvent e) {
    int newX = e.getX();
    int newY = e.getY();
    int deltaX = newX - this.mouseX;
    int deltaY = newY - this.mouseY;

    this.instance.getBoard().moveBoard(deltaX * Options.DRAG_MULTIPLIER, deltaY * Options.DRAG_MULTIPLIER);
    this.mouseX = newX;
    this.mouseY = newY;
  }

  @Override
  public void mouseMoved(MouseEvent e) {
    this.mouseX = e.getX();
    this.mouseY = e.getY();
  }
}