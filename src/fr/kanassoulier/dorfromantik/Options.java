package fr.kanassoulier.dorfromantik;

/**
 * Classe contenant les options du jeu
 * 
 * @version 1.2
 * @author Gaston Chenet
 * @author Maxence Raymond
 */
public class Options {
  /**
   * Le nombre de tours maximum
   */
  public static final int TURNS = 12;

  /**
   * Le rayon d'une cellule
   */
  public static final int CELL_RADIUS = 56;

  /**
   * La taille d'une tuile de prévisualisation
   */
  public static final int PREVIEW_TILE_SIZE = 72;

  /**
   * Le volume de la musique
   */
  public static int MUSIC_VOLUME = 0;

  /**
   * Le volume des effets sonores
   */
  public static int SOUND_VOLUME = 50;

  /**
   * Savoir si le son principal est coupé lors de l'exécution
   */
  public static boolean MUTED = false;

  /**
   * La sensibilité du deplacement sur le plateau
   */
  public static final double DRAG_MULTIPLIER = 0.75;
}
