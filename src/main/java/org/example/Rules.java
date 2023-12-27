package org.example;

import org.example.enums.Cell;

public class Rules {

    public static boolean checkIfCellIsUnderpopulated (int neighborCount, Cell cellState) {
        return (neighborCount < 2 && cellState == Cell.ALIVE);
    }

    public static boolean checkIfCellHasTwoOrThreeNeighbors (int neighborCount, Cell cellState) {
        return ((neighborCount == 2 || neighborCount == 3) && (cellState == Cell.ALIVE));
    }

    public static boolean checkIfCellIsOverpopulated (int neighborCount, Cell cellState) {
        return (neighborCount > 3 && (cellState == Cell.ALIVE));
    }

    public static boolean checkIfCellIsReproducing (int neighborCount, Cell cellState) {
        return (neighborCount == 3 && (cellState == Cell.DEAD));
    }
}
