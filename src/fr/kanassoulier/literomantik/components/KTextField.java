package fr.kanassoulier.literomantik.components;

import javax.swing.JPanel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

/**
 * Classe permettant de créer un champ de texte stylisé
 * 
 * @version 1.0
 * @author Gaston Chenet
 */
public class KTextField extends JPanel {
  private KTextFieldInput input;
  private KTextFieldSubmit submit;

  /**
   * Constructeur de KTextField
   * 
   * @param text Le texte du champ de texte
   */
  public KTextField(String text) {
    this.input = new KTextFieldInput(text);
    this.submit = new KTextFieldSubmit();

    this.setLayout(new GridBagLayout());
    this.setBorder(null);
    this.setOpaque(false);

    GridBagConstraints gbc = new GridBagConstraints();

    gbc.fill = GridBagConstraints.HORIZONTAL;

    gbc.gridx = 1;
    this.add(this.submit, gbc);

    gbc.insets = new Insets(0, 0, 0, 8);
    gbc.weightx = 1.0f;
    gbc.gridx = 0;
    this.add(this.input, gbc);
  }

  /**
   * Constructeur de KTextField
   */
  public KTextField() {
    this("");
  }

  /**
   * Permet de récupérer le champ de texte
   * 
   * @return Le champ de texte
   */
  public KTextFieldInput getInput() {
    return this.input;
  }

  /**
   * Permet de récupérer le bouton de validation
   * 
   * @return Le bouton de validation
   */
  public KTextFieldSubmit getSubmit() {
    return this.submit;
  }
}
