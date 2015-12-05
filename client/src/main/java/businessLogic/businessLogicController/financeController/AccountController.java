package businessLogic.businessLogicController.financeController;

import vo.financeVO.AccountVO;
import businessLogic.businessLogicModel.financeModel.Account;
import businessLogicService.financeBLService.AccountBLService;
/** 
 * description:为账户管理界面提供服务的具体实现
 * @author 张仁知
 *
 */

public class AccountController implements AccountBLService {
	
	private Account account = new Account();
	
	public boolean addAccount(AccountVO accountVO) {
			return account.addAccount(accountVO);		
	}
	
	public AccountVO findAccount(String name) {
		
		return account.findAccount(name);
	}
	
	public boolean deleteAccount(String name) {
		
		return account.deleteAccount(name);
	}
	
	public boolean modifyAccount(String oldName, String newName) {
		
		return account.modifyAccount(oldName, newName);
	}

}
 