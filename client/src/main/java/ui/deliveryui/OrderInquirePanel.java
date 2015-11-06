package ui.deliveryui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import businessLogicService.deliveryBLService.OrderBLService;
import stub.businessLogicImpl_stub.deliveryBLImpl_stub.OrderBLImpl_Stub;
import ui.baseui.DetailPanel;

@SuppressWarnings("serial")
public class OrderInquirePanel extends DetailPanel{

	private OrderBLService orderService = new OrderBLImpl_Stub();
	
	private JTextField search = new JTextField();

	private JLabel orderLabel = new JLabel("订单条形码号");

	private JButton inquire = new JButton("查询");

	private JButton cancel = new JButton("取消");
	
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
		//添加事件监听
		this.addListener();
		//把组件添加到面板
		this.container.add(this.orderLabel);
		this.container.add(this.search);
		this.container.add(this.inquire);
		this.container.add(this.cancel);
	}
	
	private void addListener() {
		//查询按钮
		this.inquire.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//检查订单条形码号是否为10位数字
				
			}
		});
		
		//取消按钮
		this.cancel.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//TODO 将当前细节信息面板设置为初始页面
				search.setVisible(false);
				orderLabel.setVisible(false);
				inquire.setVisible(false);
				cancel.setVisible(false);
			}
		});
	}
}
