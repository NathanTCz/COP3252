import java.util.*;

public class Player {
  private boolean ai;
  private String symbol;
  private int gamesWon;
  private int gamesLost;
  private Random rand = new Random();
  private int X = 2;
  private int O = 3;
  public ArrayList<Choice> choices;

  private int sum (int[] a) {
    int sum = 0;

    for (int i = 0; i < a.length; i++) {
      sum += a[i];
    }

    return sum;
  }

  private int findEmpty (int[] row) {
    for (int i = 0; i < 3; i++) {
      if ( row[i] == 0 )
        return i;
    }
    return 0;
  }

  private Coordinate findEmptyInDiag2 (int[] row) {
    int empty = 9999;
    for (int i = 0; i < 3; i++) {
      if ( row[i] == 0 )
        empty = i;
    }

    if (empty == 0)
      return new Coordinate(0,2);
    if (empty == 1)
      return new Coordinate(1,1);
    else
      return new Coordinate(2,0);
  }

  private void sortChoices () {
    Collections.sort(choices, new ChoiceComparator());
  }

  public String getSymbol () {
    return symbol;
  }

  public String getOppSym () {
    if (symbol == "X")
      return "O";
    else
      return "X";
  }

  public void setSymbol (String s) {
    symbol = s;
  }

  public boolean isAi () {
    return ai;
  }

  public void setAi (boolean t) {
    ai = t;
  }

  public Coordinate findRandAIMove (String[][] grid) {
    int x = 0;
    int y = 0;

    do {
      x = rand.nextInt(3);
      y = rand.nextInt(3);
    }
    while ( grid[x][y] != "-" );

    return new Coordinate(x,y);
  }

  public Coordinate findSmartAIMove (String[][] grid) {
    choices = new ArrayList<Choice>();

    checkRowsForTwo(grid);
    checkColsForTwo(grid);
    checkDiag1ForTwo(grid);
    checkDiag2ForTwo(grid);
    sortChoices();

    // System.out.println("AI move: " + choices.get(0).coord.x + ", " + choices.get(0).coord.y);

    return choices.get(0).coord;
  }

  public void checkRowsForTwo (String[][] grid) {
    for (int i = 0; i < 3; i++) {
      int[] row = {0, 0, 0};
      for (int j = 0; j < 3; j++) {
        if ( grid[i][j] == "X" )
          row[j] = X;
        if ( grid[i][j] == "O" )
          row[j] = O;
      }
      for (int k = 0; k < 3; k++)
        // System.out.print(row[k]);
      // System.out.print("\n");
      // System.out.println("row" + i + "sum = " + sum(row));

      if ( sum(row) > 3 && sum(row) <= 6 ) {
        // X - X or any two X's
        if ( sum(row) % 4 == 0 && symbol == "X" ) {
          // winning move
          // System.out.println("winning move");
          Choice c = new Choice( new Coordinate(i, findEmpty(row)), 3 );
          choices.add(c);
        }
        // X - X or any two X's
        else if ( sum(row) % 4 == 0 && getOppSym() == "X" ) {
          // blocking move
          // System.out.println("blocking move");
          Choice c = new Choice( new Coordinate(i, findEmpty(row)), 2 );
          choices.add(c);
        }
        // O - O or any two O's
        else if ( sum(row) % 4 == 2 && symbol == "O" ) {
          // winning move
          // System.out.println("winning move");
          Choice c = new Choice( new Coordinate(i, findEmpty(row)), 3 );
          choices.add(c);
        }
        // O - O or any two O's
        else if ( sum(row) % 4 == 2 && getOppSym() == "O" ) {
          // blocking move
          // System.out.println("blocking move");
          Choice c = new Choice( new Coordinate(i, findEmpty(row)), 2 );
          choices.add(c);
        }
        else {
          Choice c = new Choice( findRandAIMove(grid), 1 );
          choices.add(c);
        }
      }
      else {
        Choice c = new Choice( findRandAIMove(grid), 1 );
        choices.add(c);
      }
    }
  }

