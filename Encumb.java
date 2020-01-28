import java.util.*;
import java.lang.Math;

class Encumb {
	//Change the below constants to effect the carrying capacity modifiers. 15 = PHB, 10&&5 = realistic
	static int ENCUMB = 5;
	static int HEAVY_ENCUMB = 10;
	static Scanner scan = new Scanner(System.in);
	public static final String RED_BOLD_BRIGHT = "\033[1;91m"; 
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\033[0;90m";
  public static final String ANSI_RED = "\033[0;91m";
  public static final String ANSI_GREEN = "\033[0;92m";
  public static final String ANSI_YELLOW = "\033[0;93m";
  public static final String ANSI_BLUE = "\033[0;94m";
  public static final String ANSI_PURPLE = "\033[0;95m";
  public static final String ANSI_CYAN = "\033[0;96m";
  public static final String ANSI_WHITE = "\033[0;97m";
	
	public Encumb() {
		System.out.println("What is your"+ANSI_BLUE+" size"+ANSI_RESET+" category? "); 
		//prompts for size
		String size = scan.nextLine();

		System.out.println("What is your "+ANSI_YELLOW+"strength"+ANSI_RESET+" score? ");
		//prompts for strength
		int strength = scan.nextInt();
		String consumed = scan.nextLine();

		double mod = detMod(size, strength);
		System.out.println("Would you like to use the experimental item library?"+RED_BOLD_BRIGHT+"(y/n)"+ANSI_RESET);
		
		String ans = scan.nextLine();
		
		boolean useLoop;
		if(ans.equals("y")){
			useLoop=false;
		}else{
			useLoop=true;
		}
		
		double totalWeight;
		if(useLoop){
			totalWeight = weightLoop();
		}else{
			totalWeight = itemLoop();
		}
		
		detEncumb(mod,totalWeight);
		
	}
	public static double detMod(String size, int strength){
		//Converts size category into the proper modifier
		double sizeMod =1;
		if (size.equals("small")){
			sizeMod = 1;
		}
		if(size.equals("medium")){
			sizeMod = 1;
		}
		if(size.equals("large")){
			sizeMod = 2;
		}
		if(size.equals("huge")){
			sizeMod = 2*2;
		}
		if(size.equals("gargantuan")){
			sizeMod = 2*2*2;
		}
		if(size.equals("tiny")){
			sizeMod = 0.5;
		}
		double mod = sizeMod * strength;
		return mod;
	}
	public static double itemLoop(){
		return 0.0;
	}
	public static double weightLoop(){
		//prompts for number of items the PC is carrying. Will use this number to determine how many times to run the while loop
		System.out.println("Number of items?");
		int loopItemGoal = scan.nextInt();

		//initialization for some variables
		int loopTimes = 1;
		double totalWeight = 0.0;
		double itemWeight = 0.0;

		//reprompts the user to determine the weight of one item everytime the loop runs, then adds that to a total.
		while (loopTimes < loopItemGoal + 1){ 
    	System.out.println("Weight of item number " + loopTimes + " in lbs?");
			itemWeight = scan.nextDouble();
			totalWeight += itemWeight;
			loopTimes++; 
		}
		
		//Updates the player on item weight and restates item total for confirmation
		System.out.println("Number of items: " +ANSI_BLUE+ loopItemGoal+ANSI_RESET);
		System.out.println("Total weight: " +ANSI_BLUE+ totalWeight+ANSI_RESET);
		return totalWeight;
	}
	public static void detEncumb(double mod, double totalWeight){
		if(ENCUMB*mod <= totalWeight){
			if(HEAVY_ENCUMB*mod <= totalWeight){
				System.out.println("You are heavily encumbered by " +ANSI_GREEN+ (totalWeight - (HEAVY_ENCUMB * mod)) +ANSI_RESET+ "lbs.\nYour speed drops by"+ANSI_YELLOW+" 20 "+ANSI_RESET+"feet and you have"+ANSI_RED+" disadvantage"+ANSI_RESET+" on"+ANSI_CYAN+" ability checks"+ANSI_RESET+", "+ANSI_CYAN+"attack rolls"+ANSI_RESET+", and "+ANSI_CYAN+"saving throws"+ANSI_RESET+" that use Strength, Dexterity, or Constitution.");
			}else{
				System.out.println("You are encumbered by " +ANSI_GREEN+ (totalWeight - (ENCUMB*mod)) +ANSI_RESET+ "lbs. \nYour speed drops by 10 feet." );
			}
		}else{
			System.out.println("You are not encumbered.\nYou have " +ANSI_PURPLE+ ((ENCUMB*mod)-totalWeight)+ANSI_RESET+" lbs of carry weight left");
		}
	}
}
  
