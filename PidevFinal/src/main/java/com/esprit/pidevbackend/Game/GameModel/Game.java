package com.esprit.pidevbackend.Game.GameModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {
    private String gameId;
    private Player player1;
    private Player player2;
    private GameStatus status;
    private int[][] board;
    private TicToe winner;

}
