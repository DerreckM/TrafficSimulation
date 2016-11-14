package model;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import model.Data.Orientation;

/**
 * A road holds cars.
 */
public class Road implements CarAcceptor {
	
	
	
	@Override
	public boolean accept(Car c, Double firstPosition) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Double distanceToObstacle(Double fromPosition,
			Orientation orientation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getLastPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
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
