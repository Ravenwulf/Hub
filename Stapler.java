public class Stapler
{


	//********Instance Variables********


	//DO NOT ADD, DO NOT CHANGE
	private int numStaples;		//how many staples in stapler
	private int capacity;		//how many staples it can hold
	private boolean isClosed;	//is stapler closed?


	//********Constructors********


	//No args constructor.
	//Set to: zero staples, capacity 250, closed.
	public Stapler()
	{
		numStaples = 0;
		capacity = 250;
		isClosed = true;
	}

	//Regular constructor.  Initialize instance variables with
	//provided values.  Assume user will use valid values for all.
	public Stapler(int staples, int cap, boolean closed)
	{
		numStaples = staples;
		capacity = cap;
		isClosed = closed;
	}

	//Copy constructor.  Initializes stapler with values provided
	//from another stapler.  Assume "temp" stapler has valid values.
	public Stapler(Stapler temp)
	{
		numStaples = temp.getNumStaples();
		capacity = temp.getCapacity();
		isClosed = temp.getIsClosed();


	}

	//********Accessor Methods (return values) ********

	//returns number of staples
	public int getNumStaples()
	{
		return numStaples;
	}

	//returns capacity of stapler
	public int getCapacity()
	{
		return capacity;
	}

	//returns open/closed status of stapler
	public boolean getIsClosed()
	{
		return isClosed;
	}

	//********Mutator Methods (change values) ********


	//Close the stapler
	public void closeStapler()
	{
		isClosed = true;
	}

	//Open the stapler
	public void openStapler()
	{
		isClosed = false;
	}

	//Subtract a single staple.  The stapler can
	//staple only when already closed AND when it HAS STAPLES.
	//**Both** conditions **must** be true to staple.
	//HINT:  Requires one or more IF statements.
	public void staple()
	{
		if(isClosed&&numStaples>0){
			numStaples -= 1;
		}
	}

	//Increase staples up to the maximum capacity.
	//The stapler must already be OPEN to add staples.
	//HINT: Requires IF statement(s) to make sure stapler is already open
	//and to make sure you fill it up to, BUT NOT BEYOND capacity.
	public void addStaples(int moreStaples)
	{
		if(!isClosed)
		{
			numStaples = capacity;
		}
	}



}