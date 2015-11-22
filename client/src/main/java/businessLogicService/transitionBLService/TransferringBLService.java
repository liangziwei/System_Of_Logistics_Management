package businessLogicService.transitionBLService;

import java.util.List;

import vo.repositoryVO.RepositoryVO;
import vo.transitionVO.TransferringVO;

/**
 * description:业务逻辑层为中转中心中转信息界面提供的服务
 * @author 阮威威
 * */
public interface TransferringBLService {

	/**
	 * description:通过中转单编号得到相应的中转单信息
	 * 前置条件：用户输入有效中转单编号
	 * 后置条件：根据中转单编号查找相应中转单信息，返回给界面显示
	 * 需接口：TransferringDataService.FindTransferringFormDT(String transferringNumber)（根据中转单编号查询中转单）
	 * @param TransferringNumber ,中转单编号（中转中心编号+日期+0000000七位数字）
	 * @return TransferringVO, 返回中转单信息的值对象，具体参照TransferringVO的定义
	 * */
	public TransferringVO findTransferringFormBL(String transferringNumber);
	
	/**
	 * description:添加新的中转单信息
	 * 前置条件：用户按照界面输入TransferringVO的信息，界面传递TransferringVO
	 * 后置条件：系统保存中转单信息，返回界面是否保存成功
	 * 需接口：TransferringDataService.addTransferringFormmDT(TransferringPO transferringPO),
	 * TransferringBLService.transferringFare(String CityFrom,String CityTo)
	 * @param TranferringVO ,中转单信息的相关值对象，具体参照TransferringVO的定义
	 * @return boolean, 返回中转单信息是否添加成功
	 * */
	public boolean addTransferringFormBL(TransferringVO transferringVO);
	
	/**
	 * description:修改新的中转单信息
	 * 前置条件：用户按照界面输入TransferringVO的信息，界面传递TransferringVO
	 * 后置条件：系统保存修改的中转单信息，返回界面是否修改成功
	 * 需接口：TransferringDataService.modifyTransferringFormDT(TransferringPO transferringPO),
	 * TransferringBLService.transferringFare(String CityFrom,String CityTo)
	 * @param TranferringVO ,中转单信息的相关值对象，具体参照TransferringVO的定义
	 * @return boolean, 返回中转单信息是否修改成功
	 * */
	public boolean modifyTransferringFormBL(TransferringVO transferringVO);
	
	/**
	 * description:通过不同城市来定义中转单的运费值
	 * 前置条件：addTransferringFormBL，modifyTransferringFormBL传递中转单的出发地和目的地
	 * 后置条件：返回中转单的运费
	 * 需接口：无
	 * @param CityFrom , 出发城市
	 * @param CityTo , 到达城市
	 * @return double, 返回中转单的运费值
	 * */
	public double tranferringFare(String CityFrom,String CityTo);
	/**
	 * description:判断输入是否正确
	 * 前置条件：LoadingPanel
	 * 后置条件：返回是否正确
	 * 需接口：无
	 * @param transferringVO,输入的中转单信息
	 * @return boolean, 返回是否正确
	 * */
	public boolean verify(TransferringVO transferringVO);
	
	/**
	 * description:查看库存信息
	 * 前置条件：用户请求进行库存信息的查看
	 * 后置条件：系统返回库存信息列表List<RepositoryVO>（详细参数参照RepositoryVO）给界面
	 * 需接口：ManageRepositoryBLImpl.List<RepositoryVO> GetRepositoryInfoBL()
	 * @param 
	 * @return List<RepositoryVO>, 返回仓库的库存信息的值对象，具体参照RepositoryVO
	 * */
	public List<RepositoryVO> getRepositoryInfo();
	
	/**
	 * description:取得当天的中转单列表信息（实际取得中转单列表的BL）
	 * 前置条件：启动一个出库单操作，用户请求查询当天的中转单列表
	 * 后置条件：系统返回中转单信息列表List<TransferringVO>（详细参数参照TransferringVO）给界面
	 * 需接口：TransferringDataService.List<TransferringPO> GetTransferringInfoDT(String date)
	 * @param date ：当天的日期
	 * @return List<TransferringVO>, 返回中转单列表信息的值对象，具体参照TransferringVO的定义
	 * */
	public List<TransferringVO> GetTansferringInfoBL(String date);
}
