package ui.deliveryui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import businessLogicImpl.deliveryBLImpl.OrderBLImpl;
import businessLogicService.deliveryBLService.OrderBLService;
import constant.City;
import constant.ClientType;
import constant.OrderLabelName;
import constant.TransitionNode;
import constant.VerifyResult;
import po.deliveryPO.ClientInfo;
import po.deliveryPO.GoodsInfo;
import ui.baseui.DetailPanel;
import ui.deliveryui.orderInfo.ClientInfoPanel;
import ui.deliveryui.orderInfo.GoodsInfoPanel;
import ui.deliveryui.orderInfo.OtherInfo;
import vo.deliveryVO.OrderVO;
import vo.deliveryVO.VerifyMessage;

@SuppressWarnings("serial")
public class OrderInputPanel extends DetailPanel{
	
	private OrderBLService orderService = new OrderBLImpl();

	private ClientInfoPanel sender = new ClientInfoPanel(ClientType.SENDER);
	
	private ClientInfoPanel receiver = new ClientInfoPanel(ClientType.RECEIVER);
	
	private GoodsInfoPanel goodsInfo = new GoodsInfoPanel();
	
	private OtherInfo otherInfo = new OtherInfo();
	
	private JPanel buttonPanel = new JPanel();
	
	private JLabel state = new JLabel("" ,JLabel.CENTER);
	
	private JButton ok = new JButton("确定");
	
	private JButton cancel = new JButton("取消");
	
	public static Font WORD_FONT = new Font("宋体", Font.PLAIN, 12);
	
	public static final int LABEL_W = 80;
	
	public static final int LABEL_H = 35;
	
	public static final int TEXT_W = LABEL_W << 1;
	
	public static final int TEXT_H = LABEL_H;
	
	public static final int COMPONENT_GAP = 20;
	
	private static final int PANEL_W = LABEL_W + COMPONENT_GAP + TEXT_W;
	
	private static final int BUTTON_W = 80;
	
	private static final int BUTTON_H = 30;
	
	/**
	 * 信息面板之间的距离
	 */
	private static final int PANEL_GAP = (DetailPanel.DETAIL_PANEL_W - (PANEL_W << 1)) / 3;
	
	/**
	 *寄件人面板开始x坐标 
	 */
	private static final int SENDER_X = PANEL_GAP;
	
	/**
	 *寄件人面板开始y坐标 
	 */
	private static final int SENDER_Y = SENDER_X;
	
	/**
	 * 标签列表，每个字符串对应一个标签
	 */
	private Map<OrderLabelName, JLabel> labelList = new HashMap<OrderLabelName, JLabel>();
	
	/**
	 * 是否为第一次按确认按钮
	 */
	private boolean isFirstEnsure = true;
	
	public OrderInputPanel() {
		super();
		//初始化信息面板
		this.initUI();
		//按钮面板
		this.buttonPanel.setBounds(this.otherInfo.getX(),
				this.otherInfo.getY() + this.otherInfo.getHeight() + PANEL_GAP,
				(BUTTON_W << 1) + PANEL_GAP, BUTTON_H);
		this.buttonPanel.setLayout(null);
		//确定按钮
		this.ok.setBounds(0, 0, BUTTON_W, BUTTON_H);
		this.ok.setFont(WORD_FONT);
		//取消按钮
		this.cancel.setBounds(BUTTON_W + PANEL_GAP, 0, BUTTON_W, BUTTON_H);
		this.cancel.setFont(WORD_FONT);
		//添加事件监听
		this.addListener();
		//将按钮添加到按钮面板
		this.buttonPanel.setLayout(null);
		this.buttonPanel.add(this.ok);
		this.buttonPanel.add(this.cancel);
		//状态信息
		this.state.setBounds(this.sender.getX(), this.buttonPanel.getY() - BUTTON_H, PANEL_W, BUTTON_W);
		this.state.setFont(WORD_FONT);
		this.state.setForeground(Color.RED);
		//将信息面板加到主面板
		this.addPanels();
		//初始化标签列表
		this.initLabelList();
	}
	
	private void initUI() {
		int panelH = 0;
		//寄件人信息面板
		panelH = LABEL_H * this.sender.getUILineNum()
				+ COMPONENT_GAP * (this.sender.getUILineNum() - 1);
		this.sender.setBounds(SENDER_X, SENDER_Y,
				PANEL_W, panelH);
		//收件人信息面板
		panelH = LABEL_H * this.receiver.getUILineNum()
				+ COMPONENT_GAP * (this.receiver.getUILineNum() - 1);
		this.receiver.setBounds(SENDER_X + PANEL_W + PANEL_GAP, SENDER_Y ,
				PANEL_W, panelH);
		//物品信息面板
		panelH = LABEL_H * this.goodsInfo.getUILineNum()
				+ COMPONENT_GAP * (this.goodsInfo.getUILineNum() - 1);
		this.goodsInfo.setBounds(this.sender.getX(), this.sender.getY() + this.sender.getHeight() + PANEL_GAP,
				PANEL_W, panelH);
		//其他信息面板
		panelH = LABEL_H * this.otherInfo.getUILineNum()
				+ COMPONENT_GAP * (this.otherInfo.getUILineNum() - 1);
		this.otherInfo.setBounds(this.receiver.getX(), this.goodsInfo.getY(),
				PANEL_W, panelH);
		//设置日期
		this.otherInfo.getDatePanel().setDate();
	}
	
