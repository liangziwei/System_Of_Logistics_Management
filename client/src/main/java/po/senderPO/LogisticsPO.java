package po.senderPO;

import java.util.List;

import constant.City;
import constant.TransitionNode;

/**
 * 物流信息的持久化对象
 * @author 肖安祥
 */
public class LogisticsPO {

	/**
	 * 物品的货运状态（派件中、到达寄件人营业厅、到达寄件人中转中心、
	 * 到达收件人中转中心、到达收件人营业厅、收件）
	 */
	private TransitionNode state;
	
	/**
	 * 物流轨迹（从寄出点到当前位置所经过的所有站点）
	 */
	private List<City> trace;

	public LogisticsPO(TransitionNode state, List<City> trace) {
		super();
		this.state = state;
		this.trace = trace;
	}

	public TransitionNode getState() {
		return state;
	}

	public void setState(TransitionNode state) {
		this.state = state;
	}

	public List<City> getTrace() {
		return trace;
	}

	public void setTrace(List<City> trace) {
		this.trace = trace;
	}
}
