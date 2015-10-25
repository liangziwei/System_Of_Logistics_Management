package dataService.transitionDataService;

import po.transitionPO.LoadingPO;

/**
 *description:数据服务层为中转中心装运信息管理提供的服务 
 * @author 阮威威
 */
public interface LoadingDataService {
	
	/**
	 * description:添加新的装运单信息
	 * 前置条件：逻辑层传送的LoadingPO不为null且格式正确
	 * 后置条件：保存装运单
	 * 需接口：无
	 * @param LoadingPO ,装运信息的相关持久化对象存储，具体参照LoadingPO的定义
	 * @return boolean, 返回给方法调用者装运信息是否添加成功
	 * */
	public boolean AddLoadingFormDT(LoadingPO loadingPO);
	
	/**
	 * description:修改装运单信息
	 * 前置条件：逻辑层传送的LoadingPO不为null且格式正确
	 * 后置条件：修改装运单
	 * 需接口：无
	 * @param LoadingPO ,装运信息的相关持久化对象存储，具体参照LoadingPO的定义
	 * @return boolean, 返回给方法调用者装运信息是否修改成功
	 * */
	public boolean ModifyLoadingFormDT(LoadingPO loadingPO);

	/**
	 * description:通过装运单编号得到相应的装运信息
	 * 前置条件：逻辑层传送的LoadingNumber正确
	 * 后置条件：将获得的装运单信息返回给逻辑层
	 * 需接口：无
	 * @param LoadingNumber ,装运单编号（中转中心编号+日期+0000四位数字）
	 * @return LoadingPO, 返回装运信息的持久化对象，具体参照LoadingPO的定义
	 */
	public LoadingPO FindLoadingFormDT(String loadingNumber);
	
}
