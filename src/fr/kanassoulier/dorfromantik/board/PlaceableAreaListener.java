package fr.kanassoulier.dorfromantik.board;

import java.awt.event.*;

/**
 * L'implémentation des méthodes de Swing pour la classe PlaceableArea.
 * 
 * @version 1.0
 * @author Maxence Raymond
 * @see PlaceableArea
 */

public class PlaceableAreaListener implements MouseListener {

    private PlaceableArea zone;

    public PlaceableAreaListener(PlaceableArea zone) {
        this.zone = zone;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.zone.setMouseOver(true);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.zone.setMouseOver(false);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.zone.placeTile();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }
}
