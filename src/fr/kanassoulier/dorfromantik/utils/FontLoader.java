package fr.kanassoulier.dorfromantik.utils;

import java.awt.*;
import java.io.*;

/**
 * Classe mettant à disposition les fonts
 * 
 * @author Maxence Raymond
 * @version 1.0
 */
public class FontLoader {
  /**
   * Méthode statique permettant de charger une police spécifiée ou Sans Serif en
   * cas d'échec
   * 
   * @param ressource Le chemin du fichier contenant la police
   * @return La police spécifiée ou Sans Serif en cas de problème
   */
  protected static final Font loadFont(String ressource) {
    try {
      Font font = Font.createFont(Font.TRUETYPE_FONT, Thread.currentThread().getContextClassLoader().getResourceAsStream(ressource)).deriveFont(20f);
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      ge.registerFont(font);
      return font;
    } catch (IOException | FontFormatException e) {
      e.printStackTrace();
      return Font.getFont(Font.SANS_SERIF);
    }
  }

  public static final Font LEXEND_BOLD = FontLoader.loadFont("resources/fonts/Lexend-Bold.ttf");
  public static final Font LEXEND_REGULAR = FontLoader.loadFont("resources/fonts/Lexend-Regular.ttf");
  public static final Font LILITA_ONE_REGULAR = FontLoader.loadFont("resources/fonts/LilitaOne-Regular.ttf");
}
