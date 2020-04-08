package java21days;

import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import javax.swing.*;

public class DiceRoller extends JFrame implements ActionListener, PropertyChangeListener {

  // table for dice-roll results
  JTextField[] total = new JTextField[16];
  // the "Roll" button
  JButton roll;
  // the number of times to roll
  JTextField quantity;
  // the Swing worker
  DiceWorker worker;

  public DiceRoller() {
    super("Dice Roller");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(850, 145);

    // set up top row
    JPanel topPane = new JPanel();
    GridLayout paneGrid = new GridLayout(1, 16);
    topPane.setLayout(paneGrid);
    for (int i = 0; i < 16; i++) {
      // create a textfield and label
      total[i] = new JTextField("0", 4);
      JLabel label = new JLabel((i + 3) + ": ");
      // create this cell in the grid
      JPanel cell = new JPanel();
      cell.add(label);
      cell.add(total[i]);
      // add the cell to the top row
      topPane.add(cell);
    }

    // setup bottom row
    JPanel bottomPane = new JPanel();
    JLabel quantityLabel = new JLabel("Times to roll: ");
    quantity = new JTextField("0", 5);
    roll = new JButton("Roll");
    roll.addActionListener(this);
    bottomPane.add(quantityLabel);
    bottomPane.add(quantity);
    bottomPane.add(roll);

    // setup frame
    GridLayout frameGrid = new GridLayout(2,1);
    setLayout(frameGrid);
    add(topPane);
    add(bottomPane);
    setVisible(true);
  }

  // respond when the "Roll" button is clicked
  @Override
  public void actionPerformed(ActionEvent event) {
    int timesToRoll;
    try {
      // turn off the button
      timesToRoll = Integer.parseInt(quantity.getText());
      roll.setEnabled(false);
      // setup the worker that will roll the dice
      worker = new DiceWorker(timesToRoll);
      // add a listener that monitors the worker
      worker.addPropertyChangeListener(this);
      // start the worker
      worker.execute();
    } catch (NumberFormatException exc) {
      System.out.println(exc.getMessage());
    }
  }

  // respond when the worker's task is complete
  @Override 
  public void propertyChange(PropertyChangeEvent event) {
    try {
      // get the worker's dice-roll results
      int[] result = (int[]) worker.get();
      // store the results in text fields
      for (int i = 0; i < result.length; i++) {
        total[i].setText("" + result[i]);
      }
    } catch(Exception exc) {
      System.out.println(exc.getMessage());
    }
  }

  private static void setLookAndFeel() {
    try {
      UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
    } catch (Exception exc) {
      // ignore error
    }
  }

  public static void main(String[] args) {
    DiceRoller.setLookAndFeel();
    DiceRoller app = new DiceRoller();
  }
}