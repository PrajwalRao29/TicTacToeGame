package com.cg.tictactoegame;

import java.util.Scanner;

public class TicTacToeGame {
	static Scanner scanner = new Scanner(System.in);

	/**
	 * UC1 initializing the board
	 */
	public static char[] createBoard() {
		char[] board = new char[10];
		for (int i = 1; i < 10; i++) {
			board[i] = ' ';
		}
		return board;
	}

	/**
	 * UC2 taking the player's input to choose between X and O
	 */
	public static char playerInput() {

		System.out.println("Choose your character (X/0)");
		char symbol = Character.toUpperCase(scanner.next().charAt(0));
		if (symbol == 'X' || symbol == 'O')
			return symbol;
		else {
			System.out.println("Invalid Character");
			return playerInput();
		}
	}

	/**
	 * UC3 Displaying the board
	 */
	public static void showBoard(char[] board) {

		for (int position = 1; position < createBoard().length; position++) {
			System.out.print("|  " + board[position] + " ");
			if (position % 3 == 0) {
				System.out.println("|");

			}
		}
	}

	/**
	 * UC4 Player move & UC10, UC 11 Computer prioritizes corner ,center and side
	 * positions
	 */
	public static void move(char[] board, char player, char user) {
		if (player == user) {
			System.out.println("Enter the index to make a move");
			int index = scanner.nextInt();
			if (index > 9 || index < 1 || !isFree(board, index)) {
				System.out.println("index not free");
				move(board, player, user);
			} else {
				board[index] = player;
			}
		} else {
			System.out.println("Computer's turn to move");
			if (compWinMove(board, player)) {
				return;
			} else if (denyWin(board, player, user)) {
				return;
			} else if (board[1] == ' ') {
				board[1] = player;
			} else if (board[3] == ' ') {
				board[3] = player;
			} else if (board[7] == ' ') {
				board[7] = player;
			} else if (board[9] == ' ') {
				board[9] = player;
			} else if (board[5] == ' ') {
				board[5] = player;
			} else {
				for (int position = 1; position < 10; position++) {
					if (board[position] == ' ') {
						board[position] = player;
					}
				}
			}
		}
	}

	/**
	 * @UC5 check if space is free
	 */
	public static boolean isFree(char[] board, int index) {
		if (board[index] != ' ') {

			return false;
		} else {
			return true;
		}
	}

	/**
	 * @UC6 Toss to determine first player
	 */
	public static boolean Toss() {
		System.out.println("Call heads or tails (H/T)");
		char toss = Character.toUpperCase(scanner.next().charAt(0));
		int a = (int) Math.floor(Math.random() * 2 % 2);
		char outcome = (a == 0) ? 'H' : 'T';
		if (toss == outcome) {
			System.out.println("USER WON THE TOSS");
			return true;
		} else {
			System.out.println("USER LOST THE TOSS");
			return false;
		}
	}

	/**
	 * UC7 Check winning condition
	 */
	public static boolean checkWin(char[] board, char player) {
		if ((board[1] == player && board[2] == player && board[3] == player)
				|| (board[4] == player && board[5] == player && board[6] == player)
				|| (board[7] == player && board[8] == player && board[9] == player)
				|| (board[1] == player && board[4] == player && board[7] == player)
				|| (board[2] == player && board[5] == player && board[8] == player)
				|| (board[3] == player && board[6] == player && board[9] == player)
				|| (board[1] == player && board[5] == player && board[9] == player)
				|| (board[3] == player && board[5] == player && board[7] == player))
			return true;
		else {
			return false;
		}
	}

	public static boolean checkTie(char[] board) {
		for (int position = 0; position < 10; position++) {
			if (board[position] == ' ') {
				return false;
			}
		}
		System.out.println("GAME TIED !!!");
		return true;
	}

	/**
	 * UC8 Check if computer can win then move
	 */
	public static boolean compWinMove(char[] board, char ch) {
		for (int position = 1; position < 10; position++) {
			if (board[position] == ' ') {
				board[position] = ch;
				if (!checkWin(board, ch)) {
					board[position] = ' ';
				} else {
					{
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * UC9 Check if user can win next move and deny it.
	 */
	public static boolean denyWin(char[] board, char player, char user) {
		for (int position = 1; position < 10; position++) {
			if (board[position] == ' ') {
				board[position] = user;
				if (!checkWin(board, user)) {
					board[position] = ' ';
				} else {
					{
						board[position] = player;
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * UC12_Play till game is won or tied.
	 */
	public static void winOrSwitch(char[] board, char player, char user) {
		while ((!checkTie(board))) {
			move(board, player, user);
			showBoard(board);
			if (checkWin(board, player)) {
				System.out.println(player + " wins the game");
				break;
			}
			player = ((player == 'X') ? 'O' : 'X');
		}
	}

	/**
	 * UC13_Check if user wants to invoke initiate function again
	 */
	public static void initiateGame() {
		char[] board = createBoard();
		char user = playerInput();
		char computer = ((user == 'X') ? 'O' : 'X');
		showBoard(board);
		char player;
		if (Toss())
			player = user;
		else {
			player = computer;
		}
		winOrSwitch(board, player, user);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to TicTacToe program");
		int initiatekey = 1;
		while (initiatekey != 0) {
			initiateGame();
			System.out.println("DO YOU WANT TO PLAY AGAIN? (Y/N)");
			if (Character.toUpperCase(scanner.next().charAt(0)) == 'N') {
				initiatekey = 0;
				System.out.println("THANKS FOR PLAYING !");
			}

		}
		scanner.close();
	}
}
