package org.example.tictactoe.models;

import org.example.tictactoe.strategies.botplayingstrategy.BotPlayingStrategy;

public class Bot extends Player {
    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(String name, Symbol symbol, BotDifficultyLevel difficultyLevel, BotPlayingStrategy botPlayingStrategy) {
        super(name, symbol);
        this.botDifficultyLevel = difficultyLevel;
        this.setPlayerType(PlayerType.BOT);
        this.botPlayingStrategy = botPlayingStrategy;
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    public BotPlayingStrategy getBotPlayingStrategy() {
        return botPlayingStrategy;
    }

    public void setBotPlayingStrategy(BotPlayingStrategy botPlayingStrategy) {
        this.botPlayingStrategy = botPlayingStrategy;
    }

    @Override
    public Move executeMove(Board board) {
        return botPlayingStrategy.makeMove(board);
    }
}
