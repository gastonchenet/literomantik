package fr.kanassoulier.literomantik.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.kanassoulier.literomantik.end.EndGameInfo;
import fr.kanassoulier.literomantik.landing.LandingMenuLeaderboard;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	private static final String URL = Environment.getValue("DATABASE_URL");
	private static final String LOGIN = Environment.getValue("DATABASE_LOGIN");
	private static final String PASSWORD = Environment.getValue("DATABASE_PASSWORD");

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
			this.database = DriverManager.getConnection(Database.URL, Database.LOGIN, Database.PASSWORD);
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
	 * @param endGameInfo information de fin de partie
	 */

	public void insertEndResult(EndGameInfo endGameInfo) {
		try {
			PreparedStatement statement = this.database
					.prepareStatement("INSERT INTO Score(value,username,seed,date) VALUES (?,?,?,?);");

			statement.setInt(1, endGameInfo.getScore());
			statement.setString(2, endGameInfo.getUsername());
			statement.setLong(3, endGameInfo.getSeed());
			statement.setDate(4, endGameInfo.getDate());

			statement.executeUpdate();

			statement.close();
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
	public EndGameInfo[] getRowsFromSeed(long seed) {
		try {
			EndGameInfo[] leaderboardRows = new EndGameInfo[LandingMenuLeaderboard.LEADERBOARD_SIZE];

			PreparedStatement infoStatement = this.database
					.prepareStatement("SELECT value, username FROM Score WHERE seed = ? ORDER BY value DESC LIMIT ?;");

			infoStatement.setLong(1, seed);
			infoStatement.setInt(2, LandingMenuLeaderboard.LEADERBOARD_SIZE);
			infoStatement.executeUpdate();

			ResultSet infoResult = infoStatement.executeQuery();

			for (int i = 0; i < LandingMenuLeaderboard.LEADERBOARD_SIZE; i++) {
				infoResult.next();

				if (infoResult.isAfterLast())
					break;

				int score = infoResult.getInt(1);
				String username = infoResult.getString(2);
				EndGameInfo infoLine = new EndGameInfo(score, username);

				leaderboardRows[i] = infoLine;
			}

			infoStatement.close();
			infoResult.close();
			return leaderboardRows;
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
			return new EndGameInfo[0];
		}
	}

	/**
	 * Méthode permettant de récupérer le meilleur score pour une seed donnée
	 * 
	 * @param seed la seed pour laquelle on veut le meilleur score
	 * @return le meilleur score pour la seed donnée
	 */
	public int getBestScore(long seed) {
		try {
			PreparedStatement statement = this.database
					.prepareStatement("SELECT MAX(value) FROM Score WHERE seed = ?;");

			statement.setLong(1, seed);
			statement.executeUpdate();

			ResultSet result = statement.executeQuery();
			result.next();

			int bestScore = result.getInt(1);

			statement.close();
			result.close();

			return bestScore;
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