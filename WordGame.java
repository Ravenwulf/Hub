import java.util.*;

public class WordGame {
  public WordGame() {
	  Player player1 = new Player("Gabby");
	  Scanner scan = new Scanner(System.in);
	  Player player2 = new Player("Marcello");
	  player2.setNewWord(player1.getRealWord());
	  while(!player1.isWinner() && !player2.isWinner())
	  {
			System.out.printf("\033[2J");
	    player1.displayBoard();
	    System.out.println( player1.getName() + ", guess a letter");
	    player1.guessLetter(scan.nextLine());
	    if (player1.isWinner())
	    {
	      System.out.println("Congrats " + player1.getName() + ", a winner is you!");
	      break;
	    }
			System.out.printf("\033[2J");
	    System.out.println("Changing players \n");
	    player2.displayBoard();
	    System.out.println(player2.getName() + ", guess a letter");
	    player2.guessLetter(scan.nextLine());
		if(player2.isWinner()){
	    System.out.println("Congrats " + player2.getName() + ", a winner is you!");
		break;
	  	}
	    System.out.println("Changing players \n");
	  }
	  
	 
  } // end main method
} // end Main class
