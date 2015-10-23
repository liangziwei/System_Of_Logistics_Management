package dataService.repositoryDataService;

import po.repositoryPO.InRepositoryPO;

/**
 *description:数据服务层为中转中心库存管理的入库单信息管理提供的服务 
 * @author 阮威威
 */
public interface InRepositoryDataService {
	
	/**
	 * description:添加新的入库单信息
	 * @param InRepositoryPO ,入库单信息的相关持久化对象存储，具体参照InRepositoryPO的定义
	 * @return boolean, 返回给方法调用者入库单信息是否添加成功
	 * */
	public boolean AddInRepositoryFormDT(InRepositoryPO inRepositoryPO);
	
	/**
	 * description:修改入库单信息
	 * @param InRepositoryPO ,入库单信息的相关持久化对象存储，具体参照InRepositoryPO的定义
	 * @return boolean, 返回给方法调用者入库单信息是否修改成功
	 * */
	public boolean ModifyInRepositoryFormDT(InRepositoryPO inRepository);
	
	/**
	 * description:通过入库单的快递编号得到相应的入库单信息
	 * @param InRepositoryNumber ,入库单的快递编号（十位数字）
	 * @return InRepositoryPO, 返回入库单信息的持久化对象，具体参照InRepositoryPO的定义
	 */
	public InRepositoryPO FindInRepositoryFormDT(String InRepositoryNumber);
	
	/**
	 * description:根据入库单信息更新库存信息
	 * @param InRepositoryPO , 入库单信息的相关持久化对象存储，具体参照InRepositoryPO的定义
	 * @return boolean, 返回给方法调用者库存信息是否更新成功
	 * */
	public boolean UpdateRepositoryInfoDT(InRepositoryPO inRepository);

}

