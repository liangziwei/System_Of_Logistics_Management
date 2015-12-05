package dataImpl.financeDataImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dataService.financeDataService.SettlementDataService;
import mysql.Database;
import po.businessPO.ReceivablePO;

/**
 * description:数据服务层为结算管理提供服务的具体实现
 * @author 张仁知
 */
public class SettlementDataImpl implements SettlementDataService{

	ResultSet rs;
	
	public List<ReceivablePO> getReceiList(String date) {
		List<ReceivablePO> po = new ArrayList<ReceivablePO>();
		String sql = "select * from receivable where date = '" + date + "';";
		try {
			ResultSet rs = Database.findOperation(sql);
			while(rs.next()) {
				po.add(this.createReceivablePO(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return po;
	}
	
	public List<ReceivablePO> getBusinessRecei(String id,String date) {
		//TODO TEST
		List<ReceivablePO> receivables = new ArrayList<ReceivablePO>();
		if(id.equals("1")) {
			ArrayList<String> id1 = new ArrayList<String>();
			id1.add("1000010000");
			id1.add("1000010001");
			ArrayList<String> id2 = new ArrayList<String>();
			id2.add("0000010000");
			id2.add("0000010001");
			ArrayList<String> id3 = new ArrayList<String>();
			id3.add("1000610000");
			id3.add("1000610001");
			id3.add("1000610002");
			id3.add("1000610003");
			receivables.add(new ReceivablePO("1990-1-1", 12.0, "A", id1));
			receivables.add(new ReceivablePO("1990-1-1", 0.0, "B", id2));
			receivables.add(new ReceivablePO("1990-1-1", 0.0, "C", id3));
		}
		else {
			ArrayList<String> id1 = new ArrayList<String>();
			id1.add("1000010000");
			id1.add("1000010001");
			ArrayList<String> id2 = new ArrayList<String>();
			id2.add("0000010000");
			id2.add("0000010001");
			ArrayList<String> id3 = new ArrayList<String>();
			id3.add("1000610000");
			id3.add("1000610001");
			id3.add("1000610002");
			id3.add("1000610003");
			receivables.add(new ReceivablePO("1993-1-1", 12.0, "A", id1));
			receivables.add(new ReceivablePO("1993-1-1", 2.0, "B", id2));
			receivables.add(new ReceivablePO("1993-1-1", 0.0, "C", id3));
			receivables.add(new ReceivablePO("1993-1-1", 12.0, "A", id1));
			receivables.add(new ReceivablePO("1993-1-1", 2.0, "B", id2));
			receivables.add(new ReceivablePO("1993-1-1", 0.0, "C", id3));
			receivables.add(new ReceivablePO("1993-1-1", 12.0, "A", id1));
			receivables.add(new ReceivablePO("1993-1-1", 2.0, "B", id2));
			receivables.add(new ReceivablePO("1993-1-1", 0.0, "C", id3));
		}
		return receivables;
	}
	
	private ReceivablePO createReceivablePO(ResultSet rs) {
		ArrayList<String> id = new ArrayList<String>();;
		try {
			String idText = rs.getString("deliveryid");
			String[] temp = idText.split(" ");
			int size = temp.length;
			for(int i = 0; i < size; i++) {
				id.add(temp[i]);
			}
			return new ReceivablePO(rs.getString("date"), rs.getDouble("money"),
					rs.getString("courier"), id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
