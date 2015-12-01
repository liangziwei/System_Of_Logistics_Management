package stub.businessLogicImpl_stub.financeBLImpl_stub;

import po.financePO.AccountPO;
import stub.dataImpl_stub.financeDataImpl_stub.AccountDataImpl_Stub;
import vo.financeVO.AccountVO;
import businessLogicService.financeBLService.AccountBLService;
import dataService.financeDataService.AccountDataService;

public class AccountBLImpl_Stub implements AccountBLService{
	
	private AccountDataService account = new AccountDataImpl_Stub();
	
	public boolean addAccount(AccountVO accountVO) {
		boolean success = false;
		try{
			success = account.addAccount(this.AccountVOToAccountPO(accountVO));	
		}catch(Exception e){
			e.printStackTrace();
		}
		return 	success;
	}
	
	public AccountVO findAccount(String name) {
		AccountVO accountVO = null;
		try{
			accountVO = this.AccountPOToAccountVO(account.findAccount(name));
		} catch(Exception e){
			e.printStackTrace();
		}
		return accountVO;
	}
	
	public boolean deleteAccount(String name) {
		boolean success =false;
		try{
			success = account.deleteAccount(name);
		}catch(Exception e){
			e.printStackTrace();
		}
		return success;
	}
	
	public boolean modifyAccount(String name) {
		boolean success = false;
		try{
//			success = account.modifyAccount(name);
		}catch(Exception e){
			e.printStackTrace();
		}
		return success;
	}
	
	private AccountVO AccountPOToAccountVO(AccountPO accountPO){
		return new AccountVO(accountPO.getName(),accountPO.getBalance());
	}
	
	private AccountPO AccountVOToAccountPO(AccountVO accountVO){
		return new AccountPO(accountVO.getName(),accountVO.getBalance());
	}

	@Override
	public boolean modifyAccount(String oldName, String newName) {
		// TODO Auto-generated method stub
		return false;
	}

}
