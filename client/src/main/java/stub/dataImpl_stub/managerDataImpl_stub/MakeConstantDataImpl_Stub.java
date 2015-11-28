package stub.dataImpl_stub.managerDataImpl_stub;

import constant.City;
import constant.TransitType;
import dataService.managerDataService.MakeConstantDataService;

public class MakeConstantDataImpl_Stub implements MakeConstantDataService{
	public boolean updatePrice(double price,TransitType transType) {
		return false;
	}
	
	public boolean updateDistance(double distance,City source,City destination) {
		return false;
	}
}
