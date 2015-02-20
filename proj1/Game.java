public class Game {
  private Player p1;
  private Player p2;
  private Player turn;
  private int numGames;
  private String[][] grid;

  public boolean over;
  public Player winner;

  public Game (boolean p1t, String p1s, boolean p2t, String p2s) {
    p1 = new Player(p1t, p1s);
    p2 = new Player(p2t, p2s);
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

  public void updateGrid (int x, int y, String s) {
    grid[x][y] = s;
    printGrid();
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
    String s = turn.getSymbol();

    updateGrid(x, y, s);
    checkWin(s);

    if (turn == p1) turn = p2;
    else turn = p1;

    return grid[x][y];
  }

  public void checkWin (String sym) {
  }
}
