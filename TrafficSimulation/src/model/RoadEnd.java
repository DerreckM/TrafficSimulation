package model;

import model.Data.Orientation;

public interface RoadEnd {

	public double getLastPosition();
	public CarAcceptor getNextRoad(Orientation orientation);
	public void remove(Car car);
	public boolean accept(Car car, double d);
	public double distanceToObstacle(double firstPosition, Orientation orientation);
	public LightObject getLight();
	public void setNextRoad(CarAcceptor l, Orientation ew);

}
