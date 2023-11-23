package tictactoe;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Mouse listener for the game board.
 */
public class BoardMouseListener extends MouseAdapter {
  private final TicTacToeController controller;
  private final Component component;

  /**
   * Constructor.
   *
   * @param controller the controller to use
   * @param component  the component to listen to
   */
  public BoardMouseListener(TicTacToeController controller, Component component) {
    this.controller = controller;
    this.component = component;
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    System.out.println("Mouse clicked at (" + e.getX() + ", " + e.getY() + ")");
    System.out.println("Component size: " + component.getWidth() + "x" + component.getHeight());
    int row = e.getY() / (component.getHeight() / 3);
    int col = e.getX() / (component.getWidth() / 3);
    controller.handleCellClick(row, col);
  }
}
