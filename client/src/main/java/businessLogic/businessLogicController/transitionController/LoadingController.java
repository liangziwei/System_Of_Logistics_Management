package businessLogic.businessLogicController.transitionController;

import businessLogic.businessLogicModel.transitionModel.Loading;
import businessLogicService.transitionBLService.LoadingBLService;
import constant.City;
import vo.transitionVO.LoadingVO;

public class LoadingController implements LoadingBLService{
	Loading loading = new Loading();

	public LoadingVO findLoadingFormBL(String loadingNumber) {
		// TODO Auto-generated method stub
		return loading.findLoadingFormBL(loadingNumber);
	}

	public boolean addLoadingFormBL(LoadingVO loadingVO) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean modifyLoadingFormBL(LoadingVO loadingVO) {
		// TODO Auto-generated method stub
		return false;
	}

	public double loadingFare(String CityFrom, String CityTo) {
		// TODO Auto-generated method stub
		return 0;
	}
	public boolean verify(LoadingVO loadingVO) {
		boolean result = loading.verifyres(loadingVO);
		return result;
	}

}
