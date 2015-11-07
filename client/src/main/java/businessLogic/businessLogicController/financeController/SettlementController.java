package businessLogic.businessLogicController.financeController;

import java.util.List;

import vo.businessVO.ReceivableVO;
import businessLogic.businessLogicModel.financeModel.Settlement;
import businessLogicService.financeBLService.SettlementBLService;
/**
 * description:为结算管理界面提供服务的具体实现
 * @author 张仁知
 *
 */

public class SettlementController implements SettlementBLService{
	
	private Settlement settlement = new Settlement();
	
	public List<ReceivableVO> showReceiList(String date) {
		return settlement.showReceiList(date);
	}
	
	public double calculateSum() {
		return 0.0;
	}
	
	public List<ReceivableVO> showBusinessRecei( String id,String date) {
		return settlement.showBusinessRecei(id, date);
	}

}
