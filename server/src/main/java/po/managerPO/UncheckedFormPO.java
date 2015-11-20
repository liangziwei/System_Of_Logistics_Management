package po.managerPO;

import java.io.Serializable;
import java.util.List;

import po.businessPO.ArrivalFormPO;
import po.businessPO.EntruckingPO;
import po.businessPO.ReceivablePO;
import po.businessPO.SendFormPO;
import po.deliveryPO.OrderPO;
import po.financePO.PaymentPO;
import po.repositoryPO.InRepositoryPO;
import po.repositoryPO.OutRepositoryPO;
import po.transitionPO.ReceivingPO;
import po.transitionPO.TransferringPO;

/**
 * 记录了未审批单据的信息
 * @author 张仁知
 */
public class UncheckedFormPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7692206600497076397L;

	/**
	 *未审批寄件单
	 */
	private List<OrderPO> orderlist;
	
	/**
	 *未审批装车单 
	 */
	private List<EntruckingPO> entruckinglist;
	/**
	 *未审批营业厅到达单 
	 */
	private List<ArrivalFormPO> arrivalformlist;
	/**
	 *未审批收款单 
	 */
	private List<ReceivablePO> receivablelist;
	/**
	 *未审批派件单
	 */
	private List<SendFormPO> sendformlist;
	/**
	 *未审批中转中心到达单 
	 */
	private List<ReceivingPO> receivinglist;
	/**
	 *未审批入库单 
	 */
	private List<InRepositoryPO> inrepositorylist;
	/**
	 *未审批中转单 
	 */
	private List<TransferringPO> transferringlist;
	/**
	 *未审批出库单 
	 */
	
    private List<OutRepositoryPO> outrepositorylist;
	/**
	 *未审批付款单 
	 */
	private List<PaymentPO> paymentlist;
	public UncheckedFormPO(List<OrderPO> orderlist,
			List<EntruckingPO> entruckinglist,
			List<ArrivalFormPO> arrivalformlist,
			List<ReceivablePO> receivablelist, List<SendFormPO> sendformlist,
			List<ReceivingPO> receivinglist,
			List<InRepositoryPO> inrepositorylist,
			List<TransferringPO> transferringlist,
			List<OutRepositoryPO> outrepositorylist, List<PaymentPO> paymentlist) {
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
	public List<OrderPO> getOrderlist() {
		return orderlist;
	}
	public void setOrderlist(List<OrderPO> orderlist) {
		this.orderlist = orderlist;
	}
	public List<EntruckingPO> getEntruckinglist() {
		return entruckinglist;
	}
	public void setEntruckinglist(List<EntruckingPO> entruckinglist) {
		this.entruckinglist = entruckinglist;
	}
	public List<ArrivalFormPO> getArrivalformlist() {
		return arrivalformlist;
	}
	public void setArrivalformlist(List<ArrivalFormPO> arrivalformlist) {
		this.arrivalformlist = arrivalformlist;
	}
	public List<ReceivablePO> getReceivablelist() {
		return receivablelist;
	}
	public void setReceivablelist(List<ReceivablePO> receivablelist) {
		this.receivablelist = receivablelist;
	}
	public List<SendFormPO> getSendformlist() {
		return sendformlist;
	}
	public void setSendformlist(List<SendFormPO> sendformlist) {
		this.sendformlist = sendformlist;
	}
	public List<ReceivingPO> getReceivinglist() {
		return receivinglist;
	}
	public void setReceivinglist(List<ReceivingPO> receivinglist) {
		this.receivinglist = receivinglist;
	}
	public List<InRepositoryPO> getInrepositorylist() {
		return inrepositorylist;
	}
	public void setInrepositorylist(List<InRepositoryPO> inrepositorylist) {
		this.inrepositorylist = inrepositorylist;
	}
	public List<TransferringPO> getTransferringlist() {
		return transferringlist;
	}
	public void setTransferringlist(List<TransferringPO> transferringlist) {
		this.transferringlist = transferringlist;
	}
	public List<OutRepositoryPO> getOutrepositorylist() {
		return outrepositorylist;
	}
	public void setOutrepositorylist(List<OutRepositoryPO> outrepositorylist) {
		this.outrepositorylist = outrepositorylist;
	}
	public List<PaymentPO> getPaymentlist() {
		return paymentlist;
	}
	public void setPaymentlist(List<PaymentPO> paymentlist) {
		this.paymentlist = paymentlist;
	}
	

}
