public class Stars {
  private int rows;
  private int cols;

  public Stars(int row, int col) {
    set_rows(row);
    set_cols(col);
  }

  public void set_rows(r) {
    rows = r;
  }

  public int get_rows() {
    return rows;
  }

  public void set_cols(c) {
    cols = c;
  }

  public int get_cols() {
    return cols;
  }
}
