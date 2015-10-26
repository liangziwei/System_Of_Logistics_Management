package po.deliveryPO;

import java.io.Serializable;
import java.util.List;

import constant.DeliveryType;
import constant.PackageType;
import constant.TransitionNode;

/**
 * 记录了快递的货物信息
 * @author 肖安祥
 */
public class GoodsInfo implements Serializable{
	
	/**
	 * 重量
	 */
	private double weight;
	
	/**
	 * 物品名称
	 */
	private List<String> names;
	
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

	public GoodsInfo(String id, double weight, List<String> names, String size,
			PackageType packageType, DeliveryType deliveryType, String date,
			List<TransitionNode> transitNode) {
		super();
		this.id = id;
		this.weight = weight;
		this.names = names;
		this.size = size;
		this.packageType = packageType;
		this.deliveryType = deliveryType;
		this.date = date;
		this.transitNode = transitNode;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
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
	
}