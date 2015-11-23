package po.repositoryPO;

import java.io.Serializable;

import constant.AreaCodeType;

/**
 * 记录了库存查询所需的信息
 * @author 阮威威
 */
public class RepositoryInfoPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2472228324955707314L;
	/**
	 * 快递的编号（十位数字）
	 */
	private String deliveryid;
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
	 * 快递金额
	 */
	private double money;
	public RepositoryInfoPO(String deliveryid,AreaCodeType areaCode,
			String rowid,String shelfid,String posid,boolean beinrepository) {
		// TODO Auto-generated constructor stub
		super();
		this.deliveryid=deliveryid;
		this.areaCode=areaCode;
		this.rowid=rowid;
		this.shelfid=shelfid;
		this.posid=posid;
		this.beinrepository=beinrepository;
	}
	public void setdeliveryid(String deliveryid) {
		this.deliveryid=deliveryid;
	}
	public String getdeliveryid() {
		return deliveryid;
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
	public void setmoney(double money) {
		this.money=money;
	}
	public double getmoney() {
		return money;
	}
}
