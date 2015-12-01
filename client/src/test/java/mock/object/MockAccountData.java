package mock.object;

import po.financePO.AccountPO;

import java.rmi.RemoteException;

import dataService.financeDataService.AccountDataService;

public class MockAccountData implements AccountDataService{

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

	@Override
	public boolean modifyAccount(String oldName, String newName) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
}
