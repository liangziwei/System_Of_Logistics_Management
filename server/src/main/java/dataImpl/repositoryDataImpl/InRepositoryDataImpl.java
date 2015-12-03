package dataImpl.repositoryDataImpl;

import java.sql.ResultSet;

import constant.AreaCodeType;
import dataService.repositoryDataService.InRepositoryDataService;
import mysql.Database;
import po.repositoryPO.InRepositoryPO;

public class InRepositoryDataImpl implements InRepositoryDataService {

	ResultSet rs;

	public boolean AddInRepositoryFormDT(InRepositoryPO inRepositoryPO) {
		// TODO Auto-generated method stub
		String deliveryid = inRepositoryPO.getdeliveryid();
		String inrepositorydate = inRepositoryPO.getinrepositorydate();
		String arrivalid = inRepositoryPO.getarrivalid();
		AreaCodeType areaCode = inRepositoryPO.getareaCode();
		String rowid = inRepositoryPO.getrowid();
		String shelfid = inRepositoryPO.getshelfid();
		String posid = inRepositoryPO.getposid();
		boolean add = false;
		String val = "";
		val = "'" + deliveryid + "','" + inrepositorydate + "','" + arrivalid + "','" + areaCode.toString() + "','"
				+ rowid + "','" + shelfid + "','" + posid + "'," + "0,1";
		try {
			add = Database.add("inRepository", val);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return add;
	}

	public boolean ModifyInRepositoryFormDT(InRepositoryPO inRepository) {
		// TODO Auto-generated method stub
		String deliveryid = inRepository.getdeliveryid();
		String inrepositorydate = inRepository.getinrepositorydate();
		String arrivalid = inRepository.getarrivalid();
		AreaCodeType areaCode = inRepository.getareaCode();
		String rowid = inRepository.getrowid();
		String shelfid = inRepository.getshelfid();
		String posid = inRepository.getposid();
		boolean modify = false;
		String val = "";
		val = "deliveryid='" + deliveryid + "',inrepositorydate='" + inrepositorydate + "',arrivalid='" + arrivalid
				+ "',areaCode='" + areaCode.toString() + "',rowid='" + rowid + "',shelfid='" + shelfid + "',posid='"
				+ posid + "'," + "isApproved=0,isPassed=1";
		try {
			modify = Database.modify("inRepository", val, "deliveryid", deliveryid);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return modify;

	}

	public InRepositoryPO FindInRepositoryFormDT(String InRepositoryNumber) {
		// TODO Auto-generated method stub
		// InRepositoryPO inRepositoryPO = new InRepositoryPO("1110101023",
		// "2015-10-13", "北京", AreaCodeType.MOTOAREA,
		// "004", "012", "042");
		String deliveryid = InRepositoryNumber;
		String inrepositorydate = null;
		String arrivalid = null;
		AreaCodeType areaCode = null;
		String rowid = null;
		String shelfid = null;
		String posid = null;
		boolean isApproval = false;
		boolean isPass = false;
		try {
			rs = Database.query("inRepository", "deliveryid", InRepositoryNumber);
			while (rs.next()) {
				inrepositorydate = rs.getString("inrepositorydate");
				arrivalid = rs.getString("arrivalid");
				areaCode = AreaCodeType.valueOf(rs.getString("areaCode"));
				rowid = rs.getString("rowid");
				shelfid = rs.getString("shelfid");
				posid = rs.getString("posid");
				isApproval = Boolean.parseBoolean(rs.getString("isApproved"));
				isPass = Boolean.parseBoolean(rs.getString("isPassed"));
			}
		} catch (Exception e) {
			// TODO: handle exception

		}
		if (areaCode == null) {
			return null;
		}
		InRepositoryPO inRepositoryPO = new InRepositoryPO(deliveryid, inrepositorydate, arrivalid, areaCode, rowid,
				shelfid, posid);
		inRepositoryPO.setisApproved(isApproval);
		inRepositoryPO.setisPassed(isPass);
		return inRepositoryPO;
	}

	public boolean UpdateRepositoryInfoDT(InRepositoryPO inRepository) {
		// TODO Auto-generated method stub
		String deliveryid = inRepository.getdeliveryid();
		String inrepositorydate = inRepository.getinrepositorydate();
		String arrivalid = inRepository.getarrivalid();
		AreaCodeType areaCode = inRepository.getareaCode();
		String rowid = inRepository.getrowid();
		String shelfid = inRepository.getshelfid();
		String posid = inRepository.getposid();
		boolean add = false;
		String val = "";
		val = "'" + deliveryid + "','" + inrepositorydate + "','" + arrivalid + "','" + areaCode.toString() + "','"
				+ rowid + "','" + shelfid + "','" + posid + "'";
		try {
			add = Database.add("repository", val);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return add;
	}

	public boolean modifyUpdateRepositoryInfoDT(InRepositoryPO inRepository) {
		String deliveryid = inRepository.getdeliveryid();
		String inrepositorydate = inRepository.getinrepositorydate();
		String arrivalid = inRepository.getarrivalid();
		AreaCodeType areaCode = inRepository.getareaCode();
		String rowid = inRepository.getrowid();
		String shelfid = inRepository.getshelfid();
		String posid = inRepository.getposid();
		boolean modify = false;
		String val = "";
		val = "inrepositorydate='" + inrepositorydate + "',arrivalid='" + arrivalid + "',areaCode='"
				+ areaCode.toString() + "',rowid='" + rowid + "',shelfid='" + shelfid + "',posid='" + posid + "'";
		try {
			modify = Database.modify("repository", val, "deliveryid", deliveryid);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return modify;
	}

}
