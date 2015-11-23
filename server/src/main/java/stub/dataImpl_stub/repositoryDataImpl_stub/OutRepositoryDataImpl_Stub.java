package stub.dataImpl_stub.repositoryDataImpl_stub;

import constant.LoadingType;
import dataService.repositoryDataService.OutRepositoryDataService;
import po.repositoryPO.OutRepositoryPO;

public class OutRepositoryDataImpl_Stub implements OutRepositoryDataService{

	public boolean AddOutRepositoryFormDT(OutRepositoryPO outRepository) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean ModifyOutRepositoryFormDT(OutRepositoryPO outRepositoryPO) {
		// TODO Auto-generated method stub
		return true;
	}

	public OutRepositoryPO FindOutRepositoryFormDT(String OutRepositoryNumber) {
		// TODO Auto-generated method stub
		return new OutRepositoryPO("2015100046", "2015-10-18","广州",LoadingType.TRUCK,"025 1012 0002301",false);
	}

	public boolean UpdateRepositoryInfoDT(OutRepositoryPO outRepositoryPO) {
		// TODO Auto-generated method stub
		return true;
	}

}
