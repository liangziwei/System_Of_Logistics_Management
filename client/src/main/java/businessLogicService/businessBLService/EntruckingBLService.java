package businessLogicService.businessBLService;

import vo.businessVO.EntruckingVO;

/**
 * description:业务逻辑层为装车管理界面提供的服务 
 * @author 张云飞
 */
public interface EntruckingBLService {
	
	/**
	 * description:通过传入装车单信息新建一个装车单
	 * 前置条件：ui层发出添加装车单的命令
	 * 后置条件：系统添加装车单信息
	 * 需要的服务：EntruckingDataService.addEntruckingFrom(EntruckingPO entruckingPO)
	 * @param entruckingVO 装车单信息值对象，具体参见EntruckingVO
	 * @return 添加是否成功
	 */
    public boolean addEntruckingFrom(EntruckingVO entruckingVO);

	public double getFreight();
}
