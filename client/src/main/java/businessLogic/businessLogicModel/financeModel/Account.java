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
			return false;
		}
		return result;
	}
	
	public AccountVO findAccount(String name) {
		AccountVO account = null;
		try{
			AccountPO po = accountData.findAccount(name);
			if(po == null) return null;
			account = this.AccountPOToAccountVO(po);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
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
	
	public boolean modifyAccount(String oldName, String newName) {
		boolean result = false;
		try{
			result = accountData.modifyAccount(oldName, newName);
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
