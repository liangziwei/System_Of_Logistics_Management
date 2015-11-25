package dataImpl.repositoryDataImpl;

import constant.LoadingType;
import dataService.repositoryDataService.OutRepositoryDataService;
import po.repositoryPO.OutRepositoryPO;

public class OutRepositoryDataImpl implements OutRepositoryDataService {

	public boolean AddOutRepositoryFormDT(OutRepositoryPO outRepository) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean ModifyOutRepositoryFormDT(OutRepositoryPO outRepositoryPO) {
		// TODO Auto-generated method stub
		return false;
	}

	public OutRepositoryPO FindOutRepositoryFormDT(String OutRepositoryNumber) {
		// TODO Auto-generated method stub
		OutRepositoryPO outRepositoryPO = new OutRepositoryPO("2015100046", "2015-10-18","广州",LoadingType.TRUCK,"025 1012 0002301");
		return outRepositoryPO;
	}

	public boolean UpdateRepositoryInfoDT(OutRepositoryPO outRepositoryPO) {
		// TODO Auto-generated method stub
		return false;
	}

}
