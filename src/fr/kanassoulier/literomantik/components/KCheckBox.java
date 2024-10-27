package fr.kanassoulier.literomantik.components;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.kanassoulier.literomantik.utils.FontLoader;

/**
 * Classe permettant de créer une case à cocher stylisée
 * 
 * @version 1.0
 * @author Gaston Chenet
 */
public class KCheckBox extends JPanel {
  /**
   * La largeur de la case à cocher
   */
  private static final int WIDTH = 200, HEIGHT = 20;

  private KCheckBoxContent content;

  /**
   * Constructeur de KCheckBox
   * 
   * @param text Le texte de la case à cocher
   */
  public KCheckBox(String text) {
    this.setOpaque(false);
    this.setLayout(null);
    this.setPreferredSize(new Dimension(KCheckBox.WIDTH, KCheckBox.HEIGHT));

    this.content = new KCheckBoxContent();
    this.add(this.content);

    JLabel label = new JLabel(text);
    label.setBounds(25, 0, KCheckBox.WIDTH - 25, KCheckBox.HEIGHT);
    label.setFont(FontLoader.LEXEND_REGULAR.deriveFont(14f));
    this.add(label);
  }

  /**
   * Permet de savoir si la case à cocher est cochée
   * 
   * @param checked
   */
  public void setChecked(boolean checked) {
    this.content.setChecked(checked);
  }

  /**
   * Permet de savoir si la case à cocher est cochée
   * 
   * @return true si la case à cocher est cochée, false sinon
   */
  public boolean isChecked() {
    return this.content.isChecked();
  }
}
