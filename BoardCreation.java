package com.capgemini.TicTacToe;
import java.util.Scanner;
public class TicTacToe
{
	Scanner sc= new Scanner(System.in);
	public static char[] boardisCreated() {
		char[] tictactoe=new char[10];
		for(int i=1;i<10;i++) {
			tictactoe[i]=' ';
		}
		return tictactoe;
	}
	public static void main (String[]args)
	{
		char[] tictactoe=boardisCreated();	
	}
}
