package com.capgemini.TicTacToe;
import java.util.Scanner;
/*UC1*/
public class TicTacToe
{
	public static char[] boardIsCreated() {
		char[] tictactoe=new char[10];
		for(int i=1;i<10;i++) {
			tictactoe[i]=' ';
		}
		return tictactoe;
	}
	/*UC2*/
	public static char chooseLetterXO()
	{	
		System.out.println("Enter letter X or O");
		Scanner sc= new Scanner(System.in);
		char userInput = sc.next().charAt(0);
		return userInput;
	}
	/*UC3*/
	public static void printBoard(char[] tictactoe) {

		System.out.println("| " + tictactoe[0] + "| " + tictactoe[1] + "| " + tictactoe[2] + "| " );
		System.out.println("----------");
		System.out.println("| " + tictactoe[3] + "| " + tictactoe[4] + "| " + tictactoe[5] + "|" );
		System.out.println("----------");
		System.out.println("| " + tictactoe[6] + "| " + tictactoe[7] + "| " + tictactoe[8] + "|" );
		System.out.println("----------");
	}
	/*UC4*/
	public static int isLocationAvailable(char[] board, char userinput) {
		Scanner sc = new Scanner(System.in);
		int index;
		boolean emptyStatus;
		do {
			System.out.println("Enter index to place letter " + userinput);
			index = sc.nextInt();
			if (board[index] == ' ') {
				emptyStatus = true;
				System.out.println("Index available");
			} else {
				emptyStatus = false;
				System.out.println("Index not available");
			}
		} while (emptyStatus == false);
		return index;
	}
	/*UC5*/
	public static void checkMove(char[] board, int index, char userinput) {

		board[index] = userinput;
	}
	/*UC6*/
		public static String switchUser() { 
		String userTurn = " ";
		int user = (int) Math.floor(Math.random() * 10) % 2;
		System.out.println("User turn");
		if (user == 0)
			userTurn = User;
		else
			userTurn = Computer;
		return userTurn;
	}
	public static void main (String[]args)
	{
		char computerLetter;
		char[] tictactoe= boardIsCreated();
		char userInputLetter=chooseLetterXO();
		if(userInputLetter== 'X')
			computerLetter='O';
		else
			computerLetter='X';
		printBoard(tictactoe);
		createBoard();
		showBoard(board);
		int index = isLocationAvailable(board, userinput);
		checkMove(board, index, userinput);
	}

}
