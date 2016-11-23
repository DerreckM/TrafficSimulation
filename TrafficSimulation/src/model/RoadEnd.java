package model;

import model.Data.Orientation;

public interface RoadEnd {

	public double getLastPosition();
	public CarAcceptor getNextRoad(Orientation orientation);
	public boolean remove(Car car);   // my thread error was due to this being set void
	public boolean accept(Car car, double firstPosition);
	public double distanceToObstacle(double fromPosition, Orientation orientation);
	public LightObject getLight();
	public void setNextRoad(CarAcceptor nextRoad, Orientation orientation);
	public Orientation getOrientation();

}
