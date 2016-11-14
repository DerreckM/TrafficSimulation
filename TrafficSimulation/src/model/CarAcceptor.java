package model;

import java.util.Set;
import model.Data.Orientation;

public interface CarAcceptor {
	public boolean accept(Car c, Double firstPosition);
	public Double distanceToObstacle(Double fromPosition, Orientation orientation);
	public Double getLastPosition();
	public RoadEnd getNextRoad(Orientation orientation);
	public void setNextRoad(RoadEnd road);
	public boolean remove(Car car);
	public Set<Car> getCars();	
}
