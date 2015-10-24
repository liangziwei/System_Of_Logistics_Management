
package vo.repositoryVO;

import constant.AreaCodeType;

/**
 * 记录了库存的信息
 * @author 阮威威
 */
public class RepositoryVO {
	/**
	 * 快递的编号（十位数字）
	 */
	private String deliveryid;
	/**
	 * 区号
	 */
	private AreaCodeType areaCode;
	/**
	 * 排号
	 */
	private String rowid;
	/**
	 * 架号
	 */
	private String shelfid;
	/**
	 * 位号
	 */
	private String posid;
}

