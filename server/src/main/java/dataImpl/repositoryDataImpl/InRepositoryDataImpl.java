package dataImpl.repositoryDataImpl;

import constant.AreaCodeType;
import dataService.repositoryDataService.InRepositoryDataService;
import po.repositoryPO.InRepositoryPO;

public class InRepositoryDataImpl implements InRepositoryDataService {

	public boolean AddInRepositoryFormDT(InRepositoryPO inRepositoryPO) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean ModifyInRepositoryFormDT(InRepositoryPO inRepository) {
		// TODO Auto-generated method stub
		return false;
	}

	public InRepositoryPO FindInRepositoryFormDT(String InRepositoryNumber) {
		// TODO Auto-generated method stub
		InRepositoryPO inRepositoryPO = new InRepositoryPO("1110101023","2015-10-13", "北京",AreaCodeType.MOTOAREA,"004","012","042");
		return inRepositoryPO;
	}

	public boolean UpdateRepositoryInfoDT(InRepositoryPO inRepository) {
		// TODO Auto-generated method stub
		return false;
	}

}
