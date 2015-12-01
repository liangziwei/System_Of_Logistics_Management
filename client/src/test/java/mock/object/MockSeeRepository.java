package mock.object;

import java.util.ArrayList;
import java.util.List;

import constant.AreaCodeType;
import po.repositoryPO.RepositoryInfoPO;

public class MockSeeRepository {
	List<RepositoryInfoPO> repositoryInfoPOs =new ArrayList<RepositoryInfoPO>();
	public List<RepositoryInfoPO> SeeRepositoryDT(String time) {
		repositoryInfoPOs.add(new RepositoryInfoPO("1232409000",AreaCodeType.PLANEAREA, "014","101","067", true));
		repositoryInfoPOs.add(new RepositoryInfoPO("1232409120",AreaCodeType.PLANEAREA, "015","111","167", false));
		repositoryInfoPOs.add(new RepositoryInfoPO("1232409010",AreaCodeType.TRAINAREA, "024","001","067", true));
		repositoryInfoPOs.add(new RepositoryInfoPO("1682409010",AreaCodeType.TRUCKAREA, "064","041","014", false));
		return repositoryInfoPOs;
	}
	public void setRepositoryDT(List<RepositoryInfoPO> repositoryInfoPOs) {
		this.repositoryInfoPOs=repositoryInfoPOs;
	}


}
