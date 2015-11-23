package businessLogic.businessLogicController.repositoryController;

import java.util.List;

import businessLogic.businessLogicController.transitionController.TransferringController;
import businessLogicService.repositoryBLService.OutRepositoryBLService;
import businessLogicService.transitionBLService.TransferringBLService;
import vo.repositoryVO.OutRepositoryVO;
import vo.transitionVO.TransferringVO;

public class OutRepositoryController implements OutRepositoryBLService{
	TransferringBLService transferringBLService = new TransferringController();

	public boolean addOutRepositoryFormBL(OutRepositoryVO outRepositoryVO) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean modifyOutRepositoryFormBL(OutRepositoryVO outRepositoryVO) {
		// TODO Auto-generated method stub
		return false;
	}

	public OutRepositoryVO findOutRepositoryFormBL(String OutRepositoryNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TransferringVO> GetTransferringInfo(String date) {
		// TODO Auto-generated method stub
		return transferringBLService.GetTansferringInfoBL(date);
	}

}
