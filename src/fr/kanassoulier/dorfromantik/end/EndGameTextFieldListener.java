package fr.kanassoulier.dorfromantik.end;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.Date;
import java.time.LocalDate;

import fr.kanassoulier.dorfromantik.components.KTextField;
import fr.kanassoulier.dorfromantik.utils.Database;

public class EndGameTextFieldListener implements ActionListener {

	private KTextField tF;
	private int score;
	private long seed;

	public EndGameTextFieldListener(KTextField tF, int score, long seed) {
		this.tF = tF;
		this.score = score;
		this.seed = seed;
	}

	public void actionPerformed(ActionEvent e) {
		LocalDate currentDate = LocalDate.now();
		Date todayDate = Date.valueOf(currentDate);
		EndGameInfos egi = new EndGameInfos(this.score, this.tF.getInput().getText(), this.seed, todayDate);
		Database data = new Database();
		data.insertDatabase(egi);
		data.closeDatabase();
	}
}
