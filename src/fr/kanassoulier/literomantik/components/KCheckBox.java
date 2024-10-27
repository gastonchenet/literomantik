package fr.kanassoulier.literomantik.components;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.kanassoulier.literomantik.utils.FontLoader;

public class KCheckBox extends JPanel {
  private static final int WIDTH = 200;
  private static final int HEIGHT = 20;

  private KCheckBoxContent content;

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

  public void setChecked(boolean checked) {
    this.content.setChecked(checked);
  }

  public boolean isChecked() {
    return this.content.isChecked();
  }
}
