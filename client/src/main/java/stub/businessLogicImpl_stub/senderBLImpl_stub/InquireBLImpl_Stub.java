package stub.businessLogicImpl_stub.senderBLImpl_stub;

import java.util.ArrayList;
import java.util.List;

import businessLogicService.senderBLService.InquireBLService;
import constant.City;
import constant.TransitionNode;
import vo.senderVO.LogisticsVO;

public class InquireBLImpl_Stub implements InquireBLService{

	public LogisticsVO getLogInfoById(String id) {
		// TODO Auto-generated method stub
		List<City> trace = new ArrayList<City>();
		trace.add(City.NAN_JING);
		trace.add(City.BEI_JING);
		return new LogisticsVO(TransitionNode.RECEIVER_TRANSI_CENTER, trace);
	}

}
