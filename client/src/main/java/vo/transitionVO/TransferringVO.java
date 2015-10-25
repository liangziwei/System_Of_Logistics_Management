
package vo.transitionVO;

import java.util.List;

import constant.City;
import constant.LoadingType;

/**
 * 记录了装运单的信息
 * @author 阮威威
 */
public class TransferringVO {
	
	/**
	 * 装车（机）日期（yyyy-mm-dd）
	 */
	private String loadingdate;
	/**
	 * 本中转中心中转单编号（中转中心编号+日期+0000000七位数字）
	 */
	private String transferringid;
	/**
	 * 运送方式
	 */
	private LoadingType way;
	/**
	 * 车辆（或火车或飞机）代号
	 */
	private String wayid;
	/**
	 * 出发地
	 */
	private City departureid;
	/**
	 * 目的地
	 */
	private City arrivalid;
	/**
	 * 监装员
	 */
	private String  supervisionid;
	/**
	 * 货柜号
	 */
	private String containerid;
	/**
	 * 快递的条形码好（十位数字）
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
	public TransferringVO(String loadingdate,String transferringid,LoadingType way,String wayid,
			City departureid,City arrivalid,String supervisionid,
			String containerid,List<String> alldeliveryid) {
		// TODO Auto-generated constructor stub
		super();
		this.loadingdate=loadingdate;
		this.transferringid=transferringid;
		this.departureid=departureid;
		this.arrivalid=arrivalid;
		this.way=way;
		this.wayid=wayid;
		this.containerid=containerid;
		this.supervisionid=supervisionid;
		this.alldeliveryid=alldeliveryid;
	}
	public void setloadingdate(String loadingdate) {
		this.loadingdate=loadingdate;
	}
	public String getloadingdate() {
		return loadingdate;
	}public void settransferringid(String transferringid) {
		this.transferringid=transferringid;
	}
	public String gettransferringid() {
		return transferringid;
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
	public void setdepartureid(City departureid) {
		this.departureid=departureid;
	}
	public City  getdepartureid() {
		return departureid;
	}
	public void setarrivalid(City  arrivalid) {
			this.arrivalid=arrivalid;
	}
	public City getarrivalid() {
		return arrivalid;
	}
	public void setsupervisionid(String supervisionid) {
		this.supervisionid=supervisionid;
	}
	public String getsupervisionid() {
		return supervisionid;
	}
	public void setcontainerid(String containerid) {
			this.containerid=containerid;
	}
	public String getcontainerid() {
		return containerid;
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

