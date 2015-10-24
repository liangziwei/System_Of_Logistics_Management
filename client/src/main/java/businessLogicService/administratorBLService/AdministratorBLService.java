package businessLogicService.administratorBLService;

import vo.administratorVO.AdministratorVO;

/**
 *description:业务逻辑层为管理员界面提供的服务 
 * @author 张云飞
 */
public interface AdministratorBLService {
	
	/**
	 *description:通过传入账户信息新建一个账户信息单
	 * 前置条件：启动一个账户信息管理操作
	 * 后置条件：系统增加一个账户的信息
	 * 需要的服务：AdministratorDataService.addAdministrator(AdministratorPO administratorPO) 
	 * @param administratorVO 账户信息的值对象，具体参见AdministratorVO
	 * @return 添加是否成功
	 */
	public boolean addUser(AdministratorVO administratorVO);
   
	/**
	 *description:通过账户账号删除对应账户信息
	 * 前置条件： 启动一个账户信息管理操作
	 * 后置条件：系统删除要删除的账户信息
	 * 需要的服务：AdministratorDataService.deleteAdministrator(String administratorid)
	 * @param administratorid 账户账号
	 * @return 删除是否成功
	 */
    public boolean deleteUser(String administratorid);
    
    /**
     *description:通过传入对应账户信息修改账户信息
     * 前置条件： 启动一个账户信息管理操作
	 * 后置条件：系统修改账户的信息
	 * 需要的服务：AdministratorDataService.modifyAdministrator(AdministratorPO administratorPO) 
	 * @param administratorVO 账户信息的值对象，具体参见AdministratorVO
	 * @return 修改是否成功
	 */
    public boolean modifyUser(AdministratorVO administratorVO);
    
    /**
	 *description:通过账户账号得到账户的信息
	 * 前置条件： 启动一个账户信息管理操作
	 * 后置条件：返回要查找的账户信息
	 * 需要的服务：AdministratorDataService.findAdministrator(String administratorid)
	 * @param asministratorid 账户账号
	 * @return administratorVO 返回账户信息的值对象，具体参见AdministratorVO的定义
	 */
    public AdministratorVO findUser(String administratorid);
}
