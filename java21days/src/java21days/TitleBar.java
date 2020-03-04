package java21days;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class TitleBar extends JFrame implements ActionListener {
  JButton b1;
  JButton b2;

  public TitleBar() {
    super("Title Bar");
    setSize(330, 80);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    b1 = new JButton("Rosencrantz");
    b2 = new JButton("Guildenstern");
    b1.addActionListener(this);
    b2.addActionListener(this);
    FlowLayout flow = new FlowLayout();
    setLayout(flow);
    add(b1);
    add(b2);
    setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent event) {
    Object source = event.getSource();
    if (source == b1) {
      setTitle("Rosencrantz");
    } else if (source == b2) {
      setTitle("Guildenstern");
    }
    repaint();
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
    TitleBar.setLookAndFeel();
    TitleBar frame = new TitleBar();
  }
}