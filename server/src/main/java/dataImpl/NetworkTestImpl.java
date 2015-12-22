package dataImpl;

import java.rmi.RemoteException;

import dataService.NetworkTest;

/**
 *网络连接测试 
 */
public class NetworkTestImpl implements NetworkTest{

	@Override
	public boolean connect() throws RemoteException {
		return true;
	}

}
