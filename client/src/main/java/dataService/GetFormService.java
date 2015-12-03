package dataService;

public interface GetFormService {

	/**
	 * 获得单据的PO对象，用户总经理的审批单据，
	 * 使用者为能获得单据PO对象的逻辑模型类
	 */
	public<T> T getUncheckForm();
}
