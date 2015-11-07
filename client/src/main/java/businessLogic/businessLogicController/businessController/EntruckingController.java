package businessLogic.businessLogicController.businessController;

import vo.businessVO.EntruckingVO;
import businessLogic.businessLogicModel.businessModel.Entrucking;
import businessLogicService.businessBLService.EntruckingBLService;

public class EntruckingController implements EntruckingBLService {

	Entrucking entrucking=new Entrucking();
	public boolean addEntruckingFrom(EntruckingVO entruckingVO) {
		// TODO Auto-generated method stub
		return entrucking.addEntruckingFrom(entruckingVO);
	}

}
