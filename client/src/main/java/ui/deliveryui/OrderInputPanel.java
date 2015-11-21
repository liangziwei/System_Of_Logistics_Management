package ui.deliveryui;

import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JScrollPane;

import businessLogic.businessLogicController.deliveryController.OrderController;
import businessLogicService.deliveryBLService.OrderBLService;
import constant.City;
import constant.ClientType;
import constant.LabelName;
import constant.TransitionNode;
import constant.VerifyResult;
import po.deliveryPO.ClientInfo;
import po.deliveryPO.GoodsInfo;
import ui.baseui.DetailPanel;
import ui.deliveryui.orderInfo.ClientInfoPanel;
import ui.deliveryui.orderInfo.GoodsInfoPanel;
import ui.deliveryui.orderInfo.OtherInfoPanel;
import vo.deliveryVO.OrderVO;
import vo.deliveryVO.VerifyMessage;

@SuppressWarnings("serial")
public class OrderInputPanel extends DetailPanel{
	
	private OrderBLService orderService = new OrderController();
	
	/**
	 * 承载所有信息的面板
	 */
	private JPanel infoPanel = new JPanel();
	
	/**
	 * 承载infoPanel的下拉框面板
	 */
	private JScrollPane container = new JScrollPane();

	private ClientInfoPanel sender = new ClientInfoPanel(ClientType.SENDER);
	
	private ClientInfoPanel receiver = new ClientInfoPanel(ClientType.RECEIVER);
	
	private GoodsInfoPanel goodsInfo = new GoodsInfoPanel();
	
