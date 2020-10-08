package com.capgemini.TicTacToe;
import java.util.Scanner;
public class TicTacToe
{
	static char[] tictactoe;
	Scanner sc= new Scanner(System.in);
	public static void boardisCreated() {
		tictactoe=new char[10];
		for(int i=1;i<10;i++) {
			tictactoe[i]=' ';
		}
	}
	public static void main (String[]args)
	{
		TicTacToe tictactoe=new TicTacToe();
		tictactoe.boardisCreated();
	}
}
