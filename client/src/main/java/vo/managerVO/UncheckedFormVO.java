package vo.managerVO;

import java.util.List;

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
	private List<OrderVO> orderlist;
	
	/**
	 *未审批装车单 
	 */
	private List<EntruckingVO> entruckinglist;
	/**
	 *未审批营业厅到达单 
	 */
	private List<ArrivalFormVO> arrivalformlist;
	/**
	 *未审批收款单 
	 */
	private List<ReceivableVO> receivablelist;
	/**
	 *未审批派件单
	 */
	private List<SendFormVO> sendformlist;
	/**
	 *未审批中转中心到达单 
	 */
	private List<ReceivingVO> receivinglist;
	/**
	 *未审批入库单 
	 */
	private List<InRepositoryVO> inrepositorylist;
	/**
	 *未审批中转单 
	 */
	private List<TransferringVO> transferringlist;
	/**
	 *未审批出库单 
	 */
	
    private List<OutRepositoryVO> outrepositorylist;
	/**
	 *未审批付款单 
	 */
	private List<PaymentVO> paymentlist;
	public UncheckedFormVO(List<OrderVO> orderlist,
			List<EntruckingVO> entruckinglist,
			List<ArrivalFormVO> arrivalformlist,
			List<ReceivableVO> receivablelist, List<SendFormVO> sendformlist,
			List<ReceivingVO> receivinglist,
			List<InRepositoryVO> inrepositorylist,
			List<TransferringVO> transferringlist,
			List<OutRepositoryVO> outrepositorylist, List<PaymentVO> paymentlist) {
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
	public List<OrderVO> getOrderlist() {
		return orderlist;
	}
	public void setOrderlist(List<OrderVO> orderlist) {
		this.orderlist = orderlist;
	}
	public List<EntruckingVO> getEntruckinglist() {
		return entruckinglist;
	}
	public void setEntruckinglist(List<EntruckingVO> entruckinglist) {
		this.entruckinglist = entruckinglist;
	}
	public List<ArrivalFormVO> getArrivalformlist() {
		return arrivalformlist;
	}
	public void setArrivalformlist(List<ArrivalFormVO> arrivalformlist) {
		this.arrivalformlist = arrivalformlist;
	}
	public List<ReceivableVO> getReceivablelist() {
		return receivablelist;
	}
	public void setReceivablelist(List<ReceivableVO> receivablelist) {
		this.receivablelist = receivablelist;
	}
	public List<SendFormVO> getSendformlist() {
		return sendformlist;
	}
	public void setSendformlist(List<SendFormVO> sendformlist) {
		this.sendformlist = sendformlist;
	}
	public List<ReceivingVO> getReceivinglist() {
		return receivinglist;
	}
	public void setReceivinglist(List<ReceivingVO> receivinglist) {
		this.receivinglist = receivinglist;
	}
	public List<InRepositoryVO> getInrepositorylist() {
		return inrepositorylist;
	}
	public void setInrepositorylist(List<InRepositoryVO> inrepositorylist) {
		this.inrepositorylist = inrepositorylist;
	}
	public List<TransferringVO> getTransferringlist() {
		return transferringlist;
	}
	public void setTransferringlist(List<TransferringVO> transferringlist) {
		this.transferringlist = transferringlist;
	}
	public List<OutRepositoryVO> getOutrepositorylist() {
		return outrepositorylist;
	}
	public void setOutrepositorylist(List<OutRepositoryVO> outrepositorylist) {
		this.outrepositorylist = outrepositorylist;
	}
	public List<PaymentVO> getPaymentlist() {
		return paymentlist;
	}
	public void setPaymentlist(List<PaymentVO> paymentlist) {
		this.paymentlist = paymentlist;
	}
	
}
