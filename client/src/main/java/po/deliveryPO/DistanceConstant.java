package po.deliveryPO;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import constant.City;

public class DistanceConstant implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3986296629496079661L;

	private Map<City, HashMap<City, Double>> distance = new HashMap<City, HashMap<City, Double>>();

	public DistanceConstant(Map<City, HashMap<City, Double>> distance) {
		super();
		this.distance = distance;
	}

	public Map<City, HashMap<City, Double>> getDistance() {
		return distance;
	}

	public void setDistance(Map<City, HashMap<City, Double>> distance) {
		this.distance = distance;
	}
}
