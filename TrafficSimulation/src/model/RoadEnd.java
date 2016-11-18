package model;

import model.Data.Orientation;

public interface RoadEnd {

	double getLastPosition();
	CarAcceptor getNextRoad(Orientation orientation);
	void remove(Car car);
	void accept(Car car, double d);
	double distanceToObstacle(double firstPosition, Orientation orientation);

}
