package businessLogicService.businessBLService;

import vo.businessVO.ReceiveFormVO;
import vo.businessVO.SendFormVO;

public interface ReceiveAndSendBLService {
	
	public boolean addReceiveFrom(ReceiveFormVO receiveFormVO);
	
	public boolean addSendFrom(SendFormVO sendFormVO);
	
}
