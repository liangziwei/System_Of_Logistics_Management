package businessLogicService.repositoryBLService;

import java.util.List;

import vo.repositoryVO.DeliveryInfoVO;
import vo.repositoryVO.RepositoryInfoVO;

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
	 * @param ID :某个区的区号（plane、train、car）
	 * @param allNum ：该区的库存容量
	 * @param WarnNum ：该区的预警的百分比
	 * @return boolean, 返回库存预警值是否保存成功
	 * */
	public boolean SetWarnValueBL(String ID,int allNum,double WarnNum);
	
	
}
