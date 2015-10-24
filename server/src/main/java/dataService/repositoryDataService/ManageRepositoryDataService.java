package dataService.repositoryDataService;

import java.util.List;

import po.repositoryPO.DeliveryInfoPO;
import po.repositoryPO.RepositoryInfoPO;
import po.repositoryPO.RepositoryPO;

/**
 *description:数据服务层为中转中心库存管理人员管理库存信息提供的服务 
 * @author 阮威威
 */
public interface ManageRepositoryDataService {
	
	/**
	 * description:进行库存信息的查看
	 * @param time , 要查看的库存信息的时间短
	 * @return List<RepositoryInfoPO> ， 所需库存信息的相关持久化对象存储，具体参照RepositoryInfoPO的定义
	 * */
	public List<RepositoryInfoPO> SeeRepositoryDT(String time);
	
	/**
	 * description:进行库存信息的快递信息盘点
	 * @param 
	 * @return List<DeliveryInfoPO> ， 截止当前时间所有快递信息的相关持久化对象存储，具体参照DeliveryInfoPO的定义
	 * */
	public List<DeliveryInfoPO> CheckRepositoryDT();
	
	/**
	 * description:更新库存预警值
	 * @param allNum 某个区的总容量
	 * @param WarnNum 某个区的警戒百分比
	 * @param ID 存储的区号（plane、train、car、auto）
	 * @return boolean  返回警戒信息是否存储成功
	 */
	public boolean UpdataRepositoryWarnDT(int allNum,double WarnNum,String ID);
	
	/**
	 * description : 取得某个区的警戒百分比
	 * @param ID ：所需的区号
	 * @return double ， 所需区的警戒百分比
	 * */
	public double GetWarnNumDT(String ID);
	
	/**
	 * description : 取得某个区的总容量
	 * @param ID ：所需的区号
	 * @return double ， 所需区的库存总容量
	 * */
	public int GetRepositoryNumDT(String ID);
	
	/**
	 * description:取得库存信息
	 * @param 
	 * @return List<RepositoryPO> ， 所需库存信息的相关持久化对象存储，具体参照RepositoryPO的定义
	 * */
	public List<RepositoryPO> GetRepositoryInfoDT();
	
	/**
	 * description : 取得某个区现存的快递数量
	 * @param ID ：所需的区号
	 * @return int ， 所需区现存的库存数量
	 * */
	public int GetRepositoryExistDT(String ID);
	
	
}

