package businessLogicService.financeBLService;

import vo.financeVO.AccountVO;

/**
 * description:业务逻辑层为账户管理界面提供的服务
 * @author 张仁知
 */

public interface AccountBLService {
	
	/**
	 * description:添加一个账户
	 * @param AccountVO ,记录账户信息的值对象，具体参照AccountVO的定义
	 * @return 添加是否成功
	 */
	public boolean addAccount(AccountVO accountVO);		
	
	/**
	 * description:查询一个账户
	 * @param  name 关键字（账户名称）
	 * @return AccountVO ,返回查询到的账户信息
	 */
	public AccountVO findAccount(String name);
	
	/**
	 * description:删除一个账户
	 * @param  name 账户名称
	 * @return 删除是否成功
	 */
	public boolean deleteAccount(String name);
	
	/**
	 * description:修改一个账户
	 * @param AccountVO ,记录账户信息的值对象，具体参照AccountVO的定义
	 * @return 修改是否成功
	 */
	public boolean modifyAccount(AccountVO accountVO);

}
