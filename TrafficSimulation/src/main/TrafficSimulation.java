package main;

import ui.UI;

//import model.Model;
//import model.swing.SwingAnimatorBuilder;
//import model.text.TextAnimatorBuilder;

// A static class to demonstrate the visualization aspect of simulation.
 
public class TrafficSimulation{
	private TrafficSimulation() {}
	public static void main(String[] args) {
		UI ui;
		ui = new ui.TextUI();
		SimpleTrafficSimulation simulation = new SimpleTrafficSimulation(ui);
		simulation.run();
/*		
		{
			Model m = new Model(new TextAnimatorBuilder(), 0, 1);
			m.run(10);
			m.dispose();
		}
		{
			Model m = new Model(new SwingAnimatorBuilder(), 0, 1);
			m.run(10);
			m.dispose();
		}
		{
			Model m = new Model(new TextAnimatorBuilder(), 1, 1);
			m.run(10);
			m.dispose();
		}
		{
			Model m = new Model(new SwingAnimatorBuilder(), 1, 1);
			m.run(10);
			m.dispose();
		}
		{
			Model m = new Model(new SwingAnimatorBuilder(), 2, 3);
			m.run(500);
			m.run(500);
			m.dispose();
		}
		System.exit(0);
	
*/
	}	
}

