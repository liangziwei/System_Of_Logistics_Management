package businessLogicService.businessBLService;

import vo.businessVO.EntruckingVO;
/**
 * description:新建装车单逻辑操作 
 * @author 张云飞
 * 
 */
public interface EntruckingBLService {
	
	/**
	 * description:新建一个装车单
	 * @param EntruckingVO 装车单
	 * @return 添加是否成功
	 */
    public boolean addEntruckingFrom(EntruckingVO entruckingVO);
}
