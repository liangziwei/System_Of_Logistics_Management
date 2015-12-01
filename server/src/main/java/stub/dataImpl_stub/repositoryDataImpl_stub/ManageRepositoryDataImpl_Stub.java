package stub.dataImpl_stub.repositoryDataImpl_stub;

import java.util.ArrayList;
import java.util.List;

import constant.AreaCodeType;
import dataService.repositoryDataService.ManageRepositoryDataService;
import po.repositoryPO.DeliveryInfoPO;
import po.repositoryPO.RepositoryInfoPO;
import po.repositoryPO.RepositoryPO;

public class ManageRepositoryDataImpl_Stub implements ManageRepositoryDataService{

	public List<RepositoryInfoPO> SeeRepositoryDT(String time) {
		// TODO Auto-generated method stub
		List<RepositoryInfoPO> repositoryInfoPOs =new ArrayList<RepositoryInfoPO>();
		repositoryInfoPOs.add(new RepositoryInfoPO("1232409000",AreaCodeType.PLANEAREA, "014","101","067", true));
		repositoryInfoPOs.add(new RepositoryInfoPO("1232409120",AreaCodeType.PLANEAREA, "015","111","167", false));
		repositoryInfoPOs.add(new RepositoryInfoPO("1232409010",AreaCodeType.TRAINAREA, "024","001","067", true));
		repositoryInfoPOs.add(new RepositoryInfoPO("1682409010",AreaCodeType.TRUCKAREA, "064","041","014", false));
		return repositoryInfoPOs;
	}

	public List<DeliveryInfoPO> CheckRepositoryDT() {
		// TODO Auto-generated method stub
		List<DeliveryInfoPO> deliveryInfoPOs = new ArrayList<DeliveryInfoPO>();
		deliveryInfoPOs.add(new DeliveryInfoPO("1269324125", "2015-08-14","南京",AreaCodeType.TRUCKAREA,"072", "044", "011"));
		deliveryInfoPOs.add(new DeliveryInfoPO("1298697725", "2015-07-25","北京",AreaCodeType.MOTOAREA,"015", "034", "321"));
		deliveryInfoPOs.add(new DeliveryInfoPO("1349124125", "2015-10-13","北京",AreaCodeType.TRAINAREA,"012", "054", "141"));
		deliveryInfoPOs.add(new DeliveryInfoPO("8669124125", "2015-09-12","广州",AreaCodeType.PLANEAREA,"014", "084", "561"));
		deliveryInfoPOs.add(new DeliveryInfoPO("1269122352", "2015-12-13","上海",AreaCodeType.TRUCKAREA,"032", "564", "323"));
		deliveryInfoPOs.add(new DeliveryInfoPO("1262354125", "2015-08-15","南京",AreaCodeType.PLANEAREA,"022", "654", "091"));
		return deliveryInfoPOs;
	}

	public boolean UpdataRepositoryWarnDT(int allNum, double WarnNum, AreaCodeType ID) {
		// TODO Auto-generated method stub
		return true;
	}

	public double GetWarnNumDT(AreaCodeType ID) {
		// TODO Auto-generated method stub
		return 0.8;
	}

	public int GetRepositoryNumDT(AreaCodeType ID) {
		// TODO Auto-generated method stub
		return 700;
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
		return 300;
	}

}
