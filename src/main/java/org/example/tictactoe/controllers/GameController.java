package org.example.tictactoe.controllers;

import org.example.tictactoe.exceptions.InvalidBotCountException;
import org.example.tictactoe.exceptions.InvalidMoveException;
import org.example.tictactoe.exceptions.InvalidNumberOfPlayersException;
import org.example.tictactoe.models.Game;
import org.example.tictactoe.models.GameState;
import org.example.tictactoe.models.Player;
import org.example.tictactoe.strategies.winningstrategy.GameWinningStrategy;

import java.util.List;

public class GameController {
    //In the Controller class, we'll write all the methods which client needs from our System.
    public Game startGame(int dimension, List<Player> players, List<GameWinningStrategy> winningStrategies) throws InvalidBotCountException, InvalidNumberOfPlayersException {
        return Game.getBuilder()
                .setDimension(dimension)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build();
    }

    public void makeMove(Game game) throws InvalidMoveException {
        game.makeMove();
    }

    public GameState getGameState(Game game) {
        return game.getGameState();
    }

    public void undo(Game game) {
        game.undo();
    }

    public void displayBoard(Game game) {
        game.getBoard().displayBoard();
    }

    public Player getWinner(Game game) {
        return game.getWinnner();
    }
}
