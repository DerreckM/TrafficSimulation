package model;

import java.util.HashSet;
import java.util.Set;
import properties.PropertyBag;
import model.Data.Orientation;

/**
 * A road holds cars.
 */
final class Road implements CarAcceptor {
	
	private Set<Car> cars;
	private double lastPosition;
	private RoadEnd nextRoad;
	private PropertyBag propertyBag = PropertyBag.makePropertyBag();
	
	public Road() {
		this.lastPosition = Math.random() * this.propertyBag.getRoadLengthMax();
		this.lastPosition = Math.max(this.lastPosition, this.propertyBag.getRoadLengthMin());
		this.cars = new HashSet<Car>();
	}
	
	public boolean accept(Car car, double firstPosition) {
		if (this.cars != null) {
			this.cars.remove(car);
		}
		if(firstPosition> lastPosition) {
			return nextRoad.accept(car, firstPosition-lastPosition);
		} else {
			car.setCurrentRoad(this);
			car.setFirstPosition(firstPosition);
			cars.add(car);
			return true;
		}
	}
	
	public boolean remove(Car car) {
		if (this.cars.contains(car)) {
			this.cars.remove(car);
			return true;
		}
		else {
			return false;
		}
	}
	
	public double distanceToObstacle(double fromPosition, Orientation orientation) {
		double obstaclePosition = this.distanceToBackObstacle(fromPosition, orientation);
		if (obstaclePosition == Double.POSITIVE_INFINITY) {
			double distanceToEnd = this.lastPosition - fromPosition;
		obstaclePosition = nextRoad.distanceToObstacle(0.0, orientation) + distanceToEnd;
		return obstaclePosition;
		}
		return obstaclePosition - fromPosition;
	}
	
	public double distanceToBackObstacle(double fromPosition, Orientation orientation) {
		double carLastPosition = Double.POSITIVE_INFINITY;
		for (Car car : cars)
			if (car.getLastPosition() >= fromPosition && car.getLastPosition() < carLastPosition) {
				carLastPosition = car.getLastPosition();
			}
		return carLastPosition;
	}

	public double getLastPosition() {
		return lastPosition;
	}

	public RoadEnd getNextRoad(Orientation orientation) {
		return nextRoad;
	}

	public void setNextRoad(RoadEnd nextRoad) {
		this.nextRoad = nextRoad;		
	}

	public Set<Car> getCars() {
		return cars;
	}

	
}
