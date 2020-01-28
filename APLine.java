public class APLine{
	private double a;
	private double b;
	private double c;
	public APLine(double valA, double valB, double valC){
		a = valA;
		b = valB;
		c = valC;
	}
	public double getSlope(){
		return ((-1*(a))/b);
	}
	public boolean isOnLine(double x, double y){
		if(((a*x)+(b*y)+c)==0){
			return true;
		}
		return false;
	}
}