package po.deliveryPO;

import constant.City;

/**
 * 快递到达时间的历史记录的持久化对象
 * @author 肖安祥
 */
public class TimeRecordPO {

	/**
	 *快递出发地 
	 */
	private City source;
	
	/**
	 * 快递目的地
	 */
	private City destination;
	
	/**
	 *快递到达时间（天） 
	 */
	private int time;

	public TimeRecordPO(City source, City destination, int time) {
		super();
		this.source = source;
		this.destination = destination;
		this.time = time;
	}

	public City getSource() {
		return source;
	}

	public void setSource(City source) {
		this.source = source;
	}

	public City getDestination() {
		return destination;
	}

	public void setDestination(City destination) {
		this.destination = destination;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
}
