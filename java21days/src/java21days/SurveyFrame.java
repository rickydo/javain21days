package java21days;

import javax.swing.*;

public class SurveyFrame extends JFrame {
  public SurveyFrame() {
    super("Survey");
    setSize(290, 140);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLookAndFeel();
    SurveyWizard wiz = new SurveyWizard();
    add(wiz);
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
    SurveyFrame.setLookAndFeel();
    SurveyFrame surv = new SurveyFrame();
  }
}