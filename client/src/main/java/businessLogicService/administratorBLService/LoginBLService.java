package businessLogicService.administratorBLService;

/**
 *description:业务逻辑层为登陆界面提供的服务 
 * @author 张云飞
 */
public interface LoginBLService {
	
	/**
	 *description:通过账户账号和密码进行登陆 
	 * @param userid 账户账号
	 * @param passward 账户密码
	 * @return 登陆是否成功
	 */
	public boolean login(String userid,String passward);
}
