package model;

import model.Data.Orientation;

public class Sink implements RoadEnd {

	@Override
	public double getLastPosition() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CarAcceptor getNextRoad(Orientation orientation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Car car) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean accept(Car car, double d) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double distanceToObstacle(double firstPosition,
			Orientation orientation) {
		// TODO Auto-generated method stub
		return 0;
	}

}
