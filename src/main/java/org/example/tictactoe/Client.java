package org.example.tictactoe;

import org.example.tictactoe.controllers.GameController;
import org.example.tictactoe.exceptions.InvalidBotCountException;
import org.example.tictactoe.exceptions.InvalidMoveException;
import org.example.tictactoe.exceptions.InvalidNumberOfPlayersException;
import org.example.tictactoe.models.*;
import org.example.tictactoe.strategies.winningstrategy.ColWinningStrategy;
import org.example.tictactoe.strategies.winningstrategy.DiagonalRowWinningStrategy;
import org.example.tictactoe.strategies.winningstrategy.GameWinningStrategy;
import org.example.tictactoe.strategies.winningstrategy.RowWinningStrategy;

import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws InvalidBotCountException, InvalidNumberOfPlayersException, InvalidMoveException {
        GameController controller = new GameController();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter game dimension");
        int dimension = scanner.nextInt();

        List<Player> players = List.of(
                new Player("Deepak", new Symbol('X')),
                new Player("Umes", new Symbol('O'))
        );
        List<GameWinningStrategy> winningStrategies = List.of(
                new RowWinningStrategy(),
                new ColWinningStrategy(),
                new DiagonalRowWinningStrategy()
        );

        Game game = controller.startGame(dimension, players, winningStrategies);

        while (controller.getGameState(game).equals(GameState.IN_PROGRESS)) {
            controller.displayBoard(game);

            System.out.println("Do you want to undo ?");
            String moveType = scanner.next();

            if (moveType.equalsIgnoreCase("y")) {
                controller.undo(game);
                continue;
            }

            controller.makeMove(game);
        }

        //While loop will be over if the game has ENDED or game has DRAWN.
        System.out.println("Game finished");
        controller.displayBoard(game);
        if (controller.getGameState(game).equals(GameState.ENDED)) {
            System.out.println("Winner is " + controller.getWinner(game).getName());
        } else {
            System.out.println("Game DRAWN");
        }
    }
}
