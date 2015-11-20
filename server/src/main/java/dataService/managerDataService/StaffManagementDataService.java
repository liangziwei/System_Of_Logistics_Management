package dataService.managerDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.managerPO.StaffPO;
/**
 * description:数据服务层为人员管理逻辑处理提供的服务
 * @author 张仁知
 */
public interface StaffManagementDataService extends Remote{
	
	/**
	 * description:添加一个人员
	 * @param  StaffPO ,记录人员信息的值对象，具体参照StaffPO定义
	 * @return boolean, 添加是否成功
	 */
	public boolean addStaff(StaffPO staffPO) throws RemoteException;
	
	/**
	 * description:查询一个人员信息
	 * @param  id ,人员编号
	 * @return StaffPO, 记录人员信息的值对象，具体参照StaffVO定义
	 */
	public StaffPO findStaff(String id) throws RemoteException;
	
	/**
	 * description:删除一个人员信息
	 * @param  id ,人员编号
	 * @return boolean, 删除是否成功
	 */	
	public boolean deleteStaff(String id) throws RemoteException;
	
	/**
	 * description:修改一个人员信息
	 * @param  StaffVO, 记录人员信息的值对象，具体参照StaffVO定义
	 * @return boolean ,修改是否成功
	 */
	public boolean modifyStaff(StaffPO staffPO) throws RemoteException;


}
