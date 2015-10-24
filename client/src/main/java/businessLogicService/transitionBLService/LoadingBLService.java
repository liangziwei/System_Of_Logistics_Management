package businessLogicService.transitionBLService;

import vo.transitionVO.LoadingVO;;

/**
 * description:业务逻辑层为中转中心装运信息界面提供的服务
 * @author 阮威威
 * */
public interface LoadingBLService {
	
	/**
	 * description:通过装运编号得到相应的装运单信息
	 * @param LoadingNumber ,装运编号（中转中心编号+日期+0000四位数字）
	 * @return LoadingVO, 返回装运信息的值对象，具体参照LoadingVO的定义
	 * */
	public LoadingVO findLoadingFormBL(String loadingNumber);
	
	/**
	 * description:添加新的装运单信息
	 * @param LoadingVO ,装运信息的相关值对象，具体参照LoadingVO的定义
	 * @return boolean, 返回装运信息是否添加成功
	 * */
	public boolean addLoadingFormBL(LoadingVO loadingVO);
	
	/**
	 * description:修改某份装运单信息
	 * @param LoadingVO ,装运信息的相关值对象，具体参照LoadingVO的定义
	 * @return boolean, 返回装运信息是否修改成功
	 * */
	public boolean modifyLoadingFormBL(LoadingVO loadingVO);
	
	/**
	 * description:通过不同城市来定义装运单的运费值
	 * @param CityFrom , 出发城市
	 * @param CityTo , 到达城市
	 * @return double, 返回装运单的运费值
	 * */
	public double loadingFare(String CityFrom,String CityTo);
	
}
