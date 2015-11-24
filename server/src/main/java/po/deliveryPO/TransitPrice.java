package po.deliveryPO;

import java.io.Serializable;

public class TransitPrice implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2789270228284388431L;

	private double air;
	
	private double railway;
	
	private double road;

	public TransitPrice(double air, double railway, double road) {
		super();
		this.air = air;
		this.railway = railway;
		this.road = road;
	}

	public double getAir() {
		return air;
	}

	public void setAir(double air) {
		this.air = air;
	}

	public double getRailway() {
		return railway;
	}

	public void setRailway(double railway) {
		this.railway = railway;
	}

	public double getRoad() {
		return road;
	}

	public void setRoad(double road) {
		this.road = road;
	}
}
