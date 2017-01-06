package po.repositoryPO;

import java.io.Serializable;
import java.util.ArrayList;

import constant.AreaCodeType;
import dataService.Approvable;
import vo.repositoryVO.InRepositoryVO;

/**
 * 记录了入库单的信息
 * @author 阮威威
 */
public class InRepositoryPO implements Serializable, Approvable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7074545353878225576L;
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
	 * 中转中心编号
	 */
	private String transitionid;
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
	 * 是否经过审批
	 */
	private boolean isApproved = false;
	/**
	 * 是否审批通过
	 */
	private boolean isPassed = false;
	public InRepositoryPO(String deliveryid,String inrepositorydate,String arrivalid,
			AreaCodeType areaCode,String rowid,String shelfid,String posid,String transitionid) {
		// TODO Auto-generated constructor stub
		super();
		this.deliveryid=deliveryid;
		this.inrepositorydate=inrepositorydate;
		this.arrivalid=arrivalid;
		this.areaCode=areaCode;
		this.rowid=rowid;
		this.shelfid=shelfid;
		this.posid=posid;
		this.transitionid = transitionid;
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
	public void settransitionid(String transitionid) {
		this.transitionid = transitionid;
	}
	public String gettransitionid() {
		return transitionid;
	}
	
	public InRepositoryVO inRepositoryPOToVO() {
		return new InRepositoryVO(this.deliveryid, this.inrepositorydate, 
				this.arrivalid, this.areaCode, this.rowid, this.shelfid, this.posid,this.transitionid);
	}
	
	public static InRepositoryPO inRepositoryVOToPO(InRepositoryVO vo) {
		return new InRepositoryPO(vo.getdeliveryid(), vo.getinrepositorydate(), 
				vo.getarrivalid(), vo.getareaCode(), vo.getrowid(), vo.getshelfid(), vo.getposid(),vo.gettransitionid());
	}
	
	public static ArrayList<InRepositoryPO> inRepositoryVOListToPO(ArrayList<InRepositoryVO> list) {
		ArrayList<InRepositoryPO> po = new ArrayList<InRepositoryPO>();
		int size = list.size();
		for(int i = 0; i < size; i++) {
			po.add(inRepositoryVOToPO(list.get(i)));
		}
		return po;
	}
	
	public static ArrayList<InRepositoryVO> inRepositoryPOListToVO(ArrayList<InRepositoryPO> po) {
		ArrayList<InRepositoryVO> vo = new ArrayList<InRepositoryVO>();
		int size = po.size();
		for(int i = 0; i < size; i++) {
			vo.add(po.get(i).inRepositoryPOToVO());
		}
		return vo;
	}
	
	public static void try(){
	}
}
