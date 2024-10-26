package fr.kanassoulier.literomantik.end;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import fr.kanassoulier.literomantik.components.KTextField;
import fr.kanassoulier.literomantik.utils.Database;

import java.sql.Date;
import java.time.LocalDate;

public class EndGameTextFieldListener implements ActionListener {
	private KTextField textField;
	private int score;
	private long seed;
	private boolean status;
	private JLabel statusTxt;

	public EndGameTextFieldListener(KTextField textField, int score, long seed, boolean status, JLabel statusTxt) {
		this.textField = textField;
		this.score = score;
		this.seed = seed;
		this.status = status;
		this.statusTxt = statusTxt;
	}

	public void actionPerformed(ActionEvent e) {
		EndMenu window = (EndMenu) SwingUtilities.getWindowAncestor(this.textField);

		if (!this.status) {
			LocalDate currentDate = LocalDate.now();
			Date todayDate = Date.valueOf(currentDate);
			EndGameInfo egi = new EndGameInfo(this.score, this.textField.getInput().getText(), this.seed, todayDate);
			Database data = new Database();

			data.insertEndResult(egi);
			data.closeDatabase();

			this.status = true;
			this.statusTxt.setText("enregistré !");
			this.statusTxt.setForeground(Color.GREEN);
		} else {
			this.statusTxt.setText("Vous avez déjà enregistré votre score !");
			this.statusTxt.setForeground(new Color(180, 180, 180));
		}

		window.revalidate();
		window.repaint();
	}
}
