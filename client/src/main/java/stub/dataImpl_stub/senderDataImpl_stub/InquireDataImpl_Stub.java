package stub.dataImpl_stub.senderDataImpl_stub;

import java.util.ArrayList;
import java.util.List;

import constant.City;
import constant.TransitionNode;
import dataService.senderDataService.InquireDataService.InquireDataService;
import po.senderPO.LogisticsPO;

public class InquireDataImpl_Stub implements InquireDataService{

	public LogisticsPO getLogInfoById(String id) {
		// TODO Auto-generated method stub
		List<City> trace = new ArrayList<City>();
		trace.add(City.SHANG_HAI);
		trace.add(City.BEI_JING);
		return new LogisticsPO(TransitionNode.RECEIVER_BUSINESS_HALL, trace);
	}

}
