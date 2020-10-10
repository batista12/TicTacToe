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

         /*UC9*/
        public static int computerChance(char[] board, char userinput, char playerLetter, char computerLetter) {
	String playerWinPossibility;
	int positionForPlayerWin = 10;
	char previousInput = swapPlayerLetter(userinput, playerLetter,computerLetter);
	for (int i = 0; i < 10; i++) {
		if (board[i] == ' ') {
			board[i] = previousInput;
			playerWinPossibility = isWinning(board, previousInput);
			if (playerWinPossibility.contains("Win")) {
				positionForPlayerWin = i;
				board[i] = ' ';
				break;
			}
			board[i] = ' ';
		}
	}
	return positionForPlayerWin;
	}
	public static int availableCorner(char[] board) {
		int indexOfCorner = 10;
		if (board[0] == ' ')
			indexOfCorner = 0;
		else if (board[2] == ' ')
			indexOfCorner = 2;
		else if (board[6] == ' ')
			indexOfCorner = 6;
		else if (board[8] == ' ')
			indexOfCorner = 8;
		return indexOfCorner;
	}
	/*UC10*/

	public static void computerChance(char[] board, int indexC, char computerLetter) {
	while (true) {
		if (isLocationAvailable(board, indexC)) {
			System.out.println("Index is free");
			board[indexC] = computerLetter;
			showBoard(board);
			break;
		} else {
			System.out.println("Index isnt free, enter another index");
					showBoard(board);
					indexC = (int) (Math.floor(Math.random() * 10 % 9));
					System.out.println("Computer choose " + indexC);
					computerMove(board, indexC, computerLetter);
					break;
		}
	   }
      }
	/*UC 11*/
	public static int availableCentreOrSide(char[] board) {
	int indexOfSide = 0;
	if(board[4]==' ')
		indexOfSide = 4;
	else if(board[3]==' ')
		indexOfSide = 3;
	else if(board[1]==' ')
		indexOfSide = 1;
	else if(board[5]==' ')
		indexOfSide = 5;
	else if(board[7]==' ')
		indexOfSide = 7;
	return indexOfSide;
       }
	/*UC 12 and 13*/
       public static void ticTacToe() {
	char[] board = createBoard();
	showBoard(board);
	char playerLetter = chooseLetter();
	char computerLetter = ' ';
	if (playerLetter == 'X') {
		computerLetter = 'O';
		System.out.println("Players letter is " + playerLetter + " and Computers letter is " +computerLetter);
	} else {
		computerLetter = 'X';
		System.out.println("Players letter is " + playerLetter + " and Computers letter is " + computerLetter);
	}
	String firstPlayer = switchUser();
	System.out.println("First chance " + firstPlayer);
	char userinput = ' ';
	if (firstPlayer == User)
		userinput = playerLetter;
	else
		userinput = computerLetter;
	System.out.println("Input taken for firstPlayer is " + userinput);
	int turn = 0;
	do {
		int positionComputer = 0;
		int blockPlayer = 0;
		int cornerPosition = 0;
		int centreSidePosition = 0;
		if (firstPlayer == Computer) {
			showBoard(board);
			positionComputer = compWin(board, userinput);
			blockPlayer = computerChance(board, userinput,playerLetter, computerLetter);
			if (positionComputer != 10) {
				System.out.println("Computer will win if " +positionComputer + " is choosen");
				board[positionComputer] = userinput;
				showBoard(board);
			} else if (blockPlayer != 10) {
				System.out.println("If " + blockPlayer + " is
						choosen player will win.So Block that");
						board[blockPlayer] = userinput;
				showBoard(board);
			} else if (cornerPosition != 10) {
				System.out.println("Computer choose corner position " + cornerPosition);
						board[cornerPosition] = userinput;
						showBoard(board);
			}
			else if(centreSidePosition != 10) {
				System.out.println("Computer choose position "+cornerPosition);
						board[centreSidePosition] = userinput;
						showBoard(board);
			}
			else {
				System.out.println("Enter computer position ");
				int indexC = (int) (Math.floor(Math.random() * 10
						% 9));
				System.out.println("Computer choose position " +
						indexC);
				checkMove(board, indexC, userinput);
				showBoard(board);
			}
		} else {
			System.out.println("Enter player position");
			int index = sc.nextInt();
			checkMove(board, index, userinput);
		}
		String output = isWinning(board, userinput);
		System.out.println("Output is " + output);
		if (output == "Win")
			turn = 1;
		else if (output == "Change") {
			userinput = swapPlayerLetter(userinput, playerLetter,
					computerLetter);
			firstPlayer = swapTurn(firstPlayer);
			turn = 0;
		} else
			turn = 1;
	} while (turn != 1);
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
		int corner=availableCorner(board);
		computerChance(board,indexC,computerLetter);
		int availablepart=availableCentreOrSide(board);
		showBoard(board);
		char anotherGame=' ';
		do {
		ticTac();
		System.out.println("Do you want to play again ? (Y / N)");
		anotherGame = sc.next().charAt(0);
		}while(anotherGame != 'N')
	}
}


