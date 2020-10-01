package com.cg.tictactoegame;

import java.util.Scanner;

import org.graalvm.compiler.lir.aarch64.AArch64Move.Move;

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
			System.out.print("|  " + board[position]+" ");
			if (position % 3 == 0) {
				System.out.println("|");
				
			}
		}
	}
	public static void move(char[] board,char player)
	{
		System.out.println("Enter the index to make a move");
		int index=scanner.nextInt();
		if(index>9 || index<1 ||board[index]!=' ')
		{
			System.out.println("Cannot play this index");
			move(board,player);
		}
		else {
			board[index]=player;
		}
	}
	public static void main(String[] args) {
		System.out.println("Welcome to TicTacToe program");
		char[] board = createBoard();
		char player = playerInput();
		char computer = (player == 'x') ? 'o' : 'x';
		showBoard(board);
		move(board,player);
		showBoard(board);
	}
}
