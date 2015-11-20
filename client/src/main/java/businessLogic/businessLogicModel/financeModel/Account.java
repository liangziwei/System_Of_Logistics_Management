package businessLogic.businessLogicModel.financeModel;

import network.RMI;
import po.financePO.AccountPO;
import vo.financeVO.AccountVO;
import dataService.financeDataService.AccountDataService;

public class Account {

	private AccountDataService accountData = RMI.<AccountDataService>getDataService("account");	
	
	public boolean addAccount(AccountVO accountVO) {
		boolean result = false;
		try{
			result = accountData.addAccount(this.AccountVOToAccountPO(accountVO));
		} catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public AccountVO findAccount(String name) {
		AccountVO account = null;
		try{
			account = this.AccountPOToAccountVO(accountData.findAccount(name));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return account;
	}
	
	public boolean deleteAccount(String name) {
		boolean result = false;
		try{
			result = accountData.deleteAccount(name);
		} catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean modifyAccount(String name) {
		boolean result = false;
		try{
			result = accountData.modifyAccount(name);
		} catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	private AccountVO AccountPOToAccountVO(AccountPO accountPO){
		return new AccountVO(accountPO.getName(),accountPO.getBalance());
	}
	
	private AccountPO AccountVOToAccountPO(AccountVO accountVO){
		return new AccountPO(accountVO.getName(),accountVO.getBalance());
	}

}
