package dataImpl.senderDataImpl;

import java.util.ArrayList;
import java.util.List;

import constant.City;
import constant.TransitionNode;
import dataService.senderDataService.InquireDataService;
import po.senderPO.LogisticsPO;

/**
 * description:数据服务层为物流信息逻辑处理提供服务的具体实现
 * @author 肖安祥
 */
public class InquireDataImpl implements InquireDataService{

	public LogisticsPO getLogInfoById(String id) {
		//临时数据
		TransitionNode state = TransitionNode.SENDER_TRANSI_CENTER;
		List<City> trace = new ArrayList<City>();
		trace.add(City.BEI_JING);
		trace.add(City.NAN_JING);
		trace.add(City.SHANG_HAI);
		trace.add(City.GUANG_ZHOU);
		return new LogisticsPO(state, trace);
	}

}
