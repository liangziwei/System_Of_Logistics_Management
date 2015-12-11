package po.constant;

import java.io.Serializable;

import constant.City;

/**
 * 一条城市距离记录
 */
public class DistanceItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5418690738331150683L;
	
	/**
	 *出发地 
	 */
	private City source;
	
	/**
	 *目的地 
	 */
	private City destination;
	
	/**
	 *距离 
	 */
	private double distance;
	
	public DistanceItem(City source, City destination, double distance) {
		this.source = source;
		this.destination = destination;
		this.distance = distance;
	}

	public City getSource() {
		return source;
	}

	public City getDestination() {
		return destination;
	}

	public double getDistance() {
		return distance;
	}
}

