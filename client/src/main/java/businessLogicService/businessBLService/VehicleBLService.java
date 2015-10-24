package businessLogicService.businessBLService;

import vo.businessVO.VehicleVO;

/**
 *description:业务逻辑层为车辆信息管理界面提供的服务 
 * @author 张云飞
 */
public interface VehicleBLService {
     
	/**
	 *description:通过传入车辆信息新建一个车辆信息单
	 * 前置条件：启动一个车辆信息管理操作
	 * 后置条件：系统增加一个车辆的信息
	 * 需要的服务：VehicleDataService.addVehicle(VehiclePO vehiclePO) 
	 * @param vehicleVO 车辆信息的值对象，具体参见VehicleVO
	 * @return 添加是否成功
	 */
	public boolean addVehicle(VehicleVO vehicleVO);
     
	/**
	 *description:通过车辆代号得到车辆的信息
	 * 前置条件： 启动一个车辆信息管理操作
	 * 后置条件：返回要查找的车辆信息
	 * 需要的服务：VehicleDataService.findVehicle(String vehicleid) 
	 * @param vehicleid 车辆代号
	 * @return VehicleVO 返回车辆信息的值对象，具体参见VehicleVO的定义
	 */
    public VehicleVO findVehicle(String vehicleid);
    
    /**
	 *description:通过车辆代号删除对应车辆信息
	 * 前置条件： 启动一个车辆信息管理操作
	 * 后置条件：系统删除要删除的车辆信息
	 * 需要的服务：VehicleDataService.deleteVehicle(String vehicleid) 
	 * @param vehicleid 车辆代号
	 * @return 删除是否成功
	 */
    public boolean deleteVehicle(String vehicleid);
    
    /**
	 *description:通过传入对应车辆信息修改车辆信息单
	 * 前置条件： 启动一个车辆信息管理操作
	 * 后置条件：系统修改车辆的信息
	 * 需要的服务：VehicleDataService.modifyVehicle(VehiclePO vehiclePO) 
	 * @param vehicleVO 车辆信息的值对象，具体参见VehicleVO
	 * @return 修改是否成功
	 */
    public boolean modifyVehicle(VehicleVO vehicleVO);
}
