package org.example;

import org.example.enums.Cell;

public class GameOfLifeBoard {

    private Cell[][] board = null;

    public GameOfLifeBoard (Cell[][] board) {
        setBoard(board);
    }


    public void printBoard () {
        for (Cell[] rows : board) {
            for (Cell cells : rows) {
                System.out.print(cells);
            }
            System.out.println();
        }
    }

    public Cell[][] getBoard () {
        return board;
    }

    public void setBoard (Cell[][] board) {
        this.board = board;
    }

    public int countNeighborsOfCell (int row, int col) {
        int sum = 0;
        return sum + (countNeighborsOfCellAbove(row, col) + countNeighborsOfCellEven(row, col) + countNeighborsOfCellBelow(row, col));
    }

    public int countNeighborsOfCellAbove(int row, int col) {
        int sum = 0;

        try {
            if(board[row - 1][col - 1] == Cell.ALIVE) {
                sum++;
            }
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            // do nothing
        }

        try {
            if(board[row - 1][col] == Cell.ALIVE) {
                sum++;
            }
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            // do nothing
        }

        try {
            if(board[row - 1][col + 1] == Cell.ALIVE) {
                sum++;
            }
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            // do nothing
        }
        return sum;
    }

    public int countNeighborsOfCellEven(int row, int col) {
        int sum = 0;

        try {
            if(board[row][col - 1] == Cell.ALIVE) {
                sum++;
            }
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            // do nothing
        }

        try {
            if(board[row][col + 1] == Cell.ALIVE) {
                sum++;
            }
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            // do nothing
        }
        return sum;
    }

    public int countNeighborsOfCellBelow(int row, int col) {
        int sum = 0;

        try {
            if(board[row + 1][col - 1] == Cell.ALIVE) {
                sum++;
            }
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            // do nothing
        }

        try {
            if(board[row + 1][col] == Cell.ALIVE) {
                sum++;
            }
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            // do nothing
        }

        try {
            if(board[row + 1][col + 1] == Cell.ALIVE) {
                sum++;
            }
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            // do nothing
        }
        return sum;
    }


}
