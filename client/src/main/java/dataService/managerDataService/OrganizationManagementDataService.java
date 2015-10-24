package dataService.managerDataService;

import po.managerPO.OrganizationPO;
/**
 * description:数据服务层为机构管理逻辑处理提供的服务
 * @author 张仁知
 */
public interface OrganizationManagementDataService {
	
	/**
	 * description:添加一个机构
	 * 前置条件：同样id的po在数据库中不存在
	 * 后置条件：在数据库中添加一个po
	 * @param  OrganizationPO ,记录机构信息的值对象，具体参照OrganizationPO定义
	 * @return boolean, 添加是否成功
	 */
	public boolean addOrganization(OrganizationPO organizationPO);
	
	/**
	 * description:查询一个机构信息
	 * 前置条件：无
	 * 后置条件：按id进行查找返回相应的OrganizationPO结果
	 * @param  id ,机构编号
	 * @return OrganizationPO, 记录机构信息的值对象，具体参照OrganizationPO定义
	 */
	public OrganizationPO findOrganization(String id);
	
	/**
	 * description:删除一个机构信息
	 * 前置条件：在数据库中存在同样id的po
	 * 后置条件：删除一个po
	 * @param  id ,机构编号
	 * @return boolean, 删除是否成功
	 */	
	public boolean deleteOrganization(String id);
	
	/**
	 * description:修改一个机构信息
	 * 前置条件：在数据库中存在同样id的po
	 * 后置条件：修改一个po
	 * @param  OrganizationPO, 记录机构信息的值对象，具体参照OrganizationPO定义
	 * @return boolean ,修改是否成功
	 */
	public boolean modifyOrganization(OrganizationPO organizationPO);	
}
