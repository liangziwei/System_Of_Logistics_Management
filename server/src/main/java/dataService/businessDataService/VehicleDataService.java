package dataService.businessDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.businessPO.VehiclePO;

/**
 *description:数据服务层为车辆信息管理提供的服务 
 * @author 张云飞
 */
public interface VehicleDataService extends Remote{

	/**
	 *description:通过传入车辆信息新建一个车辆信息单
	 * 前置条件：同样id的po在数据库中不存在
	 * 后置条件：在数据库增加一个po记录 
	 * @param vehiclePO 车辆信息的持久化对象，具体参见VehiclePO
	 * @return 添加是否成功
	 */
	public boolean addVehicle(VehiclePO vehiclePO)throws RemoteException;
    
	/**
	 *description:通过车辆代号得到车辆的信息
	 * 前置条件：无
	 * 后置条件：按id进行查找返回相应的VehiclePO结果 
	 * @param vehicleid 车辆代号
	 * @return VehiclePO 返回车辆信息的持久化对象，具体参见VehiclePO的定义
	 */
    public VehiclePO findVehicle(String vehicleid)throws RemoteException;
    
    /**
	 *description:通过车辆代号删除对应车辆信息
	 * 前置条件：数据库中存在同样id的po
	 * 后置条件：在数据库删除一个po 
	 * @param vehicleid 车辆代号
	 * @return 删除是否成功
	 */
    public boolean deleteVehicle(String vehicleid)throws RemoteException;
    
    /**
	 *description:通过传入对应车辆信息修改车辆信息单
	 * 前置条件：数据库中存在同样id的po
	 * 后置条件：修改一个po  
	 * @param vehiclePO 车辆信息的持久化对象，具体参见VehiclePO
	 * @return 修改是否成功
	 */
    public boolean modifyVehicle(VehiclePO vehiclePO)throws RemoteException;
}

