package businessLogicImpl.repositoryBLImpl;

import java.util.List;

import businessLogicService.repositoryBLService.ManageRepositoryBLService;
import vo.repositoryVO.DeliveryInfoVO;
import vo.repositoryVO.RepositoryInfoVO;
import vo.repositoryVO.RepositoryVO;

public class ManageRepositoryBLImpl implements ManageRepositoryBLService{

	public List<RepositoryInfoVO> SeeRepositoryBL(String time) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DeliveryInfoVO> CheckRepositoryBL() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean SetWarnValueBL(String ID, int allNum, double WarnNum) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * description:取得仓库中某个区的报警百分比
	 * @param ID：仓库的某个区号
	 * @return double, 返回仓库的某个区的报警百分比
	 * */
	public double GetWranNumBL(String ID){
		return 0;
	}
	
	/**
	 * description:取得仓库中某个区的容量值
	 * @param ID：仓库的某个区号
	 * @return int ： 返回仓库的某个区的容量值
	 * */
	public int GetRepositoryNumBL(String ID){
		return 0;
	}
	
	/**
	 * description:取得仓库中某个区的现存快递数量
	 * @param ID：仓库的某个区号
	 * @return int ： 返回仓库的某个区的现存快递数量
	 * */
	public int GetRepositoryExistBL(String ID){
		return 0;
	}
	
	/**
	 * description:取得库存信息
	 * @param
	 * @return List<RepositoryVO>, 返回仓库的库存信息的值对象，具体参照RepositoryVO
	 * */
	public List<RepositoryVO> GetRepositoryInfoBL(){
		return null;
	}


}
