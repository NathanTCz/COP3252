public class Game {
  private Player p1 = new Player();
  private Player p2 = new Player();
  private int numGames;
  private String winningSym;

  public boolean over;
  public Player winner;
  public Player prevWinner;
  public Player turn;
  public String[][] grid;

  public Game (boolean p1t, String p1s, boolean p2t, String p2s) {
    p1.setAi(p1t);
    p1.setSymbol(p1s);
    p2.setAi(p2t);
    p2.setSymbol(p2s);
    turn = p1;

    over = false;

    createGrid();
  }

  public void createGrid () {
    grid = new String[3][3];

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        grid[i][j] = "-";
      }
    }
  }

  public void restartGame () {
    over = false;
    createGrid();

    if (winner == null)
      if (prevWinner != null)
        turn = prevWinner;
      else
        turn = p1;
    else
      turn = winner;
      prevWinner = winner;
      winner = null;
  }

  public void updateGrid (int x, int y, String s) {
    grid[x][y] = s;
    //printGrid();
  }

  public void printGrid () {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        System.out.print(grid[i][j]);
      }
      System.out.print("\n");
    }
  }

  public String takeTurn (int x, int y) {
    if (!over) {
      String s = turn.getSymbol();

      updateGrid(x, y, s);
      checkWin();
      //printGrid();

      if (turn == p1) turn = p2;
      else turn = p1;
    }

    return grid[x][y];
  }

  public void checkWin () {
    if (checkRow() || checkCol() || checkDiag1() || checkDiag2()) {
      over = true;

      if ( winningSym == p1.getSymbol() )
        winner = p1;
      else
        winner = p2;
    }
    else if (checkCat()) {
      over = true;
    }
  }

  public boolean checkRow () {
    for (int i = 0; i < 3; i++) {
      String sym = grid[i][0];
      if (sym == "-") continue;

      if ( grid[i][1] == sym && grid[i][2] == sym ) {
        System.out.println("row" + i);
        winningSym = sym;
        return true;
      }
    }
    return false;
  }

  public boolean checkCol () {
    for (int i = 0; i < 3; i++) {
      String sym = grid[0][i];
      if (sym == "-") continue;

      if ( grid[1][i] == sym && grid[2][i] == sym ) {
        System.out.println("col" + i);
        winningSym = sym;
        return true;
      }
    }
    return false;
  }

  public boolean checkDiag1 () {
    String sym = grid[0][0];
    if (sym == "-")
      return false;
    if ( grid[1][1] == sym && grid[2][2] == sym ) {
      System.out.println("diag1");
      winningSym = sym;
      return true;
    }

    return false;
  }
  public boolean checkDiag2 () {
    String sym = grid[0][2];
    if (sym == "-")
      return false;
    if ( grid[1][1] == sym && grid[2][0] == sym ) {
      System.out.println("diag2");
      winningSym = sym;
      return true;
    }

    return false;
  }

  public boolean checkCat() {
    boolean cat = true;

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (grid[i][j] == "-")
          cat = false;
      }
    }

    return cat;
  }

}
