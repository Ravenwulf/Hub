/* Use these two sites for help understanding how an Illinois Driver's license number is created (these will be used in the Person class, not in this one)

http://www.highprogrammer.com/alan/numbers/dl_us_shared.html
http://www.highprogregardscom/alan/numbers/soundex.html
*/

/* A person should have a first name, last name, middle initial, birthday, birthmonth, birthyear, and gender... Read the comments to determine what needs to be completed*/

// NOTE: Anything you need to do will be in ALL CAPS

public class Person
{
    // CREATE INSTANCE VARIABLES
  private String lastName = "";
  private String middleInitial = "";
  private String firstName = "";
  private boolean isMale = false;
  private String gender = "";
  
  private int[] dob = new int[3];

  public static final String RED_BOLD_BRIGHT = "\033[1;91m"; 
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\033[0;90m"; // B
  public static final String ANSI_RED = "\033[0;91m"; // 1
  public static final String ANSI_GREEN = "\033[0;92m"; // 2
  public static final String ANSI_YELLOW = "\033[0;93m"; // 3
  public static final String ANSI_BLUE = "\033[0;94m"; // 4
  public static final String ANSI_PURPLE = "\033[0;95m"; // 5+
  public static final String ANSI_CYAN = "\033[0;96m";
  public static final String ANSI_WHITE = "\033[0;97m";

	// WRITE CONSTRUCTOR
    
  public Person(String lastName, String middleInitial, String firstName, String isMale, int month, int day, int year) {
			this.isMale = isMale.equals("M") || isMale.equals("MALE");
      this.lastName = lastName.toUpperCase();
      this.middleInitial = middleInitial.toUpperCase();
      this.firstName = firstName.toUpperCase();
      
      this.dob[0] = month;
      this.dob[1] = day;
      this.dob[2] = year;

      if(this.isMale)
        gender = "MALE";
      else
        gender = "FEMALE";
  }


	// FIND THE SOUNDEX CODE
	// DO THIS METHOD LAST... IT'S THE HARDEST :)
	// USE http://www.highprogrammer.com/alan/numbers/soundex.html FOR RULES 
    public String getName() {
      if(middleInitial.length() >= 1)
        return firstName + " " + middleInitial + " " + lastName; 
      else
        return firstName + " " + lastName; 
    }

    public String getSSSS(){
        String result = "";
        result += lastName.substring(0, 1);
        
        String tempL = "";
        boolean skip = false;
        int lastCode = -1;
        for(int i = 0; i < lastName.length(); i++) {
          if(skip){
            skip = false;  
            continue;
          }
          if(i < lastName.length() - 1 && SSSScode(lastName.substring(i, i+1)) == SSSScode(lastName.substring(i+1, i+2)) || SSSScode(lastName.substring(i, i+1)) == lastCode) {
            lastCode = SSSScode(lastName.substring(i, i+1));
            skip = true;
          } else {
            lastCode = -1;
          }
          if(i < lastName.length() - 1 && lastName.substring(i, i+1).equals("W") || lastName.substring(i, i+1).equals("H")) {
            skip = true;
          }
          tempL += lastName.substring(i, i + 1);
        }
        // System.out.println(tempL);
        int remaining = 3;
        for(int i = 1; i < tempL.length(); i++) {
          if(remaining <= 0)
            break;
          int temp = SSSScode(tempL.substring(i, i + 1));
          if(temp > 0) {
            result += temp;
            remaining--;
          }
          else
            continue;
        }
        
        for(int i = 0; i < remaining; i++)
          result += 0;

        return result;
    }
    
    public int SSSScode(String s) {
      int code = 0;
      switch(s) {
        case "B":
        case "F":
        case "P":
        case "V":
          code = 1;
          break;
        case "C":
        case "G":
        case "J":
        case "K":
        case "Q":
        case "S":
        case "X":
        case "Z":
          code = 2;
          break;
        case "D":
        case "T":
          code = 3;
          break;
        case "L":
          code = 4;
          break;
        case "M":
        case "N":
          code = 5;
          break;
        case "R":
          code = 6;
          break;
        default:
          code = 0;
          break;
      }
      return code;
    }

	// FIND FFF CODE... 
	// NOTE: There are some helper methods already written for you... PLEASE use them!
    public String getFFF(){
			String result = "";
			int f = 0;
      if(getFirstNameCode() != 0) {
        f += getFirstNameCode();
      } else {
				f = getFirstInitialCode(firstName.substring(0,1));
			}
			f += getMiddleInitialCode();
			result += f;
      return String.format("%03d", new Integer(result));  
    }
    
	// COMPLETE THE DDD CODE
    public String getDDD(){
			int result = 0;
			result += ((dob[0]-1)*31)+dob[1];
			if(!isMale){
				result+=600;
			}
			String res = "";
			res+=result;
      res = String.format("%03d", new Integer(res));
			return res;
    }
    
	// WRITE A METHOD THAT WILL RETURN THE ENTIRE DRIVER'S LICENSE NUMBER
		public String gN(){
      String str = "" + getSSSS() + getFFF() + String.format("%02d", new Integer(dob[2])) + getDDD();
      return str.substring(0,4) + "-" + str.substring(4,8) + "-" + str.substring(8,12);
    }

	// Do NOT change this code... but DO USE this code... it is tedious, and would not have had value for you to write it on your own.
    private int getFirstNameCode ()
    {
        int fff = 0;
        
        if (firstName.equals("ALBERT") ||
            firstName.equals("ALICE"))
        {
            fff = 20;
        }
        else if (firstName.equals("ANN") ||
            firstName.equals("ANNA") ||
            firstName.equals("ANNE")||
            firstName.equals("ANNIE")||
            firstName.equals("ARTHUR"))
        {
            fff = 40;
        }
        else if (firstName.equals("BERNARD") ||
            firstName.equals("BETTE") ||
            firstName.equals("BETTIE")||
            firstName.equals("BETTY"))
        {
            fff = 80;
        }
        else if (firstName.equals("CARL") ||
            firstName.equals("CATHERINE")) 
        {
            fff = 120;
        }
        else if (firstName.equals("CHARLES") ||
            firstName.equals("CLARA"))
        {
            fff = 140;
        }
        else if (firstName.equals("DORTHY") ||
            firstName.equals("DONALD"))
        {
            fff = 180;
        }
        else if (firstName.equals("EDWARD") ||
            firstName.equals("ELIZABETH")) 
        {
            fff = 220;
        }
        else if (firstName.equals("FLORENCE") ||
            firstName.equals("FRANK"))
        {
            fff = 260;
        }
        else if (firstName.equals("GEORGE") ||
            firstName.equals("GRACE")) 
        {
            fff = 300;
        }
        else if (firstName.equals("HAROLD") ||
            firstName.equals("HARRIET")) 
        {
            fff = 340;
        }
        else if (firstName.equals("HARRY") ||
            firstName.equals("HAZEL")) 
        {
            fff = 360;
        }
        else if (firstName.equals("JAMES") ||
            firstName.equals("JANE") ||
            firstName.equals("JAYNE"))
        {
            fff = 440;
        }
        else if (firstName.equals("JEAN") ||
            firstName.equals("JOHN"))
        {
            fff = 460;
        }
        else if (firstName.equals("JOAN") ||
            firstName.equals("JOSEPH"))
        {
            fff = 480;
        }
        else if (firstName.equals("MARGARET") ||
            firstName.equals("MARTIN"))
        {
            fff = 560;
        }
        else if (firstName.equals("MARVIN") ||
            firstName.equals("MARY"))
        {
            fff = 580;
        }
        else if (firstName.equals("MELVIN") ||
            firstName.equals("MILDRED"))
        {
            fff = 600;
        }
        else if (firstName.equals("PATRICIA") ||
            firstName.equals("PAUL"))
        {
            fff = 680;
        }
        else if (firstName.equals("RICHARD") ||
            firstName.equals("RUBY"))
        {
            fff = 740;
        }
        else if (firstName.equals("ROBERT") ||
            firstName.equals("RUTH"))
        {
            fff = 760;
        }
        else if (firstName.equals("THELMA") ||
            firstName.equals("THOMAS"))
        {
            fff = 820;
        }
        else if (firstName.equals("WALTER") ||
            firstName.equals("WANDA"))
        {
            fff = 900;
        }
        else if (firstName.equals("WILLIAM") ||
            firstName.equals("WILMA"))
        {
            fff = 920;
        }
        
        return fff;
    }
    
	// Do NOT change this code... but DO USE this code... it is tedious, and would not have had value for you to write it on your own.
    private int getFirstInitialCode(String firstInitial)
    {
        int fff = 0;
        
        if (firstInitial.equals("A")) fff = 0;
        else if (firstInitial.equals("B")) fff = 60;
        else if (firstInitial.equals("C")) fff = 100;
        else if (firstInitial.equals("D")) fff = 160;
        else if (firstInitial.equals("E")) fff = 200;
        else if (firstInitial.equals("F")) fff = 240;
        else if (firstInitial.equals("G")) fff = 280;
        else if (firstInitial.equals("H")) fff = 320;
        else if (firstInitial.equals("I")) fff = 400;
        else if (firstInitial.equals("J")) fff = 420;
        else if (firstInitial.equals("K")) fff = 500;
        else if (firstInitial.equals("L")) fff = 520;
        else if (firstInitial.equals("M")) fff = 540;
        else if (firstInitial.equals("N")) fff = 620;
        else if (firstInitial.equals("O")) fff = 640;
        else if (firstInitial.equals("P")) fff = 660;
        else if (firstInitial.equals("Q")) fff = 700;
        else if (firstInitial.equals("R")) fff = 720;
        else if (firstInitial.equals("S")) fff = 780;
        else if (firstInitial.equals("T")) fff = 800;
        else if (firstInitial.equals("U")) fff = 840;
        else if (firstInitial.equals("V")) fff = 860;
        else if (firstInitial.equals("W")) fff = 880;
        else if (firstInitial.equals("X")) fff = 940;
        else if (firstInitial.equals("Y")) fff = 960;
        else if (firstInitial.equals("Z")) fff = 980;
        
        return fff;
    }
    
	// Do NOT change this code... but DO USE this code... it is tedious, and would not have had value for you to write it on your own.
    private int getMiddleInitialCode()
    {
        int fff = 0;

        if (middleInitial.equals("A")) fff = 1;
        else if (middleInitial.equals("B")) fff = 2;
        else if (middleInitial.equals("C")) fff = 3;
        else if (middleInitial.equals("D")) fff = 4;
        else if (middleInitial.equals("E")) fff = 5;
        else if (middleInitial.equals("F")) fff = 6;
        else if (middleInitial.equals("G")) fff = 7;
        else if (middleInitial.equals("H")) fff = 8;
        else if (middleInitial.equals("I")) fff = 9;
        else if (middleInitial.equals("J")) fff = 10;
        else if (middleInitial.equals("K")) fff = 11;
        else if (middleInitial.equals("L")) fff = 12;
        else if (middleInitial.equals("M")) fff = 13;
        else if (middleInitial.equals("N")) fff = 14;
        else if (middleInitial.equals("O")) fff = 14;
        else if (middleInitial.equals("P")) fff = 15;
        else if (middleInitial.equals("Q")) fff = 15;
        else if (middleInitial.equals("R")) fff = 16;
        else if (middleInitial.equals("S")) fff = 17;
        else if (middleInitial.equals("T")) fff = 18;
        else if (middleInitial.equals("U")) fff = 18;
        else if (middleInitial.equals("V")) fff = 18;
        else if (middleInitial.equals("W")) fff = 19;
        else if (middleInitial.equals("X")) fff = 19;
        else if (middleInitial.equals("Y")) fff = 19;
        else if (middleInitial.equals("Z")) fff = 19;
        
        return fff;
    }

    public String toString() {
      return "NAME: " + (ANSI_PURPLE + getName() + ANSI_RESET) + "\n" +
      ("DOB: " + ANSI_GREEN + String.format("%02d", new Integer(dob[0])) + "/" + String.format("%02d", new Integer(dob[1])) + "/" + String.format("%02d", new Integer(dob[2])) + ANSI_RESET) + "\n" +
      ("GENDER: " + ANSI_RED + gender) + "\n" +
      (ANSI_BLUE + "\u001b[4m" + gN()) + ANSI_RESET + "\n" +
      ("");
    }

    // ("SSSS: " + ANSI_GREEN + getSSSS()+ ANSI_RESET) + "\n" +
    // ("FFF: " + ANSI_GREEN + getFFF()+ ANSI_RESET) + "\n" +
    // ("DDD: " + ANSI_GREEN + getDDD()+ ANSI_RESET) + "\n" +
}
