package fr.kanassoulier.literomantik.end;

import java.sql.Date;

/**
 * classe permettant de rassembler des informations en fin de partie
 * 
 * @version 1.1
 * @author Marco Orfao, Gaston Chenet
 */
public class EndGameInfo {
  private int score;
  private String username;
  private long seed = -1;
  private Date date;

  /**
   * Constructeur permettant de rassembler les informations en fin de partie
   * 
   * @param score    score de fin de partie
   * @param username nom du joueur
   * @param seed     graine de la partie
   * @param date     date de la partie
   */
  public EndGameInfo(int score, String username, long seed, Date date) {
    this.score = score;
    this.username = username;
    this.seed = seed;
    this.date = date;
  }

  /**
   * constructeur permettant une instanciation optimisé pour le leaderboard
   * 
   * @param score    score de fin de partie
   * @param username nom du joueur
   */
  public EndGameInfo(int score, String username) {
    this.score = score;
    this.username = username;
  }

  /**
   * méthoder pour récupérer le score
   * 
   * @return score de fin de partie
   */
  public int getScore() {
    return this.score;
  }

  /**
   * méthoder pour récupérer le username du joueur
   * 
   * @return le nom indiqué par le joueur
   */
  public String getUsername() {
    return this.username;
  }

  /**
   * méthoder pour récupérer la seed de la partie
   * 
   * @return la seed de la partie
   */
  public long getSeed() {
    return this.seed;
  }

  /**
   * méthoder pour récupérer la date de la partie
   * 
   * @return la date de la partie
   */
  public Date getDate() {
    return this.date;
  }
}
