import java.lang.Math;
import java.util.*;
import java.util.concurrent.TimeUnit;
//TimeUnit.SECONDS.sleep(1);
public class BingoCard {
	private int[][] board = new int[5][5];
	private boolean[][] guessArr = new boolean[5][5];
	public String[][] boardS=new String[5][5];
	public String boardFull;
	Scanner scan = new Scanner(System.in);

	// public void BingoCard(int[][] bingo){
	// 	board=bingo;
	// }
	public BingoCard(){
		// System.out.println("DEBUG:BINGOconstructor ");
		while(!checkDupes()){
			for(int row=0;row<board.length;row++){
				for(int col=0;col<board[row].length;col++){
					board[col][row]= (int) (((Math.random()*15)+((row*15)+1)));
				}

			}
		}
		// System.out.println("DEBUG:finished BINGOconstructor ");
		// for(int row=0;row<board.length;row++){
		// 	for(int col=0;col<board[row].length;col++){
		// 		System.out.print(board[row][col]+"\t");
		// 	}
		// }

	}

	public boolean checkDupes(){
		// System.out.println("DEBUG: duplicates");
		int count =0;
		for(int row=0;row<board.length;row++){
			for(int col=0;col<board[row].length;col++){
				if(count>1){
					return false;
				}
				count = 0;
				int temp=board[row][col];
				
				for(int row1=0;row1<board.length;row1++){
					for(int col1=0;col1<board[row].length;col1++){
						if(board[row1][col1]==temp){
							count++;
						}
					}
				}

			}
		}
		
	return true;
	}

	public void guess(int num){
		// System.out.println("DEBUG: guess");
		for(int row=0;row<board.length;row++){
			for(int col=0;col<board[row].length;col++){
				if(board[row][col]==num){
					guessArr[row][col]=true;
				}
			}
		}
	}

	public String toBoardString(){
		// System.out.println("DEBUG: toString");
		for(int row=0;row<boardS.length;row++){
			for(int col=0;col<boardS[row].length;col++){
				boardS[row][col]=Integer.toString(board[row][col]);
			}
		}
		boardFull+="\033[2J"+"\n";
		boardFull+= "B"+"\t"+"I"+"\t"+"N"+"\t"+"G"+"\t"+"O"+"\n";
		for(int row=0;row<boardS.length;row++){
			for(int col=0;col<boardS[row].length;col++){
				if(guessArr[row][col]){
					boardFull+="\033[1;91m"+boardS[row][col]+"\t"+"\u001B[0m";
				}else{
					boardFull+=boardS[row][col]+"\t";
				}
			}
			boardFull+="\n";
		}
		System.out.print(boardFull);
		return boardFull;
	}

	public void inputNum(){
		boolean finished=false;
		int input;
		int countRow=0;
		int countCol=0;
		int countDiag=0;
		int windex=0;
		String wintype="";
		while(!finished){
			System.out.print("\nInput number: ");
			input=scan.nextInt();
			guess(input);
			toBoardString();
			for(int row=0;row<guessArr.length;row++){
				countRow=0;
				for(int col=0;col<guessArr[row].length;col++){
					if(guessArr[row][col]){
						countRow++;
					}
					if(countRow>=5){
						finished=true;
						windex=row;
						wintype="ROW";
					}
				}
			}
			
			for(int col=0;col<5;col++){
				countCol=0;
				for(int row=0;row<guessArr.length;row++){
					if(guessArr[row][col]){
						countCol++;
					}
					if(countCol>=5){
						finished=true;
						windex=col;
						wintype="COL";
					}
				}
			}
			countCol=0;
			countRow=0;
			countDiag=0;
			for(int i=0;i<5;i++){
				if(guessArr[i][i]){
					countDiag++;
				}
				if(countDiag>=5){
					finished=true;
					wintype="diagL";
				}
			}
			countDiag=0;
			for(int i=4;i>=0;i--){
				if(guessArr[4-i][i]){
					countDiag++;
				}
				if(countDiag>=5){
					finished=true;
					wintype="diagR";
					
				}

			}
		}
		winSequence(wintype, windex);
		System.out.println("\033[0;96m"+"BINGO!");
	}

