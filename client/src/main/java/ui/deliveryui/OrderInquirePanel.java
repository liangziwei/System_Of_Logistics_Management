package ui.deliveryui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import businessLogic.businessLogicController.deliveryController.OrderController;
import businessLogicService.deliveryBLService.OrderBLService;
import constant.VerifyResult;
import ui.baseui.DetailPanel;
import ui.baseui.LimpidButton;
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

	private LimpidButton inquire = new LimpidButton("","picture/查询.png");

	private LimpidButton cancel = new LimpidButton("","picture/取消.png");
	
	private JLabel error = new JLabel();
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 15);
	
	private static Image BACKGROUND = new ImageIcon("picture/订单查询.jpg").getImage();
	
	private static final int LABEL_W = 100;
	
	private static final int LABEL_H = 30;
	
	private static final int TEXT_W = LABEL_W;
	
	private static final int TEXT_H = LABEL_H;
	
	private static final int BUTTON_W = 80;
	
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
		this.search.setOpaque(false);
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
		this.container.setVisible(false);
		this.container.setOpaque(false);
		this.container.getViewport().setOpaque(false);
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
					orderInfo = orderInput.OrderInfoView();
					//显示订单信息
					container.setVisible(true);
					container.setViewportView(orderInfo);
				}
				repaint();
			}
		});
		
		//取消按钮
		this.cancel.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//将当前细节信息面板设置为初始页面
				container.setVisible(false);
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(BACKGROUND, 0, orderLabel.getY() + (LABEL_H << 1),
				DETAIL_PANEL_W - 30, DETAIL_PANEL_H - (LABEL_H << 2), null);
	}

}
