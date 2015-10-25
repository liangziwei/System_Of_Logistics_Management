package businessLogicImpl.repositoryBLImpl;

import java.util.List;

import businessLogicService.repositoryBLService.ManageRepositoryBLService;
import constant.AreaCodeType;
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

	public boolean SetWarnValueBL(AreaCodeType ID, int allNum, double WarnNum) {
		// TODO Auto-generated method stub
		return false;
	}
<<<<<<< Updated upstream
	
	/**
	 * description:取得仓库中某个区的报警百分比
	 * 前置条件：进行一次添加（修改）入库单的操作
	 * 后置条件：返回仓库的某个区的报警百分比
	 * 需接口：ManageRepositoryDataService.GetWarnNumDT(String ID)
	 * @param ID：仓库的某个区号
	 * @return double, 返回仓库的某个区的报警百分比
	 * */
	public double GetWranNumBL(String ID){
		return 0;
	}
	
	/**
	 * description:取得仓库中某个区的容量值
	 * 前置条件：进行一次添加（修改）入库单的操作
	 * 后置条件：返回仓库的某个区的容量值
	 * 需接口：ManageRepositoryDataService.GetRepositoryNumDT(String ID)
	 * @param ID：仓库的某个区号
	 * @return int ： 返回仓库的某个区的容量值
	 * */
	public int GetRepositoryNumBL(String ID){
		return 0;
	}
	
	/**
	 * description:取得仓库中某个区的现存快递数量
	 * 前置条件：进行一次添加（修改）入库单的操作
	 * 后置条件：返回仓库的某个区的现存快递数量
	 * 需接口：ManageRepositoryDataService.GetRepositoryExistDT(String ID)
	 * @param ID：仓库的某个区号
	 * @return int ： 返回仓库的某个区的现存快递数量
	 * */
	public int GetRepositoryExistBL(String ID){
=======
<<<<<<< HEAD

	public double GetWranNumBL(AreaCodeType ID) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int GetRepositoryNumBL(AreaCodeType ID) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int GetRepositoryExistBL(AreaCodeType ID) {
		// TODO Auto-generated method stub
=======
	
	/**
	 * description:取得仓库中某个区的报警百分比
	 * 前置条件：进行一次添加（修改）入库单的操作
	 * 后置条件：返回仓库的某个区的报警百分比
	 * 需接口：ManageRepositoryDataService.GetWarnNumDT(String ID)
	 * @param ID：仓库的某个区号
	 * @return double, 返回仓库的某个区的报警百分比
	 * */
	public double GetWranNumBL(String ID){
>>>>>>> Stashed changes
		return 0;
	}
	
	/**
<<<<<<< Updated upstream
	 * description:取得库存信息
	 * 前置条件：系统响应用户请求进行库存信息的查看
	 * 后置条件：返回仓库的库存信息的值对象
	 * 需接口：ManageRepositoryDataService.List<RepositoryPO> GetRepositoryInfoDT()
	 * @param
	 * @return List<RepositoryVO>, 返回仓库的库存信息的值对象，具体参照RepositoryVO
	 * */
	public List<RepositoryVO> GetRepositoryInfoBL(){
		return null;
	}
=======
	 * description:取得仓库中某个区的容量值
	 * 前置条件：进行一次添加（修改）入库单的操作
	 * 后置条件：返回仓库的某个区的容量值
	 * 需接口：ManageRepositoryDataService.GetRepositoryNumDT(String ID)
	 * @param ID：仓库的某个区号
	 * @return int ： 返回仓库的某个区的容量值
	 * */
	public int GetRepositoryNumBL(String ID){
		return 0;
	}
	
	/**
	 * description:取得仓库中某个区的现存快递数量
	 * 前置条件：进行一次添加（修改）入库单的操作
	 * 后置条件：返回仓库的某个区的现存快递数量
	 * 需接口：ManageRepositoryDataService.GetRepositoryExistDT(String ID)
	 * @param ID：仓库的某个区号
	 * @return int ： 返回仓库的某个区的现存快递数量
	 * */
	public int GetRepositoryExistBL(String ID){
>>>>>>> origin/master
		return 0;
	}
	
	/**
	 * description:取得库存信息
	 * 前置条件：系统响应用户请求进行库存信息的查看
	 * 后置条件：返回仓库的库存信息的值对象
	 * 需接口：ManageRepositoryDataService.List<RepositoryPO> GetRepositoryInfoDT()
	 * @param
	 * @return List<RepositoryVO>, 返回仓库的库存信息的值对象，具体参照RepositoryVO
	 * */
	public List<RepositoryVO> GetRepositoryInfoBL(){
		return null;
	}
>>>>>>> Stashed changes


}
