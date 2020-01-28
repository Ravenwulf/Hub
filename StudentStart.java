public class StudentStart {
  public StudentStart() {
    // Create a student using no parameters (a no name student)
		Student student1 = new Student();
	
    // Create a student with your name and ID Number
    Student marcello = new Student("Marcello", 220893);
    
    // Print the name and ID number for both of your objects
    
    System.out.println(student1.getName() + "\n" + student1.getIDNumber());
    System.out.println(marcello.getName() + "\n" + marcello.getIDNumber());
    
    // Change the no name student to have your friend's info
		student1.setName("Alex");
		student1.setIDNumber(229384);
 
		// Print your friend's info to verify it is correct.   
    System.out.println(student1.getName() + "\n" + student1.getIDNumber());
    
    
  }
}