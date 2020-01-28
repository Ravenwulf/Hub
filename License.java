import java.util.*;
/* You only need to add a couple of lines at the bottom of the main method in this class.

Use these two sites for help understanding how an Illinois Driver's license number is created (these will be used in the Person class, not in this one)

http://www.highprogrammer.com/alan/numbers/dl_us_shared.html
http://www.highprogrammer.com/alan/numbers/soundex.html
*/


public class License {

  public License(){
    Scanner scan = new Scanner(System.in);
        
  //   System.out.println("Please enter your last name");
	// String lastName = "Washington";//scan.nextLine().toUpperCase();
	
	// System.out.println("Please enter your first name");
	// String firstName = "jonh";//scan.nextLine().toUpperCase();
	
	// System.out.println("Please enter your middle initial... enter none if you don't have one");
	// String middleName = "";//scan.nextLine().toUpperCase();
	
	// System.out.println("Please enter your birthday in the following format mm/dd/yy");
	// String birthday = "01/01/01"; // scan.nextLine();
	
	// // This code separates the user's birthday into year, month, and day
	// int year = Integer.parseInt(birthday.substring(6,8));
	// int month = Integer.parseInt(birthday.substring(0,2));
	// int day = Integer.parseInt(birthday.substring(3,5));
	
	// System.out.println("Please tell me if you are male or female (enter m or f only)");
	// String gender = "m"; // scan.nextLine().toUpperCase();

	// DO THIS...
	// Create a Person and print out their driver's license number
    Person[] people = new Person[]{
      // new Person("Washington", "P", "Matt", "M", 1, 1, 12),
      // new Person("Wu", "", "Matt", "M", 2, 1, 1),
      // new Person("DeSmet", "H", "Edward", "M", 11, 1, 48),
      // new Person("Jackson", "", "Janet", "F", 5, 16, 66),
      // new Person("Ashcroft", "", "Janet", "F", 5, 16, 66),
			// new Person("Gutierrez", "E", "Ansel", "M", 1,1,12),
			// new Person("Pfister", "", "Henry", "M", 1,1,12),
			// new Person("Tymczak", "", "Zamek", "M", 1,1,12),
			// new Person("Ashcraft", "", "Mark", "M", 1,1,12),
			// new Person("Ack", "", "Marilyn", "M", 1,1,12),
			// new Person("Jarmula", "", "Maximillian", "M", 5,27,04),
			// new Person("Case", "J", "Joseph", "M", 9,18,03),
			// new Person("Hutchison", "E", "Ethan","M", 3,11,04),
			// new Person("Reincke", "P", "Evan", "M", 1,2,04),
			//new Person("Pezzella", "", "Adriano", "M", 11, 28, 68),
			new Person("Bryczek", "D", "Grant", "M", 9,2,03),

			
    };
    for(Person p : people) {
      System.out.println(p);
      
    }
  }
}