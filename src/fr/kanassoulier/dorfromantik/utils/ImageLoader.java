package fr.kanassoulier.dorfromantik.utils;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Classe statique mettant à disposition les images nécessaires
 * 
 * @version 1.1
 * @author Maxence Raymond
 */
public class ImageLoader {
	/**
	 * Charge l'image spécifiée
	 * 
	 * @param path Le chemin relatif vers l'image
	 * @return L'image chargée ou null en cas d'échec
	 */
	protected static final Image loadImage(String path) {
		try {
			return ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream(path));
		} catch (IOException e) {
			System.err.println("Unable to read the image");
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Logo de l'application
	 */
	public static final Image IMAGE_LOGO = ImageLoader.loadImage("resources/images/favicon.png");
}