package vo.deliveryVO;

public class GoodsInfo {

//	原件数、实际重量、内件品名、尺寸），
//	包装类型（纸箱、木箱、快递袋、其它，系统默认显示快递袋），
//	快递类型（经济快递、标准快递、特快，系统默认显示经济快递），
//	订单条形码号（10位，系统自动生成）），
//	订单的创建日期，
//	货物所在站点（寄件人营业厅、寄件人中转中心、收件人营业厅、收件人中转中心，收件人手中）
//	当前所在城市
	
	private int goodsNumber;
	
	private double weight;
	
	private String name;
	
	private String size;
	
	private String packageType;
	
	private String deliveryType;
	
	private String orderID;
	
	private String date;
	
	private String transitNode;
	
	private String location;

	public GoodsInfo(int goodsNumber, double weight, String name, String size,
			String packageType, String deliveryType,String orderID, 
			String date, String transitNode, String location) {
		super();
		this.goodsNumber = goodsNumber;
		this.weight = weight;
		this.name = name;
		this.size = size;
		this.packageType = packageType;
		this.deliveryType = deliveryType;
		this.orderID = orderID;
		this.date = date;
		this.transitNode = transitNode;
		this.location = location;
	}

	int getGoodsNumber() {
		return goodsNumber;
	}

	double getWeight() {
		return weight;
	}

	String getName() {
		return name;
	}

	String getSize() {
		return size;
	}

	String getPackageType() {
		return packageType;
	}

	String getDeliveryType() {
		return deliveryType;
	}

	String getOrderID() {
		return orderID;
	}

	String getDate() {
		return date;
	}

	String getTransitNode() {
		return transitNode;
	}

	String getLocation() {
		return location;
	}
	
}
