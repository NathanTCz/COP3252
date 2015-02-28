import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TTTButton extends JButton {
  private static final long serialVersionUID = 1239471827;
  public int xCoord;
  public int yCoord;
  public boolean active;

  public TTTButton (int x, int y) {
    xCoord = x;
    yCoord = y;
    active = true;
  }
}
