package model;

import java.awt.Color;

import properties.PropertyBag;
import timeServer.TimeServer;
import model.Data.Orientation;



/**
 * A car remembers its position from the beginning of its road.
 * Cars have random velocity and random movement pattern:
 * when reaching the end of a road, the dot either resets its position
 * to the beginning of the road, or reverses its direction.
 */
public class Car implements Agent {
	Car() { } // Created only by this package

	//private boolean backAndForth = Math.round(Math.random())==1 ? true : false;
	//private double position = 0;  can probably omit this
	private double maxVelocity; //= (int) Math.ceil(Math.random() * MP.maxVelocity);
	private java.awt.Color color = new java.awt.Color((int)Math.ceil(Math.random()*255),(int)Math.ceil(Math.random()*255),(int)Math.ceil(Math.random()*255));
	private CarAcceptor currentRoad;  //reference to current road interface
	private RoadEnd currentIntersection;
	private double firstPosition;  //reference to first car position (front of pack)
	private double stopDistance;
	private double brakeDistance;
	private boolean atIntersection;  // is car at an intersection?
	private double carLength;
	private double timeStep;
	private Integer roadsTraversed;
	private Orientation orientation;
	private PropertyBag propertyBag;
	private TimeServer time;
	
	//we need a constructor to create a new car object
	Car(Orientation orientation) {
		
		this.carLength = Math.random() * propertyBag.getCarLengthMax();
		this.carLength = Math.max(propertyBag.getCarLengthMin(), this.carLength);
		
		this.maxVelocity = Math.random() * propertyBag.getCarMaxVelocityMax();
		this.maxVelocity = Math.max(propertyBag.getCarMaxVelocityMin(), this.maxVelocity);
				
		this.stopDistance = Math.random() * propertyBag.getCarStopDistanceMax();
		this.stopDistance = Math.max(propertyBag.getCarStopDistanceMin(), this.stopDistance);
		this.stopDistance = Math.max(propertyBag.getCarLengthMax() / 2, this.stopDistance);
		
		
		this.brakeDistance = Math.random() * propertyBag.getCarBrakeDistanceMax();
		this.brakeDistance = Math.max(propertyBag.getCarBrakeDistanceMin(), this.brakeDistance);
		this.brakeDistance = Math.max(this.stopDistance, this.brakeDistance);
		
		this.color = getRandomColor();
		this.timeStep = propertyBag.getTimeStep();	
		this.firstPosition = 0.0;
		this.roadsTraversed = 0;
		
		this.orientation = orientation;
		this.time = this.propertyBag.getTimeServer();
	}
	
	public double getPosition() {
		return firstPosition;
	}
	public java.awt.Color getColor() {
		return color;
	}
	
	private Color getRandomColor() {
		return color;	
		
	}
	public void run(double time) {
		//setFirstPosition(changeVelocity);
		/*if (backAndForth) {
			if (((position + velocity) < 0) || ((position + velocity) > (MP.roadLength-MP.carLength)))
				velocity *= -1;
		} else {
			if ((position + velocity) > (MP.roadLength-MP.carLength))
				position = 0;
		}
		position += velocity;*/
	}
	
	public double getCarVelocity() {
		return brakeDistance;
		
	}
	
	public CarAcceptor getCurrentRoad() {
 		return currentRoad;
 	}
	
	public double getCarLength() {
		return carLength;
	}
	
	public double getFirstPosition() {
		return firstPosition;
	}
	
	public double getStopDistance() {
		return stopDistance;
	}
	
	public double getBrakeDistance() {
		return brakeDistance;
	}
	
}
