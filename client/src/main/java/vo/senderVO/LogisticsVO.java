package vo.senderVO;

import java.util.List;

import constant.City;
import constant.TransitionNode;

/**
 * 记录了物流的信息
 * @author 肖安祥
 */
public class LogisticsVO {

	/**
	 * 物品的物流轨迹
	 */
	private List<TransitionNode> state;
	
	/**
	 * 物流轨迹（从寄出点到当前位置所经过的所有站点）
	 */
	private List<City> trace;

	public LogisticsVO(List<TransitionNode> state, List<City> trace) {
		super();
		this.state = state;
		this.trace = trace;
	}

	public List<TransitionNode> getState() {
		return state;
	}

	public void setState(List<TransitionNode> state) {
		this.state = state;
	}

	public List<City> getTrace() {
		return trace;
	}

	public void setTrace(List<City> trace) {
		this.trace = trace;
	}
}
