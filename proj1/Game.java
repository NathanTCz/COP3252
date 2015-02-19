public class Game {
  private Player p1;
  private Player p2;
  private Player turn;
  private int numGames;
  private String[] grid;

  public Game (boolean p1t, String p1s, boolean p2t, String p2s) {
    p1 = new Player(p1t, p1s);
    p2 = new Player(p2t, p2s);
    turn = p1;
  }

  public String takeTurn () {
    String s = turn.getSymbol();

    if (turn == p1) turn = p2;
    else turn = p1;

    return s;
  }
}
