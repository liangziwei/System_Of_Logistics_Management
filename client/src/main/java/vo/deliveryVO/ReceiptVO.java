package vo.deliveryVO;

public class ReceiptVO {
	
//	订单条形码号、收件人姓名、收件日期
	
	private String orderID;
	
	private String name;
	
	private String date;

	public ReceiptVO(String orderID, String name, String date) {
		super();
		this.orderID = orderID;
		this.name = name;
		this.date = date;
	}

	String getOrderID() {
		return orderID;
	}

	String getName() {
		return name;
	}

	String getDate() {
		return date;
	}

}
