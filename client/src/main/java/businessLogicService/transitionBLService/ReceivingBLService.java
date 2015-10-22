package businessLogicService.transitionBLService;

import vo.receivingVO.ReceivingVO;

/**
 * description:业务逻辑层为中转中心接收货物信息界面提供的服务
 * @author 阮威威
 * */
public interface ReceivingBLService {

	/**
	 * description:添加新的接收信息
	 * @param ReceivingVO ,接收信息的相关值对象，具体参照ReceivingVO的定义
	 * @return boolean, 返回接收信息是否添加成功
	 * */
	public boolean addReceivingFormBL(ReceivingVO receivingVO);
	
	/**
	 * description:修改新的接收信息
	 * @param ReceivingVO ,接收信息的相关值对象，具体参照ReceivingVO的定义
	 * @return boolean, 返回接收信息是否修改成功
	 * */
	public boolean modifyReceivingFormBL(ReceivingVO receivingVO);
	
	/**
	 * description:通过中转单编号找到相应的货物接收单
	 * @param ReceivingNumber ,中转单编号（年月日＋000000六位数字）
	 * @return ReceivingVO, 返回货物接受信息的值对象，具体参见ReceivingVo的定义
	 * */
	public ReceivingVO findReceivingformBL(String receivingNumber);
	
}
