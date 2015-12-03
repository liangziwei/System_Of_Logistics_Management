package businessLogicService.transitionBLService;

import constant.City;
import constant.LoadingType;
import vo.transitionVO.LoadingVO;;

/**
 * description:业务逻辑层为中转中心装运信息界面提供的服务
 * @author 阮威威
 * */
public interface LoadingBLService {
	
	/**
	 * description:通过装运编号得到相应的装运单信息
	 * 前置条件：用户输入有效装运编号
	 * 后置条件：根据装运编号查找相应装运单信息，返回给界面显示
	 * 需接口：LoadingDataService.FindLoadingFormDT(String loadingNumber)（根据装运编号查询装运单）
	 * @param LoadingNumber ,装运编号（中转中心编号+日期+0000四位数字）
	 * @return LoadingVO, 返回装运信息的值对象，具体参照LoadingVO的定义
	 * */
	public LoadingVO findLoadingFormBL(String loadingNumber);
	
	/**
	 * description:添加新的装运单信息
	 * 前置条件：用户按照界面输入LoadingVO的信息，界面传递LoadingVO
	 * 后置条件：系统保存装运单信息，返回界面是否保存成功
	 * 需接口：LoadingDataService.addLoadingFormmDT(LoadingPO loadingPO),
	 * LoadingBLService.loadingFare(String CityFrom,String CityTo)
	 * @param LoadingVO ,装运信息的相关值对象，具体参照LoadingVO的定义
	 * @return boolean, 返回装运信息是否添加成功
	 * */
	public boolean addLoadingFormBL(LoadingVO loadingVO);
	
	/**
	 * description:修改某份装运单信息
	 * 前置条件：用户按照界面输入LoadingVO的信息，界面传递LoadingVO
	 * 后置条件：系统保存修改的装运单信息，返回界面是否修改成功
	 * 需接口：LoadingDataService.modifyLoadingFormDT(LoadingPO loadingPO),
	 * LoadingBLService.loadingFare(String CityFrom,String CityTo)
	 * @param LoadingVO ,装运信息的相关值对象，具体参照LoadingVO的定义
	 * @return boolean, 返回装运信息是否修改成功
	 * */
	public boolean modifyLoadingFormBL(LoadingVO loadingVO);
	
	/**
	 * description:通过不同城市来定义装运单的运费值
	 * 前置条件：addLoadingFormBL，modifyLoadingFormBL传递装运单的出发地和目的地
	 * 后置条件：返回装运的运费
	 * 需接口：无
	 * @param CityFrom , 出发城市
	 * @param CityFrom , 到达的某营业厅
	 * @param LoadingType,装运方式
	 * @return double, 返回装运单的运费值
	 * */
	public double loadingFare(String CityFrom,String CityTo,LoadingType type);
	/**
	 * description:判断输入是否正确
	 * 前置条件：LoadingPanel
	 * 后置条件：返回是否正确
	 * 需接口：无
	 * @param loadingVO,输入的装运单信息
	 * @return boolean, 返回是否正确
	 * */
	public boolean verify(LoadingVO loadingVO);
	
}
