package stub.businessLogicImpl_stub.repositoryBLImpl_stub;

import businessLogicService.repositoryBLService.InRepositoryBLService;
import dataService.repositoryDataService.InRepositoryDataService;
import stub.dataImpl_stub.repositoryDataImpl.InRepositoryDataImpl_Stub;
import vo.repositoryVO.InRepositoryVO;

public class InRepositoryBLImpl_Stub implements InRepositoryBLService{
	InRepositoryDataService inRepositoryDataService=new InRepositoryDataImpl_Stub();

	public String addInRepositoryFormBL(InRepositoryVO inRepository) {
		// TODO Auto-generated method stub
		
		return null;
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

	public double getWarnNum(String ID) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int GetRepositoryNum(String ID) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int GetRepositoryExist(String ID) {
		// TODO Auto-generated method stub
		return 0;
	}

}
