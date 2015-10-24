package businessLogicService.managerBLService;

import vo.managerVO.OrganizationVO;

/**
 * description:业务逻辑层为机构管理界面提供的服务
 * @author 张仁知
 */

public interface OrganizationManagementBLService {
	
	/**
	 * description:添加一个机构
	 * @param  OrganizationVO ,记录机构信息的值对象，具体参照OrganizationVO定义
	 * @return boolean, 添加是否成功
	 */
	public boolean addOrganization(OrganizationVO organizationVO);
	
	/**
	 * description:查询一个机构信息
	 * @param  id ,机构编号
	 * @return OrganizationVO, 记录机构信息的值对象，具体参照OrganizationVO定义
	 */
	public OrganizationVO findOrganization(String id);
	
	/**
	 * description:删除一个机构信息
	 * @param  id ,机构编号
	 * @return boolean, 删除是否成功
	 */	
	public boolean deleteOrganization(String id);
	
	/**
	 * description:修改一个机构信息
	 * @param  OrganizationVO, 记录机构信息的值对象，具体参照OrganizationVO定义
	 * @return boolean ,修改是否成功
	 */
	public boolean modifyOrganization(OrganizationVO organizationVO);
}
