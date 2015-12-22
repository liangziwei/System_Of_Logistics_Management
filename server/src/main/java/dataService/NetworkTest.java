package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *用于测试网络是否畅通 
 */
public interface NetworkTest extends Remote{

	/**
	 *RMI调用测试 
	 */
	public boolean connect() throws RemoteException;
}
