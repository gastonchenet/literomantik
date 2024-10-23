package fr.kanassoulier.dorfromantik.landing;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;

import fr.kanassoulier.dorfromantik.end.EndGameInfos;
import fr.kanassoulier.dorfromantik.utils.Database;

/**
 * classe qui permet d'exécuter des actions précise à l'appuie d'un "SeedButton"
 * du menu
 * 
 * @version 1.0
 * @author Marco Orfao
 */
public class LandingMenuSeedsButtonsListener implements ActionListener {

  /**
   * Variables générales permettant de manipuler la seed ainsi que le tableau des
   * scores
   */
  private long seed;
  private JPanel leaderboard;

  /**
   * Constructeur de la classe
   * 
   * @param seed
   * @param leaderboard
   */
  public LandingMenuSeedsButtonsListener(long seed, JPanel leaderboard) {
    super();

    this.seed = seed;
    this.leaderboard = leaderboard;
  }

  /**
   * sert à ajouter au tableau des scores le contenu de la base de donnée pour une
   * seed donnée.
   */
  public void actionPerformed(ActionEvent e) {

    Database data = new Database();

    GridBagConstraints gbc = new GridBagConstraints();

    EndGameInfos[] infoArray;
    infoArray = data.getInfoDatabase(this.seed);

    for (int i = 0; i < 10; i++) {

      JLabel username = new JLabel(infoArray[i].getUsername());
      gbc.gridx = 0;
      gbc.gridy = i;
      this.leaderboard.add(username, gbc);

      JLabel score = new JLabel(infoArray[i].toString(infoArray[i].getScore()));
      gbc.gridx = 1;
      gbc.gridy = i;
      this.leaderboard.add(score, gbc);
    }

    data.closeDatabase();
  }

}
