package businessLogicService.repositoryBLService;

import vo.repositoryVO.InRepositoryVO;

/**
 * description:业务逻辑层为中转中心仓库入库信息界面提供的服务
 * @author 阮威威
 * */
public interface InRepositoryBLService {

	/**
	 * description:添加新的入库单信息
	 * @param InRepositoryVO ,入库单信息的相关值对象，具体参照InRepositoryVO的定义
	 * @return String, 返回入库单信息的处理结果（true:添加成功；false：添加失败；true.warn：添加成功并报警）
	 * */
	public String addInRepositoryFormBL(InRepositoryVO inRepository);
	
	/**
	 * description:修改新的入库单信息
	 * @param InRepositoryVO ,入库单信息的相关值对象，具体参照InRepositoryVO的定义
	 * @return String, 返回入库单信息的处理结果（true:添加成功；false：添加失败；true.warn：添加成功并报警）
	 * */
	public String modifyInRepositoryFormBL(InRepositoryVO inRepositoryVO);
	
	/**
	 * description:通过入库单的快递编号得到相应的入库单信息
	 * @param InRepositoryNumber ,快递编号（十位数字）
	 * @return InRepositoryVO, 返回入库单信息的值对象，具体参照InRepositoryVO的定义
	 * */
	public InRepositoryVO findInRepositoryFormBL(String InRepositoryNumber);
}
