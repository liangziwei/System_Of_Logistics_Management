package po.repositoryPO;

import constant.AreaCodeType;

/**
 * 记录了库存的信息
 * @author 阮威威
 */
public class RepositoryPO {
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
	public RepositoryPO(String deliveryid,String inrepositorydate,String arrivalid,
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
}
