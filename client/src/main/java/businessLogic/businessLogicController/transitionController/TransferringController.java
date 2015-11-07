package businessLogic.businessLogicController.transitionController;

import java.util.List;

import businessLogic.businessLogicController.repositoryController.ManageRepositoryController;
import businessLogic.businessLogicModel.transitionModel.Transferring;
import businessLogicService.repositoryBLService.ManageRepositoryBLService;
import businessLogicService.transitionBLService.TransferringBLService;
import constant.City;
import vo.repositoryVO.RepositoryVO;
import vo.transitionVO.TransferringVO;

public class TransferringController implements TransferringBLService{
	ManageRepositoryBLService manageRepositoryBLService = new ManageRepositoryController();
	Transferring transferring = new Transferring();

	public TransferringVO findTransferringFormBL(String transferringNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addTransferringFormBL(TransferringVO transferringVO) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean modifyTransferringFormBL(TransferringVO transferringVO) {
		// TODO Auto-generated method stub
		return false;
	}

	public double tranferringFare(String CityFrom, String CityTo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<RepositoryVO> getRepositoryInfo() {
		// TODO Auto-generated method stub
		return manageRepositoryBLService.GetRepositoryInfoBL();
	}

	public List<TransferringVO> GetTansferringInfoBL(String date) {
		// TODO Auto-generated method stub
		return transferring.GetTansferringInfoBL(date);
	}


}
