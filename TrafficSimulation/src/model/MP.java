package model;

/**
 * Static class for model parameters.
 */
public class MP {
	private MP() {}
	/** Length of cars, in meters */
	public static double carLength = 10;
	
	/** Length of roads, in meters */
	public static double roadLength = 200;
	
	/** Maximum car velocity, in meters/second */
	public static double maxVelocity = 6;
	
	private double simTimeStep;  //How much model time elapses between each simulation step
	
	private int simRunTime;  	 //the length of the simulation in model seconds
	
	
}

