import static org.junit.Assert.assertEquals;

import tictactoe.TicTacToeControllerImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for {@link TicTacToeControllerImpl}.
 */
public class TicTacToeControllerImplTest {
  private TicTacToeControllerImpl controller;
  private MockTicTacToeViewImpl mockTicTacToeView;
  private MockTicTacToeModelImpl mockTicTacToeModel;

  @Before
  public void setUp() {
    mockTicTacToeModel = new MockTicTacToeModelImpl();
    mockTicTacToeView = new MockTicTacToeViewImpl();
    controller = new TicTacToeControllerImpl(mockTicTacToeView, mockTicTacToeModel);
  }

  @Test
  public void testHandleCellClick() {
    controller.handleCellClick(0, 0);
    assertEquals("Expected one refresh call", 1, mockTicTacToeView.refreshCount);
  }

  @Test
  public void testHandleCellClickInvalidMove() {
    mockTicTacToeModel.throwOnMove = true;
    controller.handleCellClick(0, 0);
    assertEquals("The view should not be refreshed on invalid move", 0,
        mockTicTacToeView.refreshCount);
  }

}

