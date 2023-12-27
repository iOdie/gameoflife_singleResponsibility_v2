package org.example;

import org.example.enums.Cell;
import org.example.exceptions.InvalidGameTypeException;

import static org.example.Rules.*;
import static org.example.Rules.checkIfCellHasTwoOrThreeNeighbors;

public class Spiel {


    GameOfLifeBoard board;
    private Cell[][] preset;

    public void execute (int gamePreset) throws InvalidGameTypeException {
        setPreset(gamePreset); // add test if input is integer
        board = new GameOfLifeBoard(preset);
        doIterations(10);
    }

    private void setPreset (int gamePreset) throws InvalidGameTypeException {
        if (gamePreset <= 2) {
            switch (gamePreset) {
                case 1:
                    preset = new Cell[][]{{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
                            {Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
                            {Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
                            {Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.ALIVE, Cell.DEAD, Cell.DEAD, Cell.DEAD},
                            {Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.ALIVE, Cell.DEAD, Cell.DEAD, Cell.DEAD},
                            {Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.ALIVE, Cell.DEAD, Cell.DEAD, Cell.DEAD},
                            {Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD}
                    };
                    break;
                case 2:
                    preset = new Cell[][]{{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
                            {Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
                            {Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
                            {Cell.DEAD, Cell.DEAD, Cell.ALIVE, Cell.ALIVE, Cell.ALIVE, Cell.DEAD, Cell.DEAD},
                            {Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
                            {Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
                            {Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD}
                    };
                    break;
            }
        } else {
            throw new InvalidGameTypeException("Not a valid game type. Choose 1-4");
        }
    }

    public void doIterations (int count) {
        for(int i = 0; i < count; i++) {
            setNextIteration();
        }
    }
    private void setNextIteration () {
        Cell[][] currentIteration = board.getBoard();
        Cell[][] nextIterationGameBoard = new Cell[currentIteration.length][currentIteration[0].length];

        for (int row = 0; row < currentIteration.length; row++) {
            for(int col = 0; col < currentIteration[row].length; col++) {
                if (checkIfCellWillBeAlive(board.countNeighborsOfCell(row, col), currentIteration[row][col])) {
                    nextIterationGameBoard[row][col] = Cell.ALIVE;
                }
            }
            board.setBoard(nextIterationGameBoard);
        }
    }

    public boolean checkIfCellWillBeAlive (int neighborCount, Cell cellState) {

        return     !checkIfCellIsOverpopulated(neighborCount, cellState)
                && checkIfCellIsReproducing(neighborCount, cellState)
                && !checkIfCellIsUnderpopulated(neighborCount, cellState)
                && checkIfCellHasTwoOrThreeNeighbors(neighborCount, cellState);
    }


}
