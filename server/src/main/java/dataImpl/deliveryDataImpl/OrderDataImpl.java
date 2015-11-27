package dataImpl.deliveryDataImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import constant.City;
import constant.ClientType;
import constant.DeliveryType;
import constant.PackageType;
import constant.TransitionNode;
import dataService.deliveryDataService.OrderDataService;
import mysql.Database;
import po.deliveryPO.ClientInfo;
import po.deliveryPO.GoodsInfo;
import po.deliveryPO.OrderPO;
import po.deliveryPO.TimeRecordPO;

/**
 * description:数据服务层为订单信息处理提供服务的具体实现
 * @author 肖安祥
 */
public class OrderDataImpl implements OrderDataService{

	public OrderPO getOrderInfoById(String id){
		ResultSet rs;
		try {
			rs = Database.findOperation("select * from order_table where goods_id = '" + id + "';");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		//货物信息
		String goods_id = id, number = null, weight = null, volumn = null, name = null;
		DeliveryType deliveryType = null;
		PackageType packageType = null;
		List<TransitionNode> nodes = new ArrayList<TransitionNode>();
		List<City> citys = new ArrayList<City>();
		//寄件人信息
		String sender_name = null, sender_addr = null, sender_com = null, sender_phone = null, sender_mobile = null;
		City sender_city = null;
		//收件人信息
		String receiver_name = null, receiver_addr = null, receiver_com = null, receiver_phone = null, receiver_mobile = null;
		City receiver_city = null;
		//送件日期
		String date = null;
		//运费
		String price = null;
		//预估时间
		String time = null;
		try {
			if(rs.next()) {
				//货物信息
				goods_id = rs.getString("goods_id");
				number = new Integer(rs.getInt("goods_number")).toString();
				weight = new Double(rs.getDouble("goods_weight")).toString();
				volumn = new Double(rs.getDouble("goods_volumn")).toString();
				name = rs.getString("goods_name");
				deliveryType = DeliveryType.valueOf(rs.getString("goods_delivery_type"));
				packageType = PackageType.valueOf(rs.getString("goods_package_type"));
				String temp1 = rs.getString("goods_trace");
				String[] temp2 = temp1.split("-");
				for(int i = 0; i < temp2.length; i++) {
					nodes.add(TransitionNode.valueOf(temp2[i]));
				}
				temp1 = rs.getString("goods_city");
				temp2 = temp1.split("-");
				for(int i = 0; i < temp2.length; i++) {
					 citys.add(City.valueOf(temp2[i]));
				}
				//寄件人信息
				sender_name = rs.getString("sender_name");
				sender_addr = rs.getString("sender_address");
				sender_com = rs.getString("sender_company");
				sender_phone = rs.getString("sender_phone");
				sender_mobile = rs.getString("sender_mobile");
				sender_city = City.valueOf(rs.getString("sender_city"));
				//收件人信息
				receiver_name = rs.getString("receiver_name");
				receiver_addr = rs.getString("receiver_address");
				receiver_com = rs.getString("receiver_company");
				receiver_phone = rs.getString("receiver_phone");
				receiver_mobile = rs.getString("receiver_mobile");
				receiver_city = City.valueOf(rs.getString("receiver_city"));
				//送件日期
				date = rs.getString("date");
				//运费
				price = new Double(rs.getDouble("price")).toString();
				//预估时间
				time = new Integer(rs.getInt("time")).toString();
			}
			else return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return new OrderPO(
				new ClientInfo(ClientType.SENDER, sender_name, sender_addr, sender_com,
						sender_phone, sender_mobile, sender_city),
				new ClientInfo(ClientType.RECEIVER, receiver_name, receiver_addr, receiver_com,
						receiver_phone, receiver_mobile, receiver_city),
				new GoodsInfo(number, goods_id, weight, name, volumn,
						packageType, deliveryType, date, nodes, citys, time, price));
	}

	public boolean saveOrderInfo(OrderPO orderPO) {
		String sql = "insert into order_table values('";
		//货物信息
		GoodsInfo goods = orderPO.getGoodsInfo();
		sql += goods.getId() + "'," + goods.getNumber() + "," + goods.getWeight() + "," + goods.getSize() + ",'";
		sql += goods.getName() + "','" + goods.getDeliveryType() + "','" + goods.getPackageType() + "','";
		List<TransitionNode> nodes = goods.getTransitNode();
		for(int i = 0; i < nodes.size() - 1; i++) {
			sql += nodes.get(i) + "-";
		}
		sql += nodes.get(nodes.size() - 1) + "','";
		List<City> citys = goods.getCity();
		for(int i = 0; i < nodes.size() - 1; i++) {
			sql += citys.get(i) + "-";
		}
		sql += citys.get(citys.size() - 1) + "','";
		//寄件人信息
		ClientInfo sender = orderPO.getSenderInfo();
		sql += sender.getName() + "','";
		sql += sender.getAddress() + "','";
		sql += sender.getCompany() + "','";
		sql += sender.getPhoneNumber() + "','";
		sql += sender.getMobileNumber() + "','";
		sql += sender.getCity() + "','";
		//收件人信息
		ClientInfo receiver = orderPO.getReceiverInfo();
		sql += receiver.getName() + "','";
		sql += receiver.getAddress() + "','";
		sql += receiver.getCompany() + "','";
		sql += receiver.getPhoneNumber() + "','";
		sql += receiver.getMobileNumber() + "','";
		sql += receiver.getCity() + "','";
		//快递出发日期
		sql += goods.getDate() + "',";
		//快递运费
		sql += goods.getPrice() + ",";
		//快递预估时间
		sql += goods.getTime() + ",'";
		//是否已经被审批
		sql += goods.isApproved() + "','";
		//是否已经审批通过
		sql += goods.isPassed() + "');";
		try {
			return Database.operate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<TimeRecordPO> getTimeRecords(City source, City destination) {
		List<TimeRecordPO> records = new ArrayList<TimeRecordPO>();
		ResultSet rs = null;
		try {
			rs = Database.findOperation("select * from time_record where source = '"
					+ source + "' && destination = '" + destination + "';");
		} catch (SQLException e1) {
			e1.printStackTrace();
			return null;
		}
		try {
			while(rs.next()) {
				records.add(new TimeRecordPO(source, destination, rs.getInt("time")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return records;
	}

}
