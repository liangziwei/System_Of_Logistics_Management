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
	 * @param TransferringNumber ,中转单编号（中转中心编号+日期+0000000七位数字）
	 * @return TransferringVO, 返回中转单信息的值对象，具体参照TransferringVO的定义
	 * */
	public TransferringVO findTransferringFormBL(String transferringNumber);
	
	/**
	 * description:添加新的中转单信息
	 * @param TranferringVO ,中转单信息的相关值对象，具体参照TransferringVO的定义
	 * @return boolean, 返回中转单信息是否添加成功
	 * */
	public boolean addTransferringFormBL(TransferringVO transferringVO);
	
	/**
	 * description:修改新的中转单信息
	 * @param TranferringVO ,中转单信息的相关值对象，具体参照TransferringVO的定义
	 * @return boolean, 返回中转单信息是否修改成功
	 * */
	public boolean modifyTransferringFormBL(TransferringVO transferringVO);
	
	/**
	 * description:通过不同城市来定义中转单的运费值
	 * @param CityFrom , 出发城市
	 * @param CityTo , 到达城市
	 * @return double, 返回中转单的运费值
	 * */
	public double tranferringFare(String CityFrom,String CityTo);
	
	/**
	 * description:查看库存信息
	 * @param 
	 * @return List<RepositoryVO>, 返回仓库的库存信息的值对象，具体参照RepositoryVO
	 * */
	public List<RepositoryVO> getRepositoryInfo();
}
