import java.util.*;

public class TicTacToe 
{
	static String[] board;
	static String turn;

	static String checkWinner() 
	{
		for (int a = 0; a < 16; a++) 
		{
			String line = "0";

			switch (a) 
			{
			case 0:
				line = board[0] + board[1] + board[2] + board[3];
				break;
			case 1:
				line = board[4] + board[5] + board[6] + board[7];
				break;
			case 2:
				line = board[8] + board[9] + board[10] + board[11];
				break;
			case 3:
				line = board[12] + board[13] + board[14] + board[15];
				break;
			case 4:
				line = board[0] + board[4] + board[8] + board[12];
				break;
			case 5:
				line = board[1] + board[5] + board[9] + board[13];
				break;
			case 6:
				line = board[2] + board[6] + board[10] + board[14];
				break;
			case 7:
				line = board[3] + board[7] + board[11] + board[15];
				break;
			case 8:
				line = board[0] + board[5] + board[10] + board[15];
				break;
			case 9:
				line = board[3] + board[6] + board[9] + board[12];
				break;
			}

			line = line.replaceAll("\\s+", "");

			if (line.equals("XXXX")) 
			{
				return "X";
			} 
			else if (line.equals("OOOO")) 
			{
				return "O";
			}
		}

		for (int a = 0; a < 16; a++) 
		{
			if (Arrays.asList(board).contains(String.valueOf(a + 1))) 
			{
				break;
			} 
			else if (a == 15) 
			{
				return "Unentschieden";
			}
		}
		System.out.println(turn + " ist an der Reihe. Gib deine gewünschte Zahl ein:");
		return null;
	}

	static void printBoard() 
	{
		System.out.println("|-----|-----|-----|-----|");
		System.out.println("|  " + board[0] + "  |  " + board[1] + "  |  " + board[2] + "  |  " + board[3] + "  | ");

		System.out.println("|-----------------------|");
		System.out.println("|  " + board[4] + "  |  " + board[5] + "  |  " + board[6] + "  |  " + board[7] + "  | ");

		System.out.println("|-----------------------|");
		System.out.println("|  " + board[8] + "  |  " + board[9] + " |  " + board[10] + " |  " + board[11] + " | ");

		System.out.println("|-----------------------|");
		System.out.println("|  " + board[12] + " |  " + board[13] + " |  " + board[14] + " |  " + board[15] + " | ");
		System.out.println("|-----|-----|-----|-----|");
	}

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		board = new String[16];

		for (int a = 0; a < 16; a++) 
		{
			board[a] = String.valueOf(a + 1);
		}
		turn = "X";
		String winner = null;

		for (int a = 0; a < 16; a++) 
		{
			board[a] = String.valueOf(a + 1);
		}

		System.out.println("Moin, viel Spaß beim 4x4 Tic Tac Toe.");
		printBoard();

		System.out.println("X startet. Gib eine Zahl an um zu starten:");

		while (winner == null)
{
			int numInput;

			try 
			{
				numInput = in.nextInt();
				if (!(numInput > 0 && numInput <= 16)) 
				{
					System.out.println("Ups, dass kann nicht sein; entscheide weiße:");
					continue;
				}
			} 
			catch (InputMismatchException e) 
			{
				System.out.println("Ups, dass kann nicht sein; entscheide weiße:");
				continue;
			}
			if (numInput > 9 && turn == "X") 
			{
				turn = "X ";
			}
			if (numInput > 9 && turn == "O") 
			{
				turn = "O ";
			}
			if (board[numInput - 1].equals(String.valueOf(numInput))) 
			{
				board[numInput - 1] = turn;

				if (turn.equals("X") || turn.equals("X ")) 
				{
					turn = "O";
				} 
				else 
				{
					turn = "X";
				}

				printBoard();
				winner = checkWinner();
			} 
			else 
			{
				System.out.println("Sorry, dieses Feld ist schon belegt. Entscheide dich für ein Anderes:");
			}
		}
		if (winner.equalsIgnoreCase("Unentschieden")) 
		{
			System.out.println("Super, ein Kunstwerk! Danke für´s Spielen.");
		} 
		else {
			System.out.println("Glückwunsch! " + winner + " hat sich den Sieg geholt! Danke für´s Spielen.");
		}
		in.close();
	}
}
