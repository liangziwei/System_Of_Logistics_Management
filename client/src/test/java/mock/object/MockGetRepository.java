package mock.object;

import java.util.ArrayList;
import java.util.List;

import constant.AreaCodeType;
import po.repositoryPO.RepositoryPO;

public class MockGetRepository {
	List<RepositoryPO> repositoryPOs = new ArrayList<RepositoryPO>();
	public List<RepositoryPO> GetRepositoryInfoDT() {
		repositoryPOs.add(new RepositoryPO("1269324125", "2015-08-14","南京",AreaCodeType.TRUCKAREA,"072", "044", "011"));
		repositoryPOs.add(new RepositoryPO("8669124125", "2015-09-12","广州",AreaCodeType.PLANEAREA,"014", "084", "561"));
		repositoryPOs.add(new RepositoryPO("1262354125", "2015-08-15","南京",AreaCodeType.PLANEAREA,"022", "654", "091"));
		return repositoryPOs;
	}
	
	public void setRepositoryInfoDT(List<RepositoryPO> repositoryPOs) {
		this.repositoryPOs=repositoryPOs;
	}
	
}
