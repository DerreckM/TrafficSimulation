package model;

import properties.PropertyBag;
import timeServer.TimeServer;
import model.Data.Orientation;

final class CarSourceObject implements Agent, CarSource {
	
	private PropertyBag propertyBag = PropertyBag.makePropertyBag();
	private Double generateCarDelay;
	private CarAcceptor nextRoad;
	private TimeServer time;
	private Orientation orientation;
	
	CarSourceObject(Orientation orientation) {
		this.time = this.propertyBag.getTimeServer();
		this.orientation = orientation;
		
		this.generateCarDelay = Math.random() * propertyBag.getCarGenerationDelayMax();
		this.generateCarDelay = Math.max(propertyBag.getCarGenerationDelayMin(), this.generateCarDelay);
		
		this.time.enqueue(this.time.currentTime(), this);
	}

	public void run(double time) {
		Car c = Data.makeCar(orientation);
		if (this.nextRoad == null) {
			throw new NullPointerException("Next Road Was Not Set");
		}
		Boolean blocker = false;
		for (Car e : this.nextRoad.getCars()) {
			if (e.getFirstPosition() <= c.getCarLength() + c.getStopDistance()) {
				blocker = true;
			}
		}
		if (blocker == false) {
			this.nextRoad.accept(c, 0.0);
			this.time.enqueue(this.time.currentTime() + this.propertyBag.getTimeStep(), c);
		}
		this.time.enqueue(this.time.currentTime() + this.generateCarDelay, this);
	}
	
	public void setNextRoad(CarAcceptor l) {
		this.nextRoad = l;
	}
}
