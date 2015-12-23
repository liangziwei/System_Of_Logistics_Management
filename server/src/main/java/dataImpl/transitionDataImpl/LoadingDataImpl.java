package dataImpl.transitionDataImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import constant.LoadingType;
import dataService.transitionDataService.LoadingDataService;
import mysql.Database;
import po.transitionPO.LoadingPO;

public class LoadingDataImpl implements LoadingDataService {
	
	ResultSet rs;
	
	public boolean AddLoadingFormDT(LoadingPO loadingPO) {
		// TODO Auto-generated method stub
		String loadingid = loadingPO.getloadingid();
		String arrivalid = loadingPO.getarrivalid();
		LoadingType way = loadingPO.getway();
		String wayid = loadingPO.getwayid();
		String supervisionid = loadingPO.getsupervisionid();
		String supercargo = loadingPO.getsupercargoid();
		List<String> alldeliveryid = loadingPO.getalldeliveryid();
		String theallDeliveryid = "";
		for (String all : alldeliveryid) {
			theallDeliveryid = theallDeliveryid + all + " ";
		}
		double fare = loadingPO.getfare();
		boolean add = false;
		String val = "";
		val = "'" + loadingid + "','" + arrivalid + "','" + way.toString() + "','" + wayid + "','" + supervisionid + "','"
				+ supercargo + "','" + theallDeliveryid + "'," + fare + ",0,1";
		try {
			add = Database.add("loading", val);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return add;
	}

	public boolean ModifyLoadingFormDT(LoadingPO loadingPO) {
		// TODO Auto-generated method stub
		String loadingid = loadingPO.getloadingid();
		String arrivalid = loadingPO.getarrivalid();
		LoadingType way = loadingPO.getway();
		String wayid = loadingPO.getwayid();
		String supervisionid = loadingPO.getsupervisionid();
		String supercargo = loadingPO.getsupercargoid();
		List<String> alldeliveryid = loadingPO.getalldeliveryid();
		String theallDeliveryid = null;
		for (String all : alldeliveryid) {
			theallDeliveryid = theallDeliveryid + all + " ";
		}
		double fare = loadingPO.getfare();
//		boolean isApproval = loadingPO.getisApproved();
//		boolean isPass = loadingPO.getisPassed();
		String Val = "";
		Val =  "arrivalid='" + arrivalid + "',way='" + way.toString() + "',wayid='" + wayid
				+ "',supervisionid='" + supervisionid + "',supercargoid='" + supercargo + "',alldeliveryid='"
				+ theallDeliveryid + "',fare=" + fare + ",isApproved=0,isPassed=1";

		return Database.modify("loading", Val, "loadingID", loadingid);
	}

	public LoadingPO FindLoadingFormDT(String loadingNumber) {
		// TODO Auto-generated method stub
//		ArrayList<String> alldeliveryid = new ArrayList<String>();
//		alldeliveryid.add("1234567890");
//		alldeliveryid.add("0987654321");
//		LoadingPO loadingPO = new LoadingPO("12312311111", "123", LoadingType.TRAIN, "212453", "haha", "xixi",
//				alldeliveryid);
//		return loadingPO;
		String loadingid = loadingNumber;
		String arrivalid = null;
		LoadingType way = null;
		String wayid = null;
		String supervisionid = null;
		String supercargo = null;
		List<String> alldeliveryid = new ArrayList<String>();
		double fare = 0.0;
		boolean isApproval = false;
		boolean isPass = false;
		try {
			rs=Database.query("loading","loadingID",loadingNumber);
			while(rs.next()){
				arrivalid = rs.getString("arrivalid");
				way = LoadingType.valueOf(rs.getString("way"));
				wayid= rs.getString("wayid");
				supervisionid = rs.getString("supervisionid");
				supercargo = rs.getString("supercargoid");
				fare = rs.getDouble("fare");
				isApproval = Boolean.parseBoolean(rs.getString("isApproved"));
				isPass = Boolean.parseBoolean(rs.getString("isPassed"));
				String deliver = rs.getString("alldeliveryid");
				String[] del = deliver.split(" ");
//				alldeliveryid.add("1");
				for(String a:del){
					alldeliveryid.add(a);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception

		}
		if (way==null) {		
			return null;
		}
		if (wayid.equals("")) {
			return null;
		}
		if (arrivalid.equals("")) {
			return null;
		}
		LoadingPO loadingPO = new LoadingPO(loadingid, arrivalid, way, wayid, supervisionid, supercargo, alldeliveryid);
		loadingPO.setfare(fare);
		loadingPO.setisApproved(isApproval);
		loadingPO.setisPassed(isPass);
		return loadingPO;
	}

}
