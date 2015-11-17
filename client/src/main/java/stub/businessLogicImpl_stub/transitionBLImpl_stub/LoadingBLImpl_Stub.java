package stub.businessLogicImpl_stub.transitionBLImpl_stub;

import businessLogicService.transitionBLService.LoadingBLService;
import constant.City;
import dataService.transitionDataService.LoadingDataService;
import po.transitionPO.LoadingPO;
import stub.dataImpl_stub.transitionDataImpl_stub.LoadingDataImpl_Stub;
import vo.transitionVO.LoadingVO;

public class LoadingBLImpl_Stub implements LoadingBLService {
	private LoadingDataService  loadingdata = new LoadingDataImpl_Stub();

	public LoadingVO findLoadingFormBL(String loadingNumber) {
		// TODO Auto-generated method stub		
		return this.LoadingPOtoLoadingVO(loadingdata.FindLoadingFormDT(loadingNumber));
	}

	public boolean addLoadingFormBL(LoadingVO loadingVO) {
		// TODO Auto-generated method stub
		double fare =this.loadingFare("南京", loadingVO.getarrivalid());
		loadingVO.setfare(fare);
		LoadingPO loadingPO = this.LoadingVOtoLoadingPO(loadingVO);
		return loadingdata.AddLoadingFormDT(loadingPO);
	}

	public boolean modifyLoadingFormBL(LoadingVO loadingVO) {
		// TODO Auto-generated method stub
		double fare =this.loadingFare("南京", loadingVO.getarrivalid());
		loadingVO.setfare(fare);
		LoadingPO loadingPO = this.LoadingVOtoLoadingPO(loadingVO);
		return loadingdata.ModifyLoadingFormDT(loadingPO);
	}

	public double loadingFare(String CityFrom, String CityTo) {
		// TODO Auto-generated method stub
		return 500;
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

	@Override
	public boolean verify(LoadingVO loadingVO) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
