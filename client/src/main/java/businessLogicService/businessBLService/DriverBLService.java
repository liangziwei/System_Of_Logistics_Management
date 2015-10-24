package businessLogicService.businessBLService;

import vo.businessVO.DriverVO;

/**
 *description:业务逻辑层为司机信息管理界面提供的服务 
 * @author 张云飞
 */
public interface DriverBLService {
	
	/**
	 *description:通过传入司机信息新建一个司机信息单
	 * 前置条件：启动一个司机信息管理操作
	 * 后置条件：系统增加一个司机的信息
	 * 需要的服务：DriverDataService.addDriver(DriverPO driverPO)
	 * @param dirverVO 司机信息的值对象，具体参见DirverVO
	 * @return 添加是否成功
	 */
	public boolean addDriver(DriverVO driverVO);
    
	/**
	 *description:通过司机编号得到司机的信息
	 * 前置条件： 启动一个司机信息管理操作
	 * 后置条件：返回要查找的司机信息
	 * 需要的服务：DriverDataService.findDriver(String driverid)
	 * @param dirverid 司机编号
	 * @return dirverVO 返回司机信息的值对象，具体参见DirverVO的定义
	 */
    public DriverVO findDriver(String driverid);
    
    /**
	 *description:通过司机编号删除对应司机信息
	 * 前置条件： 启动一个司机信息管理操作
	 * 后置条件：系统删除要删除的司机信息
	 * 需要的服务：DriverDataService.deleteDriver(String driverid)
	 * @param dirverid 司机编号
	 * @return 删除是否成功
	 */
    public boolean deleteDriver(String driverid);
    
    /**
	 *description:通过传入对应司机信息修改司机信息单
	 * 前置条件： 启动一个司机信息管理操作
	 * 后置条件：系统修改司机的信息
	 * 需要的服务：DriverDataService.modifyDriver(DriverPO driverPO)
	 * @param dirverVO 司机信息的值对象，具体参见DirverVO
	 * @return 修改是否成功
	 */
    public boolean modifyDriver(DriverVO driverVO);
}
