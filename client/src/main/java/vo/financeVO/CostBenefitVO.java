package vo.financeVO;

/**
 * 记录了成本收益表的信息
 * @author 张仁知
 */
public class CostBenefitVO {

	/**
	 * 总收入
	 */
	private double totalIncome;
	
	/**
	 * 总支出
	 */ 
	private double totalPayment;
	/**
	 * 总利润
	 */ 
	private double totalProfit;
	public CostBenefitVO(double totalIncome, double totalPayment,
			double totalProfit) {
		super();
		this.totalIncome = totalIncome;
		this.totalPayment = totalPayment;
		this.totalProfit = totalProfit;
	}
	public double getTotalIncome() {
		return totalIncome;
	}
	public void setTotalIncome(double totalIncome) {
		this.totalIncome = totalIncome;
	}
	public double getTotalPayment() {
		return totalPayment;
	}
	public void setTotalPayment(double totalPayment) {
		this.totalPayment = totalPayment;
	}
	public double getTotalProfit() {
		return totalProfit;
	}
	public void setTotalProfit(double totalProfit) {
		this.totalProfit = totalProfit;
	}
	
}
