import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class WindowDriver implements ActionListener {
  public int YES_OPTION = 0;
  public int NO_OPTION = 1;

  private JFrame window = new JFrame("FSU");
  private ArrayList<TTTButton> buttons = new ArrayList<TTTButton>();
  private Game curGame;
  private Random rand = new Random();

  public WindowDriver (Game g) {
    /*Create Window*/
    window.setSize(300,300);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setLayout(new GridLayout(3,3));

    /*Make The Window Visible*/
    window.setVisible(true);

    curGame = g;
    initGrid();
  }

  public void initGrid () {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        TTTButton b = new TTTButton(i, j);
        window.add(b);
        b.addActionListener(this);
        b.setText("");
        buttons.add(b);
      }
    }
  }

  public void clearGrid () {
    for (int i = 0; i < buttons.size(); i++) {
      buttons.get(i).setText("");
    }
  }

  public void actionPerformed (ActionEvent a) {
    if (a.getSource() instanceof TTTButton)
      markButton( (TTTButton)a.getSource() );
  }

  public void markButton (TTTButton b) {
    b.setText( curGame.takeTurn( b.xCoord, b.yCoord ) );

    checkOver(curGame);
  }

  public void checkOver (Game g) {
    if (g.over) {
      System.out.println("game over");

      String output;
      if (g.checkCat())
        output = "Cat Game";
      else
        output = g.winner.getSymbol() + " wins!";

      int opt = JOptionPane.showConfirmDialog(null,
                                    "Play Again?",
                                    output,
                                    JOptionPane.YES_NO_OPTION
                                   );
      if (opt == YES_OPTION) {
        curGame.restartGame();
        clearGrid();
      }
      else if (opt == NO_OPTION)
       window.dispose();
    }
    else
      checkAITurn();
  }

  public void checkAITurn () {
    if ( curGame.turn.isAi() ) {
      Coordinate c = curGame.turn.findSmartAIMove(curGame.grid);

      for (int i = 0; i < buttons.size(); i++) {
        TTTButton b = buttons.get(i);
        if (b.xCoord == c.x && b.yCoord == c.y)
          b.doClick();
      }
    }
  }

}
