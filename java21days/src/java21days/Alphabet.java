package java21days;

import java.awt.*;
import javax.swing.*;

public class Alphabet extends JFrame {
  public Alphabet() {
    super("Alphabet");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLookAndFeel();
    setSize(360, 120);
    FlowLayout lm = new FlowLayout(FlowLayout.LEFT);
    setLayout(lm);
    JButton a = new JButton("Alibi");
    JButton b = new JButton("Burglar");
    JButton c = new JButton("Corpse");
    JButton d = new JButton("Deadbeat");
    JButton e = new JButton("Evidence");
    JButton f = new JButton("Fugitive");
    add(a);
    add(b);
    add(c);
    add(d);
    add(e);
    add(f);
    setVisible(true);
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
  public static void main(String[] arguments) {
      Alphabet.setLookAndFeel();
      Alphabet frame = new Alphabet();
  }
}