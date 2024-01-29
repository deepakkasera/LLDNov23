package org.example.tictactoe.models;

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
}
