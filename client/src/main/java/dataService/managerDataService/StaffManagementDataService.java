package dataService.managerDataService;

import po.managerPO.StaffPO;
/**
 * description:数据服务层为人员管理逻辑处理提供的服务
 * @author 张仁知
 */
public interface StaffManagementDataService {
	
	/**
	 * description:添加一个人员
	 * 前置条件：启动人员管理
	 * 后置条件：在数据库中添加一个人员信息
	 * @param  StaffVO ,记录人员信息的值对象，具体参照StaffPO定义
	 * @return boolean, 添加是否成功
	 */
	public boolean addStaff(StaffPO staffPO);
	
	/**
	 * description:查询一个人员信息
	 * 前置条件：启动人员管理
	 * 后置条件：返回查询到的人员信息
	 * @param  id ,人员编号
	 * @return StaffPO, 记录人员信息的值对象，具体参照StaffVO定义
	 */
	public StaffPO findStaff(String id);
	
	/**
	 * description:删除一个人员信息
	 * 前置条件：启动人员管理
	 * 后置条件：在数据库中删除一个人员信息
	 * @param  id ,人员编号
	 * @return boolean, 删除是否成功
	 */	
	public boolean deleteStaff(String id);
	
	/**
	 * description:修改一个人员信息
	 * 前置条件：启动人员管理
	 * 后置条件：在数据库中修改一个机构信息
	 * @param  StaffVO, 记录人员信息的值对象，具体参照StaffVO定义
	 * @return boolean ,修改是否成功
	 */
	public boolean modifyStaff(StaffPO staffPO);


}
