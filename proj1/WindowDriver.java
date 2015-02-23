import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WindowDriver implements ActionListener {
  public int YES_OPTION = 0;
  public int NO_OPTION = 1;

  private JFrame window = new JFrame("FSU");
  private JButton b1 = new JButton();
  private JButton b2 = new JButton();
  private JButton b3 = new JButton();
  private JButton b4 = new JButton();
  private JButton b5 = new JButton();
  private JButton b6 = new JButton();
  private JButton b7 = new JButton();
  private JButton b8 = new JButton();
  private JButton b9 = new JButton();

  private Game curGame;

  public WindowDriver (Game g) {
    /*Create Window*/
    window.setSize(300,300);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setLayout(new GridLayout(3,3));


    /*Add Buttons To The Window*/
    window.add(b1);
    window.add(b2);
    window.add(b3);
    window.add(b4);
    window.add(b5);
    window.add(b6);
    window.add(b7);
    window.add(b8);
    window.add(b9);

    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    b4.addActionListener(this);
    b5.addActionListener(this);
    b6.addActionListener(this);
    b7.addActionListener(this);
    b8.addActionListener(this);
    b9.addActionListener(this);

    /*Make The Window Visible*/
    window.setVisible(true);

    curGame = g;
    initGrid();
  }

  public void initGrid () {
    b1.setText("");
    b2.setText("");
    b3.setText("");
    b4.setText("");
    b5.setText("");
    b6.setText("");
    b7.setText("");
    b8.setText("");
    b9.setText("");
  }

  public void actionPerformed (ActionEvent a) {
    if (a.getSource() instanceof JButton) markButton(a);
  }

  public void markButton (ActionEvent a) {
    if (a.getSource() == b1) b1.setText( curGame.takeTurn(0, 0) );
    if (a.getSource() == b2) b2.setText( curGame.takeTurn(0, 1) );
    if (a.getSource() == b3) b3.setText( curGame.takeTurn(0, 2) );
    if (a.getSource() == b4) b4.setText( curGame.takeTurn(1, 0) );
    if (a.getSource() == b5) b5.setText( curGame.takeTurn(1, 1) );
    if (a.getSource() == b6) b6.setText( curGame.takeTurn(1, 2) );
    if (a.getSource() == b7) b7.setText( curGame.takeTurn(2, 0) );
    if (a.getSource() == b8) b8.setText( curGame.takeTurn(2, 1) );
    if (a.getSource() == b9) b9.setText( curGame.takeTurn(2, 2) );

    checkOver(curGame);
  }

  public void checkOver(Game g) {
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
        curGame = new Game(false, "X", false, "O");
        initGrid();
      }
      else if (opt == NO_OPTION)
       window.dispose();
    }
  }
}
