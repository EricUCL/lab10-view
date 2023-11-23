import tictactoe.TicTacToeController;
import tictactoe.TicTacToeView;

/**
 * A mock view for TicTacToe: display the game board and provide visual interface for users.
 */
public class MockTicTacToeViewImpl implements TicTacToeView {
  public int refreshCount = 0;
  @Override
  public void addClickListener(TicTacToeController listener) {

  }

  @Override
  public void refresh() {
    refreshCount++;
  }

  @Override
  public void makeVisible() {

  }
}
