package stub.dataImpl_stub.transitionDataImpl;

import java.util.ArrayList;
import java.util.List;

import constant.LoadingType;
import dataService.transitionDataService.LoadingDataService;
import po.transitionPO.LoadingPO;

public class LoadingDataImpl_Stub implements LoadingDataService{

	public boolean AddLoadingFormDT(LoadingPO loadingPO) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean ModifyLoadingFormDT(LoadingPO loadingPO) {
		// TODO Auto-generated method stub
		return true;
	}

	public LoadingPO FindLoadingFormDT(String loadingNumber) {
		// TODO Auto-generated method stub
		List<String> alldeliveryid = new ArrayList<String>();
		alldeliveryid.add("1000221181");
		alldeliveryid.add("1244291091");
		alldeliveryid.add("1827461871");
		
		return new LoadingPO("017 1010 0007", "北京", LoadingType.PLANE,"139 010 001","茗柯","茗柯",alldeliveryid);
	}

}
