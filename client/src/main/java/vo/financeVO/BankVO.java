package vo.financeVO;

/**
 * 记录了银行账户信息的值对象
 * @author 肖安祥
 */
public class BankVO {

	/**
	 * 银行名称
	 */
	private String name;
	
	/**
	 * 银行账户余额
	 */
	private double balance;

	public BankVO(String name, double balance) {
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

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
