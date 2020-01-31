public class LightBoardStart {
	public LightBoardStart()
  {
    LightBoard sim = new LightBoard(7, 5);
    System.out.println(sim);
    System.out.println();

    String[] stars = {"**.**", "*..*.", "*..**", "*...*", "*...*", "**.**", "....."};
    boolean[][] lights = sim.lights;
    for (int r = 0; r < stars.length; r++)
      for (int c = 0; c < stars[0].length(); c++)
        lights[r][c] = stars[r].charAt(c) == '*';
    System.out.println(sim.evaluateLight(0, 3) + " " + sim.evaluateLight(6, 0) + " " +
                       sim.evaluateLight(4, 1) + " " + sim.evaluateLight(5, 4));
  }
}