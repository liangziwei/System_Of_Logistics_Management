package dataImpl.financeDataImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dataService.financeDataService.StatisticsDataService;
import mysql.Database;
import po.businessPO.ReceivablePO;
import po.financePO.PaymentPO;

/**
 * description:数据服务层为成本经营统计分析提供服务的具体实现
 * @author 张仁知
 */
public class StatisticsDataImpl implements StatisticsDataService{

	public List<ReceivablePO> getReceivableList(String startDate,String endDate) {
		List<ReceivablePO> po = new ArrayList<ReceivablePO>();
		String sql = "select * from receivable where date >= '" + startDate
				+ "' && date <= '" + endDate + "';";
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
	
	public List<ReceivablePO> getReceivableList() {
		List<ReceivablePO> po = new ArrayList<ReceivablePO>();
		String sql = "select * from receivable;";
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
	
	public List<PaymentPO>	getPaymentList(String startDate,String endDate) {
		List<PaymentPO> pay = new ArrayList<PaymentPO>();
		String sql = "select * from payment where date <= '" + endDate
				+ "' && date >= '" + startDate + "';";
		try {
			ResultSet rs = Database.findOperation(sql);
			while(rs.next()) {
				pay.add(this.createPaymentPO(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pay;
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
	
	private PaymentPO createPaymentPO(ResultSet rs) {
		try {
			return new PaymentPO(rs.getString("date"), rs.getDouble("payAmount"), rs.getString("name"),
					rs.getString("account"), rs.getString("entry"), rs.getString("remark"),
					Boolean.parseBoolean(rs.getString("is_approved")),
					Boolean.parseBoolean(rs.getString("is_passed")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
