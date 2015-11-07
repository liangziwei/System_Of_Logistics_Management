package ui.deliveryui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import ui.baseui.TaskButton;
import ui.baseui.TaskPanel;
import ui.baseui.UserImagePanel;
import ui.baseui.UserPanel;
import ui.mainui.LoginPanel;
import ui.viewcontroller.ViewController;

@SuppressWarnings("serial")
public class DeliveryPanel extends UserPanel{

	private TaskButton orderInput = new TaskButton("输入订单");

	private TaskButton orderInquire = new TaskButton("查询订单");

	private TaskButton receipt = new TaskButton("记录收件信息");
	
	private TaskButton exit = new TaskButton("退出");
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 17);
	
	public DeliveryPanel(ViewController controller) {
		super(controller);
		initUI();
		addListener();
		
		List<JButton> d = new ArrayList<JButton>();
		d.add(new JButton("haha"));
		d.add(new JButton("hehe"));
		d.add(new JButton("heihei"));
		d.add(new JButton("huohuo"));
		d.add(new JButton("2333"));
		d.add(new JButton("haha"));
		orderInput.setDetailButtons(d);
		
		List<JButton> d1 = new ArrayList<JButton>();
		d1.add(new JButton("haha"));
		d1.add(new JButton("hehe"));
		d1.add(new JButton("heihei"));
		d1.add(new JButton("huohuo"));
		d1.add(new JButton("2333"));
		d1.add(new JButton("haha"));
		orderInquire.setDetailButtons(d1);
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
	}
	
	private void addListener() {
		//订单输入按钮
		this.orderInput.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
//				//设置当前细节信息面板为不可见
//				detail.setVisible(false);
//				//设置细节信息面板显示订单输入界面
//				detail = new OrderInputPanel();
//				//将细节信息面板添加到主面板
//				add(detail);
//				//将子组件重新布局和重绘
//				revalidate();
				
				
				List<TaskButton> b = new ArrayList<TaskButton>();
				b.add(orderInquire);
				b.add(receipt);
				b.add(exit);
				if(!orderInput.isUnfold()) {
					orderInput.setUnfold(true);
					task.showTaskDetail(orderInput, b);
				}else {
					orderInput.setUnfold(false);
					task.hideTaskDetail(orderInput, b);
				}
			}
		});
		
		//订单查询按钮
		this.orderInquire.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
//				//设置当前细节信息面板为不可见
//				detail.setVisible(false);
//				//设置细节信息面板显示订单查询界面
//				detail = new OrderInquirePanel();
//				//将细节信息面板添加到主面板
//				add(detail);
//				//将子组件重新布局
//				revalidate();
				
				List<TaskButton> b = new ArrayList<TaskButton>();
				b.add(receipt);
				b.add(exit);
				if(!orderInquire.isUnfold()) {
					orderInquire.setUnfold(true);
					task.showTaskDetail(orderInquire, b);
				}else {
					orderInquire.setUnfold(false);
					task.hideTaskDetail(orderInquire, b);
				}
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
