package po.transitionPO;

import java.io.Serializable;
import java.util.List;

import constant.LoadingType;


/**
 * 记录了装运单的信息
 * @author 阮威威
 */
public class LoadingPO implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 8421592450936238542L;
	/**
	 * 装运编号（中转中心编号+日期+0000四位数字）
	 */
	private String loadingid;
	/**
	 * 到达地（某营业厅）
	 */
	private String arrivalid;
	/**
	 * 装运方式
	 */
	private LoadingType way;
	/**
	 * 车辆（或火车或飞机）代号
	 */
	private String wayid;
	/**
	 * 监装员
	 */
	private String  supervisionid;
	/**
	 * 押运员
	 */
	private String supercargoid;
	/**
	 * 快递的条形码号（十位数字）
	 */
	private String deliveryid;
	/**
	 * 本次装箱所有货物的订单条形码号
	 */
	private List<String> alldeliveryid;
	/**
	 * 装运单的运费
	 */
	private double fare;
	/**
	 * 是否经过审批
	 */
	private boolean isApproved = false;
	/**
	 * 是否审批通过
	 */
	private boolean isPassed = false;
	public LoadingPO(String loadingid,String arrivalid,LoadingType way,
			String wayid,String  supervisionid,String supercargoid,List<String> alldeliveryid) {
		// TODO Auto-generated constructor stub
		super();
		this.loadingid=loadingid;
		this.arrivalid=arrivalid;
		this.way=way;
		this.wayid=wayid;
		this.supercargoid=supercargoid;
		this.supervisionid=supervisionid;
		this.alldeliveryid=alldeliveryid;
	}
	public void setloadingid(String loadingid) {
		this.loadingid=loadingid;
	}
	public String getloadingid() {
		return loadingid;
	}
	public void setarrivalid(String arrivalid){
		this.arrivalid=arrivalid;
	}
	public String getarrivalid() {
		return arrivalid;
	}
	public void setway(LoadingType way) {
		this.way=way;
	}
	public LoadingType getway() {
		return way;
	}
	public void setwayid(String wayid) {
		this.wayid=wayid;
	}
	public String getwayid() {
		return wayid;
	}
	public void setsupervisionid(String supervisionid) {
		this.supervisionid=supervisionid;
	}
	public String getsupervisionid() {
		return supervisionid;
	}
	public void setsupercargoid(String supercargoid) {
		this.supercargoid=supercargoid;
	}
	public String getsupercargoid() {
		return supercargoid;
	}
	public void setalldeliveryid(List<String> alldeliveryid) {
		this.alldeliveryid=alldeliveryid;
	}
	public List<String> getalldeliveryid() {
		return alldeliveryid;
	}
	public void setfare(double fare) {
		this.fare=fare;
	}
	public double getfare() {
		return fare;
	}
	public void setisApproved(boolean isApproved) {
		this.isApproved=isApproved;
	}
	public boolean getisApproved() {
		return isApproved;
	}
	public void setisPassed(boolean isPassed) {
		this.isPassed=isPassed;
	}
	public boolean getisPassed() {
		return isPassed;
	}
}
