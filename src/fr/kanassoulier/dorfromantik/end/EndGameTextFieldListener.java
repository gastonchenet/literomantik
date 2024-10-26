package fr.kanassoulier.dorfromantik.end;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JDialog;

import java.sql.Date;
import java.time.LocalDate;

import fr.kanassoulier.dorfromantik.components.KTextField;
import fr.kanassoulier.dorfromantik.utils.Database;

public class EndGameTextFieldListener implements ActionListener {

	private KTextField tF;
	private int score;
	private long seed;
	private boolean status;
	private JLabel statusTxt;
	private JDialog window;

	public EndGameTextFieldListener(JDialog window, KTextField tF, int score, long seed, boolean status,
			JLabel statusTxt) {
		this.tF = tF;
		this.score = score;
		this.seed = seed;
		this.status = status;
		this.statusTxt = statusTxt;
		this.window = window;
	}

	public void actionPerformed(ActionEvent e) {
		if (this.status == false) {
			LocalDate currentDate = LocalDate.now();
			Date todayDate = Date.valueOf(currentDate);
			EndGameInfos egi = new EndGameInfos(this.score, this.tF.getInput().getText(), this.seed, todayDate);
			Database data = new Database();
			data.insertDatabase(egi);
			data.closeDatabase();
			this.status = true;
			this.statusTxt.setText("enregistré !");
			this.statusTxt.setForeground(Color.GREEN);
			this.window.revalidate();
			this.window.repaint();
		} else {
			this.statusTxt.setText("Vous avez déjà enregistré votre score !");
			this.statusTxt.setForeground(new Color(180, 180, 180));
			this.window.revalidate();
			this.window.repaint();
		}
	}
}
