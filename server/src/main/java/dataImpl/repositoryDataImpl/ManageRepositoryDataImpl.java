package dataImpl.repositoryDataImpl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import constant.AreaCodeType;
import dataService.repositoryDataService.ManageRepositoryDataService;
import mysql.Database;
import po.repositoryPO.DeliveryInfoPO;
import po.repositoryPO.RepositoryInfoPO;
import po.repositoryPO.RepositoryPO;

public class ManageRepositoryDataImpl implements ManageRepositoryDataService {

	ResultSet rs;

	public List<RepositoryInfoPO> SeeRepositoryDT(String time) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM repository";
		ResultSet rs = null;
		try {
			rs = Database.findOperation(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		// List
		List<RepositoryInfoPO> thelist = null;
		// 相关信息
		String deliveryid = null;
		AreaCodeType areaCode = null;
		String rowid = null;
		String shelfid = null;
		String posid = null;
		try {
			while (rs.next()) {
				deliveryid = rs.getString("deliveryid");
				areaCode = AreaCodeType.valueOf(rs.getString("areaCode"));
				rowid = rs.getString("rowid");
				shelfid = rs.getString("shelfid");
				posid = rs.getString("posid");

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return thelist;
	}

	public List<DeliveryInfoPO> CheckRepositoryDT() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM repository";
		ResultSet rs = null;
		try {
			rs = Database.findOperation(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		// List
		List<DeliveryInfoPO> thelist = new ArrayList<DeliveryInfoPO>();
		// 相关信息
		String deliveryid = null;
		String inrepositorydate = null;
		String arrivalid = null;
		AreaCodeType areaCode = null;
		String rowid = null;
		String shelfid = null;
		String posid = null;
		try {
			while (rs.next()) {
				deliveryid = rs.getString("deliveryid");
				inrepositorydate = rs.getString("inrepositorydate");
				arrivalid = rs.getString("arrivalid");
				areaCode = AreaCodeType.valueOf(rs.getString("areaCode"));
				rowid = rs.getString("rowid");
				shelfid = rs.getString("shelfid");
				posid = rs.getString("posid");
				DeliveryInfoPO deliveryInfoPO = new DeliveryInfoPO(deliveryid, inrepositorydate, arrivalid, areaCode,
						rowid, shelfid, posid);
				thelist.add(deliveryInfoPO);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return thelist;
	}

	public boolean UpdataRepositoryWarnDT(int allNum, double WarnNum, AreaCodeType ID) {
		// TODO Auto-generated method stub
		try {
			if (ID==AreaCodeType.PLANEAREA) {
				BufferedWriter writer = new BufferedWriter(new FileWriter(new File("data/plane.txt")));
				writer.write(allNum+";"+WarnNum);
				writer.close();
			}
			else if (ID==AreaCodeType.TRAINAREA) {
				BufferedWriter writer = new BufferedWriter(new FileWriter(new File("data/train.txt")));
				writer.write(allNum+";"+WarnNum);
				writer.close();
			}
			else if (ID==AreaCodeType.TRUCKAREA) {
				BufferedWriter writer = new BufferedWriter(new FileWriter(new File("data/truck.txt")));
				writer.write(allNum+";"+WarnNum);
				writer.close();
			}
			else if (ID==AreaCodeType.MOTOAREA) {
				BufferedWriter writer = new BufferedWriter(new FileWriter(new File("data/moto.txt")));
				writer.write(allNum+";"+WarnNum);
				writer.close();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public double GetWarnNumDT(AreaCodeType ID) {
		// TODO Auto-generated method stub
		double warnNUM = 0.0;
		try {
			if (ID==AreaCodeType.PLANEAREA) {
				BufferedReader reader = new BufferedReader(new FileReader(new File("data/plane.txt")));
				String line = reader.readLine();
				String[] num = line.split(";");
				warnNUM = Double.parseDouble(num[1]);
				reader.close();
			}
			else if (ID==AreaCodeType.TRAINAREA) {
				BufferedReader reader = new BufferedReader(new FileReader(new File("data/train.txt")));
				String line = reader.readLine();
				String[] num = line.split(";");
				warnNUM = Double.parseDouble(num[1]);
				reader.close();
			}
			else if (ID==AreaCodeType.TRUCKAREA) {
				BufferedReader reader = new BufferedReader(new FileReader(new File("data/truck.txt")));
				String line = reader.readLine();
				String[] num = line.split(";");
				warnNUM = Double.parseDouble(num[1]);
				reader.close();
			}
			else if (ID==AreaCodeType.MOTOAREA) {
				BufferedReader reader = new BufferedReader(new FileReader(new File("data/moto.txt")));
				String line = reader.readLine();
				String[] num = line.split(";");
				warnNUM = Double.parseDouble(num[1]);
				reader.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		return warnNUM;
	}

	public int GetRepositoryNumDT(AreaCodeType ID) {
		// TODO Auto-generated method stub
		int allNUM = 0;
		try {
			if (ID==AreaCodeType.PLANEAREA) {
				BufferedReader reader = new BufferedReader(new FileReader(new File("data/plane.txt")));
				String line = reader.readLine();
				String[] num = line.split(";");
				allNUM = Integer.parseInt(num[0]);
				reader.close();
			}
			else if (ID==AreaCodeType.TRAINAREA) {
				BufferedReader reader = new BufferedReader(new FileReader(new File("data/train.txt")));
				String line = reader.readLine();
				String[] num = line.split(";");
				allNUM = Integer.parseInt(num[0]);
				reader.close();
			}
			else if (ID==AreaCodeType.TRUCKAREA) {
				BufferedReader reader = new BufferedReader(new FileReader(new File("data/truck.txt")));
				String line = reader.readLine();
				String[] num = line.split(";");
				allNUM = Integer.parseInt(num[0]);
				reader.close();
			}
			else if (ID==AreaCodeType.MOTOAREA) {
				BufferedReader reader = new BufferedReader(new FileReader(new File("data/moto.txt")));
				String line = reader.readLine();
				String[] num = line.split(";");
				allNUM = Integer.parseInt(num[0]);
				reader.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		return allNUM;
	}

	public int GetRepositoryExistDT(AreaCodeType ID) {
		// TODO Auto-generated method stub
		int existnum = 0;
		AreaCodeType areaCode = null;
		String sql = "SELECT * FROM repository";
		ResultSet rs = null;
		try {
			rs = Database.findOperation(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			while (rs.next()) {
				areaCode = AreaCodeType.valueOf(rs.getString("areaCode"));
				if (areaCode==ID) {
					existnum++;
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return existnum;
	}
	
	public List<RepositoryPO> GetRepositoryInfoDT() {
		// TODO Auto-generated method stub
		// List<RepositoryPO> repositoryPOs = new ArrayList<RepositoryPO>();
		// repositoryPOs.add(new RepositoryPO("1269324125",
		// "2015-08-14","南京",AreaCodeType.TRUCKAREA,"072", "044", "011"));
		// repositoryPOs.add(new RepositoryPO("8669124125",
		// "2015-09-12","广州",AreaCodeType.PLANEAREA,"014", "084", "561"));
		// repositoryPOs.add(new RepositoryPO("1262354125",
		// "2015-08-15","南京",AreaCodeType.PLANEAREA,"022", "654", "091"));

		String sql = "SELECT * FROM repository";
		ResultSet rs = null;
		try {
			rs = Database.findOperation(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		// List
		List<RepositoryPO> thelist = new ArrayList<RepositoryPO>();
		// 相关信息
		String deliveryid = null;
		String inrepositorydate = null;
		String arrivalid = null;
		AreaCodeType areaCode = null;
		String rowid = null;
		String shelfid = null;
		String posid = null;
		try {
			while (rs.next()) {
				deliveryid = rs.getString("deliveryid");
				inrepositorydate = rs.getString("inrepositorydate");
				arrivalid = rs.getString("arrivalid");
				areaCode = AreaCodeType.valueOf(rs.getString("areaCode"));
				rowid = rs.getString("rowid");
				shelfid = rs.getString("shelfid");
				posid = rs.getString("posid");
				RepositoryPO repositoryPO = new RepositoryPO(deliveryid, inrepositorydate, arrivalid, areaCode, rowid,
						shelfid, posid);
				thelist.add(repositoryPO);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return thelist;
	}


}
