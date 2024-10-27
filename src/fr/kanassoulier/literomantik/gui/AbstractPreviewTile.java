package fr.kanassoulier.literomantik.gui;

import java.awt.Point;

import fr.kanassoulier.literomantik.game.Board;
import fr.kanassoulier.literomantik.game.Tile;

public class AbstractPreviewTile extends Tile {

	public AbstractPreviewTile(Board board, int i, int j, int previewTileSize) {
		super(board, i, j, previewTileSize);
	}

	public void animateTo(Point center, Point viewportCenter) {
	}

}
