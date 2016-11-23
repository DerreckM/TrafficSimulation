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
	private Double carGenerationDelayMax = 10.0;
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
	private Double runTime = 1000.0;
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
	
	public Integer getGridRow() {
		return gridRow;
	}

	public void setGridRow(Integer gridRow) {
		this.gridRow = gridRow;
	}

	public Integer getGridColumn() {
		return gridColumn;
	}

	public void setGridColumn(Integer gridColumn) {
		this.gridColumn = gridColumn;
	}
	
	public TrafficType gettrafficPattern() {
		return trafficPattern;
	}

	public void setTrafficPattern(TrafficType trafficPattern) {
		this.trafficPattern = trafficPattern;
	}
	
	public Double getIntersectionLengthMin() {
		return intersectionLengthMin;
	}

	public void setIntersectionLengthMin(Double intersectionLengthMin) {
		this.intersectionLengthMin = intersectionLengthMin;
	}

	public Double getIntersectionLengthMax() {
		return intersectionLengthMax;
	}

	public void setIntersectionLengthMax(Double intersectionLengthMax) {
		this.intersectionLengthMax = intersectionLengthMax;
	}
	
	public Double getCarLengthMin() {
		return carLengthMin;
	}

	public void setCarLengthMin(Double carLengthMin) {
		this.carLengthMin = carLengthMin;
	}

	public Double getcarLengthMax() {
		return carLengthMax;
	}

	public void setCarLengthMax(Double carLengthMax) {
		this.carLengthMax = carLengthMax;
	}
	

	public double getCarMaxVelocityMax() {
		return carMaxVelocityMax;
	}

	public double getCarMaxVelocityMin() {
		return carMaxVelocityMin;
	}
	
	public void setCarMaxVelocityMin(Double carMaxVelocityMin) {
		this.carMaxVelocityMin = carMaxVelocityMin;
	}

	public void setCarMaxVelocityMax(Double carMaxVelocityMax) {
		this.carMaxVelocityMax = carMaxVelocityMax;
	}

	public double getCarStopDistanceMax() {
		return carStopDistanceMax;
	}

	public double getCarStopDistanceMin() {
		return carStopDistanceMin;
	}

	public double getcarBrakeDistanceMax() {
		return carBrakeDistanceMax;		
	}

	public void setcarBrakeDistanceMin(Double carBrakeDistanceyMin) {
		this.carBrakeDistanceMin = carBrakeDistanceyMin;
	}
	
	public void setcarBrakeDistanceMax(double carBrakeDistanceyMax) {
		this.carBrakeDistanceMax = carBrakeDistanceyMax;		
	}

	public void setCarStopDistanceMin(Double carStopDistanceyMin) {
		this.carStopDistanceMin = carStopDistanceyMin;
	}

	public void setCarStopDistanceMax(Double carStopDistanceyMax) {
		this.carStopDistanceMax = carStopDistanceyMax;
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
	
	public void setRoadLengthMax(Double roadLengthMax) {
		this.roadLengthMax = roadLengthMax;
	}
	
	public void setRoadLengthMin(Double roadLengthMin) {
		this.roadLengthMin = roadLengthMin;
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
	
	public Double getCarGenerationDelayMin() {
		return carGenerationDelayMin;
	}

	public void setCarGenerationDelayMin(Double carGenerationDelayMin) {
		this.carGenerationDelayMin = carGenerationDelayMin;
	}
	
	public Double getCarGenerationDelayMax() {
		return carGenerationDelayMax;
	}

	public void setCarGenerationDelayMax(Double carGenerationDelayMax) {
		this.carGenerationDelayMax = carGenerationDelayMax;
	}
	
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append("Simulation time step (seconds)        [" + this.getTimeStep() + "]\n");
		b.append("Simulation run time (seconds)        [" + this.getRunTime() + "]\n");
		b.append("Grid size (number of roads)          [row=" + this.getGridRow() + ",column=" + this.getGridColumn() + "]\n");
		String pattern = (this.gettrafficPattern() == TrafficType.ALTERNATE ? "Alternating" : "Simple");
		b.append("Traffic pattern                      [" + pattern + "]\n");
		b.append("Car entry rate (seconds/car)         [min=" + this.getCarGenerationDelayMin() + ",max=" + this.getCarGenerationDelayMax() + "]\n");
		b.append("Road segment length (meters)         [min=" + this.getRoadLengthMin() + ",max=" + this.getRoadLengthMax() + "]\n");
		b.append("Intersection length (meters)         [min=" + this.getIntersectionLengthMin() + ",max=" + this.getIntersectionLengthMax() + "]\n");
		b.append("Car length (meters)                  [min=" + this.getCarLengthMin() + ",max=" + this.getcarLengthMax() + "]\n");
		b.append("Car maximum velocity (meters/second) [min=" + this.getCarMaxVelocityMin() + ",max=" + this.getCarMaxVelocityMax() + "]\n");
		b.append("Car stop distance (meters)           [min=" + this.getCarStopDistanceMin() + ",max=" + this.getCarStopDistanceMax() + "]\n");
		b.append("Car brake distance (meters)          [min=" + this.getCarBrakeDistanceMin() + ",max=" + this.getcarBrakeDistanceMax() + "]\n");
		b.append("Traffic light green time (seconds)   [min=" + this.getLightGreenTimeMin() + ",max=" + this.getLightGreenTimeMax() + "]\n");
		b.append("Traffic light yellow time (seconds)  [min=" + this.getTrafficLightYellowTimeMin() + ",max=" + this.getLightYellowTimeMax() + "]\n");
		return b.toString();
	}

}
