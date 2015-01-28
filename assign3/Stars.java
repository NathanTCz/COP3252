public class Stars {
  private int rows;
  private int cols;

  public Stars(int row, int col) {
    set_rows(row);
    set_cols(col);
  }

  public void set_rows(int r) {
    rows = r;
  }

  public int get_rows() {
    return rows;
  }

  public void set_cols(int c) {
    cols = c;
  }

  public int get_cols() {
    return cols;
  }

  public String show_stars() {
    boolean row = false;
    String output= "";

    for (int i = 0; i < rows; i++) {
      if (row) output += "  ";
      for (int j = 0; j < cols; j++) {
        output += "*  ";
      }
      output += "\n";
      row = !row;
    }

    return output;
  }
}
