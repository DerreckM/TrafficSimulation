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
	private Color color; //= new java.awt.Color((int)Math.ceil(Math.random()*255),(int)Math.ceil(Math.random()*255),(int)Math.ceil(Math.random()*255));
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
	private PropertyBag propertyBag = PropertyBag.makePropertyBag();
	private TimeServer time;
	
	//we need a constructor to create a new car object
	Car(Orientation orientation) {
		
		this.carLength = Math.random() * propertyBag.getcarLengthMax();
		this.carLength = Math.max(propertyBag.getCarLengthMin(), this.carLength);
		
		this.maxVelocity = Math.random() * propertyBag.getCarMaxVelocityMax();
		this.maxVelocity = Math.max(propertyBag.getCarMaxVelocityMin(), this.maxVelocity);
				
		this.stopDistance = Math.random() * propertyBag.getCarStopDistanceMax();
		this.stopDistance = Math.max(propertyBag.getCarStopDistanceMin(), this.stopDistance);
		this.stopDistance = Math.max(propertyBag.getcarLengthMax() / 2, this.stopDistance);
		
		
		this.brakeDistance = Math.random() * propertyBag.getcarBrakeDistanceMax();
		this.brakeDistance = Math.max(propertyBag.getCarBrakeDistanceMin(), this.brakeDistance);
		this.brakeDistance = Math.max(this.stopDistance, this.brakeDistance);
		
		this.color = getRandomColor();
		this.timeStep = propertyBag.getTimeStep();	
		this.firstPosition = 0.0;
		this.roadsTraversed = 0;
		
		this.orientation = orientation;
		this.time = this.propertyBag.getTimeServer();
	}
	
	//we need to set the first car position and logic
	public void setFirstPosition(Double position) {
		double roadEnd = this.atIntersection ? this.currentIntersection.getLastPosition() : this.currentRoad.getLastPosition();
		if (position > roadEnd) {
			if (this.atIntersection) {
				RoadEnd currentIntersection = this.currentIntersection;
				this.currentIntersection.getNextRoad(this.orientation).accept(this, position - roadEnd);
				currentIntersection.remove(this);
				this.roadsTraversed++;
				return;
			}
			else {
				CarAcceptor road = this.currentRoad;
				this.currentRoad.getNextRoad(this.orientation).accept(this, position - roadEnd);
				road.remove(this);
				this.roadsTraversed++;
				return;
			}
		}
		else {
			this.firstPosition = position;
		}
	}
	

	public java.awt.Color getcolor() {
		return color;
	}
	
	private Color getRandomColor() {
		Color a = new java.awt.Color(255,255,50);
		Color b = new java.awt.Color(255,180,101);
		Color c = new java.awt.Color(50,255,255);
		Color d = new java.awt.Color(255,105,188);

		Double r = Math.random();
		
		if (r <= 0.25) {
			return a;
		}
		if (r <= 0.5) {
			return b;
		}
		if (r <= 0.75) {
			return c;
		}
		return d;
	}
	
	private double getCurrentVelocity() {
		double velocity;
		double distanceToObstacle;
		if (this.atIntersection) {
			distanceToObstacle = this.currentIntersection.distanceToObstacle(this.firstPosition, this.orientation);
		}
		else {
			 distanceToObstacle = this.currentRoad.distanceToObstacle(this.firstPosition, this.orientation);
		}
		if (distanceToObstacle == Double.POSITIVE_INFINITY) {
			return this.firstPosition + this.maxVelocity * this.timeStep;
		}
		if (distanceToObstacle < this.maxVelocity && 
				(distanceToObstacle > this.brakeDistance || distanceToObstacle > this.stopDistance))
			velocity = distanceToObstacle / 2;
		else {
			velocity = (this.maxVelocity / (this.brakeDistance - this.stopDistance))
					* (this.currentRoad.distanceToObstacle(this.firstPosition, this.orientation) - this.stopDistance);
		}
		velocity = Math.max(0.0, velocity);
		velocity = Math.min(this.maxVelocity, velocity);
		Double nextFrontPosition = this.firstPosition + velocity * this.timeStep;
		return nextFrontPosition;
	}

	
	public void run(double time) {
		double currentVelocity = getCurrentVelocity();
		setFirstPosition(currentVelocity);
		this.time.enqueue(this.time.currentTime() + this.timeStep, this);
	}
	
	public double getMaxVelocity() {
		return this.maxVelocity;
		
	}
	
	public CarAcceptor getCurrentRoad() {
 		return currentRoad;
 	}
	
	public double getCarLength() {
		return this.carLength;
	}
	
	public double getFirstPosition() {
		return this.firstPosition;
	}
	
	public double getLastPosition() {
		return this.firstPosition - this.carLength;
	}
	
	public double getStopDistance() {
		return stopDistance;
	}
	
	public double getBrakeDistance() {
		return this.brakeDistance;
	}
	
	public double getTimeStep() {
		return this.timeStep;
	}
	
	public double getRoadsTraversed() {
		return this.roadsTraversed;
	}
	
	public Orientation getOrientation() {
		return this.orientation;
	}
	
	public void setCurrentRoad(CarAcceptor roadCarIsOn) {
		this.currentRoad = roadCarIsOn;
		this.atIntersection = false;
	}
	
	public void setCurrentIntersection(RoadEnd intersectionCarIsAt) {
		this.currentIntersection = intersectionCarIsAt;
		this.atIntersection = true;
	}
}
