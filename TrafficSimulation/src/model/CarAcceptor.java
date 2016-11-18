package model;

import java.util.Set;
import model.Data.Orientation;

public interface CarAcceptor {
	public boolean accept(Car car, double firstPosition);
	public double distanceToObstacle(double fromPosition, Orientation orientation);
	public double getLastPosition();
	public RoadEnd getNextRoad(Orientation orientation);
	public void setNextRoad(RoadEnd road);
	public boolean remove(Car car);
	public Set<Car> getCars();	
}
