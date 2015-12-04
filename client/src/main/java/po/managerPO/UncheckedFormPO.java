package po.managerPO;

import java.io.Serializable;
import java.util.ArrayList;

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
import vo.businessVO.ArrivalFormVO;
import vo.businessVO.EntruckingVO;
import vo.businessVO.ReceivableVO;
import vo.businessVO.SendFormVO;
import vo.deliveryVO.OrderVO;
import vo.financeVO.PaymentVO;
import vo.managerVO.UncheckedFormVO;
import vo.repositoryVO.InRepositoryVO;
import vo.repositoryVO.OutRepositoryVO;
import vo.transitionVO.ReceivingVO;
import vo.transitionVO.TransferringVO;

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
	private ArrayList<OrderPO> orderlist;
	
	/**
	 *未审批装车单 
	 */
	private ArrayList<EntruckingPO> entruckinglist;
	/**
	 *未审批营业厅到达单 
	 */
	private ArrayList<ArrivalFormPO> arrivalformlist;
	/**
	 *未审批收款单 
	 */
	private ArrayList<ReceivablePO> receivablelist;
	/**
	 *未审批派件单
	 */
	private ArrayList<SendFormPO> sendformlist;
	/**
	 *未审批中转中心到达单 
	 */
	private ArrayList<ReceivingPO> receivinglist;
	/**
	 *未审批入库单 
	 */
	private ArrayList<InRepositoryPO> inrepositorylist;
	/**
	 *未审批中转单 
	 */
	private ArrayList<TransferringPO> transferringlist;
	/**
	 *未审批出库单 
	 */
	
    private ArrayList<OutRepositoryPO> outrepositorylist;
	/**
	 *未审批付款单 
	 */
	private ArrayList<PaymentPO> paymentlist;
	public UncheckedFormPO(ArrayList<OrderPO> orderlist,
			ArrayList<EntruckingPO> entruckinglist,
			ArrayList<ArrivalFormPO> arrivalformlist,
			ArrayList<ReceivablePO> receivablelist, ArrayList<SendFormPO> sendformlist,
			ArrayList<ReceivingPO> receivinglist,
			ArrayList<InRepositoryPO> inrepositorylist,
			ArrayList<TransferringPO> transferringlist,
			ArrayList<OutRepositoryPO> outrepositorylist, ArrayList<PaymentPO> paymentlist) {
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
	
	public static  UncheckedFormVO uncheckedFormPOToVO(UncheckedFormPO po){
		ArrayList<OrderVO> order = OrderPO.orderPOListToVO(po.getOrderlist());
		ArrayList<EntruckingVO> entrucking = EntruckingPO.entruckingPOListToVO(po.getEntruckinglist());
		ArrayList<ArrivalFormVO> arrival = ArrivalFormPO.arrivalPOListToVO(po.getArrivalformlist());
		ArrayList<ReceivableVO> receivable = ReceivablePO.receivablePOListToVO(po.getReceivablelist());
		ArrayList<SendFormVO> send = SendFormPO.sendFormPOListToVO(po.getSendformlist());
		ArrayList<ReceivingVO> receiving = ReceivingPO.receivingPOListToVO(po.getReceivinglist());
		ArrayList<InRepositoryVO> in = InRepositoryPO.inRepositoryPOListToVO(po.getInrepositorylist());
		ArrayList<TransferringVO> transferring = TransferringPO.transferringPOListToVO(po.getTransferringlist());
		ArrayList<OutRepositoryVO> out = OutRepositoryPO.outRepositoryPOListToVO(po.getOutrepositorylist());
		ArrayList<PaymentVO> payment = PaymentPO.paymentPOListToVO(po.getPaymentlist());
		
		return new UncheckedFormVO(order, entrucking, arrival, receivable, send,
				receiving, in, transferring, out, payment);
	}
	
	public ArrayList<OrderPO> getOrderlist() {
		return orderlist;
	}
	public void setOrderlist(ArrayList<OrderPO> orderlist) {
		this.orderlist = orderlist;
	}
	public ArrayList<EntruckingPO> getEntruckinglist() {
		return entruckinglist;
	}
	public void setEntruckinglist(ArrayList<EntruckingPO> entruckinglist) {
		this.entruckinglist = entruckinglist;
	}
	public ArrayList<ArrivalFormPO> getArrivalformlist() {
		return arrivalformlist;
	}
	public void setArrivalformlist(ArrayList<ArrivalFormPO> arrivalformlist) {
		this.arrivalformlist = arrivalformlist;
	}
	public ArrayList<ReceivablePO> getReceivablelist() {
		return receivablelist;
	}
	public void setReceivablelist(ArrayList<ReceivablePO> receivablelist) {
		this.receivablelist = receivablelist;
	}
	public ArrayList<SendFormPO> getSendformlist() {
		return sendformlist;
	}
	public void setSendformlist(ArrayList<SendFormPO> sendformlist) {
		this.sendformlist = sendformlist;
	}
	public ArrayList<ReceivingPO> getReceivinglist() {
		return receivinglist;
	}
	public void setReceivinglist(ArrayList<ReceivingPO> receivinglist) {
		this.receivinglist = receivinglist;
	}
	public ArrayList<InRepositoryPO> getInrepositorylist() {
		return inrepositorylist;
	}
	public void setInrepositorylist(ArrayList<InRepositoryPO> inrepositorylist) {
		this.inrepositorylist = inrepositorylist;
	}
	public ArrayList<TransferringPO> getTransferringlist() {
		return transferringlist;
	}
	public void setTransferringlist(ArrayList<TransferringPO> transferringlist) {
		this.transferringlist = transferringlist;
	}
	public ArrayList<OutRepositoryPO> getOutrepositorylist() {
		return outrepositorylist;
	}
	public void setOutrepositorylist(ArrayList<OutRepositoryPO> outrepositorylist) {
		this.outrepositorylist = outrepositorylist;
	}
	public ArrayList<PaymentPO> getPaymentlist() {
		return paymentlist;
	}
	public void setPaymentlist(ArrayList<PaymentPO> paymentlist) {
		this.paymentlist = paymentlist;
	}
}
