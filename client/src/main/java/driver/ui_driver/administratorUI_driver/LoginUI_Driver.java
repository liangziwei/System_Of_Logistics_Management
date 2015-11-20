package driver.ui_driver.administratorUI_driver;

import java.rmi.RemoteException;

import stub.businessLogicImpl_stub.administratorBLImpl_stub.LoginBLImpl_Stub;
import businessLogicService.administratorBLService.LoginBLService;

public class LoginUI_Driver {

	private LoginBLService loginBL=new LoginBLImpl_Stub();
	
	public static void main(String[] args) throws RemoteException {
		LoginUI_Driver login=new LoginUI_Driver();
		login.driver();
	}
	
	public void driver() throws RemoteException{
		if(loginBL.login("C123456","0000")){
			System.out.println("登陆成功");
		}else{
			System.out.println("登陆失败");
		}
	}
}
