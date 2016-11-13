package model;

import java.util.List;
import java.util.ArrayList;

/**
 * A road holds cars.
 */
public class Road implements CarAcceptor {
	
	CarAcceptor nextAcceptor;
	
	Road() {   
		nextAcceptor = null;
	}  // Created only by this package
	
	
	private List<Car> cars = new ArrayList<Car>();

	public void accept(Car d) {
		if (d == null) { throw new IllegalArgumentException(); }
		cars.add(d);
	}
	public List<Car> getCars() {
		return cars;
	}
	
	@Override
	public boolean accept(Car c, Double firstPosition) {
		// TODO Auto-generated method stub
		return false;
	}
}
