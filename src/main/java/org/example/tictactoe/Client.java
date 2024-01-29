package org.example.tictactoe;

import org.example.tictactoe.controllers.GameController;
import org.example.tictactoe.exceptions.InvalidBotCountException;
import org.example.tictactoe.exceptions.InvalidNumberOfPlayersException;
import org.example.tictactoe.models.Game;
import org.example.tictactoe.models.Player;
import org.example.tictactoe.models.PlayerType;
import org.example.tictactoe.models.Symbol;
import org.example.tictactoe.strategies.winningstrategy.GameWinningStrategy;

import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws InvalidBotCountException, InvalidNumberOfPlayersException {
        GameController controller = new GameController();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter game dimension");
        int dimension = scanner.nextInt();

        List<Player> players = List.of(
                new Player("Deepak", new Symbol('X')),
                new Player("Umes", new Symbol('O'))
        );
        List<GameWinningStrategy> winningStrategies = List.of(

        );

        Game game = controller.startGame(dimension, players, winningStrategies);
        controller.displayBoard(game);
    }
}
