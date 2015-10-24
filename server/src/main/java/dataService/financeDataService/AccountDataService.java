package dataService.financeDataService;

import po.financePO.AccountPO;

/**
 * description:数据服务层为账户管理逻辑处理提供的服务
 * @author 张仁知
 */
public interface AccountDataService {
	
	/**
	 * description:添加一个账户
	 * @param AccountPO ,记录账户信息的值对象，具体参照AccountPO的定义
	 * @return 添加是否成功
	 */
	public boolean addAccount(AccountPO accountPO);		
	
	/**
	 * description:查询一个账户
	 * @param  name 关键字（账户名称）
	 * @return AccountPO 返回查询到的账户信息
	 */
	public AccountPO findAccount(String name);
	
	/**
	 * description:删除一个账户
	 * @param  name 账户名称
	 * @return 删除是否成功
	 */
	public boolean deleteAccount(String name);
	
	/**
	 * description:修改一个账户
	 * @param  name ,账户名称
	 * @return 要修改的账户是否存在
	 */
	public boolean modifyAccount(String name);


}
