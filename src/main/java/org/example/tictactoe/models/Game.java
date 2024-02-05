package org.example.tictactoe.models;

import org.example.inheritance3.B;
import org.example.tictactoe.exceptions.InvalidBotCountException;
import org.example.tictactoe.exceptions.InvalidMoveException;
import org.example.tictactoe.exceptions.InvalidNumberOfPlayersException;
import org.example.tictactoe.strategies.winningstrategy.GameWinningStrategy;

import java.awt.image.CropImageFilter;
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

    private boolean validateMove(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if (row < 0 || row >= board.getSize() || col < 0 || col >= board.getSize()) {
            return false;
        }

        System.out.println("hello");
        return board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY);
    }

    public void makeMove() throws InvalidMoveException {
        Player currentPlayer = players.get(nextMovePlayerIndex);

        System.out.println("It is " + currentPlayer.getName() + "'s move");
        Move currentMove = currentPlayer.executeMove(board);

        int row = currentMove.getCell().getRow();
        int col = currentMove.getCell().getCol();
        System.out.println(currentPlayer.getName() + " has made a move at row: " + row + " & col: " + col);

        if (!validateMove(currentMove)) {
            throw new InvalidMoveException("Player is trying to make an invalid move");
        }

        nextMovePlayerIndex = (nextMovePlayerIndex + 1) % players.size();
        Cell cell = board.getBoard().get(row).get(col);
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(currentPlayer);

        Move finalMove = new Move(cell, currentPlayer);
        moves.add(finalMove);
        //Check if the move made by the player is a winning move or not.

        if (checkWinner(board, finalMove)) {
            gameState = GameState.ENDED;
            winnner = currentPlayer;
        } else if (moves.size() == board.getSize() * board.getSize()) {
            gameState = GameState.DRAW;
        }
    }

    private boolean checkWinner(Board board, Move move) {
        //Check all the strategies one by one to check if the current move is the winning move or not.
        for (GameWinningStrategy winningStrategy : winningStrategies) {
            if (winningStrategy.checkWinner(board, move)) {
                return true;
            }
        }
        return false;
    }

    public void undo() {
        if (moves.isEmpty()) {
            System.out.println("We can't perform UNDO operation as there are NO moves");
            return;
        }

        Move lastMove = moves.get(moves.size() - 1);
        moves.remove(lastMove);

        Cell cell = lastMove.getCell();
        cell.setPlayer(null);
        cell.setCellState(CellState.EMPTY);

        nextMovePlayerIndex -= 1;
        nextMovePlayerIndex = (nextMovePlayerIndex + players.size())%players.size();

        for (GameWinningStrategy winningStrategy : winningStrategies) {
            winningStrategy.handleUndo(board, lastMove);
        }
    }
}
