package businessLogicService.transitionBLService;

import businessLogic.businessLogicModel.transitionModel.Receiving;
import vo.transitionVO.ReceivingVO;

/**
 * description:业务逻辑层为中转中心接收货物信息界面提供的服务
 * @author 阮威威
 * */
public interface ReceivingBLService {

	/**
	 * description:添加新的接收信息
	 * 前置条件：用户按照界面输入ReceivingVO的信息，界面传递ReceivingVO
	 * 后置条件：系统保存接收单信息，返回界面是否保存成功
	 * 需接口：ReceivingDataService.addReceivingFormDT(ReceivingPO receivingPO)
	 * @param ReceivingVO ,接收信息的相关值对象，具体参照ReceivingVO的定义
	 * @return boolean, 返回接收信息是否添加成功
	 * */
	public boolean addReceivingFormBL(ReceivingVO receivingVO);
	
	/**
	 * description:修改新的接收信息
	 * 前置条件：用户按照界面输入ReceivingVO的信息，界面传递ReceivingVO
	 * 后置条件：系统保存修改的接收单信息，返回界面是否修改成功
	 * 需接口：ReceivingDataService.modifyReceivingVOFormDT(ReceivingPO receivingPO)
	 * @param ReceivingVO ,接收信息的相关值对象，具体参照ReceivingVO的定义
	 * @return boolean, 返回接收信息是否修改成功
	 * */
	public boolean modifyReceivingFormBL(ReceivingVO receivingVO);
	
	/**
	 * description:通过中转单编号找到相应的货物接收单
	 * 前置条件：用户输入有效接收单的中转编号
	 * 后置条件：根据中转编号查找相应接收单信息，返回给界面显示
	 * 需接口：ReceivingDataService.FindReceivingFormDT(String receivingNumber)（根据接收单的中转编号查询接收单）
	 * @param ReceivingNumber ,中转单编号（年月日＋000000六位数字）
	 * @return ReceivingVO, 返回货物接受信息的值对象，具体参见ReceivingVo的定义
	 * */
	public ReceivingVO findReceivingformBL(String receivingNumber);
	/**
	 * description:判断输入是否正确
	 * 前置条件：ReceivingPanel
	 * 后置条件：返回是否正确
	 * 需接口：无
	 * @param receivingVO,输入的接收单信息
	 * @return boolean, 返回是否正确
	 * */
	public boolean verify(ReceivingVO receivingVO);
	
}
