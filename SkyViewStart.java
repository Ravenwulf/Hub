public class SkyViewStart {
  public SkyViewStart()
  {
    double[] scanned = {0.3, 0.7, 0.8, 0.4, 1.4, 1.1, 0.2, 0.5, 0.1, 1.6, 0.6, 0.9};
	int numRow = 4;
	int numCol = 3;
    SkyView test = new SkyView(numRow, numCol, scanned);

    for (int r = 0; r < numRow; r++)
    {
      for (int c = 0; c < numCol; c++)
      {
        System.out.printf("%3.1f ", test.getViewElem(r,c));
      }
      System.out.println();
    }

    System.out.println();
    System.out.println("Average = " + test.getAverage(1, 2, 0, 1));
    
    
    // 2nd test
    System.out.println("\n\n");
    double[] scanned2 = {0.3, 0.7, 0.8, 0.4, 1.4, 1.1, 0.2, 0.5, 0.1, 1.6, 0.6, 0.9, 1.4, 0.1, 0.7};
	numRow = 3;
	numCol = 5;
    SkyView test2 = new SkyView(numRow, numCol, scanned2);

    for (int r = 0; r < numRow; r++)
    {
      for (int c = 0; c < numCol; c++)
      {
        System.out.printf("%3.1f ", test2.getViewElem(r,c));
      }
      System.out.println();
    }

    System.out.println();
    System.out.println("Average = " + test2.getAverage(1, 2, 1, 1));
  }
}