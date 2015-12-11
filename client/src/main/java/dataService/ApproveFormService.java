package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *审批单据 
 */
public interface ApproveFormService extends Remote{

	/**
	 *审批通过一张单据 
	 */
	public boolean ApproveOneForm(Approvable form) throws RemoteException;
	
	/**
	 *审批通过多张单据 
	 */
	public boolean ApproveMoreForm(ArrayList<? extends Approvable> forms) throws RemoteException;
}
