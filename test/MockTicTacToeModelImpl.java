import tictactoe.Player;
import tictactoe.TicTacToe;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

/*
 * A mock implementation of the TicTacToe model.
 */
public class MockTicTacToeModelImpl implements TicTacToe {
  private final Player[][] board;
  private Player turn;

  public boolean gameOver = false;
  public Player winner = null;
  public boolean throwOnMove = false;

  /** Default constructor. */
  public MockTicTacToeModelImpl() {
    board = new Player[3][3];
    turn = Player.X;
  }

  public void move(int r, int c) {
    if (throwOnMove) {
      throw new IllegalArgumentException("Invalid move");
    }
  }

  public Player getTurn() {
    return turn;
  }

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

  public Player getWinner() {
    return null;
  }

  public Player[][] getBoard() {
    Player[][] ret = new Player[3][3];
    return ret;
  }

  public Player getMarkAt(int r, int c) {
    validateRowCol(r, c);
    return board[r][c];
  }

  private static void validateRowCol(int r, int c) {
    if (r < 0 || r > 2 || c < 0 || c > 2) {
      throw new IllegalArgumentException("Invalid board position: " + r + "," + c);
    }
  }

  public String toString() {
    // Using Java stream API to save code:
    return Arrays.stream(getBoard()).map(
        row -> " " + Arrays.stream(row).map(p -> p == null ? " " : p.toString())
            .collect(Collectors.joining(" | "))).collect(Collectors.joining("\n-----------\n"));
    // This is the equivalent code as above, but using iteration, and still using the helpful
    // built-in String.join method.
    // List<String> rows = new ArrayList<>();
    // for(Player[] row : getBoard()) {
    //   List<String> rowStrings = new ArrayList<>();
    //   for(Player p : row) {
    //     if(p == null) {
    //       rowStrings.add(" ");
    //     } else {
    //       rowStrings.add(p.toString());
    //     }
    //   }
    //   rows.add(" " + String.join(" | ", rowStrings));
    // }
    // return String.join("\n-----------\n", rows);
  }
}
