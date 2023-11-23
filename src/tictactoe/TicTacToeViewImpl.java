package tictactoe;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Implementation of the view.
 */
public class TicTacToeViewImpl extends JFrame implements TicTacToeView {

  private final ReadonlyTttModel model;
  private final GameBoardPanel boardPanel;
  private final JLabel turnLabel;

  /**
   * Constructor.
   *
   * @param model the model to use
   */
  public TicTacToeViewImpl(ReadonlyTttModel model) {
    this.model = model;
    setTitle("Tic Tac Toe");
    setSize(600, 620);
    setLocation(200, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    turnLabel = new JLabel("Current turn: Player X", SwingConstants.CENTER);
    add(turnLabel, BorderLayout.NORTH);
    boardPanel = new GameBoardPanel(model);
    add(boardPanel, BorderLayout.CENTER);
  }

  @Override
  public void addClickListener(TicTacToeController listener) {
    boardPanel.addMouseListener(new BoardMouseListener(listener, boardPanel));
  }

  @Override
  public void refresh() {
    boardPanel.repaint();
    if (model.isGameOver()) {
      turnLabel.setText("Game over!");
    } else {
      turnLabel.setText("Current turn: Player " + model.getTurn());
    }
  }

  @Override
  public void makeVisible() {
    setVisible(true);
  }
}
