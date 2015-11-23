package rmiTest;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Test;

import businessLogic.businessLogicController.administratorController.LoginBL;

public class AdministratorRMI {

	@Test
	public void test() throws RemoteException {
		LoginBL login=new LoginBL();
		assertEquals(true,login.login("admin","0000"));
	}

}
