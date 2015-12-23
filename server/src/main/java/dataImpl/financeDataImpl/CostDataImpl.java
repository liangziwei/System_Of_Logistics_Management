package dataImpl.financeDataImpl;



import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dataService.Approvable;
import dataService.financeDataService.CostDataService;
import mysql.Database;
import po.financePO.PaymentPO;

/**
 * description:数据服务层为成本管理提供服务的具体实现
 * @author 张仁知
 */
public class CostDataImpl implements CostDataService{

	public boolean addPayment(PaymentPO paymentPO) {
		
		String date = paymentPO.getDate();
		double payAmount = paymentPO.getPayAmount();
		String name = paymentPO.getName();
		String account = paymentPO.getAccount();
		String entry = paymentPO.getEntry();
		String remark = paymentPO.getRemark();
		String val = "";
		val = "'"+date+"',"+payAmount+",'"+name+"','"+account+"','"+entry+"','"
		+remark+"','false','false'";
		return Database.add("payment", val);
	}
	
	public ArrayList<PaymentPO> getUncheckPayment() {
		ArrayList<PaymentPO> po = new ArrayList<PaymentPO>();
		String sql = "select * from payment where is_approved = 'false';";
		try {
			ResultSet rs = Database.findOperation(sql);
			while(rs.next()) {
				po.add(this.createPaymentPO(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return po;
	}
	
	private PaymentPO createPaymentPO(ResultSet rs) {
		try {
			return new PaymentPO(rs.getString("date"), rs.getDouble("payAmount"), rs.getString("name"),
					rs.getString("account"), rs.getString("entry"), rs.getString("remark"),
					Boolean.parseBoolean(rs.getString("is_approved")), Boolean.parseBoolean(rs.getString("is_passed")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean ApproveOneForm(Approvable form) throws RemoteException {
		String sql = "update payment set is_approved = 'true', is_passed = 'true' where "
				+ "payAmount = " + ((PaymentPO)form).getPayAmount() + ";";
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
