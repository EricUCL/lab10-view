import java.util.Arrays;
import java.util.Objects;
import tictactoe.Player;
import tictactoe.TicTacToe;

/**
 * A mock implementation of the TicTacToe model.
 */
public class MockTicTacToeModelImpl implements TicTacToe {

  public boolean gameOver = false;
  public Player winner = null;
  public boolean throwOnMove = false;
  private final Player[][] board;
  private Player turn;

  /** Default constructor. */
  public MockTicTacToeModelImpl() {
    board = new Player[3][3];
    turn = Player.X;
  }

  @Override
  public void move(int r, int c) {
    if (throwOnMove) {
      throw new IllegalArgumentException("Invalid move");
    }
  }

  @Override
  public Player getTurn() {
    return turn;
  }

  @Override
  public boolean isGameOver() {
    boolean boardFull = true;
    for (Player[] row : board) {
      if (Arrays.stream(row).anyMatch(Objects::isNull)) {
        boardFull = false;
        break;
      }
    }
    return boardFull || getWinner() != null;
  }

  @Override
  public Player getWinner() {
    return null;
  }

  public Player[][] getBoard() {
    Player[][] ret = new Player[3][3];
    return ret;
  }

  @Override
  public Player getMarkAt(int r, int c) {
    validateRowCol(r, c);
    return board[r][c];
  }

  private static void validateRowCol(int r, int c) {
    if (r < 0 || r > 2 || c < 0 || c > 2) {
      throw new IllegalArgumentException("Invalid board position: " + r + "," + c);
    }
  }
}
