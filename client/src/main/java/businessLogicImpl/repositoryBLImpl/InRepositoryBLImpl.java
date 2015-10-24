package businessLogicImpl.repositoryBLImpl;

import businessLogicService.repositoryBLService.InRepositoryBLService;
import vo.repositoryVO.InRepositoryVO;

public class InRepositoryBLImpl implements InRepositoryBLService{

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
	
	/**
	 * description:进行是否要预警的处理
	 * @param InRepositoryVO ,入库单信息的相关值对象，具体参照InRepositoryVO的定义
	 * @return boolean, 返回是否报警
	 * */
	public boolean warnBL(InRepositoryVO inRepositoryVO){
		return false;
	}
	
	/**
	 * description:取得仓库中某个区的报警百分比
	 * @param ID：仓库的某个区号
	 * @return double, 返回仓库的某个区的报警百分比
	 * */
	public double getWarnNum(String ID){
		return 0;
	}
	
	/**
	 * description:取得仓库中某个区的容量值
	 * @param ID：仓库的某个区号
	 * @return int ： 返回仓库的某个区的容量值
	 * */
	public int GetRepositoryNum(String ID){
		return 0;
	}
	
	/**
	 * description:取得仓库中某个区的现存快递数量
	 * @param ID：仓库的某个区号
	 * @return int ： 返回仓库的某个区的现存快递数量
	 * */
	public int GetRepositoryExist(String ID){
		return 0;
	}
	
}
