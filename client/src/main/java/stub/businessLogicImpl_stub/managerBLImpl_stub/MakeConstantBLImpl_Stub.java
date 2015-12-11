package stub.businessLogicImpl_stub.managerBLImpl_stub;

import java.util.HashMap;
import java.util.Map;

import businessLogicService.managerBLService.MakeConstantBLService;
import constant.City;
import po.constant.DistanceTable;
import po.constant.PackPrice;
import po.constant.TransitPrice;

public class MakeConstantBLImpl_Stub implements MakeConstantBLService{
	
	@Override
	public boolean setDistance(DistanceTable distance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<City, HashMap<City, Double>> getDistance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setPackPrice(PackPrice price) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PackPrice getPackPrice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setTransitPrice(TransitPrice price) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TransitPrice getTransitPrice() {
		// TODO Auto-generated method stub
		return null;
	}
}