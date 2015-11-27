package po.financePO;

import java.io.Serializable;

/**
 * 记录了账户的信息
 * @author 张仁知
 */
public class AccountPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3517122489468260782L;
	
	/**
	 * 账户名称
	 */
	private String name;
	
	/**
	 * 账户余额（只和收款单和付款单有关系，不可修改）
	 */
	private double balance;

	public AccountPO(String name, double balance) {
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
