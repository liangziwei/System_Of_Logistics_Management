package dataImpl.repositoryDataImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import constant.LoadingType;
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
		LoadingType way = outRepository.getway();
		String loadingid = outRepository.getloadingid();
		
		boolean add = false;
		String val = "";
		val = "'" + deliveryid + "','" + outrepositorydate + "','" + arrivalid + "','" + way.toString() + "','"
				+ loadingid + "'," +"0,1";
		try {
			add = Database.add("outRepository", val);
		} catch (Exception e) {
			// TODO: handle exception
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
		
		boolean modify = false;
		String val = "";
		val = "deliveryid='" + deliveryid + "',outrepositorydate='" + outrepositorydate + "',arrivalid='" + arrivalid
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
		String arrivalid = null;
		LoadingType way = null;
		String loadingid = null;
		boolean isApproval = false;
		boolean isPass = false;
		try {
			rs=Database.query("outRepository","deliveryid",OutRepositoryNumber);
			while(rs.next()){
				outrepositorydate = rs.getString("outrepositorydate");
				arrivalid = rs.getString("arrivalid");
				way = LoadingType.valueOf(rs.getString("way"));
				loadingid= rs.getString("loading");
				isApproval = Boolean.parseBoolean(rs.getString("isApproved"));
				isPass = Boolean.parseBoolean(rs.getString("isPassed"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (way==null) {
			return null;
		}
		OutRepositoryPO outRepositoryPO = new OutRepositoryPO(deliveryid, outrepositorydate, arrivalid, way, loadingid);
		outRepositoryPO.setisApproved(isApproval);
		outRepositoryPO.setisPassed(isPass);		
		return outRepositoryPO;
	}

	public boolean UpdateRepositoryInfoDT(OutRepositoryPO outRepositoryPO) {
		// TODO Auto-generated method stub
		
		return Database.delete("repository", "deliveryid", outRepositoryPO.getdeliveryid());
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
					rs.getString("arrivalid"), LoadingType.valueOf(rs.getString("way")), rs.getString("loadingid"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
