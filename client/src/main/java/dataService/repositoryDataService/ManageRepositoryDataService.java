package dataService.repositoryDataService;

import java.rmi.Remote;
import java.util.List;

import constant.AreaCodeType;
import po.repositoryPO.DeliveryInfoPO;
import po.repositoryPO.RepositoryInfoPO;
import po.repositoryPO.RepositoryPO;

/**
 *description:数据服务层为中转中心库存管理人员管理库存信息提供的服务 
 * @author 阮威威
 */
public interface ManageRepositoryDataService extends Remote{
	
	/**
	 * description:进行库存信息的查看
	 * 前置条件：逻辑层传送的time正确
	 * 后置条件：将获得的库存信息列表返回给逻辑层(RepositoryInfoPO类型，详情参照RepositoryInfoPO)
	 * 需接口：无
	 * @param time , 要查看的库存信息的时间短
	 * @return List<RepositoryInfoPO> ， 所需库存信息的相关持久化对象存储，具体参照RepositoryInfoPO的定义
	 * */
	public List<RepositoryInfoPO> SeeRepositoryDT(String time);
	
	/**
	 * description:进行库存信息的快递信息盘点
	 * 前置条件：系统响应用户的库存盘点操作
	 * 后置条件：将获得的库存信息列表返回给逻辑层(DeliverInfoPO类型，详情参照DeliverInfoPO)
	 * 需接口：无
	 * @param 
	 * @return List<DeliveryInfoPO> ， 截止当前时间所有快递信息的相关持久化对象存储，具体参照DeliveryInfoPO的定义
	 * */
	public List<DeliveryInfoPO> CheckRepositoryDT();
	
	/**
	 * description:更新库存预警值
	 * 前置条件：逻辑层传送allNum、WarnNum、ID，且都正确
	 * 后置条件：更新数据库中的库存预警值
	 * 需接口：无
	 * @param allNum 某个区的总容量
	 * @param WarnNum 某个区的警戒百分比
	 * @param ID 存储的区号（plane、train、car、auto）
	 * @return boolean  返回警戒信息是否存储成功
	 */
	public boolean UpdataRepositoryWarnDT(int allNum,double WarnNum,AreaCodeType ID);
	
	/**
	 * description : 取得某个区的警戒百分比
	 *  前置条件：逻辑层传送的ID正确
	 * 后置条件：将获得的预警值返回给逻辑层
	 * 需接口：无
	 * @param ID ：所需的区号
	 * @return double ， 所需区的警戒百分比
	 * */
	public double GetWarnNumDT(AreaCodeType ID);
	
	/**
	 * description : 取得某个区的总容量
	 *  前置条件：逻辑层传送的ID正确
	 * 后置条件：将获得的库存容量值返回给逻辑层
	 * 需接口：无
	 * @param ID ：所需的区号
	 * @return double ， 所需区的库存总容量
	 * */
	public int GetRepositoryNumDT(AreaCodeType ID);
	
	/**
	 * description:取得库存信息
	 *  前置条件：逻辑层响应用户的查看库存信息的请求
	 * 后置条件：将获得的库存信息列表返回给逻辑层
	 * 需接口：无
	 * @param 
	 * @return List<RepositoryPO> ， 所需库存信息的相关持久化对象存储，具体参照RepositoryPO的定义
	 * */
	public List<RepositoryPO> GetRepositoryInfoDT();
	
	/**
	 * description : 取得某个区现存的快递数量
	 *  前置条件：逻辑层传送的ID正确
	 * 后置条件：将获得的现存库存快递数量信息返回给逻辑层
	 * 需接口：无
	 * @param ID ：所需的区号
	 * @return int ， 所需区现存的库存数量
	 * */
	public int GetRepositoryExistDT(AreaCodeType ID);
	
	
}
