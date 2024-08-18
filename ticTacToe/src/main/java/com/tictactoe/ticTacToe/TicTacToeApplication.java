package com.tictactoe.ticTacToe;

import com.tictactoe.ticTacToe.model.Game;

public class TicTacToeApplication {

	public static void main(String[] args) {
		Game game = new Game();
		System.out.println("Winning Result: "+ game.startGame());
	}
}
