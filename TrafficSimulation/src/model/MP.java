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
	

	private double carLengthMin; 		// the minimum length of a car (in meters)
	private double carLengthMax; 		// the maximum length of a car (in meters)
	private double maxVelocityMin;		// the minimum top car velocity (in meters/second)
	private double maxVelocityMax;		// the maximum top car velocity (in meters/second)
	private double stopDistanceMin;		// the minimum distance away from others when car must stop (in meters) 
	private double stopDistanceMax;		// the maximum distance away from others when car must stop (in meters)
	private double brakeDistanceMin; 	// the minimum distance away from others when car must start braking (in meters) 
	private double brakeDistanceMax;	// the maximum distance away from others when car must start braking (in meters)

	
	public double getCarLengthMin() {
		return carLengthMin;
	}
	
	public double getCarLengthMax() {
		return carLengthMax;
	}
	
	public double getMaxVelocityMin() {
		return maxVelocityMin;
	}
	
	public double getMaxVelocityMax() {
		return maxVelocityMax;
	}
	
	public double getStopDistanceMin() {
		return stopDistanceMin;
	}
	
	public double getStopDistanceMax() {
		return stopDistanceMax;
	}
	
	public double getBrakeDistanceMin() {
		return brakeDistanceMin;
	}
	
	public double getBrakeDistanceMax() {
		return brakeDistanceMax;
	}
	
	public double createRandom(double min, double max){
		return min+(int)(Math.random() * ((max - min) + 1));
	}
	
}

