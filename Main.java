import java.util.*;
class Main {
  public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Which program would you like to run?");
		String input = scan.nextLine();
		boolean going = true;

		while(going){
			switch(input){
				case "bingo":
				Bingo nbingo = new Bingo();
				break;
				case "blin":
				Blin nblin = new Blin();
				break;
				case "license":
				License nlicense = new License();
				break;
				case "encumb":
				Encumb nencumb = new Encumb();
				break;
				case "line":
				Line nline = new Line();
				break;
				case "wordgame":
				WordGame nwordgame = new WordGame();
				break;
				case "student":
				StudentStart nstudentstart = new StudentStart();
				break;
				case "testscores":
				TestScores ntestscores = new TestScores();
				break;
				case "stapler":
				StaplerStart nstaplerstart = new StaplerStart();
				break;
				case "lightboard":
				LightBoardStart nlightboardstart = new LightBoardStart();
				break;
				case "skyview":
				SkyViewStart nskyviewstart = new SkyViewStart();
				break;
				case "help":
				break;
			}
			System.out.println("keep going? (true or false)");
				going = scan.nextBoolean();
		}
  }
}