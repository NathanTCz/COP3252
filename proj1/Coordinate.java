public class Coordinate {
  public int x;
  public int y;
  private int NULL = 99999;

  public Coordinate () {
    x = NULL;
    y = NULL;
  }

  public Coordinate (int xc, int yc) {
    x = xc;
    y = yc;
  }

  public boolean isNull () {
    if (x == NULL && y == NULL)
      return true;
    else
      return false;
  }
}
