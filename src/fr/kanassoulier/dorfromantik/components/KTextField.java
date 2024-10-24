package fr.kanassoulier.dorfromantik.components;

import javax.swing.JPanel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class KTextField extends JPanel {
  private KTextFieldInput input;
  private KTextFieldSubmit submit;

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

  public KTextField() {
    this("");
  }

  public KTextFieldInput getInput() {
    return this.input;
  }

  public KTextFieldSubmit getSubmit() {
    return this.submit;
  }
}
