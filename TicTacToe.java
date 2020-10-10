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
	/*UC7*/

        public static String decideWinner(char[] board, char userinput) {
		int count = 0;
		for (int i = 0; i < 10; i++)
			if (board[i] == ' ')
				count++;
		if (count == 0)
			return "Tie";
		else if ((board[0] == userinput && board[1] == userinput && board[2]
				== userinput)|| (board[3] == userinput && board[4] == userinput &&board[5] == userinput)|| (board[6] == userinput && board[7] == userinput &&
				board[8] == userinput)|| (board[0] == userinput && board[3] == userinput && board[6] == userinput)|| (board[1] == userinput && board[4] == userinput &&
				board[7] == userinput)|| (board[2] == userinput && board[5] == userinput &&board[8] == userinput)|| (board[0] == userinput && board[4] == userinput &&
				board[8] == userinput)|| (board[2] == userinput && board[4] == userinput &&board[6] == userinput))
			return "Win";
		else
			return "Change";
	}
	public static char swapPlayerLetter(char userinput, char playerLetter,
			char computerLetter) {
		if (userinput == playerLetter)
			userinput = computerLetter;
		else
			userinput = playerLetter;
		return userinput;
	}
	public static String swapTurn(String firstPlayer) {
		if (firstPlayer == User)
			firstPlayer = Computer;
		else
			firstPlayer = User;
		return firstPlayer;
	}
	
	/*UC8*/
        private static int compWin(char[] board, char userinput) {
	String compWinPossibility;
	int compWinPos = 10;
	char[] boardCopy = new char[10];
	for (int i = 0; i < 10; i++) {
		boardCopy[i] = board[i];
	}
	for (int i = 0; i < 10; i++) {
		if (boardCopy[i] == ' ') {
			boardCopy[i] = userinput;
			compWinPossibility = decideWinner(boardCopy,
					userinput);
			if (compWinPossibility.contains("Win")) {
				compWinPos = i;
			}
			boardCopy[i] = ' ';
		}
	}
	return compWinPos;
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
		int pos=compWin(board,userinput);
	}
}


