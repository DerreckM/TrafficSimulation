package model;
import java.util.HashSet;
import java.util.Set;
import properties.PropertyBag;
import model.Data.Orientation;
import model.Data.LightState;

final class IntersectionObject implements RoadEnd {
	
	private double lastPosition;
	private CarAcceptor nextRoadNS;
	private CarAcceptor nextRoadEW;
	private PropertyBag propertyBag = PropertyBag.makePropertyBag();
	private LightObject light;
	private Set<Car> carsNS;
	private Set<Car> carsEW;

	
	IntersectionObject() {
		this.lastPosition = Math.random() * this.propertyBag.getIntersectionLengthMax();
		this.lastPosition = Math.max(this.lastPosition, this.propertyBag.getIntersectionLengthMin());
		this.carsNS = new HashSet<Car>();
		this.carsEW = new HashSet<Car>();
		this.light = Data.makeLight();
	}
	
	public LightObject getLight() {
		return this.light;
	}

	public boolean accept(Car c, double firstPosition) {
		if (c.getOrientation() == Orientation.EW)
			if(firstPosition> this.lastPosition) {
				return this.nextRoadEW.accept(c,firstPosition-this.lastPosition);
			} else {
				c.setCurrentIntersection(this);
				c.setFirstPosition(firstPosition);
				this.carsEW.add(c);
				return true;
			}
		else {
			if(firstPosition> this.lastPosition) {
				return this.nextRoadNS.accept(c,firstPosition-this.lastPosition);
			} else {
				c.setCurrentIntersection(this);
				c.setFirstPosition(firstPosition);
				this.carsNS.add(c);
				return true;
			}
		}
	}
	
	public double distanceToObstacle(double fromPosition,
			Orientation orientation) {
		if (orientation == Orientation.EW) {
			if (this.light.getLightState() == LightState.EWGREEN || this.light.getLightState() == LightState.EWYELLOW) {
				double obstaclePosition = this.distanceToObstacleBack(fromPosition, this.carsEW);
				if (obstaclePosition == Double.POSITIVE_INFINITY) {
					double distanceToEnd = this.lastPosition - fromPosition;
					obstaclePosition = nextRoadEW.distanceToObstacle(0.0, Orientation.EW) + distanceToEnd;
				}
				return obstaclePosition-fromPosition;	
			}
			else {
				return 0.0;
			}
		}

		else {
			if (this.light.getLightState() == LightState.NSGREEN || this.light.getLightState() == LightState.NSYELLOW) {
				double obstaclePosition = this.distanceToObstacleBack(fromPosition, this.carsNS);
				if (obstaclePosition == Double.POSITIVE_INFINITY) {
					double distanceToEnd = this.lastPosition - fromPosition;
					obstaclePosition = nextRoadNS.distanceToObstacle(0.0, Orientation.NS) + distanceToEnd;
				}
				return obstaclePosition-fromPosition;	
			}
			else {
				return 0.0;
			}
		}
	}
	
	public double getLastPosition() {
		return this.lastPosition;
	}

	public Orientation getOrientation() {
		throw new UnsupportedOperationException();
	}
	
	private double distanceToObstacleBack(Double fromPosition, Set<Car> cars) {
		double carLastPosition = Double.POSITIVE_INFINITY;
		for (Car c : cars)
			if (c.getLastPosition() >= fromPosition &&
			c.getLastPosition() < carLastPosition)
				carLastPosition = c.getLastPosition();
		return carLastPosition;
	}
	
	public CarAcceptor getNextRoad(Orientation orientation) {
		if (orientation == Orientation.EW){
			return this.nextRoadEW;
		}
		return this.nextRoadNS;
	}

	public void setNextRoad(CarAcceptor nextRoad, Orientation orientation) {
		if (orientation == Orientation.EW) {
			this.nextRoadEW = nextRoad;
			return;
		}
		this.nextRoadNS = nextRoad;
	}
	
	public boolean remove(Car car) {
		if (this.carsEW.contains(car)) {
			this.carsEW.remove(car);
			return true;
		}
		if (this.carsNS.contains(car)) {
			this.carsNS.remove(car);
			return true;
		}
		else {
			return false;
		}
	}

}
