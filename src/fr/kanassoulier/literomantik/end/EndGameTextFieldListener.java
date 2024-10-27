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

/**
 * Classe permettant de gérer l'écouteur du champ de texte de fin de partie
 * 
 * @version 1.0
 * @author Gaston Chenet
 */
public class EndGameTextFieldListener implements ActionListener {
	private KTextField textField;
	private int score;
	private long seed;
	private boolean status;
	private JLabel statusTxt;

	/**
	 * Constructeur de EndGameTextFieldListener
	 * 
	 * @param textField Le champ de texte à écouter
	 * @param score     Le score de la partie
	 * @param seed      La graine de la partie
	 * @param status    Le statut de la partie
	 * @param statusTxt Le texte de statut de la partie
	 */
	public EndGameTextFieldListener(KTextField textField, int score, long seed, boolean status, JLabel statusTxt) {
		this.textField = textField;
		this.score = score;
		this.seed = seed;
		this.status = status;
		this.statusTxt = statusTxt;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		EndMenu window = (EndMenu) SwingUtilities.getWindowAncestor(this.textField);

		if (!this.status) {
			LocalDate currentDate = LocalDate.now();
			Date todayDate = Date.valueOf(currentDate);
			EndGameInfo egi = new EndGameInfo(this.score, this.textField.getInput().getText(), this.seed, todayDate);
			Database data = new Database();

			data.insertEndResult(egi);
			data.close();

			this.status = true;
			this.statusTxt.setText("Enregistré !");
			this.statusTxt.setForeground(new Color(13, 161, 33));
		} else {
			this.statusTxt.setText("Vous avez déjà enregistré votre score !");
			this.statusTxt.setForeground(new Color(180, 180, 180));
		}

		window.revalidate();
		window.repaint();
	}
}
