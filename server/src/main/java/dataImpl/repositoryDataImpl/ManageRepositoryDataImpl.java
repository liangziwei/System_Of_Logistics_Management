package dataImpl.repositoryDataImpl;

import java.util.ArrayList;
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
		List<RepositoryPO> repositoryPOs = new ArrayList<RepositoryPO>();
		repositoryPOs.add(new RepositoryPO("1269324125", "2015-08-14","南京",AreaCodeType.TRUCKAREA,"072", "044", "011"));
		repositoryPOs.add(new RepositoryPO("8669124125", "2015-09-12","广州",AreaCodeType.PLANEAREA,"014", "084", "561"));
		repositoryPOs.add(new RepositoryPO("1262354125", "2015-08-15","南京",AreaCodeType.PLANEAREA,"022", "654", "091"));
		return repositoryPOs;
	}

	public int GetRepositoryExistDT(AreaCodeType ID) {
		// TODO Auto-generated method stub
		return 0;
	}

}
