package businessLogic.businessLogicController.financeController;

import java.rmi.RemoteException;

import vo.financeVO.PaymentVO;
import businessLogic.businessLogicModel.financeModel.Cost;
import businessLogicService.financeBLService.CostBLService;
/**
 * description:为成本管理界面提供服务的具体实现
 * @author 张仁知
 *
 */

public class CostController implements CostBLService{
	
	private Cost costModel = new Cost();
	
	public boolean addPayment(PaymentVO paymentVO) {
		
		return costModel.addPayment(paymentVO);
	}

}
