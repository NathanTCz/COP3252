/*
Nathan Cazell
COP-3252
Assignment 2
1/14/12
*/

import java.util.*;

public class KnightDriver {
  private static Random rand = new Random();

  private static Knight k1 = new Knight();
  private static Knight k2 = new Knight();

  private static boolean over = false;

  // My main method
  public static void main(String[] args) {
    while (!over) {
      Scanner in = new Scanner(System.in);

      System.out.printf("Welcome to KnightFight!\n");
      Knight k1 = createKnight();

      System.out.printf("Would you like to auto-generate your opponent? (y|n): ");
      String choice = in.nextLine();

      switch(choice) {
        case "y":
          k2 = new Knight();
          break;
        case "n":
          k2 = createKnight();
          break;
      }

      // Display Knight Stats
      System.out.printf( k1.toString() );
      System.out.printf("\n\n          VS.\n\n");
      System.out.printf( k2.toString() );

      System.out.printf("Start the fight(f) or run away like a coward(r)? (f|r): ");
      choice = in.nextLine();

      switch(choice) {
        case "f":
          Knight winner = knightFight(k1, k2);
          declareWinner(winner);
          break;
        case "r":
          break;
      }

      System.out.printf("Restart game(r) or Quit the game(q)? (r|q): ");
      choice = in.nextLine();
      switch(choice) {
        case "r":
          break;
        case "q":
          over = true;
          break;
      }
    }
  }

  public static void declareWinner (Knight k) {
    System.out.printf("\n\n    THE WINNER IS:\n");
    System.out.printf( k.toString() );
  }

  public static Knight knightFight (Knight kn1, Knight kn2) {
    Knight[] randomChoice = new Knight[2];
    randomChoice[0] = kn1;
    randomChoice[1] = kn2;

    Knight turn = randomChoice[ rand.nextInt(2) ];

    Knight opp;
    if( turn == kn1 )
      opp = kn2;
    else
      opp = kn1;

    Knight winner;

    while(kn1.getHealth() > 0 && kn2.getHealth() > 0) {
      opp.fight(turn);


      if (turn == kn1 && opp == kn2) {
        turn = kn2;
        opp = kn1;
      }
      else if (turn == kn2 && opp == kn1) {
        turn = kn1;
        opp = kn2;
      }
    }

    if ( kn1.getHealth() <= 0 )
      winner = kn2;
    else
      winner = kn1;

    return winner;
  }

  public static Knight createKnight () {
    Scanner in = new Scanner(System.in);

    System.out.printf("Enter the name of your Knight: ");
    String name = in.nextLine();
    System.out.printf("\n\n\n\n");

    System.out.printf("Now select your weapon! (Choose number)\n");
    System.out.printf("1) Long Sword\n");
    System.out.printf("2) Battle Axe\n");
    System.out.printf("3) Spear\n");
    System.out.printf("4) Warhammer\n");
    System.out.printf("Your choice my liege? : ");
    int choice = in.nextInt();

    int weapon;

    switch(choice) {
      case 1:
        weapon = 1;
        break;
      case 2:
        weapon = 2;
        break;
      case 3:
        weapon = 3;
        break;
      case 4:
        weapon = 4;
        break;
      default:
        weapon = 1;
        break;
    }

    System.out.printf("Now select your armor! (Choose number)\n");
    System.out.printf("1) Leather\n");
    System.out.printf("2) Chain Maille\n");
    System.out.printf("Your choice my liege? : ");
    choice = in.nextInt();

    int armor;

    switch(choice) {
      case 1:
        armor = 1;
        break;
      case 2:
        armor = 2;
        break;
      default:
        armor = 1;
        break;
    }

    return new Knight(name, weapon, armor);
  }
}
