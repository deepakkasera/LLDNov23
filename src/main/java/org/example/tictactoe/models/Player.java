package org.example.tictactoe.models;

import java.util.Scanner;

public class Player {
    private Symbol symbol;
    private String name;
    private Long id;
    private PlayerType playerType;

    public Player(String name, Symbol symbol) {
        this.name = name;
        this.symbol = symbol;
        this.playerType = PlayerType.HUMAN;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Move executeMove(Board board) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the row index where you want to make the move: ");
        int row = scanner.nextInt();

        System.out.println("Please enter the col index where you want to make the move: ");
        int col = scanner.nextInt();

        return new Move(new Cell(row, col), this);
    }
}
