package po.constant;

import java.io.Serializable;

public class PackPrice implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2025616528072032768L;
	
	private double carton;
	
	private double wooden;
	
	private double courierBag;
	
	private double other;

	public PackPrice(double carton, double wooden, double courierBag, double other) {
		super();
		this.carton = carton;
		this.wooden = wooden;
		this.courierBag = courierBag;
		this.other = other;
	}

	public double getCarton() {
		return carton;
	}

	public void setCarton(double carton) {
		this.carton = carton;
	}

	public double getWooden() {
		return wooden;
	}

	public void setWooden(double wooden) {
		this.wooden = wooden;
	}

	public double getCourierBag() {
		return courierBag;
	}

	public void setCourierBag(double courierBag) {
		this.courierBag = courierBag;
	}

	public double getOther() {
		return other;
	}

	public void setOther(double other) {
		this.other = other;
	}
}
