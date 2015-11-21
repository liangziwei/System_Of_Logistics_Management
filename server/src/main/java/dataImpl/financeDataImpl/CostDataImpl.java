package dataImpl.financeDataImpl;



import mysql.Database;
import po.financePO.PaymentPO;
import dataService.financeDataService.CostDataService;

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
		+remark+"',0,1";
		return Database.add("payment", val);
	}
}
