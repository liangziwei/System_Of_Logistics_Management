package mock.object;

import constant.City;
import constant.TransitType;
import dataService.managerDataService.MakeConstantDataService;

public class MockMakeConstantData implements MakeConstantDataService{
	public boolean updatePrice(double price,TransitType transType){
		return true;
	}
	
	public boolean updateDistance(double distance,City source,City destination){
		return false;
	}
}
