package driver.ui_driver.administratorUI_driver;

import stub.businessLogicImpl_stub.administratorBLImpl_stub.LoginBLImpl_Stub;
import businessLogicService.administratorBLService.LoginBLService;

public class LoginUI_Driver {

	private LoginBLService loginBL=new LoginBLImpl_Stub();
	public void driver(){
		if(loginBL.login("C123456","0000")){
			System.out.println("登陆成功");
		}else{
			System.out.println("登陆失败");
		}
	}
}
