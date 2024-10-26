package fr.kanassoulier.dorfromantik.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.kanassoulier.dorfromantik.end.EndGameInfos;

/**
 * Classe qui permet d'interagir avec la base de donnée
 * 
 * @version 1.1
 * @author Marco Orfao
 */
public class Database {
	/**
	 * chargement des variables d'environnements
	 */
	private static final String url = Environment.getValue("DATABASE_URL");
	private static final String login = Environment.getValue("DATABASE_LOGIN");
	private static final String password = Environment.getValue("DATABASE_PASSWORD");

	/**
	 * Variable de passerelle entre le programme et la base de donnée
	 */
	private Connection database;

	/**
	 * Ouvre la connexion avec la base de donnée
	 */
	public Database() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			this.database = DriverManager.getConnection(url, login, password);
		} catch (ClassNotFoundException e) {
			System.err.println("Mauvais classpath");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	public Connection getDatabase() {
		return this.database;
	}

	/**
	 * Insérer le résultat de la partie dans la base de donnée
	 * 
	 * @param data information de fin de partie
	 */

	public void insertDatabase(EndGameInfos data) {
		try {
			PreparedStatement statement = this.database
					.prepareStatement("INSERT INTO Score(value,username,seed,date) VALUES (?,?,?,?);");

			statement.setInt(1, data.getScore());
			statement.setString(2, data.getUsername());
			statement.setLong(3, data.getSeed());
			statement.setDate(4, data.getDate());

			statement.executeUpdate();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}

	/**
	 * Méthode permettant de récupérer la liste des scores dans la base de données
	 * pour une seed donnée
	 * 
	 * @param seed
	 * @return un tableau de type EndGameInfos qui contient le résultat de la
	 *         requête SQL.
	 */
	public EndGameInfos[] getInfoDatabase(long seed) {
		try {
			EndGameInfos[] egiArray = new EndGameInfos[getSize(seed)];

			PreparedStatement infoStatement = this.database
					.prepareStatement("SELECT value,username FROM Score WHERE seed = ? ORDER BY value DESC;");

			infoStatement.setLong(1, seed);
			infoStatement.executeUpdate();

			ResultSet infoResult = infoStatement.executeQuery();

			int score;
			String username;

			for (int i = 0; i < getSize(seed); i++) {
				infoResult.next();
				score = infoResult.getInt(1);
				username = infoResult.getString(2);
				EndGameInfos infoLine = new EndGameInfos(score, username);
				egiArray[i] = infoLine;
			}

			return egiArray;

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());

			return new EndGameInfos[0];
		}
	}

	/**
	 * permet de récupérer le nombre de scores pour une seed donnée et n'en récupère
	 * pas plus de 10 pour le leaderboard
	 * 
	 * @param seed seed choisi
	 * @return la taille
	 */
	public int getSize(long seed) {
		try {
			PreparedStatement countStatement = this.database
					.prepareStatement("SELECT COUNT(Value) FROM Score WHERE seed = ?;");

			countStatement.setLong(1, seed);
			countStatement.executeUpdate();

			ResultSet countResult = countStatement.executeQuery();

			countResult.next();

			if (countResult.getInt(1) > 10) {
				return 10;
			} else {
				return countResult.getInt(1);
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());

			return 0;
		}
	}

	/**
	 * Fermer la base de donnée
	 * 
	 */
	public void closeDatabase() {
		try {
			if (this.database != null)
				this.database.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

}