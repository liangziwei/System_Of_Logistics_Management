package po.deliveryPO;

import java.io.Serializable;

/**
 *收件信息的持久化对象
 *@author 肖安祥 
 */
public class ReceiptPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3655968395582871602L;
	
	/**
	 * 订单条形码号
	 */
	private String orderID;
	
	/**
	 * 收件人姓名
	 */
	private String name;
	
	/**
	 * 收件日期
	 */
	private String date;

	public ReceiptPO(String orderID, String name, String date) {
		super();
		this.orderID = orderID;
		this.name = name;
		this.date = date;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
