package dataImpl.transitionDataImpl;

import java.util.ArrayList;

import constant.LoadingType;
import dataService.transitionDataService.LoadingDataService;
import po.transitionPO.LoadingPO;

public class LoadingDataImpl implements LoadingDataService {

	public boolean AddLoadingFormDT(LoadingPO loadingPO) {
		// TODO Auto-generated method stub
		String loadingid = loadingPO.getloadingid();
		String arrivalid = loadingPO.getarrivalid();
		LoadingType way = loadingPO.getway();
		return false;
	}

	public boolean ModifyLoadingFormDT(LoadingPO loadingPO) {
		// TODO Auto-generated method stub
		return false;
	}

	public LoadingPO FindLoadingFormDT(String loadingNumber) {
		// TODO Auto-generated method stub
		ArrayList<String>  alldeliveryid = new ArrayList<String>();
		alldeliveryid.add("1234567890");
		alldeliveryid.add("0987654321");
		LoadingPO loadingPO =new LoadingPO("12312311111", "123", LoadingType.TRAIN, "212453", "haha", "xixi", alldeliveryid);
		return loadingPO;
	}

}
