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
}
