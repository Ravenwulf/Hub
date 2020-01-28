public class Student
{
	private String name;
	private int idNumber;
	
	// No parameter constructor
	public Student()
	{
		// Complete this constructor
		name = "No Name";
		idNumber = 111111;
	}
	
	public Student(String nameC, int idNumberC)
	{
		name = nameC;
		idNumber = idNumberC;
	}
	
	// The following accessor and mutator (get/set) methods are written for you... you will use them in the Main class. They do not need to be edited.
	
	public void setName(String newName)
	{
		name = newName;
	}
	
	public void setIDNumber(int newIDNum)
	{
		idNumber = newIDNum;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getIDNumber()
	{
		return idNumber;
	}
}