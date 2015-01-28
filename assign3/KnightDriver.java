/*
Nathan Cazell
COP-3252
Assignment 2
1/14/12
*/

import javax.swing.JOptionPane;

public class KnightDriver {
  // My main method
  public static void main(String[] args) {

    String name =
      JOptionPane.showInputDialog("Enter a name:");

    int health =
      Integer.parseInt(JOptionPane.showInputDialog("Enter health: "));

    int numBat =
      Integer.parseInt(JOptionPane.showInputDialog("Enter number of battles: "));

    int age =
      Integer.parseInt(JOptionPane.showInputDialog("Enter age: "));

    int gold =
      Integer.parseInt(JOptionPane.showInputDialog("Enter gold: "));

    int star_rows =
      Integer.parseInt(JOptionPane.showInputDialog("Enter star rows: "));

    int star_cols =
      Integer.parseInt(JOptionPane.showInputDialog("Enter star columns: "));

    Knight dude = new Knight(name, health, numBat, age, gold);
    Stars stars = new Stars(star_rows, star_cols);

    String output =
      String.format(
        "Knight Name: %s\nKnight Health: %d\nKnight Battles: %d\nKnight Age: %d\nKnight Gold: %d\nKnights Average Income: %d\n\n%s",
        dude.get_name(), dude.get_health(), dude.get_numBat(), dude.get_age(), dude.get_gold(), (gold/numBat), stars.show_stars()
        );

    JOptionPane.showMessageDialog(null, output);


  }
}
