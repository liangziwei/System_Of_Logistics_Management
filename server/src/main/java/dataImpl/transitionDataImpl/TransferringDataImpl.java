package dataImpl.transitionDataImpl;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import constant.LoadingType;
import dataService.Approvable;
import dataService.transitionDataService.TransferringDataService;
import mysql.Database;
import po.transitionPO.TransferringPO;

public class TransferringDataImpl implements TransferringDataService {

	ResultSet rs;

	public boolean AddTransferringFormDT(TransferringPO transferringPO) {
		// TODO Auto-generated method stub
		String transferringid = transferringPO.gettransferringid();
		String loadingdate = transferringPO.getloadingdate();
		LoadingType way = transferringPO.getway();
		String wayid = transferringPO.getwayid();
		String departureid = transferringPO.getdepartureid();
		String arrivalid = transferringPO.getarrivalid();
		String supervisionid = transferringPO.getsupervisionid();
		String containerid = transferringPO.getcontainerid();
		double fare = transferringPO.getfare();
		List<String> alldeliveryid = transferringPO.getalldeliveryid();
		String theallDeliveryid = "";
		for (String all : alldeliveryid) {
			theallDeliveryid = theallDeliveryid + all + " ";
		}
		boolean add = false;
		String val = "";
		val = "'" + transferringid + "','" + loadingdate + "','" + way.toString() + "','" + wayid + "','" + departureid
				+ "','" + arrivalid + "','" + supervisionid + "','" + containerid + "','" + theallDeliveryid + "',"
				+ fare + ",0,1";
		try {
			add = Database.add("transferring", val);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return add;
	}

	public boolean ModifyTransferringFormDT(TransferringPO transferringPO) {
		// TODO Auto-generated method stub
		String transferringid = transferringPO.gettransferringid();
		String loadingdate = transferringPO.getloadingdate();
		LoadingType way = transferringPO.getway();
		String wayid = transferringPO.getwayid();
		String departureid = transferringPO.getdepartureid();
		String arrivalid = transferringPO.getarrivalid();
		String supervisionid = transferringPO.getsupervisionid();
		String containerid = transferringPO.getcontainerid();
		double fare = transferringPO.getfare();
		List<String> alldeliveryid = transferringPO.getalldeliveryid();
		String theallDeliveryid = "";
		for (String all : alldeliveryid) {
			theallDeliveryid = theallDeliveryid + all + " ";
		}
		boolean add = false;
		String val = "";
		val = "loadingdate='" + loadingdate + "',way='" + way.toString() + "',wayid＝'" + wayid + "',departureid='"
				+ departureid + "',arrivalid='" + arrivalid + "',supervisionid='" + supervisionid + "',containerid='"
				+ containerid + "',theallDeliveryid='" + theallDeliveryid + "',fare=" + fare
				+ ",isApproved=0,isPassed=1";
		return Database.modify("transferring", val, "transferringid", transferringid);
	}

	public TransferringPO FindTransferringFormDT(String transferringNumber) {
		// TODO Auto-generated method stub
		String transferringid = transferringNumber;
		String loadingdate = null;
		LoadingType way = null;
		String wayid = null;
		String departureid = null;
		String arrivalid = null;
		String supervisionid = null;
		String containerid = null;
		double fare = 0.0;
		List<String> alldeliveryid = new ArrayList<String>();
		boolean isApproval = false;
		boolean isPass = false;
		try {
			rs = Database.query("transferring", "transferringid", transferringNumber);
			while (rs.next()) {
				loadingdate = rs.getString("loadingdate");
				way = LoadingType.valueOf(rs.getString("way"));
				wayid = rs.getString("wayid");
				departureid = rs.getString("departureid");
				arrivalid = rs.getString("arrivalid");
				supervisionid = rs.getString("supervisionid");
				containerid = rs.getString("containerid");
				fare = rs.getDouble("fare");
				isApproval = Boolean.parseBoolean(rs.getString("isApproved"));
				isPass = Boolean.parseBoolean(rs.getString("isPassed"));
				String deliver = rs.getString("alldeliveryid");
				String[] del = deliver.split(" ");
				for (String a : del) {
					alldeliveryid.add(a);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (way == null) {
			return null;
		}
		TransferringPO transferringPO = new TransferringPO(loadingdate, transferringid, way, wayid, departureid,
				arrivalid, supervisionid, containerid, alldeliveryid);
		transferringPO.setfare(fare);
		transferringPO.setisApproved(isApproval);
		transferringPO.setisPassed(isPass);
		return transferringPO;
	}

	public List<TransferringPO> GetTransferringInfoDT(String date) {
		// TODO Auto-generated method stub
		// List<TransferringPO> alltransferringPO = new
		// ArrayList<TransferringPO>();
		// List<String> alldeliveryid1 = new ArrayList<String>();
		// alldeliveryid1.add("1110000123");
		// alldeliveryid1.add("1110001342");
		// alldeliveryid1.add("1110022123");
		// List<String> alldeliveryid2 = new ArrayList<String>();
		// alldeliveryid2.add("1110120123");
		// alldeliveryid2.add("1111001342");
		// alldeliveryid2.add("1110452123");
		// alltransferringPO.add(new TransferringPO("2015-10-11",
		// "017101000000127", LoadingType.PLANE, "139010001", "北京",
		// "南京", "茗柯", "3", alldeliveryid1));
		// alltransferringPO.add(new TransferringPO("2015-10-11",
		// "017101000100127", LoadingType.TRAIN, "159010101", "北京",
		// "南京", "haha", "2", alldeliveryid2));
		String sql = "SELECT * FROM transferring";
		ResultSet rs = null;
		try {
			rs = Database.findOperation(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		// List
		List<TransferringPO> thelist = new ArrayList<TransferringPO>();
		// 相关信息
		String transferringid = null;
		String loadingdate = null;
		LoadingType way = null;
		String wayid = null;
		String departureid = null;
		String arrivalid = null;
		String supervisionid = null;
		String containerid = null;
		double fare = 0.0;
		try {
			while (rs.next()) {
				loadingdate = rs.getString("loadingdate");
				if (loadingdate.equals(date)) {
					transferringid = rs.getString("transferringid");
					way = LoadingType.valueOf(rs.getString("way"));
					wayid = rs.getString("wayid");
					departureid = rs.getString("departureid");
					arrivalid = rs.getString("arrivalid");
					supervisionid = rs.getString("supervisionid");
					containerid = rs.getString("containerid");
					fare = rs.getDouble("fare");
					String deliver = rs.getString("alldeliveryid");
					List<String> alldeliveryid = new ArrayList<String>();
					String[] del = deliver.split(" ");
					for (String a : del) {
						alldeliveryid.add(a);
					}
					TransferringPO transferringPO = new TransferringPO(loadingdate, transferringid, way, wayid,
							departureid, arrivalid, supervisionid, containerid, alldeliveryid);
					transferringPO.setfare(fare);
					thelist.add(transferringPO);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (thelist.isEmpty()) {
			return null;
		} else {
			return thelist;
		}
	}
	
	public ArrayList<TransferringPO> getUncheckTransferring() {
		ArrayList<TransferringPO> po = new ArrayList<TransferringPO>();
		String sql = "select * from transferring where isApproved = 0;";
		try {
			ResultSet rs = Database.findOperation(sql);
			while(rs.next()) {
				po.add(this.createTransferringPO(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return po;
	}

	private TransferringPO createTransferringPO(ResultSet rs) {
		try {
			String text = rs.getString("alldeliveryid");
			String[] temp = text.split(" ");
			List<String> id = new ArrayList<String>();
			int len = temp.length;
			for(int i = 0; i < len; i++) {
				id.add(temp[i]);
			}
			return new TransferringPO(rs.getString("loadingdate"), rs.getString("transferringid"),
					LoadingType.valueOf(rs.getString("way")), rs.getString("wayid"),
					rs.getString("departureid"), rs.getString("arrivalid"),
					rs.getString("supervisionid"), rs.getString("supercargoid"), id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

//	@Override
//	public boolean approveOneTransferring(TransferringPO form) throws RemoteException {
//		
//	}
//
//	@Override
//	public boolean approveMoreTransferring(ArrayList<TransferringPO> form) throws RemoteException {
//		int size = form.size();
//		for(int i = 0; i < size; i++) {
//			this.approveOneTransferring(form.get(i));
//		}
//		return true;
//	}

	@Override
	public boolean ApproveOneForm(Approvable form) throws RemoteException {
		String sql = "update transferring set isApproved = 1, isPassed = 1 where "
				+ "transferringid = '" + ((TransferringPO)form).gettransferringid() + "';";
		try {
			return Database.operate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean ApproveMoreForm(ArrayList<? extends Approvable> forms) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
}
