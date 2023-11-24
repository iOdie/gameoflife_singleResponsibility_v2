package org.example;

public class GameOfLifeBoard implements BoardGame{

    private int[][] board;

    public GameOfLifeBoard (int[][] board) {
        setBoard(board);
    }

    @Override
    public void printBoard () {
        for (int[] rows : board) {
            for (int cells : rows) {
                System.out.print(cells);
            }
            System.out.println();
        }
    }

    public int[][] getBoard () {
        return board;
    }

    public void setBoard (int[][] board) {
        this.board = board;
    }

    /*
    public void setCellState (int value, int row, int col) {
        this.board[row][col] = value;
    }
     */
}
