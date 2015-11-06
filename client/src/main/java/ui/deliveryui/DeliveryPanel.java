package ui.deliveryui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import ui.baseui.TaskPanel;
import ui.baseui.UserImagePanel;
import ui.baseui.UserPanel;
import ui.mainui.LoginPanel;
import ui.viewcontroller.ViewController;

@SuppressWarnings("serial")
public class DeliveryPanel extends UserPanel{

	private JButton orderInput = new JButton("输入订单");

	private JButton orderInquire = new JButton("查询订单");

	private JButton receipt = new JButton("记录收件信息");
	
	private JButton exit = new JButton("退出");
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 17);
	
	private static final int BUTTON_WITH = TaskPanel.TASK_PANEL_W;
	
	private static final int BUTTON_HEIGHT = 32;
	
	private static final int BUTTON_GAP = 4;
	
	public DeliveryPanel(ViewController controller) {
		super(controller);
		initUI();
		addListener();
	}
	
	private void initUI() {
		//输入订单按钮
		this.orderInput.setBounds(0, UserImagePanel.USER_PANEL_H, BUTTON_WITH, BUTTON_HEIGHT);
		this.orderInput.setFont(WORD_FONT);
		//查询订单按钮
		this.orderInquire.setBounds(0, this.orderInput.getY() + BUTTON_HEIGHT + BUTTON_GAP,
				BUTTON_WITH, BUTTON_HEIGHT);
		this.orderInquire.setFont(WORD_FONT);
		//记录收件信息按钮
		this.receipt.setBounds(0, this.orderInquire.getY() + BUTTON_HEIGHT + BUTTON_GAP, 
				BUTTON_WITH, BUTTON_HEIGHT);
		this.receipt.setFont(WORD_FONT);
		//退出按钮
		this.exit.setBounds(0, this.receipt.getY() + BUTTON_HEIGHT + BUTTON_GAP,
				BUTTON_WITH, BUTTON_HEIGHT);
		this.exit.setFont(WORD_FONT);
		//面板添加按钮
		this.task.add(orderInput);
		this.task.add(orderInquire);
		this.task.add(receipt);
		this.task.add(exit);
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
				//设置面板
				DeliveryPanel.this.setVisible(false);
				//跳转到登录画面
				viewController.switchView(LoginPanel.class.getName());
			}
		});
	}
}
