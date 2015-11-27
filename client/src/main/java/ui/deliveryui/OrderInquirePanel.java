package ui.deliveryui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import businessLogic.businessLogicController.deliveryController.OrderController;
import businessLogicService.deliveryBLService.OrderBLService;
import constant.VerifyResult;
import ui.baseui.DetailPanel;
import vo.deliveryVO.OrderVO;
import vo.deliveryVO.VerifyMessage;

@SuppressWarnings("serial")
public class OrderInquirePanel extends DetailPanel{

	private OrderBLService orderService = new OrderController();
	
	private OrderInputPanel orderInput = new OrderInputPanel();
	
	/**
	 * 显示信息的容器
	 */
	private JScrollPane container = new JScrollPane();
	
	/**
	 * 显示订单信息
	 */
	private JPanel orderInfo = new JPanel();
	
	private JTextField search = new JTextField();

	private JLabel orderLabel = new JLabel("订单条形码号");

	private JButton inquire = new JButton("查询");

	private JButton cancel = new JButton("取消");
	
	private JLabel error = new JLabel();
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 15);
	
	private static final int LABEL_W = 100;
	
	private static final int LABEL_H = 40;
	
	private static final int TEXT_W = LABEL_W;
	
	private static final int TEXT_H = LABEL_H;
	
	private static final int BUTTON_W = 64;
	
	private static final int BUTTON_H = LABEL_H;
	
	/**
	 *组件与组件的距离 
	 */
	private static final int COMPONENT_GAP = (DetailPanel.DETAIL_PANEL_W - LABEL_W - TEXT_W - (BUTTON_W << 1)) / 5;
	
	private static final int ORDER_X = COMPONENT_GAP;
	
	private static final int ORDER_Y = COMPONENT_GAP;

	public OrderInquirePanel() {
		super();
		//订单条形码号标签
		this.orderLabel.setBounds(ORDER_X, ORDER_Y, LABEL_W, LABEL_H);
		this.orderLabel.setFont(WORD_FONT);
		//订单条形码号文本框
		this.search.setBounds(this.orderLabel.getX() + LABEL_W , this.orderLabel.getY(),
				TEXT_W + COMPONENT_GAP, TEXT_H);
		this.search.setFont(WORD_FONT);
		//确定按钮
		this.inquire.setBounds(this.search.getX() + TEXT_W + (COMPONENT_GAP << 1),
				this.search.getY(),
				BUTTON_W, BUTTON_H);
		this.inquire.setFont(WORD_FONT);
		//取消按钮
		this.cancel.setBounds(this.inquire.getX() + BUTTON_W + COMPONENT_GAP, this.inquire.getY(),
				BUTTON_W, BUTTON_H);
		this.cancel.setFont(WORD_FONT);
		//错误信息
		this.error.setBounds(this.search.getX(), this.search.getY() + (TEXT_H << 1), TEXT_W << 1, LABEL_H);
		this.error.setFont(WORD_FONT);
		this.error.setForeground(Color.RED);
		//添加事件监听
		this.addListener();
		//把组件添加到面板
		this.add(this.orderLabel);
		this.add(this.search);
		this.add(this.inquire);
		this.add(this.cancel);
		this.add(this.error);
		
		this.container.setBounds(0, orderLabel.getY() + (LABEL_H << 1),
				DETAIL_PANEL_W - 30, DETAIL_PANEL_H - (LABEL_H << 2));
		this.container.getVerticalScrollBar().setUnitIncrement(15);
		this.orderInfo = this.orderInput.OrderInfoView();
		this.orderInfo.setVisible(false);
		this.container.setViewportView(this.orderInfo);
		this.container.setVisible(false);
		this.add(this.container);
	}
	
	private void addListener() {
		//查询按钮
		this.inquire.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//验证订单条形码号是否合法
				VerifyMessage msg = orderService.verifyOrderId(search.getText());
				if(msg.getResult() == VerifyResult.FAIL) {
					orderLabel.setForeground(Color.RED);
					error.setText(msg.getErrorMsg());
					orderInfo.setVisible(false);
				}
				else {
					orderLabel.setForeground(Color.BLACK);
					error.setText("");
					//查询订单信息
					OrderVO order = orderService.getOrderInfoById(search.getText());
					//如果查找不到该订单
					if(order == null) {
						error.setText("该订单不存在");
						orderInfo.setVisible(false);
						repaint();
						return ;
					}
					orderInput.setOrderInfo(order.getSenderInfo(), order.getReceiverInfo(), order.getGoodsInfo());
					//显示订单信息
					orderInfo.setVisible(true);
					container.setVisible(true);
				}
				repaint();
			}
		});
		
		//取消按钮
		this.cancel.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//将当前细节信息面板设置为初始页面
				orderInfo.setVisible(false);
			}
		});
	}
	
	
}
