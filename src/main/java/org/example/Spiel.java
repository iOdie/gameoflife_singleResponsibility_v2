package org.example;

import org.example.GameOfLifeBoard;
import org.example.enums.Cell;
import org.example.exceptions.InvalidGameTypeException;

public class Spiel {

    GameOfLifeService service;
    GameOfLifeBoard board;
    private int[][] preset;

    public void execute (int gamePreset) throws InvalidGameTypeException {
        setPreset(gamePreset); // add test if input is integer
        board = new GameOfLifeBoard(preset);
        service = new GameOfLifeService(board);
        service.doIterations(10);
    }

    private void setPreset (int gamePreset) throws InvalidGameTypeException {
        if (gamePreset <= 2) {
            switch (gamePreset) {
                case 1:
                    preset = new int[][] {{0,0,0,0,0,0,0},
                                          {0,0,0,0,0,0,0},
                                          {0,0,0,0,0,0,0},
                                          {0,0,0,1,0,0,0},
                                          {0,0,0,1,0,0,0},
                                          {0,0,0,1,0,0,0},
                                          {0,0,0,0,0,0,0}};
                    break;
                case 2:
                    preset = new int[][] {{0,0,0,0,0,0,0},
                                          {0,0,0,0,0,0,0},
                                          {0,0,0,0,0,0,0},
                                          {0,0,0,0,0,0,0},
                                          {0,0,1,1,1,0,0},
                                          {0,0,0,0,0,0,0},
                                          {0,0,0,0,0,0,0}};
            }
        } else {
            throw new InvalidGameTypeException("Not a valid game type. Choose 1-4");
        }
    }
}
