package vo.transitionVO;

import state.CargoState;

/**
 * 记录了接收单的信息
 * @author 阮威威
 */
public class ReceivingVO {
	/**
	 * 中转中心编号（城市编号＋中转中心编号）
	 */
	private String transitionid;
	/**
	 * 到达日期(yyyy-mm-dd)
	 */
	private String arrivaldate;
	/**
	 * 中转单编号（年月日＋000000六位数字）
	 */
	private String transferringid;
	/**
	 * 出发地
	 */
	private String departureid;
	/**
	 * 目的地
	 */
	private String arrivalid;
	/**
	 * 货物到达状态（损坏、完整、丢失）
	 */
	private CargoState state;
	/**
	 * 是否经过审批
	 */
	private boolean isApproved = false;
	/**
	 * 是否审批通过
	 */
	private boolean isPassed = false;
	public ReceivingVO(String transitionid,String arrivaldate,String transferringid,
			String departureid,String arrivalid,CargoState state) {
		// TODO Auto-generated constructor stub
		super();
		this.transitionid=transitionid;
		this.transferringid=transferringid;
		this.arrivaldate=arrivaldate;
		this.arrivalid=arrivalid;
		this.departureid=departureid;
		this.state=state;
	}
	public void settransitionid(String transitionid) {
		this.transitionid=transitionid;
	}
	public String gettransitionid() {
		return transitionid;
	}
	public void setarrivaldate(String arrivaldate) {
		this.arrivaldate=arrivaldate;
	}
	public String getarrivaldate() {
		return arrivaldate;
	}
	public void settransferringid(String transferringid) {
		this.transferringid=transferringid;
	}
	public String gettransferringid() {
		return transferringid;
	}
	public void setdepartureid(String departureid) {
		this.departureid=departureid;
	}
	public String getdepartureid() {
		return departureid;
	}
	public void setarrivalid(String arrivalid) {
			this.arrivalid=arrivalid;
	}
	public String getarrivalid() {
		return arrivalid;
	}
	public void setstate(CargoState state) {
		this.state=state;
	}
	public CargoState getstate() {
		return state;
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
