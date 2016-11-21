package model;

import properties.PropertyBag;
import timeServer.TimeServer;
import model.Data.LightState;
import model.Data.Orientation;

public class LightObject implements Agent, Light {

	private PropertyBag propertyBag = PropertyBag.makePropertyBag();
	private TimeServer time;
	private boolean state;
	private LightState lightState;
	private Long greenTimeNS;
	private Long yellowTimeNS;
	private Long greenTimeEW;
	private Long yellowTimeEW;

	

	public LightObject() {
		this.time = this.propertyBag.getTimeServer();

		this.greenTimeNS = Math.round(Math.random() * propertyBag.getLightGreenTimeMax());
		this.greenTimeNS = Math.round(Math.max(propertyBag.getLightGreenTimeMin(), this.getGreenTimeNS()));
		this.greenTimeEW = Math.round(Math.random() * propertyBag.getLightGreenTimeMax());
		this.greenTimeEW = Math.round(Math.max(propertyBag.getLightGreenTimeMin(), this.getGreenTimeEW()));

		this.yellowTimeNS = Math.round(Math.random() * propertyBag.getLightYellowTimeMax());
		this.yellowTimeNS = Math.round(Math.max(propertyBag.getTrafficLightYellowTimeMin(), this.getYellowTimeNS()));
		this.yellowTimeEW = Math.round(Math.random() * propertyBag.getLightYellowTimeMax());
		this.yellowTimeEW = Math.round(Math.max(propertyBag.getTrafficLightYellowTimeMin(), this.getYellowTimeEW()));

		this.lightState = LightState.EWGREEN;
		this.state = true;
		this.time.enqueue(this.time.currentTime() + this.greenTimeEW, this);
	} 

	public void run(double time) {
		switch (this.lightState) {
		case EWGREEN:	
			this.lightState = LightState.EWYELLOW;
			this.time.enqueue(this.time.currentTime() + this.yellowTimeEW, this);
			break;
		case EWYELLOW:	
			this.lightState = LightState.NSGREEN;
			this.time.enqueue(this.time.currentTime() + this.greenTimeNS, this);
			this.state = !this.state;
			break;
		case NSGREEN:	
			this.lightState = LightState.NSYELLOW;
			this.time.enqueue(this.time.currentTime() + this.yellowTimeNS, this);
			break;
		case NSYELLOW:	
			this.lightState = LightState.EWGREEN;
			this.time.enqueue(this.time.currentTime() + this.greenTimeEW, this);
			this.state = !this.state;
			break;	
		default:	
			this.lightState = LightState.EWGREEN;
			this.time.enqueue(this.time.currentTime() + this.greenTimeEW, this);
			break;
		}
	}

	public LightState getLightState() {
		return lightState;
	}
	public void setLightState(LightState state) {
		this.lightState = state;
	}
	public boolean getState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public Long getGreenTimeNS() {
		return greenTimeNS;
	}
	public void setGreenTimeNS(Long greenTime) {
		this.greenTimeNS = greenTime;
	}
	public Long getGreenTimeEW() {
		return greenTimeEW;
	}
	public void setGreenTimeEW(Long greenTime) {
		this.greenTimeEW = greenTime;
	}
	public Long getYellowTimeNS() {
		return yellowTimeNS;
	}
	public void setYellowTimeNS(Long yellowTime) {
		this.yellowTimeNS = yellowTime;
	}
	public Long getYellowTimeEW() {
		return yellowTimeEW;
	}
	public void setYellowTimeEW(Long yellowTime) {
		this.yellowTimeEW = yellowTime;
	}

	public Orientation getOrientation() {
		if (this.lightState == LightState.EWGREEN || this.lightState == LightState.EWYELLOW) {
			return Orientation.EW;
		}
		return Orientation.NS;
	}
}
