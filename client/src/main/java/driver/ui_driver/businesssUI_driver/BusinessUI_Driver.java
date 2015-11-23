package driver.ui_driver.businesssUI_driver;

import java.rmi.RemoteException;

public class BusinessUI_Driver {

	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub

		EntruckingUI_Driver entrucking=new EntruckingUI_Driver();
		ReceiveAndSendUI_Driver receiveAndSend=new ReceiveAndSendUI_Driver();
		PaymentUI_Driver payment=new PaymentUI_Driver();
		VehicleUI_Driver vehicle=new VehicleUI_Driver();
		DriverUI_Driver driverUI=new DriverUI_Driver();
		
		entrucking.driver();
		receiveAndSend.driver();
		payment.driver();
		vehicle.driver();
		driverUI.driver();
		
	}

}
