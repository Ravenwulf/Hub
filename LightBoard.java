/* A4 */

public class LightBoard
{
  /** The lights on the board, where true represents on and false represents off.
   */
  public boolean[][] lights;

  /******************************** Part (a) ********************************/
  
  /** Constructs a LightBoard object having numRows rows and numCols columns.
   * Precondition: numRows > 0, numCols > 0
   * Postcondition: each light has a 40% probability of being set to on.
   */
  public LightBoard(int numRows, int numCols){
  	lights = new boolean[numRows][numCols];
  	int chance = 0;
  	for(int row = 0; row<lights.length;row++){
  		for(int col = 0;col<lights[row].length;col++){
  			chance = (int)((Math.random()*100)+1);
  			lights[row][col]=false;
  			if(chance<=40){
  				lights[row][col]=true;
  			}
  		}
  	}
  }

  /******************************** Part (b) ********************************/
  
  /** Evaluates a light in row index row and column index col and returns a status
   *  as described in part (b).
   *  Precondition: row and col are valid indexes in lights.
   */
  public boolean evaluateLight(int row, int col){
  	int count=0;
  	for(int nrow=0;nrow<lights.length;nrow++){
  		if(lights[nrow][col]){
  			count++;
  		}
  	}
  	if(lights[row][col]&&count%2==0){
  		return false;
  	}else if(!lights[row][col]&&count%3==0){
  		return true;
  	}else{
  		return lights[row][col];
  	}
  }

/* Test A4 */
  
  public String toString()
  {
    String s = "";
    for (int r = 0; r < lights.length; r++)
    {
      for (int c = 0; c < lights[0].length; c++)
        if (lights[r][c])
          s += "*";
        else
          s += ".";
      s += "\n";
    }
    return s;
  }
  
  
}