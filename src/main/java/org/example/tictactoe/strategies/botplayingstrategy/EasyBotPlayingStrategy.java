package org.example.tictactoe.strategies.botplayingstrategy;

import org.example.tictactoe.models.Board;
import org.example.tictactoe.models.Cell;
import org.example.tictactoe.models.CellState;
import org.example.tictactoe.models.Move;

import java.awt.event.MouseEvent;
import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {
    @Override
    public Move makeMove(Board board) {
        for (List<Cell> row : board.getBoard()) {
            for (Cell cell : row) {
                if (cell.getCellState().equals(CellState.EMPTY)) {
                    return new Move(cell, null);
                }
            }
        }

        return null;
    }
}
