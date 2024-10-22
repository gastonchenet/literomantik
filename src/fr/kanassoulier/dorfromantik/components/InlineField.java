package fr.kanassoulier.dorfromantik.components;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class InlineField extends JPanel {
  private InlineFieldInput input;
  private InlineFieldSubmit submit;

  public InlineField(String text) {
    this.input = new InlineFieldInput(text);
    this.submit = new InlineFieldSubmit();

    this.setLayout(new GridBagLayout());
    this.setBorder(new EmptyBorder(4, 0, 0, 0));
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

  public InlineField() {
    this("");
  }
}
