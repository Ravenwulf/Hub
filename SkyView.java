public class SkyView
{
  /** A rectangular array that holds the data representing a rectangular area of the sky. */
  private double[][] view;

  // Part(a)

  /** Constructs a SkyView object from a 1-dimensional array of scan data.
   *  @param numRows the number of rows represented in the view
   *         Precondition: numRows > 0
   *  @param numCols the number of columns represented in the view
   *         Precondition: numCols > 0
   *  @param scanned the scan data received from the telescope, stored in telescope order
   *         Precondition: scanned.length == numRows * numCols
   *  Postcondition: view has been created as a rectangular 2-dimensional array
   *                 with numRows rows and numCols columns and the values in
   *                 scanned have been copied to view and are ordered as
   *                 in the original rectangular area of sky.
   */
  public SkyView(int numRows, int numCols, double[] scanned){
  	view=new double[numRows][numCols];
  	boolean goingRight=true;
  	int index=0;
  	for(int row=0;row<numRows;row++){
  		for(int col=0;col<numCols;col++){
  			if(goingRight){
  				view[row][col]=scanned[index];
  			}else{
  				view[row][numCols-1-col]=scanned[index];
  			}
  			index++;
  		}
  		goingRight=!goingRight;
  	}
  }

  // Part(b)

  /** Returns the average of the values in a rectangular section of view.
   *  @param startRow the first row index of the section
   *  @param endRow the last row index of the section
   *  @param startCol the first column index of the section
   *  @param endCol the last column index of the section
   *  Precondition: 0 <= startRow <= endRow < view.length
   *  Precondition: 0 <= startCol <= endCol < view[0].length
   *  @return the average of the values in the specified section of view
   */
  public double getAverage(int startRow, int endRow, int startCol, int endCol){
    int count = 0;
    double sum = 0.0;
    for(int row = startRow;row<=endRow;row++){
    	for(int col=startCol;col<=endCol;col++){
    		sum+=view[row][col];
    		count++;
    	}
    }
    double average = sum/count;
    return average;
    
  }

  /*******************************************************************************/

  public double getViewElem(int r, int c) {
  	return view[r][c];
  }
}