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

    System.out.printf("Enter age: ");
    int age = jin.nextInt();

    Knight dude = new Knight(name, 100, 0, age, 0);
    dude.printDetails();
  }
}
