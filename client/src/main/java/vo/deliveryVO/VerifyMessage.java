package vo.deliveryVO;

import constant.LabelName;
import constant.VerifyResult;

public class VerifyMessage {

	private LabelName label;
	
	private String errorMsg;
	
	private VerifyResult result;
	
	public VerifyMessage() {
		
	}
	
	public VerifyMessage(LabelName label, String errorMsg, VerifyResult result) {
		this.label = label;
		this.errorMsg = errorMsg;
		this.result = result;
	}
	
	public LabelName getLabel() {
		return label;
	}

	public void setLabel(LabelName label) {
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
