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
		List<ReceivablePO> po = new ArrayList<ReceivablePO>();
		String sql = "select * from receivable where businessid = '" + id + "'"
				+ " && date = '" + date + "';";
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
					rs.getString("courier"), id, rs.getString("businessid"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
