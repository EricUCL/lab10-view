package tictactoe;

/**
 * Run a TicTacToe game interactively.
 */
public class Main {
  /**
   * Run a TicTacToe game interactively.
   */
  public static void main(String[] args) {
    // Old News: console-based game:
    //new TicTacToeConsoleController(new InputStreamReader(System.in),
    //    System.out).playGame(new TicTacToeModel());

    // New Hotness: Graphical User Interface:
    // 1. Create an instance of the model.
    // 2. Create an instance of the view.
    // 3. Create an instance of the controller.
    // 4. Call playGame() on the controller.
    TicTacToeModel model = new TicTacToeModel();
    TicTacToeView view = new TicTacToeViewImpl(model);
    TicTacToeController controller = new TicTacToeControllerImpl(view, model);

    view.addClickListener(controller);
    controller.playGame(model);
  }
}
