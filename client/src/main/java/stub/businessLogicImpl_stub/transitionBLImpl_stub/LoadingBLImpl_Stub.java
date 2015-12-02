package stub.businessLogicImpl_stub.transitionBLImpl_stub;

import java.rmi.RemoteException;

import businessLogicService.transitionBLService.LoadingBLService;
import constant.City;
import constant.LoadingType;
import dataService.transitionDataService.LoadingDataService;
import po.transitionPO.LoadingPO;
import stub.dataImpl_stub.transitionDataImpl_stub.LoadingDataImpl_Stub;
import vo.transitionVO.LoadingVO;

public class LoadingBLImpl_Stub implements LoadingBLService {
	private LoadingDataService  loadingdata = new LoadingDataImpl_Stub();

	public LoadingVO findLoadingFormBL(String loadingNumber) {
		// TODO Auto-generated method stub		
		try {
			return this.LoadingPOtoLoadingVO(loadingdata.FindLoadingFormDT(loadingNumber));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean addLoadingFormBL(LoadingVO loadingVO) {
		// TODO Auto-generated method stub
		double fare =this.loadingFare("南京", loadingVO.getarrivalid(),loadingVO.getway());
		loadingVO.setfare(fare);
		LoadingPO loadingPO = this.LoadingVOtoLoadingPO(loadingVO);
		try {
			return loadingdata.AddLoadingFormDT(loadingPO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean modifyLoadingFormBL(LoadingVO loadingVO) {
		// TODO Auto-generated method stub
		double fare =this.loadingFare("南京", loadingVO.getarrivalid(),loadingVO.getway());
		loadingVO.setfare(fare);
		LoadingPO loadingPO = this.LoadingVOtoLoadingPO(loadingVO);
		try {
			return loadingdata.ModifyLoadingFormDT(loadingPO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


	
	private LoadingVO LoadingPOtoLoadingVO(LoadingPO loadingPO){
		LoadingVO loadingVO =new LoadingVO(loadingPO.getloadingid(), loadingPO.getarrivalid(), 
				loadingPO.getway(), loadingPO.getwayid(), loadingPO.getsupervisionid(), 
				loadingPO.getsupercargoid(),loadingPO.getalldeliveryid());
		loadingVO.setfare(loadingPO.getfare());
		return loadingVO;
	}
	private LoadingPO LoadingVOtoLoadingPO(LoadingVO loadingVO){
		LoadingPO loadingPO =new LoadingPO(loadingVO.getloadingid(), loadingVO.getarrivalid(), loadingVO.getway(),
				loadingVO.getwayid(), loadingVO.getsupervisionid(), loadingVO.getsupercargoid(),
				loadingVO.getalldeliveryid());
		loadingPO.setfare(loadingVO.getfare());
		return loadingPO;
	}

	public boolean verify(LoadingVO loadingVO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double loadingFare(String CityFrom, String CityTo, LoadingType type) {
		// TODO Auto-generated method stub
		return 500;
	}
	
}
