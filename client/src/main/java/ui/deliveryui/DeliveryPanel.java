package ui.deliveryui;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import ui.baseui.LimpidButton;
import ui.baseui.TaskPanel;
import ui.baseui.UserImagePanel;
import ui.baseui.UserPanel;
import ui.mainui.LoginPanel;
import ui.viewcontroller.ViewController;

@SuppressWarnings("serial")
public class DeliveryPanel extends UserPanel{

	private LimpidButton orderInput = new LimpidButton("","picture/输入订单.png");

	private LimpidButton orderInquire = new LimpidButton("","picture/查询订单.png");

	private LimpidButton receipt = new LimpidButton("","picture/记录收件信息.png");
	
	private LimpidButton exit = new LimpidButton("","picture/退出.png");
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 17);
	
	private static Image head = new ImageIcon("picture/快递员.jpg").getImage();
	
	public DeliveryPanel(ViewController controller) {
		super(controller);
		//初始化组件
		initUI();
		//给按钮添加事件监听
		addListener();
	}
	
	private void initUI() {
		//输入订单按钮
		this.orderInput.setBounds(0, UserImagePanel.USER_PANEL_H, TaskPanel.BUTTON_W, TaskPanel.BUTTON_H);
		this.orderInput.setFont(WORD_FONT);
		//查询订单按钮
		this.orderInquire.setBounds(0, this.orderInput.getY() + TaskPanel.BUTTON_H + TaskPanel.BUTTON_GAP,
				TaskPanel.BUTTON_W, TaskPanel.BUTTON_H);
		this.orderInquire.setFont(WORD_FONT);
		//记录收件信息按钮
		this.receipt.setBounds(0, this.orderInquire.getY() + TaskPanel.BUTTON_H + TaskPanel.BUTTON_GAP, 
				TaskPanel.BUTTON_W, TaskPanel.BUTTON_H);
		this.receipt.setFont(WORD_FONT);
		//退出按钮
		this.exit.setBounds(0, this.receipt.getY() + TaskPanel.BUTTON_H + TaskPanel.BUTTON_GAP,
				TaskPanel.BUTTON_W, TaskPanel.BUTTON_H);
		this.exit.setFont(WORD_FONT);
		//面板添加按钮
		this.task.buttonContainer.add(orderInput);
		this.task.buttonContainer.add(orderInquire);
		this.task.buttonContainer.add(receipt);
		this.task.buttonContainer.add(exit);
		
		this.task.buttonContainer.setOpaque(false);
		this.task.user.setBackground(head);
	}
	
	private void addListener() {
		//订单输入按钮
		this.orderInput.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//设置当前细节信息面板为不可见
				detail.setVisible(false);
				//设置细节信息面板显示订单输入界面
				detail = new OrderInputPanel();
				//将细节信息面板添加到主面板
				add(detail);
				//将子组件重新布局和重绘
				revalidate();
			}
		});
		
		//订单查询按钮
		this.orderInquire.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//设置当前细节信息面板为不可见
				detail.setVisible(false);
				//设置细节信息面板显示订单查询界面
				detail = new OrderInquirePanel();
				//将细节信息面板添加到主面板
				add(detail);
				//将子组件重新布局
				revalidate();
			}
		});
		
		//纪录收件信息按钮
		this.receipt.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//设置当前细节信息面板为不可见
				detail.setVisible(false);
				//设置细节信息面板显示纪录收件信息界面
				detail = new ReceiptPanel();
				//将细节信息面板添加到主面板
				add(detail);
			}
		});
		
		//退出按钮
		this.exit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//设置面板不可见
				DeliveryPanel.this.setVisible(false);
				//跳转到登录画面
				viewController.switchView(LoginPanel.class.getName());
			}
		});
	}
}
