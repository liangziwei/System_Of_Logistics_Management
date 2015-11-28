package businessLogic.businessLogicController.repositoryController;

import businessLogic.businessLogicModel.repositoryModel.InRepository;
import businessLogicService.repositoryBLService.InRepositoryBLService;
import businessLogicService.repositoryBLService.ManageRepositoryBLService;
import constant.AreaCodeType;
import vo.repositoryVO.InRepositoryVO;

public class InRepositoryController implements InRepositoryBLService{
	InRepository inRepository = new InRepository();
	ManageRepositoryBLService manageRepositoryBLService = new ManageRepositoryController();
	public String addInRepositoryFormBL(InRepositoryVO inRepositoryVO) {
		// TODO Auto-generated method stub
		boolean add = inRepository.addInRepositoryFormBL(inRepositoryVO); 
		if (add) {
			boolean bewarn = this.warnBL(inRepositoryVO);
			if (bewarn) {
				return "true.warn";
			}
			else {
				return  "true";
			}
		}
		else {
			return "false";			
		}
	}

	public String modifyInRepositoryFormBL(InRepositoryVO inRepositoryVO) {
		// TODO Auto-generated method stub
		boolean modify = inRepository.modifyInRepositoryFormBL(inRepositoryVO);
		if (modify) {
			boolean bewarn = this.warnBL(inRepositoryVO);
			if (bewarn) {
				return "true.warn";
			}
			else {
				return "true";
			}
		}
		else {
			return "false";			
		}
	}

	public InRepositoryVO findInRepositoryFormBL(String InRepositoryNumber) {
		// TODO Auto-generated method stub
		return inRepository.findInRepositoryFormBL(InRepositoryNumber);
	}

	public boolean warnBL(InRepositoryVO inRepositoryVO) {
		// TODO Auto-generated method stub
		double warnNUM = this.getWarnNum(inRepositoryVO.getareaCode());
		int RepNUM = this.GetRepositoryNum(inRepositoryVO.getareaCode());
		int ExistNUM = this.GetRepositoryExist(inRepositoryVO.getareaCode());
		if (ExistNUM>=(warnNUM*RepNUM)) {
			return true;
		}
		else {
			return false;			
		}
	}

	public double getWarnNum(AreaCodeType ID) {
		// TODO Auto-generated method stub
		return manageRepositoryBLService.GetWarnNumBL(ID);
	}

	public int GetRepositoryNum(AreaCodeType ID) {
		// TODO Auto-generated method stub
		return manageRepositoryBLService.GetRepositoryNumBL(ID);
	}

	public int GetRepositoryExist(AreaCodeType ID) {
		// TODO Auto-generated method stub
		return manageRepositoryBLService.GetRepositoryExistBL(ID);
	}
	
	public boolean verify(InRepositoryVO inRepositoryVO) {
		boolean result = inRepository.verify(inRepositoryVO);
		return result;	
	}
	
}
