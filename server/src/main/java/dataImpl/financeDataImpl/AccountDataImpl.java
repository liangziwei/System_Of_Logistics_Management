package dataImpl.financeDataImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import mysql.Database;
import po.financePO.AccountPO;
import dataService.financeDataService.AccountDataService;

/**
 * description:数据服务层为账户管理提供服务的具体实现
 * @author 张仁知
 */
public class AccountDataImpl implements AccountDataService{
	
	ResultSet rs;
	
	public boolean addAccount(AccountPO accountPO) {
		
		String name = accountPO.getName();
		double balance = accountPO.getBalance();
		String val="";
		val = "'"+name+"',"+balance;
		
		return Database.add("account", val);
	}
	
	public AccountPO findAccount(String name) {
		String accountName = name;
		double balance = 0.0;
		try{
			rs = Database.query("account", "name", accountName);
			while(rs.next()) {
				balance = rs.getDouble("balance");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return new AccountPO(accountName, balance);
	}
	
	public boolean deleteAccount(String name) {
		
		return Database.delete("account", "name", name);
	}
	
	public boolean modifyAccount(String name) {
		String accountName = "张三";
		String val ="";
		val = "name='"+accountName+"'";
		
		return Database.modify("account", val, "name", name);
	}
}
