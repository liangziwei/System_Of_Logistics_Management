package vo.managerVO;

import java.util.ArrayList;

import vo.businessVO.ArrivalFormVO;
import vo.businessVO.EntruckingVO;
import vo.businessVO.ReceivableVO;
import vo.businessVO.SendFormVO;
import vo.deliveryVO.OrderVO;
import vo.financeVO.PaymentVO;
import vo.repositoryVO.InRepositoryVO;
import vo.repositoryVO.OutRepositoryVO;
import vo.transitionVO.ReceivingVO;
import vo.transitionVO.TransferringVO;


/**
 * 记录了未审批单据的信息
 * @author 张仁知
 */
public class UncheckedFormVO {
	/**
	 *未审批寄件单
	 */
	private ArrayList<OrderVO> orderlist;
	
	/**
	 *未审批装车单 
	 */
	private ArrayList<EntruckingVO> entruckinglist;
	/**
	 *未审批营业厅到达单 
	 */
	private ArrayList<ArrivalFormVO> arrivalformlist;
	/**
	 *未审批收款单 
	 */
	private ArrayList<ReceivableVO> receivablelist;
	/**
	 *未审批派件单
	 */
	private ArrayList<SendFormVO> sendformlist;
	/**
	 *未审批中转中心到达单 
	 */
	private ArrayList<ReceivingVO> receivinglist;
	/**
	 *未审批入库单 
	 */
	private ArrayList<InRepositoryVO> inrepositorylist;
	/**
	 *未审批中转单 
	 */
	private ArrayList<TransferringVO> transferringlist;
	/**
	 *未审批出库单 
	 */
	
    private ArrayList<OutRepositoryVO> outrepositorylist;
	/**
	 *未审批付款单 
	 */
	private ArrayList<PaymentVO> paymentlist;
	
	public UncheckedFormVO(ArrayList<OrderVO> orderlist,
			ArrayList<EntruckingVO> entruckinglist,
			ArrayList<ArrivalFormVO> arrivalformlist,
			ArrayList<ReceivableVO> receivablelist, ArrayList<SendFormVO> sendformlist,
			ArrayList<ReceivingVO> receivinglist,
			ArrayList<InRepositoryVO> inrepositorylist,
			ArrayList<TransferringVO> transferringlist,
			ArrayList<OutRepositoryVO> outrepositorylist, ArrayList<PaymentVO> paymentlist) {
		super();
		this.orderlist = orderlist;
		this.entruckinglist = entruckinglist;
		this.arrivalformlist = arrivalformlist;
		this.receivablelist = receivablelist;
		this.sendformlist = sendformlist;
		this.receivinglist = receivinglist;
		this.inrepositorylist = inrepositorylist;
		this.transferringlist = transferringlist;
		this.outrepositorylist = outrepositorylist;
		this.paymentlist = paymentlist;
	}
	public ArrayList<OrderVO> getOrderlist() {
		return orderlist;
	}
	public void setOrderlist(ArrayList<OrderVO> orderlist) {
		this.orderlist = orderlist;
	}
	public ArrayList<EntruckingVO> getEntruckinglist() {
		return entruckinglist;
	}
	public void setEntruckinglist(ArrayList<EntruckingVO> entruckinglist) {
		this.entruckinglist = entruckinglist;
	}
	public ArrayList<ArrivalFormVO> getArrivalformlist() {
		return arrivalformlist;
	}
	public void setArrivalformlist(ArrayList<ArrivalFormVO> arrivalformlist) {
		this.arrivalformlist = arrivalformlist;
	}
	public ArrayList<ReceivableVO> getReceivablelist() {
		return receivablelist;
	}
	public void setReceivablelist(ArrayList<ReceivableVO> receivablelist) {
		this.receivablelist = receivablelist;
	}
	public ArrayList<SendFormVO> getSendformlist() {
		return sendformlist;
	}
	public void setSendformlist(ArrayList<SendFormVO> sendformlist) {
		this.sendformlist = sendformlist;
	}
	public ArrayList<ReceivingVO> getReceivinglist() {
		return receivinglist;
	}
	public void setReceivinglist(ArrayList<ReceivingVO> receivinglist) {
		this.receivinglist = receivinglist;
	}
	public ArrayList<InRepositoryVO> getInrepositorylist() {
		return inrepositorylist;
	}
	public void setInrepositorylist(ArrayList<InRepositoryVO> inrepositorylist) {
		this.inrepositorylist = inrepositorylist;
	}
	public ArrayList<TransferringVO> getTransferringlist() {
		return transferringlist;
	}
	public void setTransferringlist(ArrayList<TransferringVO> transferringlist) {
		this.transferringlist = transferringlist;
	}
	public ArrayList<OutRepositoryVO> getOutrepositorylist() {
		return outrepositorylist;
	}
	public void setOutrepositorylist(ArrayList<OutRepositoryVO> outrepositorylist) {
		this.outrepositorylist = outrepositorylist;
	}
	public ArrayList<PaymentVO> getPaymentlist() {
		return paymentlist;
	}
	public void setPaymentlist(ArrayList<PaymentVO> paymentlist) {
		this.paymentlist = paymentlist;
	}
	
}
