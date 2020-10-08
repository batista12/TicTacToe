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

	public static void main (String[]args)
	{
		char computerLetter;
		char[] tictactoe= boardIsCreated();
		char userInputLetter=chooseLetterXO();
		if(userInputLetter== 'X')
			computerLetter='O';
		else
			computerLetter='X';
	}
}
