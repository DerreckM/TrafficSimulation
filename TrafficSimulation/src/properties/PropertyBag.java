package properties;

import timeServer.TimeServer;
import timeServer.TimeServerLinked;

public class PropertyBag {
	public enum TrafficType {
		ALTERNATE, SIMPLE
	}

	private static PropertyBag pb = null;
	private TimeServer timeServer = new TimeServerLinked();

	private Double timeStep = 0.5;
	private Double runTime = 500.0;
	private Integer gridRow = 2;
	private Integer gridColumn = 3;
	private TrafficType trafficPattern = TrafficType.ALTERNATE;
	private Double carGenerationDelayMin = 5.0;
	private Double carGenerationDelayMax = 9.0;
	private Double roadSegmentLengthMin = 100.0;
	private Double roadSegmentLengthMax = 200.0;
	private Double intersectionLengthMin = 10.0;
	private Double intersectionLengthMax = 15.0;
	private Double carLengthMin = 10.0;
	private Double carLengthMax = 15.0;
	private Double carMaxVelocityMin = 10.0;
	private Double carMaxVelocityMax = 20.0;	
	private Double carStopDistanceMin = 1.0;
	private Double carStopDistanceMax = 5.0;
	private Double carBrakeDistanceMin = 1.5;
	private Double carBrakeDistanceMax = 10.0;
	private Double lightGreenTimeMin = 10.0;
	private Double lightGreenTimeMax = 20.0;
	private Double lightYellowTimeMin = 3.0;
	private Double lightYellowTimeMax = 5.0;	

	private PropertyBag() {

	}

	public static PropertyBag makePropertyBag() {
		if (PropertyBag.pb == null) {
			PropertyBag.pb = new PropertyBag();
		}
		return PropertyBag.pb;
	}

	public TimeServer getTimeServer() {
		return this.timeServer;
	}

	public double getCarLengthMax() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getCarLengthMin() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getCarMaxVelocityMax() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getCarMaxVelocityMin() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getCarStopDistanceMax() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getCarStopDistanceMin() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getCarBrakeDistanceMax() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getCarBrakeDistanceMin() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getTimeStep() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
