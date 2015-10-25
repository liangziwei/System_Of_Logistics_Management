package dataImpl.repositoryDataImpl;

import java.util.List;

import constant.AreaCodeType;
import dataService.repositoryDataService.ManageRepositoryDataService;
import po.repositoryPO.DeliveryInfoPO;
import po.repositoryPO.RepositoryInfoPO;
import po.repositoryPO.RepositoryPO;

public class ManageRepositoryDataImpl implements ManageRepositoryDataService {

	public List<RepositoryInfoPO> SeeRepositoryDT(String time) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DeliveryInfoPO> CheckRepositoryDT() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean UpdataRepositoryWarnDT(int allNum, double WarnNum, AreaCodeType ID) {
		// TODO Auto-generated method stub
		return false;
	}

	public double GetWarnNumDT(AreaCodeType ID) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int GetRepositoryNumDT(AreaCodeType ID) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<RepositoryPO> GetRepositoryInfoDT() {
		// TODO Auto-generated method stub
		return null;
	}

	public int GetRepositoryExistDT(AreaCodeType ID) {
		// TODO Auto-generated method stub
		return 0;
	}

}
