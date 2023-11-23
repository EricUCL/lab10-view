package tictactoe;

import javax.swing.JOptionPane;

/**
 * Implementation of the controller.
 */
public class TicTacToeControllerImpl implements TicTacToeController {
  private final TicTacToeView view;
  private final TicTacToe model;

  /**
   * Constructor.
   *
   * @param view  the view to use
   * @param model the model to use
   */
  public TicTacToeControllerImpl(TicTacToeView view, TicTacToe model) {
    this.view = view;
    this.model = model;
  }

  @Override
  public void playGame(TicTacToe m) {
    view.makeVisible();
  }

  @Override
  public void handleCellClick(int row, int col) {
    try {
      model.move(row, col);
      view.refresh();
      if (model.isGameOver()) {
        String message = (model.getWinner() != null)
            ? "Player " + model.getWinner() + " wins!"
            : "It's a tie!";
        JOptionPane.showMessageDialog(null, message);
      }
    } catch (IllegalArgumentException | IllegalStateException e) {
      JOptionPane.showMessageDialog(null, e.getMessage());
    }
  }
}
