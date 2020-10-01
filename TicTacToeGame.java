package com.cg.tictactoegame;

import java.util.Scanner;

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

	/**
	 * @taking the player's input to choose between X and O
	 */
	public static char playerInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose your character (X/0)");
		char s = sc.next().charAt(0);
		if (s == 'X' || s == 'x') {
			return 'x';
		} else if (s == 'O' || s == 'o') {
			return 'o';
		} else {
			System.out.println("Invalid Character");
			return playerInput();
		}
	}

	public static void main(String[] args) {
		System.out.println("Welcome to TicTacToe program");
		char[] board = createBoard();
		char player = playerInput();
		char computer=(player=='x')?'o':'x';
	}
}