	private void addListener() {
		
		//确定按钮
		this.ok.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//创建订单信息的值对象
				OrderVO orderVO = createOrderVO();
				//验证输入是否合乎规范
				VerifyMessage msg = orderService.verifyOrderInfo(orderVO);
				//消除先前的错误位置提示
				setLabelBlack();		
				
				if(msg.getResult() == VerifyResult.SUCCESS) {
					throughVerifyOperation(orderVO);	//验证成功
				}else {
					verifyFailOperation(msg);			//验证失败
				}
				
				//刷新页面
				repaint();
			}
		});
		
		//取消按钮
		this.cancel.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//回到第一次点击确定的状态
				isFirstEnsure = true;
				//使提示信息消失
				state.setText("");
				setLabelBlack();
				//使信息可编辑
				enableComponents();
				//重置运费和时间
				goodsInfo.setPriceText("");
				otherInfo.setTimeText("");
			}
		});
	}
	
	private void throughVerifyOperation(OrderVO orderVO) {
		//使所有组件不可编辑
		disableComponents();
		//计算运费和时间
		double weight = Double.parseDouble(goodsInfo.getWeight());
		double price = orderService.calculatePrice(otherInfo.getDeliveryType(),
				weight, sender.getCity(), receiver.getCity());
		int day = orderService.calculateTime(sender.getCity(), receiver.getCity());
		//显示运费
		labelList.get(OrderLabelName.PRICE).setForeground(Color.RED);
		goodsInfo.setPriceText(price + "元");
		//显示时间
		labelList.get(OrderLabelName.TIME).setForeground(Color.RED);
		otherInfo.setTimeText(day + "天");
		//如果是第一次按确认，提示用户确认输入
		if(isFirstEnsure) {
			showState("请再次确认信息，无误后按确定，否则按取消");
			isFirstEnsure = false;
		}
		else {
			//记录收件信息
			boolean save = orderService.saveOrderInfo(orderVO);
			if(save) {		//保存成功
				showState("订单保存成功");
				disableComponents();
			}else {			//TODO 保存失败，说明保存失败的原因或者提出建议
				showState("订单存失败");
			}
		}
	}
	
	private void verifyFailOperation(VerifyMessage msg) {
		//提示错误位置
		labelList.get(msg.getLabel()).setForeground(Color.RED);
		//提示修改意见
		showState(msg.getErrorMsg());
	}
	
	private OrderVO createOrderVO() {
		ClientInfo senderInfo = new ClientInfo(ClientType.SENDER,
				sender.getClientName(), sender.getAddress(), sender.getCompany(),
				sender.getPhoneNumber(), sender.getMobilbeNumber());
		ClientInfo receiverInfo = new ClientInfo(ClientType.RECEIVER,
				receiver.getClientName(), receiver.getAddress(), receiver.getCompany(),
				receiver.getPhoneNumber(), receiver.getMobilbeNumber());
		List<TransitionNode> node = new ArrayList<TransitionNode>();
		node.add(TransitionNode.SENDER_BUSINESS_HALL);
		List<City> city = new ArrayList<City>();
		city.add(sender.getCity());
		GoodsInfo goods = new GoodsInfo(goodsInfo.getNumber(), otherInfo.getID(), goodsInfo.getWeight(),
				goodsInfo.getGoodsName(), goodsInfo.getVolumn(), otherInfo.getPackageType(),
				otherInfo.getDeliveryType(), otherInfo.getDate(), node, city);
		
		return new OrderVO(senderInfo, receiverInfo, goods);
	}
	
	private void initLabelList() {
		//寄件人标签
		this.labelList.put(OrderLabelName.SENDER_NAME, this.sender.getNameLabel());
		this.labelList.put(OrderLabelName.SENDER_ADDR, this.sender.getAddressLabel());
		this.labelList.put(OrderLabelName.SENDER_MOBILE, this.sender.getMobileLabel());
		//收件人标签
		this.labelList.put(OrderLabelName.RECEIVER_NAME, this.receiver.getNameLabel());
		this.labelList.put(OrderLabelName.RECEIVER_ADDR, this.receiver.getAddressLabel());
		this.labelList.put(OrderLabelName.RECEIVER_MOBILE, this.receiver.getMobileLabel());
		//物品信息标签
		this.labelList.put(OrderLabelName.GOODS_NAME, this.goodsInfo.getNumLabel());
		this.labelList.put(OrderLabelName.GOODS_WEIGHT, this.goodsInfo.getWeightLabel());
		this.labelList.put(OrderLabelName.GOODS_VOLUMN, this.goodsInfo.getVolumeLabel());
		this.labelList.put(OrderLabelName.GOODS_NAME, this.goodsInfo.getNameLabel());
		this.labelList.put(OrderLabelName.PRICE, this.goodsInfo.getPriceLabel());
		//其他信息标签
		this.labelList.put(OrderLabelName.GOODS_ID, this.otherInfo.getIdLabel());
		this.labelList.put(OrderLabelName.GOODS_DATE, this.otherInfo.getDateLabel());
		this.labelList.put(OrderLabelName.TIME, this.otherInfo.getTimeLabel());
	}
	
	private void addPanels() {
		this.container.add(this.sender);
		this.container.add(this.receiver);
		this.container.add(this.goodsInfo);
		this.container.add(this.otherInfo);
		this.container.add(this.buttonPanel);
		this.container.add(this.state);
	}
	
	private void disableComponents() {
		this.sender.disableComponents();
		this.receiver.disableComponents();
		this.goodsInfo.disableComponents();
		this.otherInfo.disableComponents();
	}
	
	private void enableComponents() {
		this.sender.enableComponents();;
		this.receiver.enableComponents();;
		this.goodsInfo.enableComponents();
		this.otherInfo.enableComponents();
	}
	
	private void showState(String msg) {
		this.state.setText(msg);
		this.repaint();
	}
	
	private void setLabelBlack() {
		this.sender.setLabelBlack();
		this.receiver.setLabelBlack();
		this.goodsInfo.setLabelBlack();
		this.otherInfo.setLabelBlack();
	}
}
