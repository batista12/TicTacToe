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
	}

}
