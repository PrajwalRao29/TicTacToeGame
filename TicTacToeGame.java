package com.cg.tictactoegame;
public class TicTacToeGame {

	/**
	 * initializing the board
	 */
	public static char[] createBoard() {
		char[] board = new char[10];
		for (int i = 0; i < 10; i++) {
			board[i] = ' ';
		}
		return board;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to TicTacToe program");
		char[] board = createBoard();
	}
}
