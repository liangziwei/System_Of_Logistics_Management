package businessLogicService.administratorBLService;

/**
 *description:业务逻辑层为登陆界面提供的服务 
 * @author 张云飞
 */
public interface LoginBLService {
	
	/**
	 *description:通过账户账号和密码进行登陆
	 * 前置条件：无
	 * 后置条件：根据输入的id和password返回登陆验证的结果
	 * 需要的服务： AdministratorDataService。getPassword(String userid)
	 * @param userid 账户账号
	 * @param passward 账户密码
	 * @return 登陆是否成功
	 */
	public boolean login(String userid,String passward);
}
