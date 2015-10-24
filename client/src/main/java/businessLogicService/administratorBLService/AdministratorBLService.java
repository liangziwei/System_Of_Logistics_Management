package businessLogicService.administratorBLService;

import vo.administratorVO.AdministratorVO;

/**
 *description:业务逻辑层为管理员界面提供的服务 
 * @author 张云飞
 */
public interface AdministratorBLService {
	
	/**
	 *description:通过传入账户信息新建一个账户信息单 
	 * @param administratorVO 账户信息的值对象，具体参见AdministratorVO
	 * @return 添加是否成功
	 */
	public boolean addUser(AdministratorVO administratorVO);
   
	/**
	 *description:通过账户账号删除对应账户信息 
	 * @param administratorid 账户账号
	 * @return 删除是否成功
	 */
    public boolean deleteUser(String administratorid);
    
    /**
     *description:通过传入对应账户信息修改账户信息 
	 * @param administratorVO 账户信息的值对象，具体参见AdministratorVO
	 * @return 修改是否成功
	 */
    public boolean modifyUser(AdministratorVO administratorVO);
    
    /**
	 *description:通过账户账号得到账户的信息 
	 * @param asministratorid 账户账号
	 * @return administratorVO 返回账户信息的值对象，具体参见AdministratorVO的定义
	 */
    public AdministratorVO findUser(String administratorid);
}
