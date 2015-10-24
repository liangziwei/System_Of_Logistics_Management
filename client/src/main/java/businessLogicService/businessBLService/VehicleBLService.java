package businessLogicService.businessBLService;

import vo.businessVO.VehicleVO;

/**
 *description:业务逻辑层为车辆信息管理界面提供的服务 
 * @author 张云飞
 */
public interface VehicleBLService {
     
	/**
	 *description:通过传入车辆信息新建一个车辆信息单 
	 * @param vehicleVO 车辆信息的值对象，具体参见VehicleVO
	 * @return 添加是否成功
	 */
	public boolean addVehicle(VehicleVO vehicleVO);
     
	/**
	 *description:通过车辆代号得到车辆的信息 
	 * @param vehicleid 车辆代号
	 * @return VehicleVO 返回车辆信息的值对象，具体参见VehicleVO的定义
	 */
    public VehicleVO findVehicle(String vehicleid);
    
    /**
	 *description:通过车辆代号删除对应车辆信息 
	 * @param vehicleid 车辆代号
	 * @return 删除是否成功
	 */
    public boolean deleteVehicle(String vehicleid);
    
    /**
	 *description:通过传入对应车辆信息修改车辆信息单 
	 * @param vehicleVO 车辆信息的值对象，具体参见VehicleVO
	 * @return 修改是否成功
	 */
    public boolean modifyVehicle(VehicleVO vehicleVO);
}
