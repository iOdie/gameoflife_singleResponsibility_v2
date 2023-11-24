package org.example;

import static org.example.Rules.*;

public class GameOfLifeService {

    private final GameOfLifeBoard gameBoard;

    GameOfLifeService (GameOfLifeBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public GameOfLifeBoard getGameBoard () {
        return this.gameBoard;
    }

    public void doIterations (int count) {
        for(int i = 0; i < count; i++) {
            setNextIteration();
            gameBoard.printBoard();
        }
    }
    private void setNextIteration () {
        int[][] currentIteration = gameBoard.getBoard();
        int[][] nextIterationGameBoard = new int[currentIteration.length][currentIteration[0].length];

        for (int row = 0; row < currentIteration.length; row++) {
            for(int col = 0; col < currentIteration[row].length; col++) {
                if (checkIfCellWillBeAlive(evaluateNeighborCount(row, col), currentIteration[row][col])) {
                    nextIterationGameBoard[row][col] = 1;
                }
            }
            gameBoard.setBoard(nextIterationGameBoard);
        }
    }

    public boolean checkIfCellWillBeAlive (int neighborCount, int cellState) {

        return     checkIfCellIsOverpopulated(neighborCount, cellState)
                && checkIfCellIsReproducing(neighborCount, cellState)
                && checkIfCellIsUnderpopulated(neighborCount, cellState)
                && checkIfCellHasTwoOrThreeNeighbors(neighborCount, cellState);
    }

    private int evaluateNeighborCount (int row, int col) {
        return 0; // TODO define calculation
    }
}
