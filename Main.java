import java.util.Scanner;  // Import the Scanner class
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Random;
public class Main
{
    static void rest(List<Integer> board)
    {
        board.clear();
        for(int i=0;i<9;i++)
    	    {
    		 board.add(10);
    		}
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
    static char board_result(List<Integer> board,int ascii_Turn)
    {
        for(int i=0;i<9;i++)
        {
            if (i%3 == 0)
            {
                if(board.get(i) == ascii_Turn && board.get(i+1) == ascii_Turn && board.get(i+2) == ascii_Turn)
                {
                    return tr(ascii_Turn);
                }
            }
            if(i<3)
            {
                if(board.get(i) == ascii_Turn && board.get(i+3) == ascii_Turn && board.get(i+6) == ascii_Turn)
                {
                    return tr(ascii_Turn);
                }
            }
            
            if(i==0 && board.get(i) == ascii_Turn && board.get(i+4) == ascii_Turn && board.get(i+8) == ascii_Turn)
            {
                return tr(ascii_Turn);
            } 
            if(i==2 && board.get(i) == ascii_Turn && board.get(i+2) == ascii_Turn && board.get(i+4) == ascii_Turn)
            {
                return tr(ascii_Turn);
            }
        }  
        
        if(Collections.frequency(board,10) == 0)
        {
            return 'D';
        }

        return 'N';
    }
    static char tr(int interger)
    {
        if(interger == 0)
        {
            return 'X';
        }
        if (interger == -1)
        {
            return 'O';
        }
        if(interger == 10)
        {
            return 'E';
        }
        else
        {
            int num = interger;
            String s= Integer.toString(num);
            char c = s.charAt(0);
            return c;
        }
    }
    static void drawBoard(List<Integer> board,int code)
    {
        System.out.println("     Tic tac toe:");
        if (code == 1)
        {
            System.out.println("Current:       Example:            (E = Empty, Number = Player's Square of choise {type '1-9' to play vs human, type '10' to rest the board, type '11' to play againt a bot})");
        }
        if(code == 2)
        {
            System.out.println("Current:       Example:            (E = Empty, Number = Player's Square of choise {type '1-9' to play, type '10' to rest the board, type '11' to play againt a human})");
 
        }
        System.out.println(tr(board.get(0)) + " | " + tr(board.get(1)) + " | " + tr(board.get(2)) + "  ||  1 | 2 | 3");
        System.out.println(tr(board.get(3)) + " | " + tr(board.get(4)) + " | " + tr(board.get(5)) + "  ||  4 | 5 | 6");
        System.out.println(tr(board.get(6)) + " | " + tr(board.get(7)) + " | " + tr(board.get(8)) + "  ||  7 | 8 | 9");
    }
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		Random rand = new Random();
        int board_rng_limit = 9;
        int botsquare;
		char CurrentTurn = 'X';
		int ACsii_Turn = 0;
		List<Integer> board = new ArrayList<>();
        rest(board);
		char Rematch_Choice;
		while(true)
		{
		  System.out.println("\n\n\n\n\n\nVS human\n");
		  drawBoard(board,1);
		  System.out.print("Enter your Square  Choise, this is  " + CurrentTurn +"'s turn\n________________________________________________________________________\nEnter move: ");
		  int usermove = in.nextInt();
		  System.out.println("\n\n\n\n\n\n\n");
		  

    		  if(usermove == 11)
    		  {
    		   while(true)
    		   {    
                System.out.println("\n\n\n\n\n\nVS Bot\n");
    		    drawBoard(board,2);
    		    System.out.println("Enter your Square  Choise, this your turn\n________________________________________________________________________\nEnter move: ");
    		    usermove = in.nextInt();
    		    if(usermove == 10)
    		    {
    		        rest(board);
    		        continue;
    		    }
    		    if(usermove == 11)
    		    {
    		        rest(board);
    		        usermove = 10;
    		        break;
    		        
    		    }
    		    if (board.get(usermove-1) == 10)
    		    {
        		  board.set(usermove-1,ACsii_Turn);
        		  if(board_result(board,ACsii_Turn) == CurrentTurn)
        		  {
        		      System.out.println("\n\n\n\n\n\n\n");
        		      System.out.println(Character.toUpperCase(CurrentTurn) + " won, would you like to praticapate again y/n?");
        		      Rematch_Choice = in.next().charAt(0);
        		      if (Rematch_Choice == 'n')
        		      {
        		        System.out.println("Goodbye, it was Nice playing with you.");
        		        break;
        		      }
        		      else if(Rematch_Choice == 'y')
        		      {
                        rest(board);
                        CurrentTurn = 'X';
    		            ACsii_Turn = 0;
                        continue;
        		      }
        		  }
        		  if (board_result(board,ACsii_Turn) == 'D')
        		  {
        		      System.out.println("\n\n\n\n\n\n\n");
        		      System.out.println("The game ended in a draw, would you like to praticapate again y/n?");
        		      Rematch_Choice = in.next().charAt(0);
        		      if (Rematch_Choice == 'n')
        		      {
        		        System.out.println("Goodbye, it was Nice playing with you.");
        		        break;
        		      }
        		      else if(Rematch_Choice == 'y')
        		      {
                        rest(board);
                        CurrentTurn = 'X';
    		            ACsii_Turn = 0;
                        continue;
        		      }
        		  }
        		  if(CurrentTurn == 'X')
        		  {
        		      List<Integer> availableSquares= new ArrayList<>();

        		      for(int i=0;i<9;i++)
        		      {
        		       int item = board.get(i);
        		       if(item == 10)
        		       {
        		           availableSquares.add(i);
        		       }
        		      }
        		      board.set(availableSquares.get(rand.nextInt(availableSquares.size())), -1);
        		  }
    		  }
    		  else
    		  {
    		  System.out.println("That square is already taken plaese pick a diffrent square.\n\n\n\n\n"); 
    		  }
    		  }
    		  
		  }
		  
		  if (usermove == 10)
		  {
		      rest(board);
		      CurrentTurn = 'X';
		      ACsii_Turn = 0;
		      continue;
		  }
		  if (board.get(usermove-1) == 10)
		  {
    		  board.set(usermove-1,ACsii_Turn);
    		  if(board_result(board,ACsii_Turn) == CurrentTurn)
    		  {
    		      System.out.println("\n\n\n\n\n\n\n");
    		      System.out.println(Character.toUpperCase(CurrentTurn) + " won, would you like to praticapate again y/n?");
    		      Rematch_Choice = in.next().charAt(0);
    		      if (Rematch_Choice == 'n')
    		      {
    		        System.out.println("Goodbye, it was Nice playing with you.");
    		        break;
    		      }
    		      else if(Rematch_Choice == 'y')
    		      {
                    rest(board);
                    CurrentTurn = 'X';
		            ACsii_Turn = 0;
                    continue;
    		      }
    		  }
    		  if (board_result(board,ACsii_Turn) == 'D')
    		  {
    		      System.out.println("\n\n\n\n\n\n\n");
    		      System.out.println("The game ended in a draw, would you like to praticapate again y/n?");
    		      Rematch_Choice = in.next().charAt(0);
    		      if (Rematch_Choice == 'n')
    		      {
    		        System.out.println("Goodbye, it was Nice playing with you.");
    		        break;
    		      }
    		      else if(Rematch_Choice == 'y')
    		      {
                    rest(board);
                    CurrentTurn = 'X';
		            ACsii_Turn = 0;
                    continue;
    		      }
    		  }
    		  if(CurrentTurn == 'X')
    		  {
    		      CurrentTurn = 'O';
    		      ACsii_Turn = -1;
    		  }
    		  else 
    		  {
    		      CurrentTurn = 'X';
    		      ACsii_Turn = 0;
    		  }
		  }
		  else
		  {
		  System.out.println("That square is already taken plaese pick a diffrent square.\n\n\n\n\n"); 
		  }
		}
	}
}