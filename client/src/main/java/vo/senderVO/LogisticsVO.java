package vo.senderVO;

import java.util.List;

/**
 * 记录了物流的信息
 * @author 肖安祥
 */
public class LogisticsVO {

	/**
	 * 物品的货运状态（派件中、到达寄件人营业厅、到达寄件人中转中心、
	 * 到达收件人中转中心、到达收件人营业厅、收件）
	 */
	private String state;
	
	/**
	 * 物流轨迹（从寄出点到当前位置所经过的所有站点）
	 */
	private List<String> trace;

	public LogisticsVO(String state, List<String> trace) {
		super();
		this.state = state;
		this.trace = trace;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<String> getTrace() {
		return trace;
	}

	public void setTrace(List<String> trace) {
		this.trace = trace;
	}
}