	public void autoGsr(){
		boolean finished=false;
		int input;
		int countRow=0;
		int countCol=0;
		int countDiag=0;
		int windex=0;
		String wintype="";
		while(!finished){
			try{
				Thread.sleep(1000);
			}
			catch(InterruptedException ex){
				Thread.currentThread().interrupt();
			}
			input=((int) (Math.random()*75)+1);
			guess(input);
			toBoardString();
			for(int row=0;row<guessArr.length;row++){
				countRow=0;
				for(int col=0;col<guessArr[row].length;col++){
					if(guessArr[row][col]){
						countRow++;
					}
					if(countRow>=5){
						finished=true;
						windex=row;
						wintype="ROW";
					}
				}
			}
			
			for(int col=0;col<5;col++){
				countCol=0;
				for(int row=0;row<guessArr.length;row++){
					if(guessArr[row][col]){
						countCol++;
					}
					if(countCol>=5){
						finished=true;
						windex=col;
						wintype="COL";
					}
				}
			}
			countCol=0;
			countRow=0;
			countDiag=0;
			for(int i=0;i<5;i++){
				if(guessArr[i][i]){
					countDiag++;
				}
				if(countDiag>=5){
					finished=true;
					wintype="diagL";
				}
			}
			countDiag=0;
			for(int i=4;i>=0;i--){
				if(guessArr[4-i][i]){
					countDiag++;
				}
				if(countDiag>=5){
					finished=true;
					wintype="diagR";
					
				}

			}
		}
		winSequence(wintype, windex);
		System.out.println("\033[0;96m"+"BINGO!");
	}

	public void autoGsrPlus(){
		boolean finished=false;
		int input;
		int countRow=0;
		int countCol=0;
		int countDiag=0;
		int windex=0;
		String wintype="";
		while(!finished){
			try{
				Thread.sleep(1000);
			}
			catch(InterruptedException ex){
				Thread.currentThread().interrupt();
			}
			int[] slot={((int) (Math.random()*5)),((int) (Math.random()*5))};

			input=board[slot[0]][slot[1]];
			guess(input);
			toBoardString();
			for(int row=0;row<guessArr.length;row++){
				countRow=0;
				for(int col=0;col<guessArr[row].length;col++){
					if(guessArr[row][col]){
						countRow++;
					}
					if(countRow>=5){
						finished=true;
						windex=row;
						wintype="ROW";
					}
				}
			}
			
			for(int col=0;col<5;col++){
				countCol=0;
				for(int row=0;row<guessArr.length;row++){
					if(guessArr[row][col]){
						countCol++;
					}
					if(countCol>=5){
						finished=true;
						windex=col;
						wintype="COL";
					}
				}
			}
			countCol=0;
			countRow=0;
			countDiag=0;
			for(int i=0;i<5;i++){
				if(guessArr[i][i]){
					countDiag++;
				}
				if(countDiag>=5){
					finished=true;
					wintype="diagL";
				}
			}
			countDiag=0;
			for(int i=4;i>=0;i--){
				if(guessArr[4-i][i]){
					countDiag++;
				}
				if(countDiag>=5){
					finished=true;
					wintype="diagR";
					
				}

			}
		}
		winSequence(wintype, windex);
		System.out.println("\033[0;96m"+"BINGO!");
	}

	public void winSequence(String type, int windex){
		boardFull="";
		// System.out.println("DEBUG: toString");
		for(int row=0;row<boardS.length;row++){
			for(int col=0;col<boardS[row].length;col++){
				boardS[row][col]=Integer.toString(board[row][col]);
			}
		}
		boardFull+="\033[2J"+"\n";
		// System.out.println(boardFull+":DEBUG");
		boardFull+= "B"+"\t"+"I"+"\t"+"N"+"\t"+"G"+"\t"+"O"+"\n";
		if(type.equals("ROW")){
			for(int row=0;row<boardS.length;row++){
				for(int col=0;col<boardS[row].length;col++){
					if(row==windex){
						boardFull+="\033[0;93m"+boardS[row][col]+"\t"+"\u001B[0m";
					}else{
						boardFull+=boardS[row][col]+"\t";
					}
				}
				boardFull+="\n";
			}
		}else if(type.equals("COL")){
			for(int row=0;row<boardS.length;row++){
				for(int col=0;col<boardS[row].length;col++){
					if(col==windex){
						boardFull+="\033[0;93m"+boardS[row][col]+"\t"+"\u001B[0m";
					}else{
						boardFull+=boardS[row][col]+"\t";
					}
				}
				boardFull+="\n";
			}
		}else if(type.equals("diagL")){
			for(int row=0;row<boardS.length;row++){
				for(int col=0;col<boardS[row].length;col++){
					if(row==col){
						boardFull+="\033[0;93m"+boardS[row][col]+"\t"+"\u001B[0m";
					}else{
						boardFull+=boardS[row][col]+"\t";
					}
				}
				boardFull+="\n";
			}
		}else{
			for(int row=0;row<boardS.length;row++){
				for(int col=0;col<boardS[row].length;col++){
					if(4-col==row){
						boardFull+="\033[0;93m"+boardS[row][col]+"\t"+"\u001B[0m";
					}else{
						boardFull+=boardS[row][col]+"\t";
					}
				}
				boardFull+="\n";
			}
		}
		// System.out.printf("\033[2J"+"\n");
		System.out.print(boardFull);
	}
}

