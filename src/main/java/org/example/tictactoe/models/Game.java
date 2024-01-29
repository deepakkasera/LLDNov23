package org.example.tictactoe.models;

import org.example.inheritance3.B;
import org.example.tictactoe.exceptions.InvalidBotCountException;
import org.example.tictactoe.exceptions.InvalidNumberOfPlayersException;
import org.example.tictactoe.strategies.winningstrategy.GameWinningStrategy;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players;
    private Board board;
    private List<Move> moves;
    private Player winnner;
    private GameState gameState;
    private int nextMovePlayerIndex;
    private List<GameWinningStrategy> winningStrategies;

    private Game(int dimension, List<Player> players, List<GameWinningStrategy> winningStrategies) {
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
        this.nextMovePlayerIndex = 0;
        this.winnner = null;
        this.winningStrategies = winningStrategies;
        this.players = players;
        this.board = new Board(dimension);
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Player getWinnner() {
        return winnner;
    }

    public void setWinnner(Player winnner) {
        this.winnner = winnner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getNextMovePlayerIndex() {
        return nextMovePlayerIndex;
    }

    public void setNextMovePlayerIndex(int nextMovePlayerIndex) {
        this.nextMovePlayerIndex = nextMovePlayerIndex;
    }

    public List<GameWinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<GameWinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public static class Builder {
        private List<Player> players;
        private List<GameWinningStrategy> winningStrategies;
        private int dimension;

        private Builder() {
            this.players = new ArrayList<>();
            this.winningStrategies = new ArrayList<>();
            this.dimension = 0;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategies(List<GameWinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        private boolean validateBotCount() {
            int botCount = 0;
            for (Player player : players) {
                if (player.getPlayerType().equals(PlayerType.BOT)) {
                    botCount++;
                }
            }
            return botCount <= 1;
        }

        private void validate() throws InvalidNumberOfPlayersException, InvalidBotCountException {
            if (players.size() != dimension - 1) {
                throw new InvalidNumberOfPlayersException("Number of players should be 1 less than the dimension");
            }

            //validate if all the players have different symbols or not.
            //TODO

            //validate number of bots in the game.
            if (!validateBotCount()) {
                throw new InvalidBotCountException("Bot count should be <= 1");
            }
        }

        public Game build() throws InvalidBotCountException, InvalidNumberOfPlayersException {
            //validations
            validate();

            return new Game(dimension, players, winningStrategies);
        }
    }
}
