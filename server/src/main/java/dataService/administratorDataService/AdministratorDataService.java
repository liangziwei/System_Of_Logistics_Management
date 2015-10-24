package dataService.administratorDataService;

import po.administratorPO.AdministratorPO;

/**
 *description:数据服务层为用户登陆和管理员操作提供的服务 
 * @author 张云飞
 */
public interface AdministratorDataService {

	/**
	 *description:通过传入账户信息新建一个账户信息单 
	 * @param administratorPO 账户信息的持久化对象，具体参见AdministratorPO
	 * @return 添加是否成功
	 */
	public boolean addUser(AdministratorPO administratorPO);
    
	/**
	 *description:通过账户账号删除对应账户信息 
	 * @param administratorid 账户账号
	 * @return 删除是否成功
	 */
    public boolean deleteUser(String administratorid);
    
    /**
     *description:通过传入对应账户信息修改账户信息 
	 * @param administratorPO 账户信息的持久化对象，具体参见AdministratorPO
	 * @return 修改是否成功
	 */
    public boolean modifyUser(AdministratorPO administratorPO);
    
    /**
	 *description:通过账户账号得到账户的信息 
	 * @param asministratorid 账户账号
	 * @return administratorPO 返回账户信息的持久化对象，具体参见AdministratorPO的定义
	 */
    public AdministratorPO findUser(String administratorid);
    
    /**
	 *description:通过账户账号获得账户密码 
	 * @param userid 账户账号
	 * @return 账户密码
	 */
    public String getPassword(String userid);
}