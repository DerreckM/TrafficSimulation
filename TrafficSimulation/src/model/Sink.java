package model;

import model.Data.Orientation;

final class Sink implements RoadEnd {

	@Override
	public double getLastPosition() {
		// TODO Auto-generated method stub
		return Double.POSITIVE_INFINITY;
	}

	@Override
	public CarAcceptor getNextRoad(Orientation orientation) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean remove(Car car) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean accept(Car car, double firstPosition) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public double distanceToObstacle(double fromPosition,
			Orientation orientation) {
		// TODO Auto-generated method stub
		return Double.POSITIVE_INFINITY;
	}

	@Override
	public LightObject getLight() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setNextRoad(CarAcceptor l, Orientation ew) {
		throw new UnsupportedOperationException();
		
	}
	
	public Orientation getOrientation() {
		throw new UnsupportedOperationException();
	}

}
