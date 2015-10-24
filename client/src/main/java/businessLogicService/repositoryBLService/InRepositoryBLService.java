package businessLogicService.repositoryBLService;

import vo.repositoryVO.InRepositoryVO;

/**
 * description:业务逻辑层为中转中心仓库入库信息界面提供的服务
 * @author 阮威威
 * */
public interface InRepositoryBLService {

	/**
	 * description:添加新的入库单信息
	 * 前置条件：用户按照界面输入InRepositoryVO的信息，界面传递InRepositoryVO
	 * 后置条件：系统保存入库单信息，返回界面是否保存成功
	 * 需接口：InRepositoryDataService.AddInRepositoryFormmDT(InRepositoryPO inRepositoryPO)，
	 *InRepositoryDataService.UpdateRepositoryInfoDT(InRepositoryPO inRepository)
	 * @param InRepositoryVO ,入库单信息的相关值对象，具体参照InRepositoryVO的定义
	 * @return String, 返回入库单信息的处理结果（true:添加成功；false：添加失败；true.warn：添加成功并报警）
	 * */
	public String addInRepositoryFormBL(InRepositoryVO inRepository);
	
	/**
	 * description:修改新的入库单信息
	 * 前置条件：用户按照界面输入InRepositoryVO的信息，界面传递InRepositoryVO
	 * 后置条件：系统保存修改的入库单信息，返回界面是否修改成功
	 * 需接口：InRepositoryDataService.ModifyInRepositoryFormDT(InRepositoryPO inRepositoryPO),
	 * InRepositoryDataService.UpdateRepositoryInfoDT(InRepositoryPO inRepository)
	 * @param InRepositoryVO ,入库单信息的相关值对象，具体参照InRepositoryVO的定义
	 * @return String, 返回入库单信息的处理结果（true:添加成功；false：添加失败；true.warn：添加成功并报警）
	 * */
	public String modifyInRepositoryFormBL(InRepositoryVO inRepositoryVO);
	
	/**
	 * description:通过入库单的快递编号得到相应的入库单信息
	 * 前置条件：用户输入有效快递编号
	 * 后置条件：根据快递编号查找相应入库单信息，返回给界面显示
	 * 需接口：InRepositoryDataService.FindInRepositoryFormDT(String inRepositoryNumber)（根据快递编号查询入库单）
	 * @param InRepositoryNumber ,快递编号（十位数字）
	 * @return InRepositoryVO, 返回入库单信息的值对象，具体参照InRepositoryVO的定义
	 * */
	public InRepositoryVO findInRepositoryFormBL(String InRepositoryNumber);
}
