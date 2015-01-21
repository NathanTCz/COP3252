/*
Nathan Cazell
COP-3252
Assignment 2
1/14/12
*/

import java.util.Scanner;

public class Assignment2 {
  // My main method
  public static void main(String[] args) {
    Scanner jin = new Scanner(System.in);

    System.out.printf("Create a new Character\n");
    System.out.printf("Enter a name: ");
    String name = jin.nextLine();

    System.out.printf("Enter health: ");
    int health = jin.nextInt();

    System.out.printf("Enter number of battles: ");
    int numBat = jin.nextInt();

    System.out.printf("Enter age: ");
    int age = jin.nextInt();

    System.out.printf("Enter gold: ");
    int gold = jin.nextInt();

    Knight dude = new Knight(name, health, numBat, age, gold);
    dude.printDetails();
  }
}
