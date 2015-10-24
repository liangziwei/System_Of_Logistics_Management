package dataService.businessDataService;

import po.businessPO.VehiclePO;

/**
 *description:数据服务层为车辆信息管理提供的服务 
 * @author 张云飞
 */
public interface VehicleDataService {

	/**
	 *description:通过传入车辆信息新建一个车辆信息单 
	 * @param vehiclePO 车辆信息的持久化对象，具体参见VehiclePO
	 * @return 添加是否成功
	 */
	public boolean addVehicle(VehiclePO vehiclePO);
    
	/**
	 *description:通过车辆代号得到车辆的信息 
	 * @param vehicleid 车辆代号
	 * @return VehiclePO 返回车辆信息的持久化对象，具体参见VehiclePO的定义
	 */
    public VehiclePO findVehicle(String vehicleid);
    
    /**
	 *description:通过车辆代号删除对应车辆信息 
	 * @param vehicleid 车辆代号
	 * @return 删除是否成功
	 */
    public boolean deleteVehicle(String vehicleid);
    
    /**
	 *description:通过传入对应车辆信息修改车辆信息单 
	 * @param vehiclePO 车辆信息的持久化对象，具体参见VehiclePO
	 * @return 修改是否成功
	 */
    public boolean modifyVehicle(VehiclePO vehiclePO);
}

