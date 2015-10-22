package businessLogicService.repositoryBLService;

import vo.manageRepositoryVO.DeliveryInfoVO;
import vo.manageRepositoryVO.RepositoryInfoVO;

/**
 * description:业务逻辑层为中转中心仓库库存信息管理界面提供的服务
 * @author 阮威威
 * */
public interface ManageRepositoryBLService {

	/**
	 * description:进行库存信息的查看
	 * @param time ,一个时间段
	 * @return RepositoryInfoVO, 返回库存信息的值对象，具体参照RepositoryInfoVO的定义
	 * */
	public RepositoryInfoVO SeeRepositoryBL(String time);
	
	/**
	 * description:进行库存盘点的查看
	 * @param 
	 * @return DeliveryInfoVO, 返回库存中快递信息的值对象，具体参照DeliveryInfoVO的定义
	 * */
	public DeliveryInfoVO CheckRepositoryBL();
	
	/**
	 * description:添加库存预警值
	 * @param ID :某个区的区号（plane、train、car）
	 * @param allNum ：该区的库存容量
	 * @param WarnNum ：该区的预警的百分比
	 * @return boolean, 返回库存预警值是否保存成功
	 * */
	public boolean SetWarnValueBL(String ID,int allNum,double WarnNum);
	
	
}
