package properties;

import timeServer.TimeServer;
import timeServer.TimeServerLinked;

public class PropertyBag {
	public enum TrafficType {
		ALTERNATE, SIMPLE
	}

	private static PropertyBag pb = null;
	private TimeServer timeServer = new TimeServerLinked();

	private TrafficType trafficPattern = TrafficType.ALTERNATE;
	private Double carGenerationDelayMin = 5.0;
	private Double carGenerationDelayMax = 9.0;
	private Double roadLengthMin = 100.0;
	private Double roadLengthMax = 200.0;
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
	
	private Double timeStep = 0.5;
	private Double runTime = 500.0;
	private Integer gridRow = 2;
	private Integer gridColumn = 3;

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
		return carMaxVelocityMax;
	}

	public double getCarMaxVelocityMin() {
		return carMaxVelocityMin;
	}

	public double getCarStopDistanceMax() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getCarStopDistanceMin() {
		return carStopDistanceMin;
	}

	public double getCarBrakeDistanceMax() {
		return carStopDistanceMax;		
	}

	public double getCarBrakeDistanceMin() {
		return carBrakeDistanceMin;
	}

	public double getTimeStep() {
		return timeStep;
	}
	
	public void setTimeStep(Double timeStep) {
		this.timeStep = timeStep;
	}

	public double getRoadLengthMax() {
		return roadLengthMax;
	}
	
	public double getRoadLengthMin() {
		return roadLengthMin;	
	}
	
	public Double getLightGreenTimeMin() {
		return lightGreenTimeMin;
	}

	public void setLightGreenTimeMin(Double lightGreenTimeMin) {
		this.lightGreenTimeMin = lightGreenTimeMin;
	}

	public Double getLightGreenTimeMax() {
		return lightGreenTimeMax;
	}

	public void setLightGreenTimeMax(Double lightGreenTimeMax) {
		this.lightGreenTimeMax = lightGreenTimeMax;
	}

	public Double getTrafficLightYellowTimeMin() {
		return lightYellowTimeMin;
	}

	public void setLightYellowTimeMin(Double lightYellowTimeMin) {
		this.lightYellowTimeMin = lightYellowTimeMin;
	}

	public Double getLightYellowTimeMax() {
		return lightYellowTimeMax;
	}

	public void setLightYellowTimeMax(Double lightYellowTimeMax) {
		this.lightYellowTimeMax = lightYellowTimeMax;
	}

	public Double getRunTime() {
		return runTime;
	}

	public void setRunTime(Double runTime) {
		this.runTime = runTime;
	}

	public Object getTrafficPattern() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
