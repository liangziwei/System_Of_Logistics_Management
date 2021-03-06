package dataImpl.repositoryDataImpl;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import constant.LoadingType;
import dataService.Approvable;
import dataService.repositoryDataService.OutRepositoryDataService;
import mysql.Database;
import po.repositoryPO.OutRepositoryPO;

public class OutRepositoryDataImpl implements OutRepositoryDataService {
	
	ResultSet rs;

	public boolean AddOutRepositoryFormDT(OutRepositoryPO outRepository) {
		// TODO Auto-generated method stub
		String deliveryid = outRepository.getdeliveryid();
		String outrepositorydate = outRepository.getoutrepositorydate();
		String arrivalid = outRepository.getarrivalid();
		String transitionid = outRepository.gettransitionid();
		LoadingType way = outRepository.getway();
		String loadingid = outRepository.getloadingid();
		
		boolean add = false;
		String val = "";
		val = "'" + deliveryid + "','" + transitionid + "','" +outrepositorydate+ "','" + arrivalid + "','" + way.toString() + "','"
				+ loadingid + "'," +"0,1";
		try {
			add = Database.add("outRepository", val);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return add;
	}

	public boolean ModifyOutRepositoryFormDT(OutRepositoryPO outRepositoryPO) {
		// TODO Auto-generated method stub
		String deliveryid = outRepositoryPO.getdeliveryid();
		String outrepositorydate = outRepositoryPO.getoutrepositorydate();
		String arrivalid = outRepositoryPO.getarrivalid();
		LoadingType way = outRepositoryPO.getway();
		String loadingid = outRepositoryPO.getloadingid();
		String transitionid = outRepositoryPO.gettransitionid();
		
		boolean modify = false;
		String val = "";
		val = "transitionid='"+transitionid+ "',outrepositorydate='" + outrepositorydate +"',arrivalid='" + arrivalid
				+ "',way='" + way.toString() + "',loadingid='" + loadingid + "',isApproved=0,isPassed=1";
		try {
			modify = Database.modify("outRepository", val, "deliveryid", deliveryid);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return modify;
	}

	public OutRepositoryPO FindOutRepositoryFormDT(String OutRepositoryNumber) {
		// TODO Auto-generated method stub
//		OutRepositoryPO outRepositoryPO = new OutRepositoryPO("2015100046", "2015-10-18","广州",LoadingType.TRUCK,"025 1012 0002301");
		String deliveryid = OutRepositoryNumber;
		String outrepositorydate = null;
		String transitionid = null;
		String arrivalid = null;
		LoadingType way = null;
		String loadingid = null;
		boolean isApproval = false;
		boolean isPass = false;
		try {
			rs=Database.query("outRepository","deliveryid",OutRepositoryNumber);
			while(rs.next()){
				outrepositorydate = rs.getString("outrepositorydate");
				transitionid = rs.getString("transitionid");
				arrivalid = rs.getString("arrivalid");
				way = LoadingType.valueOf(rs.getString("way"));
				loadingid= rs.getString("loadingid");
				isApproval = Boolean.parseBoolean(rs.getString("isApproved"));
				isPass = Boolean.parseBoolean(rs.getString("isPassed"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (way==null) {
			return null;
		}
		OutRepositoryPO outRepositoryPO = new OutRepositoryPO(deliveryid, outrepositorydate, arrivalid, way, loadingid,transitionid);
		outRepositoryPO.setisApproved(isApproval);
		outRepositoryPO.setisPassed(isPass);		
		return outRepositoryPO;
	}

	public boolean UpdateRepositoryInfoDT(OutRepositoryPO outRepositoryPO) {
		// TODO Auto-generated method stub
		String DeleTe = "DELETE FROM repository WHERE deliveryid="+"'"+outRepositoryPO.getdeliveryid()+"'"+"&&transitionid="+"'"+outRepositoryPO.gettransitionid()+"'";
		String Find = "SELECT * FROM repository WHERE deliveryid="+"'"+outRepositoryPO.getdeliveryid()+"'"+"&&transitionid="+"'"+outRepositoryPO.gettransitionid()+"'";
//		String deliveryid = outRepositoryPO.getdeliveryid();
		String date = null;
		try {
			rs=Database.findOperation(Find);
			while(rs.next()){
				date = rs.getString("inrepositorydate");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		if (date==null) {
			return false;
		}
		else {
			boolean dele = false;
			try {
				dele=Database.operate(DeleTe);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			return dele;
		}
	}
	
	public List<String> getdeliveryid(String loadingid){
		List<String> alldeliveryID = new ArrayList<String>();
		try {
			rs=Database.query("outRepository","loadingid",loadingid);
			while(rs.next()){
				String delID = rs.getString("deliveryid");
				alldeliveryID.add(delID);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (alldeliveryID.isEmpty()) {
			return null;
		}
		else {
			return alldeliveryID;
			
		}
	}
	
	public ArrayList<OutRepositoryPO> getUncheckOutRepository() {
		ArrayList<OutRepositoryPO> po = new ArrayList<OutRepositoryPO>();
		String sql = "select * from outRepository where isApproved = 0;";
		try {
			ResultSet rs = Database.findOperation(sql);
			while(rs.next()) {
				po.add(this.createOutRepositoryPO(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return po;
	}
	
	private OutRepositoryPO createOutRepositoryPO(ResultSet rs) {
		try {
			return new OutRepositoryPO(rs.getString("deliveryid"), rs.getString("outrepositorydate"),
					rs.getString("arrivalid"), LoadingType.valueOf(rs.getString("way")), rs.getString("loadingid"),rs.getString("transitionid"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean ApproveOneForm(Approvable form) throws RemoteException {
		String sql = "update outRepository set isApproved = 1, isPassed = 1 where "
				+ "deliveryid = '" + ((OutRepositoryPO)form).getdeliveryid() + "';";
		try {
			return Database.operate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean ApproveMoreForm(ArrayList<? extends Approvable> forms) throws RemoteException {
		for (Approvable a : forms) {
			this.ApproveOneForm(a);
		}
		return true;
	}

}
