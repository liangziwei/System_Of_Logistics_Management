package dataService.businessDataService;

import po.businessPO.ArrivalFormPO;
import po.businessPO.SendFormPO;

/**
 *description:数据服务层为接受和派件提供的服务
 *@author 张云飞 
 */
public interface ReceiveAndSendDataService {

	/**
	 *description:通过传入到达单信息新建一个到达单
	 * 前置条件：同样id的po在数据库中不存在
	 * 后置条件：在数据库增加一个po记录
	 *@param arrivalFormPO 到达单信息的持久化对象，具体参见ArrivalFormPO
	 *@return 添加是否成功 
	 */
	public boolean addReceiveFrom(ArrivalFormPO arrivalFormPO);
	
	/**
	 *description:通过传入派件单信息新建一个派件单
	 * 前置条件：同样id的po在数据库中不存在
	 * 后置条件：在数据库增加一个po记录 
	 * @param sendFormPO 派件单信息的持久化对象，具体参见SendFormPO
	 * @return 添加是否成功
	 */
	public boolean addSendFrom(SendFormPO sendFormPO);
	
}

