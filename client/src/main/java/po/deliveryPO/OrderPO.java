package po.deliveryPO;

import java.io.Serializable;
import java.util.ArrayList;

import dataService.Approvable;
import vo.deliveryVO.OrderVO;

/**
 * 订单的持久化对象
 * @author 肖安祥
 */
public class OrderPO implements Serializable, Approvable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4731658363143448150L;

	/**
	 *寄件人信息 
	 */
	private ClientInfo senderInfo;

	/**
	 *收件人信息 
	 */
	private ClientInfo receiverInfo;

	/**
	 *货物信息 
	 */
	private GoodsInfo goodsInfo;
	
	/**
	 * 是否已经被总经理的审批
	 */
	private boolean isApproved = false;
	
	/**
	 * 审批是否通过
	 */
	private boolean isPassed = false;

	public OrderPO(ClientInfo senderInfo, ClientInfo receiverInfo, GoodsInfo goodsInfo) {
		super();
		this.senderInfo = senderInfo;
		this.receiverInfo = receiverInfo;
		this.goodsInfo = goodsInfo;
	}
	
	public static OrderVO orderPOToVO(OrderPO orderPO) {
		return new OrderVO(orderPO.getSenderInfo(), orderPO.getReceiverInfo(), orderPO.getGoodsInfo());
	}
	
	public static OrderPO orderVOToPO(OrderVO orderVO) {
		return new OrderPO(orderVO.getSenderInfo(), orderVO.getReceiverInfo(), orderVO.getGoodsInfo());
	}
	
	public static ArrayList<OrderPO> orderVOListToPO(ArrayList<OrderVO> list) {
		ArrayList<OrderPO> po = new ArrayList<OrderPO>();
		int size = list.size();
		for(int i = 0; i < size; i++) {
			po.add(orderVOToPO(list.get(i)));
		}
		return po;
	}

	public ClientInfo getSenderInfo() {
		return senderInfo;
	}

	public void setSenderInfo(ClientInfo senderInfo) {
		this.senderInfo = senderInfo;
	}

	public ClientInfo getReceiverInfo() {
		return receiverInfo;
	}

	public void setReceiverInfo(ClientInfo receiverInfo) {
		this.receiverInfo = receiverInfo;
	}

	public GoodsInfo getGoodsInfo() {
		return goodsInfo;
	}

	public void setGoodsInfo(GoodsInfo goodsInfo) {
		this.goodsInfo = goodsInfo;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	public boolean isPassed() {
		return isPassed;
	}

	public void setPassed(boolean isPassed) {
		this.isPassed = isPassed;
	}
	
	public static ArrayList<OrderVO> orderPOListToVO(ArrayList<OrderPO> po) {
		ArrayList<OrderVO> vo = new ArrayList<OrderVO>();
		int size = po.size();
		for(int i = 0; i < size; i++) {
			vo.add(orderPOToVO(po.get(i)));
		}
		return vo;
	}
}
