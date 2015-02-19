public class Player {
  private boolean type;
  private String symbol;
  private int gamesWon;
  private int gamesLost;

  public Player (boolean t, String s) {
    type = t;
    symbol = s;
  }

  public String getSymbol () {
    return symbol;
  }
}
