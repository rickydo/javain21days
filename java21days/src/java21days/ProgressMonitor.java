package java21days;

import java.awt.*;
import javax.swing.*;

public class ProgressMonitor extends JFrame {
  JProgressBar current;
  JTextArea out;
  JButton find;
  int num = 0;

  public ProgressMonitor() {
    super("Progress Monitor");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(500, 125);
    setLayout(new FlowLayout());
    current = new JProgressBar(0, 2000);
    current.setValue(0);
    current.setStringPainted(true);
    add(current);
  }

  public void iterate() {
    while (num < 2000) {
      current.setValue(num);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {}
      num += 95;
    }
  }

  private static void setLookAndFeel() {
      try {
          UIManager.setLookAndFeel(
              "javax.swing.plaf.nimbus.NimbusLookAndFeel"
          );
      } catch (Exception e) {
          System.err.println(e);
      }
  }

  public static void main(String[] args) {
    ProgressMonitor.setLookAndFeel();
    ProgressMonitor frame = new ProgressMonitor();
    frame.setVisible(true);
    frame.iterate();
  }
}