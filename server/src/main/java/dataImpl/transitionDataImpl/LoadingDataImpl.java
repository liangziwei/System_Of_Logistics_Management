package dataImpl.transitionDataImpl;

import java.util.ArrayList;
import java.util.List;

import constant.LoadingType;
import dataService.transitionDataService.LoadingDataService;
import mysql.Database;
import po.transitionPO.LoadingPO;

public class LoadingDataImpl implements LoadingDataService {

	public boolean AddLoadingFormDT(LoadingPO loadingPO) {
		// TODO Auto-generated method stub
		String loadingid = loadingPO.getloadingid();
		String arrivalid = loadingPO.getarrivalid();
		LoadingType way = loadingPO.getway();
		String wayid = loadingPO.getwayid();
		String supervisionid = loadingPO.getsupervisionid();
		String supercargo = loadingPO.getsupercargoid();
		List<String> alldeliveryid = loadingPO.getalldeliveryid();
		String theallDeliveryid = null;
		for(String all:alldeliveryid){
			theallDeliveryid = theallDeliveryid+all+" ";
		}
		double fare = loadingPO.getfare();
		boolean isApproval = loadingPO.getisApproved();
		boolean isPass = loadingPO.getisPassed();
		boolean add =false;
		String val = "";
		val = "'"+loadingid+"','"+arrivalid+"','"+way+","+wayid+"','"+supervisionid+"','"+supercargo+"','"+theallDeliveryid+"','"+fare+"','"+"0,1";
		try {
			add = Database.add("loading", val);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return add;
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
