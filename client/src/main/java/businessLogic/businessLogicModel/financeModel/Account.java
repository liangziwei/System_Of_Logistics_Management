package businessLogic.businessLogicModel.financeModel;

import po.financePO.AccountPO;
import vo.financeVO.AccountVO;
import mock.object.MockAccountData;
import dataService.financeDataService.AccountDataService;

public class Account {

	private AccountDataService accountData = new MockAccountData();
	
	public boolean addAccount(AccountVO accountVO) {		
		return accountData.addAccount(this.AccountVOToAccountPO(accountVO));		
	}
	
	public AccountVO findAccount(String name) {
		return this.AccountPOToAccountVO(accountData.findAccount(name));
	}
	
	public boolean deleteAccount(String name) {
		return accountData.deleteAccount(name);
	}
	
	public boolean modifyAccount(AccountVO accountVO) {
		return false;
	}
	
	private AccountVO AccountPOToAccountVO(AccountPO accountPO){
		return new AccountVO(accountPO.getName(),accountPO.getBalance());
	}
	
	private AccountPO AccountVOToAccountPO(AccountVO accountVO){
		return new AccountPO(accountVO.getName(),accountVO.getBalance());
	}

}
