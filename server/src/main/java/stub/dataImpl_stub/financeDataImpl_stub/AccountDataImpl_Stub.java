package stub.dataImpl_stub.financeDataImpl_stub;

import po.financePO.AccountPO;
import dataService.financeDataService.AccountDataService;

public class AccountDataImpl_Stub implements AccountDataService {
	public boolean addAccount(AccountPO accountPO) {
		return false;
	}
	
	public AccountPO findAccount(String name) {
		AccountPO account1=new AccountPO(name,100.0);
		return account1;		
	}
	
	public boolean deleteAccount(String name) {
		return false;
	}
	
	public boolean modifyAccount(String name) {
		return false;
	}

}
