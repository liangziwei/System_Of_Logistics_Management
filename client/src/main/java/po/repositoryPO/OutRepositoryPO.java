package po.repositoryPO;

import java.io.Serializable;
import java.util.ArrayList;

import constant.LoadingType;
import vo.repositoryVO.OutRepositoryVO;

/**
 * 记录了出库单的信息
 * @author 阮威威
 */
public class OutRepositoryPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 924541203691224625L;
	/**
	 * 快递的编号（十位数字）
	 */
	private String deliveryid;
	/**
	 * 出库日期（yyyy=mm-dd）
	 */
	private String outrepositorydate;
	/**
	 * 目的地
	 */
	private String arrivalid;
	/**
	 * 装运方式
	 */
	private LoadingType way;
	/**
	 * 装运编号（中转中心编号+日期+0000四位数字）
	 */
	private String loadingid;
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
	public OutRepositoryPO(String deliveryid,String outrepositorydate,String arrivalid,
			LoadingType way,String loadingid) {
		// TODO Auto-generated constructor stub
		super();
		this.deliveryid=deliveryid;
		this.outrepositorydate=outrepositorydate;
		this.arrivalid=arrivalid;
		this.way=way;
		this.loadingid=loadingid;
	}
	public void setdeliveryid(String deliveryid) {
		this.deliveryid=deliveryid;
	}
	public String getdeliveryid() {
		return deliveryid;
	}
	public void setoutrepositorydate(String outrepositorydate) {
		this.outrepositorydate=outrepositorydate;
	}
	public String getoutrepositorydate() {
		return outrepositorydate;
	}
	public void setarrivalid(String arrivalid) {
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
	public void setloadingid(String loadingid) {
		this.loadingid=loadingid;
	}
	public String getloadingid() {
		return loadingid;
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
	
	public OutRepositoryVO outRepositoryPOToVO() {
		return new OutRepositoryVO(this.deliveryid, 
				this.outrepositorydate, this.arrivalid, this.way, this.loadingid);
	}
	
	public static OutRepositoryPO outRepositoryVOToPO(OutRepositoryVO vo) {
		return new OutRepositoryPO(vo.getdeliveryid(), vo.getoutrepositorydate(),
				vo.getarrivalid(), vo.getway(), vo.getloadingid());
	}
	
	public static ArrayList<OutRepositoryPO> outRepositoryVOListToPO(ArrayList<OutRepositoryVO> list) {
		ArrayList<OutRepositoryPO> po = new ArrayList<OutRepositoryPO>();
		int size = list.size();
		for(int i = 0; i < size; i++) {
			po.add(outRepositoryVOToPO(list.get(i)));
		}
		return po;
	}
	
	public static ArrayList<OutRepositoryVO>outRepositoryPOListToVO(ArrayList<OutRepositoryPO> po) {
		ArrayList<OutRepositoryVO> vo = new ArrayList<OutRepositoryVO>();
		int size = po.size();
		for(int i = 0; i < size; i++) {
			vo.add(po.get(i).outRepositoryPOToVO());
		}
		return vo;
	}
}
