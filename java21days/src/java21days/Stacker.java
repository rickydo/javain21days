package java21days;

import java.awt.*;
import javax.swing.*;

public class Stacker extends JFrame {
  public Stacker() {
    super("Stacker");
    setSize(430, 150);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLookAndFeel();
    // create top panel
    JPanel commandPane = new JPanel();
    BoxLayout horizontal = new BoxLayout(commandPane, BoxLayout.X_AXIS);
    commandPane.setLayout(horizontal);
    JButton subscribe = new JButton("Subscribe");
    JButton unsubscribe = new JButton("Unsubscribe");
    JButton refresh = new JButton("Refresh");
    JButton save = new JButton("Save");
    commandPane.add(subscribe);
    commandPane.add(unsubscribe);
    commandPane.add(refresh);
    commandPane.add(save);
    // create bottom panel
    JPanel textPane = new JPanel();
    JTextArea text = new JTextArea(4, 70);
    JScrollPane scrollPane = new JScrollPane(text);
    // put them together
    FlowLayout flow = new FlowLayout();
    setLayout(flow);
    add(commandPane);
    add(scrollPane);
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

  public static void main(String[] args) {
    Stacker.setLookAndFeel();
    Stacker st = new Stacker();
  }
}