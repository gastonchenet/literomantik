package fr.kanassoulier.dorfromantik.tmp;

import java.sql.*;

import fr.kanassoulier.dorfromantik.Environment;

/**
 * Classe qui permet d'interagir avec la base de donnée
 * 
 * @version 1.0
 * @author Marco Orfao
 */
public class DataBase {

  /**
   * chargement des variables d'environnements
   */
  private static final String url = Environment.getValue("DATABASE_URL");
  private static final String login = Environment.getValue("DATABASE_LOGIN");
  private static final String password = Environment.getValue("DATABASE_PASSWORD");

  /**
   * Variable de passerelle entre le programme et la base de donnée
   */
  private Connection dataBase;

  /**
   * Ouvre la connexion avec la base de donnée
   */
  public DataBase() {
    try {
      Class.forName("org.mariadb.jdbc.Driver");
      this.dataBase = DriverManager.getConnection(url, login, password);
    } catch (ClassNotFoundException e) {
      System.err.println("Mauvais classpath");
    } catch (SQLException e) {
      System.err.println(e.getMessage());
    }
  }

  /**
   * Insérer le résultat de la partie dans la base de donnée
   * 
   * @param score    score de la partie
   * @param username pseudonyme du joueur
   * @param seed     graine de la partie
   * @param date     date de la partie
   */

  public void insertDataBase(int score, String username, long seed, Date date) {
    try {
      PreparedStatement statement = this.dataBase
          .prepareStatement("INSERT INTO Score(value,username,seed,date) VALUES (?,?,?,?);");

      statement.setInt(1, score);
      statement.setString(2, username);
      statement.setLong(3, seed);
      statement.setDate(4, date);

      statement.executeUpdate();
    } catch (SQLException ex) {
      System.err.println(ex.getMessage());
    }
  }

  /**
   * Fermer la base de donnée
   * 
   */
  public void closeDataBase() {
    try {
      this.dataBase.close();
    } catch (SQLException e) {
      System.err.println(e.getMessage());
    }
  }

}