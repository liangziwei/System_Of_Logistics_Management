package businessTest;

import dataImpl.financeDataImpl.AccountDataImpl;
import po.financePO.AccountPO;

public class AccountDataTest {
	public static void main(String[] args) {
//		AccountPO accountPO = new AccountPO("南财", 131452.0);
		AccountDataImpl accountData = new AccountDataImpl();
		AccountPO result = accountData.findAccount("张三");
		System.out.println(result.getName()+"  "+result.getBalance());
	}
}
