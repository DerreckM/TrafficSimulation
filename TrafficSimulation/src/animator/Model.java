package animator;

import java.util.List;
import java.util.ArrayList;
import java.util.Observable;
import properties.PropertyBag;
import timeServer.TimeServer;
import model.CarAcceptor;
import model.CarSource;
import model.Data;
import model.LightObject;
import model.RoadEnd;
import properties.PropertyBag.TrafficType;
import model.Data.Orientation;


// This model consists of roads that are organized in a matrix for a simple visualization
public class Model extends Observable {
	private Animator animator;
	private PropertyBag propertyBag;
	private TimeServer time;
	private boolean disposeOf;

	public Model(AnimatorBuilder builder, Integer rows, Integer columns) {
		this.propertyBag = PropertyBag.makePropertyBag();
		this.time = this.propertyBag.getTimeServer();
		if (rows < 0 || columns < 0 || (rows == 0 && columns == 0)) {
			throw new IllegalArgumentException();
		}
		if (builder == null) {
			builder = new NullAnimatorBuilder();
		}
		setup(builder, rows, columns);
		animator = builder.getAnimator();
		super.addObserver(animator);
		this.time.addObserver(animator);
	}

	public void run(double duration) {
		if (disposeOf)
			throw new IllegalStateException();
		this.time.run(this.propertyBag.getRunTime());
		super.setChanged();
		super.notifyObservers();
	}

	public void dispose() {
		animator.dispose();
		disposeOf = true;
	}

	private void setup(AnimatorBuilder builder, Integer rows, Integer columns) {
		List<CarAcceptor> roads = new ArrayList<CarAcceptor>();
		RoadEnd[][] intersections = new RoadEnd[rows][columns];

		// Logic for adding lights
		for (int i=0; i<rows; i++) {
			for (int j=0; j<columns; j++) {
				intersections[i][j] = Data.makeIntersection();
				builder.addLight(intersections[i][j], i, j);
				time.enqueue(this.time.currentTime(), intersections[i][j].getLight());
			}
		}

		// Logic for adding horizontal roads with alternating lights
		boolean eastToWest = false;
		for (int i=0; i<rows; i++) {
			CarSource carsource = Data.makeSource(Orientation.EW);
			if (eastToWest) {
				for (int j=columns; j>=0; j--) {
					CarAcceptor l = Data.makeRoad();
					if (j == columns) {
						carsource.setNextRoad(l);
						l.setNextRoad(intersections[i][j-1]);
					}
					else if (j == 0) {
						intersections[i][j].setNextRoad(l, Orientation.EW);
						l.setNextRoad(Data.makeSink());
					}
					else {
						intersections[i][j].setNextRoad(l, Orientation.EW);
						l.setNextRoad(intersections[i][j-1]);
					}

					builder.addHorizontalRoad(l, i, j, eastToWest);
					roads.add(l);
				}
			}
			else {
				for (int j=0; j<=columns; j++) {
					CarAcceptor l = Data.makeRoad();
					if (j == 0) {
						carsource.setNextRoad(l);
						l.setNextRoad(intersections[i][j]);
					}
					else if (j == columns) {
						intersections[i][j-1].setNextRoad(l, Orientation.EW);
						l.setNextRoad(Data.makeSink());
					}
					else {
						intersections[i][j-1].setNextRoad(l, Orientation.EW);
						l.setNextRoad(intersections[i][j]);
					}

					builder.addHorizontalRoad(l, i, j, eastToWest);
					roads.add(l);
				}
			}
			if (propertyBag.gettrafficPattern() == TrafficType.ALTERNATE) {
				eastToWest = !eastToWest;
			}
		}

		//	Logic for adding vertical roads with alternating lights
		boolean southToNorth = false;
		for (int j=0; j<columns; j++) {
			CarSource carsource = Data.makeSource(Orientation.NS);
			if (southToNorth) {
				for (int i=rows; i>=0; i--) {
					CarAcceptor l = Data.makeRoad();
					if (i == rows) {
						carsource.setNextRoad(l);
						l.setNextRoad(intersections[i-1][j]);
					}
					else if (i == 0) {
						intersections[i][j].setNextRoad(l, Orientation.NS);
						l.setNextRoad(Data.makeSink());
					}
					else {
						intersections[i][j].setNextRoad(l, Orientation.NS);
						l.setNextRoad(intersections[i-1][j]);
					}

					builder.addVerticalRoad(l, i, j, southToNorth);
					roads.add(l);
				}
			}
			else {
				for (int i=0; i<=rows; i++) {
					CarAcceptor l = Data.makeRoad();
					if (i == 0) {
						carsource.setNextRoad(l);
						l.setNextRoad(intersections[i][j]);	
					}
					else if (i == rows) {
						intersections[i-1][j].setNextRoad(l, Orientation.NS);
						l.setNextRoad(Data.makeSink());
					}
					else {
						intersections[i-1][j].setNextRoad(l, Orientation.NS);
						l.setNextRoad(intersections[i][j]);
					}

					builder.addVerticalRoad(l, i, j, southToNorth);
					roads.add(l);
				}
			}
			if (propertyBag.gettrafficPattern() == TrafficType.ALTERNATE) {
				southToNorth = !southToNorth;
			}
		}
	}
}