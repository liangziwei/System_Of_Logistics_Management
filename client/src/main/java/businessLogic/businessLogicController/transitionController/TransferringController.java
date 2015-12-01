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
//	ManageRepositoryBLService manageRepositoryBLService = new ManageRepositoryController();
	Transferring transferring = new Transferring();
	ManageRepositoryBLService manageRepository = new ManageRepositoryController();

	public TransferringVO findTransferringFormBL(String transferringNumber) {
		// TODO Auto-generated method stub
		return transferring.findTransferringFormBL(transferringNumber);
	}

	public boolean addTransferringFormBL(TransferringVO transferringVO) {
		// TODO Auto-generated method stub
		return transferring.addTransferringFormBL(transferringVO);
	}

	public boolean modifyTransferringFormBL(TransferringVO transferringVO) {
		// TODO Auto-generated method stub
		return transferring.modifyTransferringFormBL(transferringVO);
	}

	public double tranferringFare(String CityFrom, String CityTo) {
		// TODO Auto-generated method stub
		return transferring.tranferringFare(CityFrom, CityTo);
	}

	public List<RepositoryVO> getRepositoryInfo() {
		// TODO Auto-generated method stub
		return manageRepository.GetRepositoryInfoBL();
	}

	public List<TransferringVO> GetTansferringInfoBL(String date) {
		// TODO Auto-generated method stub
		return transferring.GetTansferringInfoBL(date);
	}

	@Override
	public boolean verify(TransferringVO transferringVO) {
		// TODO Auto-generated method stub
		return transferring.verify(transferringVO);
	}


}
