package java21days;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyChecker extends JFrame {
  JLabel keyLabel = new JLabel("Hit any key");

  public KeyChecker() {
    super("Hit a Key");
    setSize(300, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new FlowLayout(FlowLayout.CENTER));
    KeyMonitor monitor = new KeyMonitor(this);
    setFocusable(true);
    addKeyListener(monitor);
    add(keyLabel);
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
    KeyChecker.setLookAndFeel();
    new KeyChecker();
  }
}

class KeyMonitor extends KeyAdapter {
  KeyChecker display;

  KeyMonitor(KeyChecker display) {
    this.display = display;
  }

  @Override
  public void keyTyped(KeyEvent event) {
    display.keyLabel.setText("" + event.getKeyChar());
    display.repaint();
  }
}