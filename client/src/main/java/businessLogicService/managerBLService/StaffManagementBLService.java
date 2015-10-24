package businessLogicService.managerBLService;

import vo.managerVO.StaffVO;

/**
 * description:业务逻辑层为人员管理界面提供的服务
 * @author 张仁知
 */
public interface StaffManagementBLService {
	
	/**
	 * description:添加一个人员
	 * @param  StaffVO ,记录人员信息的值对象，具体参照StaffVO定义
	 * @return boolean, 添加是否成功
	 */
	public boolean addStaff(StaffVO staffVO);
	
	/**
	 * description:查询一个人员信息
	 * @param  id ,人员编号
	 * @return StaffVO, 记录人员信息的值对象，具体参照StaffVO定义
	 */
	public StaffVO findStaff(String id);
	
	/**
	 * description:删除一个人员信息
	 * @param  id ,人员编号
	 * @return boolean, 删除是否成功
	 */	
	public boolean deleteStaff(String id);
	
	/**
	 * description:修改一个人员信息
	 * @param  StaffVO, 记录人员信息的值对象，具体参照StaffVO定义
	 * @return boolean ,修改是否成功
	 */
	public boolean modifyStaff(StaffVO staffVO);

}
