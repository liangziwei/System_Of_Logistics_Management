package vo.deliveryVO;

import po.deliveryPO.ClientInfo;
import po.deliveryPO.GoodsInfo;

/**
 * 记录了订单的信息
 * @author 肖安祥
 */
public class OrderVO {

	private ClientInfo senderInfo;
	
	private ClientInfo receiverInfo;
	
	private GoodsInfo goodsInfo;

	public OrderVO(ClientInfo senderInfo, ClientInfo receiverInfo, GoodsInfo goodsInfo) {
		super();
		this.senderInfo = senderInfo;
		this.receiverInfo = receiverInfo;
		this.goodsInfo = goodsInfo;
	}

	public ClientInfo getSenderInfo() {
		return senderInfo;
	}
	
	public ClientInfo getReceiverInfo() {
		return receiverInfo;
	}

	public GoodsInfo getGoodsInfo() {
		return goodsInfo;
	}

	public void setSenderInfo(ClientInfo senderInfo) {
		this.senderInfo = senderInfo;
	}

	public void setReceiverInfo(ClientInfo receiverInfo) {
		this.receiverInfo = receiverInfo;
	}

	public void setGoodsInfo(GoodsInfo goodsInfo) {
		this.goodsInfo = goodsInfo;
	}
}
