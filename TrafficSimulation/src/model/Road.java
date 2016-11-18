package model;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import properties.PropertyBag;
import model.Data.Orientation;

/**
 * A road holds cars.
 */
public class Road implements CarAcceptor {
	
	private Set<Car> cars;
	private double lastPosition;
	private RoadEnd nextRoad;
	private PropertyBag propertyBag = PropertyBag.makePropertyBag();
	
	public Road() {
		this.lastPosition = Math.random() * this.propertyBag.getRoadLengthMax();
		this.lastPosition = Math.max(this.lastPosition, this.propertyBag.getRoadLengthMin());
		this.cars = new HashSet<Car>();
	}
	
	public boolean accept(Car c, Double firstPosition) {
		if (this.cars != null) {
			this.cars.remove(c);
		}
		if(firstPosition> lastPosition) {
			return nextRoad.accept(c, firstPosition-lastPosition);
		} else {
			c.setCurrentRoad(this);
			c.setFirstPosition(firstPosition);
			cars.add(c);
			return true;
		}
	}

	public Double distanceToObstacle(Double fromPosition,
			Orientation orientation) {
		// TODO Auto-generated method stub
		return null;
	}

	public Double getLastPosition() {
		return lastPosition;
	}

	public RoadEnd getNextRoad(Orientation orientation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setNextRoad(RoadEnd road) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean remove(Car car) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Car> getCars() {
		// TODO Auto-generated method stub
		return null;
	}
}
