import java.util.Scanner;
public class Blin {
	public Blin(){
		MakeBlin();
	}
  public void MakeBlin() {
		//\u001B[0m
		int eggs;
		int eggsMin = 1;
		int milk;
		int milkMin = 100; //ml
		int flour;
		int flourMin = 100; //g
		Scanner scan = new Scanner(System.in);
    System.out.println("Hello \033[0;96mMarcello\u001B[0m\nBlinmaker is loading...\nHow many eggs do you have?\033[0;93m");
		eggs = scan.nextInt();
		System.out.println("\u001B[0mHow much milk do you have?\033[0;93m");
		milk=scan.nextInt();
		System.out.println("\u001B[0mHow much flour do you have?\033[0;93m");
		flour=scan.nextInt();
		int[] ingredients = {eggs, milk, flour, eggsMin, milkMin, flourMin};
		boolean blin = false;
		for(int i = 0; i<ingredients.length/2;i++){
			if(ingredients[i]>=ingredients[i+3]){
				blin=true;
				continue;
			}else{
				System.out.println("\033[1;91mNo blin today :(\u001B[0m");
				blin=false;
				break;
			}
		}
		if(blin){
			System.out.println("\u001B[0mYou can make at least one blin!\nLets see how many...");
			int eggAmount=eggs/eggsMin;
			int milkAmount=milk/milkMin;
			int flourAmount=flour/flourMin;
			int[] portions={eggAmount, milkAmount, flourAmount};
			int min=portions[0];
			String required="";
			for(int i=0;i<portions.length;i++){
				if(portions[i]<min){
					min=portions[i];
					if(i==0){
						required = "eggs";
					}else if(i==1){
						required = "ml of milk";
					}else{
						required = "grams of flour";
					}
				}
			}
			System.out.println("You have \033[0;93m"+eggAmount+"\u001B[0m portions of eggs\nYou have \033[0;93m"+milkAmount+"\u001B[0m portions of milk\nYou have \033[0;93m"+flourAmount+"\u001B[0m portions of flour\n\nThis means that you have \033[0;96m"+min+"\u001B[0m total blins worth of ingredients");
			if(required.equals("grams of flour")){
				System.out.println("To make your next blin, you will need \033[1;91m"+(flourMin-(flour-(flourAmount*100)))+"\u001B[0m more "+required);
			}
			if(required.equals("ml of milk")){
				System.out.println("To make your next blin, you will need \033[1;91m"+(milkMin-(milk-(milkAmount*100)))+"\u001B[0m more "+required);
			}
			if(required.equals("eggs")){
				System.out.println("To make your next blin, you will need \033[1;91m"+(eggsMin-(eggs-(eggAmount)))+"\u001B[0m more "+required);
			}
			

		}
  }
}