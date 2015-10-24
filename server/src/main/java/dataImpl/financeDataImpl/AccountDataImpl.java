package dataImpl.financeDataImpl;

import po.financePO.AccountPO;
import dataService.financeDataService.AccountDataService;

/**
 * description:数据服务层为账户管理提供服务的具体实现
 * @author 张仁知
 */
public class AccountDataImpl implements AccountDataService{
	
	public boolean addAccount(AccountPO accountPO) {
		return false;
	}
	
	public AccountPO findAccount(String name) {
		return null;
	}
	
	public boolean deleteAccount(String name) {
		return false;
	}
	
	public boolean modifyAccount(String name) {
		return false;
	}
}
