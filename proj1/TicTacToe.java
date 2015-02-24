import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class TicTacToe {

  public static void main(String[] args) {
    /*Start the Game*/
    Game curGame = new Game(false, "X", true, "O");

    WindowDriver instance = new WindowDriver(curGame);
  }
}
