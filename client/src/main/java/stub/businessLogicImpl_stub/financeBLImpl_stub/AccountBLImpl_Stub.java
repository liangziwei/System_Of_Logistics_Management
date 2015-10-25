package stub.businessLogicImpl_stub.financeBLImpl_stub;

import po.financePO.AccountPO;
import stub.dataImpl_stub.financeDataImpl_stub.AccountDataImpl_Stub;
import vo.financeVO.AccountVO;
import businessLogicService.financeBLService.AccountBLService;
import dataService.financeDataService.AccountDataService;

public class AccountBLImpl_Stub implements AccountBLService{
	
	private AccountDataService account = new AccountDataImpl_Stub();
	
	public boolean addAccount(AccountVO accountVO) {		
		return account.addAccount(this.AccountVOToAccountPO(accountVO));		
	}
	
	public AccountVO findAccount(String name) {
		return this.AccountPOToAccountVO(account.findAccount(name));
	}
	
	public boolean deleteAccount(String name) {
		return account.deleteAccount(name);
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
