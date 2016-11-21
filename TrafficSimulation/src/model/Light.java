package model;


import model.Data.LightState;

public interface Light {
	
		public LightState getLightState(); 
		public void setLightState(LightState state);
		public boolean getState();
		public void setState(boolean state);
		public Long getGreenTimeNS();
		public void setGreenTimeNS(Long greenTime);
		public Long getGreenTimeEW();
		public void setGreenTimeEW(Long greenTime);
		public Long getYellowTimeNS();
		public void setYellowTimeNS(Long yellowTime);
		public Long getYellowTimeEW();
		public void setYellowTimeEW(Long yellowTime);
		
}
/*
public class Light implements Agent {
	Light() { } // Created only by this package

	private boolean state;

	public boolean getState() {
		return state;
	}
	public void run(double time) {
		if (time%40==0) {
			state = !state;
		}
	}
}
*/
