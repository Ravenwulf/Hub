import java.util.*;
public class Player {
  //instance variables
  private String name;
  private String currentString;
  private String word;
  
  //constructor
  public Player(String n)
  {
    name = n;
    setNewWord();
    fillAsterisks();
  }
  
   public Player(String n, String w)
  {
    name = n;
    word = w;
    fillAsterisks();
  }
  
  //methods
  public String getName()
  {
    return name;
  }
  
  public String getRealWord()
  {
    return word;
  }
  
  public String getUserWord(String w)
  {
    currentString = w;
    return currentString;
  }
  
  public void setNewWord()
  {
    int randInt = (int)(Math.random()*5);
    if (randInt == 0) 
    {
      word = "hello";
    }
    if (randInt == 1)
    {
      word = "howdy";
    }
    if (randInt == 2)
    {
      word = "illinois";
    }
    if (randInt == 3)
    {
      word = "huntley";
    }
    if (randInt == 4)
    {
      word = "wow";
    }
    fillAsterisks();
  }
  
  public void setNewWord(String w)
  {
    word = w;
    fillAsterisks();
    
  }
  
  public void fillAsterisks()
  {
    int end = word.length();
    currentString = "";
    for(int i = 1; i<=end; i++)
    {
        currentString+="*";
    }
  }
  
  public boolean guessLetter(String guess)
  {
    boolean found = false;
    for (int i = 0; i < word.length(); i++) {
			// Check if the current letter equals the user's guess
			if (word.substring(i,i+1).equals(guess)) {
				// once one letter matches, change found to true (for just the current guess... see NOTE above)
				found = true;
				// Substitute in the letter that was correctly guessed
				currentString = currentString.substring(0,i) + guess + currentString.substring(i+1);	
			} // end if

		} // end for
		if(!found)
		{
		  System.out.println(currentString);
		  System.out.println("Sorry, there is no " + guess + " in the word");
		}else
		{
		  System.out.println(currentString);
		  System.out.println("Success");
		}
		return found;
  }
  
  public void displayBoard()
  {
    System.out.println(currentString);
  }
  
  public boolean isWinner(){
    if(currentString.equals(word))
    {
    return true;  
    }
    return false;
  }
}