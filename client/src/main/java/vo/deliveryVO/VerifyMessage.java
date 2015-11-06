package vo.deliveryVO;

import constant.OrderLabelName;
import constant.VerifyResult;

public class VerifyMessage {

	private OrderLabelName label;
	
	private String errorMsg;
	
	private VerifyResult result;
	
	public VerifyMessage() {
		
	}
	
	public VerifyMessage(OrderLabelName label, String errorMsg, VerifyResult result) {
		this.label = label;
		this.errorMsg = errorMsg;
		this.result = result;
	}
	
	public OrderLabelName getLabel() {
		return label;
	}

	public void setLabel(OrderLabelName label) {
		this.label = label;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public VerifyResult getResult() {
		return result;
	}

	public void setResult(VerifyResult result) {
		this.result = result;
	}
}
