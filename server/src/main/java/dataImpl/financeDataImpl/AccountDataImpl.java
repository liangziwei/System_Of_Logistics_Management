package dataImpl.financeDataImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import dataService.financeDataService.AccountDataService;
import mysql.Database;
import po.financePO.AccountPO;

/**
 * description:数据服务层为账户管理提供服务的具体实现
 * @author 张仁知
 */
public class AccountDataImpl implements AccountDataService{
	
	public boolean addAccount(AccountPO accountPO) {
		
		String name = accountPO.getName();
		double balance = accountPO.getBalance();
		String val="";
		val = "'"+name+"',"+balance;
		
		return Database.add("account", val);
	}
	
	public AccountPO findAccount(String name) {
		String sql = "select * from account where name = '" + name + "';";
		ResultSet rs;
		String accountName = name;
		double balance = 0.0;
		try {
			rs = Database.findOperation(sql);
			if(rs.next()) {
				balance = rs.getDouble("balance");
			}
			else return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return new AccountPO(accountName, balance);
	}
	
	public boolean deleteAccount(String name) {
		
		return Database.delete("account", "name", name);
	}
	
	public boolean modifyAccount(String oldName, String newName) {
		String sql = "update account set name = '" + newName + "' where name = '" + oldName + "';";
		try {
			return Database.operate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