  public void checkColsForTwo (String[][] grid) {
    for (int i = 0; i < 3; i++) {
      int[] col = {0, 0, 0};
      for (int j = 0; j < 3; j++) {
        if ( grid[j][i] == "X" )
          col[j] = X;
        if ( grid[j][i] == "O" )
          col[j] = O;
      }
      for (int k = 0; k < 3; k++)
        // System.out.println(col[k]);
      // System.out.println("col" + i + "sum = " + sum(col));

      if ( sum(col) > 3 && sum(col) <= 6 ) {
        // X - X or any two X's
        if ( sum(col) % 4 == 0 && symbol == "X" ) {
          // winning move
          // System.out.println("winning move");
          Choice c = new Choice( new Coordinate(findEmpty(col), i), 3 );
          choices.add(c);
        }
        // X - X or any two X's
        else if ( sum(col) % 4 == 0 && getOppSym() == "X" ) {
          // blocking move
          // System.out.println("blocking move");
          Choice c = new Choice( new Coordinate(findEmpty(col), i), 2 );
          choices.add(c);
        }
        // O - O or any two O's
        else if ( sum(col) % 4 == 2 && symbol == "O" ) {
          // winning move
          // System.out.println("winning move");
          Choice c = new Choice( new Coordinate(findEmpty(col), i), 3 );
          choices.add(c);
        }
        // O - O or any two O's
        else if ( sum(col) % 4 == 2 && getOppSym() == "O" ) {
          // blocking move
          // System.out.println("blocking move");
          Choice c = new Choice( new Coordinate(findEmpty(col), i), 2 );
          choices.add(c);
        }
        else {
          Choice c = new Choice( findRandAIMove(grid), 1 );
          choices.add(c);
        }
      }
      else {
        Choice c = new Choice( findRandAIMove(grid), 1 );
        choices.add(c);
      }
    }
  }

  public void checkDiag1ForTwo (String[][] grid) {
    int[] col = {0, 0, 0};

    for (int i = 0; i < 3; i++) {
      if ( grid[i][i] == "X" )
        col[i] = X;
      if ( grid[i][i] == "O" )
        col[i] = O;
    }

    for (int k = 0; k < 3; k++)
      // System.out.println(col[k]);
    // System.out.println("diag1 sum = " + sum(col));

    if ( sum(col) > 3 && sum(col) <= 6 ) {
      // X - X or any two X's
      if ( sum(col) % 4 == 0 && symbol == "X" ) {
        // winning move
        // System.out.println("winning move");
        Choice c = new Choice( new Coordinate(findEmpty(col), findEmpty(col)), 3 );
        choices.add(c);
      }
      // X - X or any two X's
      else if ( sum(col) % 4 == 0 && getOppSym() == "X" ) {
        // blocking move
        // System.out.println("blocking move");
        Choice c = new Choice( new Coordinate(findEmpty(col), findEmpty(col)), 2 );
        choices.add(c);
      }
      // O - O or any two O's
      else if ( sum(col) % 4 == 2 && symbol == "O" ) {
        // winning move
        // System.out.println("winning move");
        Choice c = new Choice( new Coordinate(findEmpty(col), findEmpty(col)), 3 );
        choices.add(c);
      }
      // O - O or any two O's
      else if ( sum(col) % 4 == 2 && getOppSym() == "O" ) {
        // blocking move
        // System.out.println("blocking move");
        Choice c = new Choice( new Coordinate(findEmpty(col), findEmpty(col)), 2 );
        choices.add(c);
      }
      else {
        Choice c = new Choice( findRandAIMove(grid), 1 );
        choices.add(c);
      }
    }
    else {
      Choice c = new Choice( findRandAIMove(grid), 1 );
      choices.add(c);
    }
  }

  public void checkDiag2ForTwo (String[][] grid) {
    int[] diag = {0, 0, 0};

    if ( grid[0][2] == "X" )
      diag[0] = X;
    if ( grid[0][2] == "O" )
      diag[0] = O;
    if ( grid[1][1] == "X" )
      diag[1] = X;
    if ( grid[1][1] == "O" )
      diag[1] = O;
    if ( grid[2][0] == "X" )
      diag[2] = X;
    if ( grid[2][0] == "O" )
      diag[2] = O;



    for (int k = 0; k < 3; k++)
      // System.out.println(diag[k]);
    // System.out.println("diag2 sum = " + sum(diag));

    if ( sum(diag) > 3 && sum(diag) <= 6 ) {
      // X - X or any two X's
      if ( sum(diag) % 4 == 0 && symbol == "X" ) {
        // winning move
        // System.out.println("winning move");
        Choice c = new Choice( findEmptyInDiag2(diag), 3 );
        choices.add(c);
      }
      // X - X or any two X's
      else if ( sum(diag) % 4 == 0 && getOppSym() == "X" ) {
        // blocking move
        // System.out.println("blocking move");
        Choice c = new Choice( findEmptyInDiag2(diag), 2 );
        choices.add(c);
      }
      // O - O or any two O's
      else if ( sum(diag) % 4 == 2 && symbol == "O" ) {
        // winning move
        // System.out.println("winning move");
        Choice c = new Choice( findEmptyInDiag2(diag), 3 );
        choices.add(c);
      }
      // O - O or any two O's
      else if ( sum(diag) % 4 == 2 && getOppSym() == "O" ) {
        // blocking move
        // System.out.println("blocking move");
        Choice c = new Choice( findEmptyInDiag2(diag), 2 );
        choices.add(c);
      }
      else {
        Choice c = new Choice( findRandAIMove(grid), 1 );
        choices.add(c);
      }
    }
    else {
      Choice c = new Choice( findRandAIMove(grid), 1 );
      choices.add(c);
    }
  }

}
