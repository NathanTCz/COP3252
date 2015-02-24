public class Choice {
  public Coordinate coord;

  /* Weight Scale
   * 3 (highest) - winning move
   * 2 - blocking move
   * 1 - random move
   */
  public int weight;

  public Choice (Coordinate c, int w) {
    coord = c;
    weight = w;
  }
}
