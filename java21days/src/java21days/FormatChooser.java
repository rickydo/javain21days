package java21days;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FormatChooser extends JFrame implements ItemListener {
  String[] formats = { "(shoose format)", "Atom", "RSS 0.92", "RSS 1.0", "RSS 2.0" };
  String[] descriptions = {
    "Atom weblog and syndication format",
    "RSS syndication format 0.92 (Netscape)",
    "RSS/RDF syndications format 1.0 (RSS/RDF)",
    "RSS syndication format 2.0 (Userland)"
  };
  JComboBox formatBox = new JComboBox();
  JLabel descriptionLabel = new JLabel("");

  public FormatChooser() {
    super("Syndication Format");
    setSize(420, 150);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    for (String format : formats) {
      formatBox.addItem(format);
    }
    formatBox.addItemListener(this);
    add(BorderLayout.NORTH, formatBox);
    add(BorderLayout.CENTER, descriptionLabel);
    setVisible(true);
  }

  @Override
  public void itemStateChanged(ItemEvent event) {
    int choice = formatBox.getSelectedIndex();
    if (choice > 0) {
      descriptionLabel.setText(descriptions[choice-1]);
    }
  }

  @Override
  public Insets getInsets() {
    return new Insets(50, 10, 10, 10);
  }

  private static void setLookAndFeel() {
    try {
        UIManager.setLookAndFeel(
            "javax.swing.plaf.nimbus.NimbusLookAndFeel"
        );
    } catch (Exception exc) {
        System.err.println(exc);
    }
  }

  public static void main(String[] args) {
    FormatChooser.setLookAndFeel();
    FormatChooser frame = new FormatChooser();
  }
}