package vo.financeVO;
/**
 * 记录了账户的信息
 * @author 张仁知
 */
public class AccountVO {

	/**
	 * 账户名称
	 */
	private String name;
	
	/**
	 * 账户余额（只和收款单和付款单有关系，不可修改）
	 */
	private double balance;

	public AccountVO(String name, double balance) {
		super();
		this.name = name;
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	
}
