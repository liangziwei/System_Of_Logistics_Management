
package vo.repositoryVO;

import constant.AreaCodeType;
import vo.ApprovalFormVO;

/**
 * 记录了入库单的信息
 * @author 阮威威
 */
public class InRepositoryVO extends ApprovalFormVO{
	/**
	 * 快递的编号（十位数字）
	 */
	private String deliveryid;
	/**
	 * 入库日期（yyyy=mm-dd）
	 */
	private String inrepositorydate;
	/**
	 * 目的地
	 */
	private String arrivalid;
	/**
	 * 区号
	 */
	private AreaCodeType areaCode;
	/**
	 * 排号
	 */
	private String rowid;
	/**
	 * 架号
	 */
	private String shelfid;
	/**
	 * 位号
	 */
	private String posid;
	/**
	 * 是否在仓库中（true>>在，false>>不在）
	 */
	private boolean beinrepository;
	/**
	 * 错误信息
	 */
	private String errorMsg;
	/**
	 * 验证结果(查询)
	 */
	private boolean VerifyResult;
	/**
	 * 是否经过审批
	 */
	private boolean isApproved = false;
	/**
	 * 是否审批通过
	 */
	private boolean isPassed = false;
	public InRepositoryVO(String deliveryid,String inrepositorydate,String arrivalid,
			AreaCodeType areaCode,String rowid,String shelfid,String posid) {
		// TODO Auto-generated constructor stub
		super();
		this.deliveryid=deliveryid;
		this.inrepositorydate=inrepositorydate;
		this.arrivalid=arrivalid;
		this.areaCode=areaCode;
		this.rowid=rowid;
		this.shelfid=shelfid;
		this.posid=posid;
	}
	public void setdeliveryid(String deliveryid) {
		this.deliveryid=deliveryid;
	}
	public String getdeliveryid() {
		return deliveryid;
	}
	public void setinrepositorydate(String inrepositorydate) {
		this.inrepositorydate=inrepositorydate;
	}
	public String getinrepositorydate() {
		return inrepositorydate;
	}
	public void setarrivalid(String arrivalid) {
		this.arrivalid=arrivalid;
	}
	public String getarrivalid() {
		return arrivalid;
	}
	public void setareaCode(AreaCodeType areaCode) {
		this.areaCode=areaCode;
	}
	public AreaCodeType getareaCode() {
		return areaCode;
	}
	public void setrowid(String rowid) {
		this.rowid=rowid;
	}
	public String getrowid() {
		return rowid;
	}
	public void setshelfid(String shelfid) {
		this.shelfid=shelfid;
	}
	public String getshelfid() {
		return shelfid;
	}
	public void setposid(String posid) {
		this.posid=posid;
	}
	public String getposid() {
		return posid;
	}
	public void setbeinrepository(boolean beinrepository) {
		this.beinrepository=beinrepository;
	}
	public boolean getbeinrepository() {
		return beinrepository;
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
	public void seterrorMsg(String errorMsg) {
		this.errorMsg=errorMsg;
	}
	public String geterrorMsg() {
		return errorMsg;
	}
	public void setVerifyResult(boolean VerifyResult) {
		this.VerifyResult=VerifyResult;
	}
	public boolean getVerifyResult() {
		return VerifyResult;
	}
	@Override
	public String getDate() {
		return this.inrepositorydate;
	}
	
	public String getAreaCodeString() {
		switch(this.areaCode) {
		case MOTOAREA:
			return "机动区";
		case PLANEAREA:
			return "航运区";
		case TRAINAREA:
			return "铁运区";
		case TRUCKAREA:
			return "汽运区";
		}
		return "";
	}
}

