package model;

/**
 * A car remembers its position from the beginning of its road.
 * Cars have random velocity and random movement pattern:
 * when reaching the end of a road, the dot either resets its position
 * to the beginning of the road, or reverses its direction.
 */
public class Car implements Agent {
	Car() { } // Created only by this package

	private boolean backAndForth = Math.round(Math.random())==1 ? true : false;
	private double position = 0;
	private double velocity = (int) Math.ceil(Math.random() * MP.maxVelocity);
	private java.awt.Color color = new java.awt.Color((int)Math.ceil(Math.random()*255),(int)Math.ceil(Math.random()*255),(int)Math.ceil(Math.random()*255));
	private CarAcceptor currentRoad;  //reference to current road interface
	private double firstPosition;  //reference to first car position (front of pack)
	private double stopDistance;
	
	public double getPosition() {
		return position;
	}
	public java.awt.Color getColor() {
		return color;
	}
	public void run(double time) {
		if (backAndForth) {
			if (((position + velocity) < 0) || ((position + velocity) > (MP.roadLength-MP.carLength)))
				velocity *= -1;
		} else {
			if ((position + velocity) > (MP.roadLength-MP.carLength))
				position = 0;
		}
		position += velocity;
	}
	
	public CarAcceptor getCurrentRoad(){
 		return currentRoad;
 	}
	
	public Double getFrontPosition() {
		return firstPosition;
	}
	
	public Double getStopDistance() {
		return stopDistance;
	}
}
