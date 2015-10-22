package vo.deliveryVO;

public class OrderVO {

	private SenderInfo senderInfo;
	
	private ReceiverInfo receiverInfo;
	
	private GoodsInfo goodsInfo;

	public OrderVO(SenderInfo senderInfo, ReceiverInfo receiverInfo, GoodsInfo goodsInfo) {
		super();
		this.senderInfo = senderInfo;
		this.receiverInfo = receiverInfo;
		this.goodsInfo = goodsInfo;
	}

	SenderInfo getSenderInfo() {
		return senderInfo;
	}

	ReceiverInfo getReceiverInfo() {
		return receiverInfo;
	}

	GoodsInfo getGoodsInfo() {
		return goodsInfo;
	}
	
}
