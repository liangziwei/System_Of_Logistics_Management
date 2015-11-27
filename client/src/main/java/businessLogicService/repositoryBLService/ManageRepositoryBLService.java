package businessLogicService.repositoryBLService;

import java.util.List;

import constant.AreaCodeType;
import vo.repositoryVO.DeliveryInfoVO;
import vo.repositoryVO.RepositoryInfoVO;
import vo.repositoryVO.RepositoryVO;

/**
 * description:业务逻辑层为中转中心仓库库存信息管理界面提供的服务
 * @author 阮威威
 * */
public interface ManageRepositoryBLService {

	/**
	 * description:进行库存信息的查询
	 * 前置条件：用户请求进行库存查询
	 * 后置条件：系统返回库存信息列表List<RepositoryInfoVO>（详细参数参照RepositoryInfoVO）给界面
	 * 需接口：ManageRepositoryBLImpl.List<RepositoryInfoVO> SeeRepositoryBL(String time)
	 * @param time ,一个时间段
	 * @return List<RepositoryInfoVO>, 返回库存信息的值对象，具体参照RepositoryInfoVO的定义
	 * */
	public List<RepositoryInfoVO> SeeRepositoryBL(String time);
	
	/**
	 * description:进行库存盘点的盘点
	 * 前置条件：用户请求进行库存盘点
	 * 后置条件：系统返回库存快递信息列表List<DeliveryInfoVO>（详细参数参照DeliveryInfoVO）给界面
	 * 需接口：ManageRepositoryBLImpl.List<DeliveryInfoVO> CheckRepositoryBL()
	 * @param 
	 * @return List<DeliveryInfoVO>, 返回库存中快递信息的值对象，具体参照DeliveryInfoVO的定义
	 * */
	public List<DeliveryInfoVO> CheckRepositoryBL();
	
	/**
	 * description:添加库存预警值
	 * 前置条件：用户请求进行预警值设置
	 * 后置条件：系统保存库存预警值，返回是否保存成功
	 * 需接口：ManageRepositoryDataService.UpdataRepositoryWarnDT(int allNum,double WarnNum,String ID)
	 * @param ID :某个区的区号（PLANEAREA、TRAINAREA、TRUCKAREA,MOTOAREA）
	 * @param allNum ：该区的库存容量
	 * @param WarnNum ：该区的预警的百分比
	 * @return boolean, 返回库存预警值是否保存成功
	 * */
	public boolean SetWarnValueBL(AreaCodeType ID,int allNum,double WarnNum);
	/**
	 * description:取得仓库中某个区的报警百分比
	 * 前置条件：进行一次添加（修改）入库单的操作
	 * 后置条件：返回仓库的某个区的报警百分比
	 * 需接口：ManageRepositoryDataService.GetWarnNumDT(String ID)
	 * @param ID：仓库的某个区号
	 * @return double, 返回仓库的某个区的报警百分比
	 * */
	public double GetWarnNumBL(AreaCodeType ID);
	
	/**
	 * description:取得仓库中某个区的容量值
	 * 前置条件：进行一次添加（修改）入库单的操作
	 * 后置条件：返回仓库的某个区的容量值
	 * 需接口：ManageRepositoryDataService.GetRepositoryNumDT(String ID)
	 * @param ID：仓库的某个区号
	 * @return int ： 返回仓库的某个区的容量值
	 * */
	public int GetRepositoryNumBL(AreaCodeType ID);
	
	/**
	 * description:取得仓库中某个区的现存快递数量
	 * 前置条件：进行一次添加（修改）入库单的操作
	 * 后置条件：返回仓库的某个区的现存快递数量
	 * 需接口：ManageRepositoryDataService.GetRepositoryExistDT(String ID)
	 * @param ID：仓库的某个区号
	 * @return int ： 返回仓库的某个区的现存快递数量
	 * */
	public int GetRepositoryExistBL(AreaCodeType ID);
	
	/**
	 * description:取得库存信息
	 * 前置条件：系统响应用户请求进行库存信息的查看
	 * 后置条件：返回仓库的库存信息的值对象
	 * 需接口：ManageRepositoryDataService.List<RepositoryPO> GetRepositoryInfoDT()
	 * @param
	 * @return List<RepositoryVO>, 返回仓库的库存信息的值对象，具体参照RepositoryVO
	 * */
	public List<RepositoryVO> GetRepositoryInfoBL();
	/**
	 * description:验证库存预警信息
	 * 前置条件：RepositoryWarn
	 * 后置条件：返回验证结果
	 * 需接口：无
	 * @param warn:预警值
	 * @param all:总容量
	 * @return boolean, 返回验证结果
	 * */
	public boolean verify(String warn,String all);
	
	
}
