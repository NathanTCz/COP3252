import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class WindowDriver implements ActionListener {
  public int YES_OPTION = 0;
  public int NO_OPTION = 1;

  /* This code taken from Orace GridBagLayout Example
   * http://docs.oracle.com/javase/tutorial/uiswing/examples/layout/GridBagLayoutDemoProject/src/layout/GridBagLayoutDemo.java
   */
  final static boolean shouldFill = true;
  /* END CITATION */

  private JFrame window = new JFrame("FSU");
  private JMenuBar menuBar = new JMenuBar();
  private JMenu menu;
  private JMenuItem menuItem;
  private JRadioButtonMenuItem radioMenuItem;
  private GridBagConstraints c = new GridBagConstraints();

  private ArrayList<TTTButton> buttons = new ArrayList<TTTButton>();
  private JLabel status;
  private JLabel footer;
  private Game curGame;
  private Random rand = new Random();

  public WindowDriver (Game g) {
    /*Create Window*/
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setLocationRelativeTo(null);

    JMenu menu = new JMenu("Game Options");

    /*Controls for playing 1 or 2 player*/
    ButtonGroup group = new ButtonGroup();
    radioMenuItem = new JRadioButtonMenuItem("1 Player");
    radioMenuItem.setActionCommand("oneplayer");
    radioMenuItem.addActionListener(this);
    group.add(radioMenuItem);
    menu.add(radioMenuItem);

    radioMenuItem = new JRadioButtonMenuItem("2 Player");
    radioMenuItem.setSelected(true);
    radioMenuItem.setActionCommand("twoplayer");
    radioMenuItem.addActionListener(this);
    group.add(radioMenuItem);
    menu.add(radioMenuItem);

    menu.addSeparator();
    menuItem = new JMenuItem("Quit");
    menuItem.setActionCommand("quit");
    menuItem.addActionListener(this);
    menuItem.setAccelerator(KeyStroke.getKeyStroke(
        KeyEvent.VK_Q, ActionEvent.ALT_MASK));
    menu.add(menuItem);

    menuBar.add(menu);
    window.setJMenuBar(menuBar);

    if (shouldFill) {
      //natural height, maximum width
      c.fill = GridBagConstraints.HORIZONTAL;
    }

    initGrid( window.getContentPane() );

    /*Make The Window Visible*/
    window.pack();
    window.setVisible(true);

    curGame = g;
    String status = g.turn.getSymbol() + "'s turn";
    changeStatus(status);
  }

  public void initGrid (Container pane) {
    pane.setLayout( new GridBagLayout() );

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        TTTButton b = new TTTButton(i, j);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.ipadx = 20;
        c.ipady = 50;
        c.gridx = b.xCoord;
        c.gridy = b.yCoord;
        pane.add(b, c);
        b.addActionListener(this);
        b.setText("");
        buttons.add(b);
      }
    }

    status = new JLabel("",
                        SwingConstants.CENTER);
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0.5;
    c.gridwidth = 3;
    c.ipady = 30;
    c.gridx = 0;
    c.gridy = 3;
    pane.add(status, c);

    /*Name Footer*/
    footer = new JLabel("by: Nathan Cazell",
                        SwingConstants.CENTER);
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0.5;
    c.gridwidth = 3;
    c.ipady = 30;
    c.gridx = 0;
    c.gridy = 4;
    pane.add(footer, c);
  }

  public void changeStatus(String s) {
    status.setText(s);
  }

  public void clearGrid () {
    for (int i = 0; i < buttons.size(); i++) {
      buttons.get(i).setText("");
      buttons.get(i).active = true;
    }
  }

  public void actionPerformed (ActionEvent a) {
    if (a.getSource() instanceof TTTButton)
      markButton( (TTTButton)a.getSource() );
    else {
      handleMenuAction( (JMenuItem)a.getSource() );
    }
  }

  public void handleMenuAction (JMenuItem i) {
    String choice = i.getActionCommand();
    System.out.printf(choice);

    switch(choice) {
      case "quit":
        window.dispose();
        break;
      case "oneplayer":
        curGame = new Game(false, "X", true, "O");
        clearGrid();
        break;
      case "twoplayer":
        curGame = new Game(false, "X", false, "O");
        clearGrid();
        break;
    }
  }

  public void markButton (TTTButton b) {
    if (b.active) {
      b.setText( curGame.takeTurn( b.xCoord, b.yCoord ) );
      b.active = false;

      String status = curGame.turn.getSymbol() + "'s turn";
      changeStatus(status);
      checkOver(curGame);
    }
  }

  public void checkOver (Game g) {
    if (g.over) {
      System.out.println("game over");

      String output;
      if (g.winner == null) {
        String status = "Cat Game";
        changeStatus(status);
        output = "Cat Game";
      }
      else {
        String status = g.winner.getSymbol() + " WINS!";
        changeStatus(status);
        output = g.winner.getSymbol() + " wins!";
      }

      int opt = JOptionPane.showConfirmDialog(null,
                                    "Play Again?",
                                    output,
                                    JOptionPane.YES_NO_OPTION
                                   );
      if (opt == YES_OPTION) {
        curGame.restartGame();
        clearGrid();
        checkAITurn();
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
