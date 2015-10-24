package dataService.businessDataService;

import po.businessPO.DriverPO;

/**
 *description:数据服务层为司机信息管理提供的服务 
 * @author 张云飞
 */
public interface DriverDataService {
	 
	/**
	 *description:通过传入司机信息新建一个司机信息单
	 * 前置条件：同样id的po在数据库中不存在
	 * 后置条件：在数据库增加一个po记录 
	 * @param dirverPO 司机信息的持久化对象，具体参见DirverPO
	 * @return 添加是否成功
	 */
    public boolean addDriver(DriverPO driverPO);
	 
    /**
	 *description:通过司机编号得到司机的信息
	 * 前置条件：无
	 * 后置条件：按id进行查找返回相应的DriverPO结果 
	 * @param dirverid 司机编号
	 * @return dirverPO 返回司机信息的持久化对象，具体参见DirverPO的定义
	 */
	public DriverPO findDriver(String driverid);
	    
	/**
	 *description:通过司机编号删除对应司机信息
	 * 前置条件：数据库中存在同样id的po
	 * 后置条件：在数据库删除一个po
	 * @param dirverid 司机编号
	 * @return 删除是否成功
	 */
    public boolean deleteDriver(String driverid);
	 
    /**
	 *description:通过传入对应司机信息修改司机信息单
	 * 前置条件：数据库中存在同样id的po
	 * 后置条件：修改一个po 
	 * @param dirverPO 司机信息的持久化对象，具体参见DirverPO
	 * @return 修改是否成功
	 */
    public boolean modifyDriver(DriverPO driverPO);

}
