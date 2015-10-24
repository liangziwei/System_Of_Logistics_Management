package po.financePO;
/**
 * 记录了付款单的信息
 * @author 张仁知
 */
public class PaymentPO {
	/**
	 * 付款日期
	 */
	private String date;
	/**
	 * 付款金额
	 */
	private double payAmount;
	/**
	 * 付款人
	 */
	private String name;
	/**
	 * 付款账户
	 */
	private String account;
	/**
	 * 条目（租金（按年收）运费（按次计算）人员工资（按月统计/快递员提成、司机计次、业务员月薪）奖励（一次性））
	 */
	private String entry;
	/**
	 * 备注（租金年份、运单号、标注工资月份）
	 */
	private String remark;
	/**
	 * 是否已经被总经理的审批
	 */
	private boolean isApproved = false;
	
	/**
	 * 审批是否通过
	 */
	private boolean isPassed = false;
	
	public PaymentPO(String date, double payAmount, String name,
			String account, String entry, String remark) {
		super();
		this.date = date;
		this.payAmount = payAmount;
		this.name = name;
		this.account = account;
		this.entry = entry;
		this.remark = remark;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(double payAmount) {
		this.payAmount = payAmount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getEntry() {
		return entry;
	}
	public void setEntry(String entry) {
		this.entry = entry;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public boolean isApproved() {
		return isApproved;
	}
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	public boolean isPassed() {
		return isPassed;
	}
	public void setPassed(boolean isPassed) {
		this.isPassed = isPassed;
	}
}
