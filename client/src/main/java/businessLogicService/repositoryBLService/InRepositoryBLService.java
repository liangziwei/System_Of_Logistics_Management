package businessLogicService.repositoryBLService;

import constant.AreaCodeType;
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
	
	/**
	 * description:进行是否要预警的处理
	 * 前置条件：进行一次添加（修改）入库单的操作
	 * 后置条件：返回是否要预警
	 * 需接口：InRepositoryBLImpl.getWarnNum(String ID),
	 * InRepositoryBLImpl.GetRepositoryNum(String ID),
	 * InRepositoryBLImpl.GetRepositoryExist(String ID)
	 * @param InRepositoryVO ,入库单信息的相关值对象，具体参照InRepositoryVO的定义
	 * @return boolean, 返回是否报警
	 * */
	public boolean warnBL(InRepositoryVO inRepositoryVO);
	
	/**
	 * description:取得仓库中某个区的报警百分比
	 * 前置条件：进行一次添加（修改）入库单的操作
	 * 后置条件：返回仓库的某个区的报警百分比
	 * 需接口：ManageRepositoryBLImpl.GetWranNumBL(String ID)
	 * @param ID：仓库的某个区号
	 * @return double, 返回仓库的某个区的报警百分比
	 * */
	public double getWarnNum(AreaCodeType ID);
	
	/**
	 * description:取得仓库中某个区的容量值
	 * 前置条件：进行一次添加（修改）入库单的操作
	 * 后置条件：返回仓库的某个区的容量值
	 * 需接口：ManageRepositoryBLImpl.GetRepositoryNumBL(String ID)
	 * @param ID：仓库的某个区号
	 * @return int ： 返回仓库的某个区的容量值
	 * */
	public int GetRepositoryNum(AreaCodeType ID);
	
	/**
	 * description:取得仓库中某个区的现存快递数量
	 * 前置条件：进行一次添加（修改）入库单的操作
	 * 后置条件：返回仓库的某个区的现存快递数量
	 * 需接口：ManageRepositoryBLImpl.GetRepositoryExistBL(String ID)
	 * @param ID：仓库的某个区号
	 * @return int ： 返回仓库的某个区的现存快递数量
	 * */
	public int GetRepositoryExist(AreaCodeType ID);

}
