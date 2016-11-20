package model;

public class Data {
	
	public enum Orientation {
		NS, EW
	}
	
	public enum LightState {
		NSGREEN, EWGREEN, NSYELLOW, EWYELLOW
	}

	public Data() {
		
	}
	
	static public final Car makeCar(Orientation orientation) {
		return new Car(orientation);
	}
	
	static public final Road makeRoad() {
		return new Road();
	}
	
	static public final RoadEnd makeIntersection() {
		return new IntersectionObject();
	}
	
	static public final RoadEnd makeSink() {
		return new Sink();
	}
	
	static public final LightObject makeLight() {
		return new LightObject();
	}
	
	static public final CarSource makeSource(Orientation orientation) {
		return new CarSourceObject(orientation);
	}
	
}
