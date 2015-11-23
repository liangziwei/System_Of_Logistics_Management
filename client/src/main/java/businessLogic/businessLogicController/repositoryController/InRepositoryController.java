package businessLogic.businessLogicController.repositoryController;

import businessLogic.businessLogicModel.repositoryModel.InRepository;
import businessLogicService.repositoryBLService.InRepositoryBLService;
import constant.AreaCodeType;
import vo.repositoryVO.InRepositoryVO;

public class InRepositoryController implements InRepositoryBLService{
	InRepository inRepository = new InRepository();
	public String addInRepositoryFormBL(InRepositoryVO inRepositoryVO) {
		// TODO Auto-generated method stub
		boolean bewarn = this.warnBL(inRepositoryVO);
		return "false";
	}

	public String modifyInRepositoryFormBL(InRepositoryVO inRepositoryVO) {
		// TODO Auto-generated method stub
		return null;
	}

	public InRepositoryVO findInRepositoryFormBL(String InRepositoryNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean warnBL(InRepositoryVO inRepositoryVO) {
		// TODO Auto-generated method stub
		return false;
	}

	public double getWarnNum(AreaCodeType ID) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int GetRepositoryNum(AreaCodeType ID) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int GetRepositoryExist(AreaCodeType ID) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public boolean verify(InRepositoryVO inRepositoryVO) {
		boolean result = inRepository.verify(inRepositoryVO);
		return result;	
	}
	
}
