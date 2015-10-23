package businessLogicService.repositoryBLService;

import java.util.List;

import vo.repositoryVO.OutRepositoryVO;
import vo.transitionVO.TransferringVO;

/**
 * description:业务逻辑层为中转中心仓库出库信息界面提供的服务
 * @author 阮威威
 * */
public interface OutRepositoryBLService {

	/**
	 * description:添加新的出库单信息
	 * @param OutRepositoryVO ,出库单信息的相关值对象，具体参照OutRepositoryVO的定义
	 * @return boolean, 返回出库单信息是否添加成功
	 * */
	public boolean addOutRepositoryFormBL(OutRepositoryVO outRepositoryVO);
	
	/**
	 * description:修改新的出库单信息
	 * @param OutRepositoryVO ,出库单信息的相关值对象，具体参照OutRepositoryVO的定义
	 * @return boolean, 返回出库单信息是否修改成功
	 * */
	public boolean modifyOutRepositoryFormBL(OutRepositoryVO outRepositoryVO);
	
	/**
	 * description:通过出库单的快递编号得到相应的出库单信息
	 * @param OutRepositoryNumber ,快递编号（四位数字）
	 * @return OutRepositoryVO, 返回出库单信息的值对象，具体参照OutRepositoryVO的定义
	 * */
	public OutRepositoryVO findOutRepositoryFormBL(String OutRepositoryNumber);
	
	/**
	 * description:查看中转单列表信息
	 * @param 
	 * @return List<TransferringVO>, 返回中转单列表信息的值对象，具体参照TransferringVO
	 * */
	public List<TransferringVO> GetTransferringInfo();
}
