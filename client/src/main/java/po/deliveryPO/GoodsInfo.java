package po.deliveryPO;

import java.io.Serializable;
import java.util.List;

import constant.City;
import constant.DeliveryType;
import constant.PackageType;
import constant.TransitionNode;

/**
 * 记录了快递的货物信息
 * @author 肖安祥
 */
public class GoodsInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -796289660796525400L;
	
	/**
	 *原件数 
	 */
	private String number;

	/**
	 * 重量
	 */
	private String weight;
	
	/**
	 * 物品名称
	 */
	private String name;
	
	/**
	 * 尺寸（长*宽*高）
	 */
	private String size;
	
	/**
	 * 包装类型（纸箱、木箱、快递袋、其它，系统默认显示快递袋）
	 */
	private PackageType packageType;
	
	/**
	 * 快递类型（经济快递、标准快递、特快，系统默认显示经济快递）
	 */
	private DeliveryType deliveryType;
	
	/**
	 * 订单条形码号（10位数字）
	 */
	private String id;
	
	/**
	 * 订单的创建日期（yyyy-mm-dd）
	 */
	private String date;
	
	/**
	 * 货物经过站点（寄件人营业厅、寄件人中转中心、收件人营业厅、收件人中转中心，收件人手中）
	 */
	private List<TransitionNode> transitNode;
	
	/**
	 * 货物所在城市
	 */
	private List<City> city;
	
	/**
	 * 快递预估到达时间
	 */
	private String time;
	
	/**
	 * 快递报价
	 */
	private String price;
	
	private boolean isApproved = false;
	
	private boolean isPassed = false;

	public GoodsInfo(String number, String id, String weight, String name, String size,
			PackageType packageType, DeliveryType deliveryType, String date,
			List<TransitionNode> transitNode, List<City> city, String time, String price) {
		super();
		this.number = number;
		this.id = id;
		this.weight = weight;
		this.name = name;
		this.size = size;
		this.packageType = packageType;
		this.deliveryType = deliveryType;
		this.date = date;
		this.transitNode = transitNode;
		this.city = city;
		this.time = time;
		this.price = price;
	}
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public PackageType getPackageType() {
		return packageType;
	}

	public void setPackageType(PackageType packageType) {
		this.packageType = packageType;
	}

	public DeliveryType getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(DeliveryType deliveryType) {
		this.deliveryType = deliveryType;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<TransitionNode> getTransitNode() {
		return transitNode;
	}

	public void setTransitNode(List<TransitionNode> transitNode) {
		this.transitNode = transitNode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<City> getCity() {
		return city;
	}

	public void setCity(List<City> city) {
		this.city = city;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	public boolean isPassed() {
		return isPassed;
	}

	public void setPassed(boolean isPassed) {
		this.isPassed = isPassed;
	}
}
