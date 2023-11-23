package tictactoe;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * Panel that displays the game board.
 */
public class GameBoardPanel extends JPanel {
  private final ReadonlyTttModel model;

  /**
   * Constructor.
   *
   * @param model the model to use
   */
  public GameBoardPanel(ReadonlyTttModel model) {
    this.model = model;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    drawBoard(g);
    drawMarks(g);
  }

  private void drawBoard(Graphics g) {
    int cellWidth = getWidth() / 3;
    int cellHeight = getHeight() / 3;

    for (int i = 1; i < 3; i++) {
      g.drawLine(0, i * cellHeight, getWidth(), i * cellHeight);
      g.drawLine(i * cellWidth, 0, i * cellWidth, getHeight());
    }
  }

  private void drawMarks(Graphics g) {
    int cellWidth = getWidth() / 3;
    int cellHeight = getHeight() / 3;

    for (int r = 0; r < 3; r++) {
      for (int c = 0; c < 3; c++) {
        Player player = model.getMarkAt(r, c);
        if (player != null) {
          if (player == Player.X) {
            drawX(g, r, c, cellWidth, cellHeight);
          } else {
            drawO(g, r, c, cellWidth, cellHeight);
          }
        }
      }
    }
  }

  private void drawX(Graphics g, int row, int col, int cellWidth, int cellHeight) {
    int x1 = col * cellWidth;
    int y1 = row * cellHeight;
    g.drawLine(x1, y1, x1 + cellWidth, y1 + cellHeight);
    g.drawLine(x1, y1 + cellHeight, x1 + cellWidth, y1);
  }

  private void drawO(Graphics g, int row, int col, int cellWidth, int cellHeight) {
    int x1 = col * cellWidth;
    int y1 = row * cellHeight;
    g.drawOval(x1, y1, cellWidth, cellHeight);
  }
}
