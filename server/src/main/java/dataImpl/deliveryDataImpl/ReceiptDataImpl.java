package dataImpl.deliveryDataImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import constant.City;
import dataService.deliveryDataService.ReceiptDataService;
import mysql.Database;
import po.deliveryPO.ReceiptPO;

/**
 * description:数据服务层为收件信息处理提供服务的具体实现
 * @author 肖安祥
 */
public class ReceiptDataImpl implements ReceiptDataService{

	public boolean saveReceiptInfo(ReceiptPO receiptPO) {
		String name = receiptPO.getName();
		String id = receiptPO.getOrderID();
		String date = receiptPO.getDate();
		//查询编号对应的订单信息
		String inquire = "select * from"
				+ " order_table where goods_id = '" + id + "';";
		ResultSet rs = null;
		try {
			rs = Database.findOperation(inquire);
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}
		//验证填写的收件人姓名和收件编号是否对应
		try {
			while(rs.next()) {
				if(!name.equals(rs.getString("receiver_name"))) return false;
			}
		} catch (SQLException e) {
			return false;
		}
		//保存订单信息
		String sql = "insert into receipt values('";
		sql += id + "','" + date + "','" + name + "');";
		try {
			return Database.operate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateTimeRecord(int day, City source, City destination) {
		String sql = "insert into time_record values('";
		sql += source + "','" + destination + "'," + day + ");";
		try {
			return Database.operate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}