package fr.kanassoulier.dorfromantik.landing;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import fr.kanassoulier.dorfromantik.utils.Database;

public class LandingMenuLeaderboardButtonsListener extends JPanel implements ActionListener {

  private long seed;
  private Database database;

  public LandingMenuLeaderboardButtonsListener(long seed, Database database) {
    super();
    this.setLayout(new GridBagLayout());

    this.seed = seed;
    this.database = database;
  }

  public void actionPerformed(ActionEvent e) {

    GridBagConstraints gbc = new GridBagConstraints();

    database.getInfoDatabase(this.seed);

  }

}
