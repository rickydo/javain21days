package java21days;

import javax.swing.*;
import java.awt.*;

public class TabPanels extends JFrame {
  public TabPanels() {
    super("Tabbed Panes");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLookAndFeel();
    setSize(480, 218);
    JPanel mainSettings = new JPanel();
    JPanel advancedSettings = new JPanel();
    JPanel privacySettings = new JPanel();
    JPanel emailSettings = new JPanel();
    JPanel securitySettings = new JPanel();
    JTabbedPane tabs = new JTabbedPane();
    tabs.addTab("Main", mainSettings);
    tabs.addTab("Advanced", advancedSettings);
    tabs.addTab("Privacy", privacySettings);
    tabs.addTab("Email", emailSettings);
    tabs.addTab("Security", securitySettings);
    add(tabs);
    setVisible(true);
  }

  private void setLookAndFeel() {
    try {
        UIManager.setLookAndFeel(
            "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
        );
        SwingUtilities.updateComponentTreeUI(this);
    } catch (Exception e) {
        System.err.println("Couldn't use the system "
            + "look and feel: " + e);
    }
  }

  public static void main(String[] args) {
    TabPanels frame = new TabPanels();
  }
}