	private OtherInfoPanel otherInfo = new OtherInfoPanel();
	
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
	private Map<LabelName, JLabel> labelList = new HashMap<LabelName, JLabel>();
	
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
		this.cancel.setVisible(false);
		//添加事件监听
		this.addListener();
		//将按钮添加到按钮面板
		this.buttonPanel.setLayout(null);
		this.buttonPanel.add(this.ok);
		this.buttonPanel.add(this.cancel);
		//状态信息
		this.state.setBounds(this.sender.getX(), this.buttonPanel.getY() - BUTTON_H, PANEL_W, BUTTON_W);
		this.state.setFont(WORD_FONT);
		//将信息面板加到主面板
		this.addPanels();
		//初始化标签列表
		this.initLabelList();
	}
	
	/**
	 * 返回展示订单信息的面板
	 */
	public JPanel OrderInfoView() {
		//创建面板
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(CONTAINER_W, CONTAINER_H - 72));
		//添加其他信息面板
		panel.add(this.sender);
		panel.add(this.receiver);
		panel.add(this.goodsInfo);
		panel.add(this.otherInfo);
		//设置信息为不可编辑
		this.disableComponents();
		return panel;
	}
	
	//设置面板信息
	public void setOrderInfo(ClientInfo sender, ClientInfo receiver,
			GoodsInfo goodsInfo) {
		this.sender.setClientInfo(sender.getName(), sender.getAddress(),
				sender.getCompany(), sender.getPhoneNumber(), sender.getMobileNumber());
		this.receiver.setClientInfo(receiver.getName(), receiver.getAddress(),
				receiver.getCompany(), receiver.getPhoneNumber(), receiver.getMobileNumber());
		this.goodsInfo.setGoodsInfo(goodsInfo.getNumber(), goodsInfo.getWeight(),
				goodsInfo.getSize(), goodsInfo.getName(), goodsInfo.getPrice());
		this.otherInfo.setOtherInfo(goodsInfo.getId(), goodsInfo.getDeliveryType(),
				goodsInfo.getPackageType(), goodsInfo.getDate(), goodsInfo.getTime());
	}
	
	private void initUI() {
		//信息面板
		this.infoPanel.setLayout(null);
		this.infoPanel.setPreferredSize(new Dimension(CONTAINER_W, CONTAINER_H));
		this.container.setBounds(0, 0, DETAIL_PANEL_W, DETAIL_PANEL_H);
		this.container.setViewportView(this.infoPanel);
		this.container.getVerticalScrollBar().setUnitIncrement(15);
		this.add(this.container);
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
				//设置取消按钮不可见
				cancel.setVisible(false);
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
		labelList.get(LabelName.PRICE).setForeground(Color.RED);
		goodsInfo.setPriceText(price + "元");
		//显示时间
		labelList.get(LabelName.TIME).setForeground(Color.RED);
		otherInfo.setTimeText(day + "天");
		//如果是第一次按确认，提示用户确认输入
		if(isFirstEnsure) {
			//设置状态为不是第一次点击确定
			isFirstEnsure = false;
			//询问用户是否确认保存
			showState("请再次确认信息，无误后按确定，否则按取消");
			//使取消按钮可见
			cancel.setVisible(true);
			
		}
		else {
			//记录收件信息
			boolean save = orderService.saveOrderInfo(orderVO);
			if(save) {		
				this.state.setForeground(Color.BLUE);
				this.state.setText("订单保存成功");
				//清空信息
				this.clearInfo();
			}else {	
				showState("订单存失败，请重试");
			}
			//使组件可编辑
			this.enableComponents();
			//设置状态为第一次点击确认按钮
			this.isFirstEnsure = true;
			//设置取消按钮不可见
			this.cancel.setVisible(false);
			//消除提示信息
			this.setLabelBlack();
		}
	}
	
	private void clearInfo() {
		//寄件人信息
		this.sender.clearInfo();
		//收件人信息
		this.receiver.clearInfo();
		//货物信息
		this.goodsInfo.clearInfo();
		//其他信息
		this.otherInfo.clearInfo();
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
				sender.getPhoneNumber(), sender.getMobilbeNumber(), sender.getCity());
		ClientInfo receiverInfo = new ClientInfo(ClientType.RECEIVER,
				receiver.getClientName(), receiver.getAddress(), receiver.getCompany(),
				receiver.getPhoneNumber(), receiver.getMobilbeNumber(), receiver.getCity());
		List<TransitionNode> node = new ArrayList<TransitionNode>();
		node.add(TransitionNode.SENDER_BUSINESS_HALL);
		List<City> city = new ArrayList<City>();
		city.add(sender.getCity());
		GoodsInfo goods = new GoodsInfo(goodsInfo.getNumber(), otherInfo.getID(), goodsInfo.getWeight(),
				goodsInfo.getGoodsName(), goodsInfo.getVolumn(), otherInfo.getPackageType(),
				otherInfo.getDeliveryType(), otherInfo.getDate(), node, city, otherInfo.getTime(),goodsInfo.getPrice());
		
		return new OrderVO(senderInfo, receiverInfo, goods);
	}
	
	private void initLabelList() {
		//寄件人标签
		this.labelList.put(LabelName.SENDER_NAME, this.sender.getNameLabel());
		this.labelList.put(LabelName.SENDER_ADDR, this.sender.getAddressLabel());
		this.labelList.put(LabelName.SENDER_MOBILE, this.sender.getMobileLabel());
		//收件人标签
		this.labelList.put(LabelName.RECEIVER_NAME, this.receiver.getNameLabel());
		this.labelList.put(LabelName.RECEIVER_ADDR, this.receiver.getAddressLabel());
		this.labelList.put(LabelName.RECEIVER_MOBILE, this.receiver.getMobileLabel());
		//物品信息标签
		this.labelList.put(LabelName.GOODS_NAME, this.goodsInfo.getNumLabel());
		this.labelList.put(LabelName.GOODS_WEIGHT, this.goodsInfo.getWeightLabel());
		this.labelList.put(LabelName.GOODS_VOLUMN, this.goodsInfo.getVolumeLabel());
		this.labelList.put(LabelName.GOODS_NAME, this.goodsInfo.getNameLabel());
		this.labelList.put(LabelName.PRICE, this.goodsInfo.getPriceLabel());
		//其他信息标签
		this.labelList.put(LabelName.GOODS_ID, this.otherInfo.getIdLabel());
		this.labelList.put(LabelName.GOODS_DATE, this.otherInfo.getDateLabel());
		this.labelList.put(LabelName.TIME, this.otherInfo.getTimeLabel());
	}
	
	private void addPanels() {
		this.infoPanel.add(this.sender);
		this.infoPanel.add(this.receiver);
		this.infoPanel.add(this.goodsInfo);
		this.infoPanel.add(this.otherInfo);
		this.infoPanel.add(this.buttonPanel);
		this.infoPanel.add(this.state);
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
		this.state.setForeground(Color.RED);
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
