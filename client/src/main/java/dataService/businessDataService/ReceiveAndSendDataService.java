package dataService.businessDataService;

import po.businessPO.ReceiveFormPO;
import po.businessPO.SendFormPO;

public interface ReceiveAndSendDataService {

	public boolean addReceiveFrom(ReceiveFormPO receiveFormPO);
	
	public boolean addSendFrom(SendFormPO sendFormPO);
	
}
