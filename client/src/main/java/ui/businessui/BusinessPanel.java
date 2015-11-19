package ui.businessui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import ui.baseui.TaskButton;
import ui.baseui.TaskPanel;
import ui.baseui.UserImagePanel;
import ui.baseui.UserPanel;
import ui.businessui.entruckingui.EntruckingPanel;
import ui.businessui.paymentui.PaymentPanel;
import ui.businessui.receiveandsendui.ReceiveAndSendPanel;
import ui.mainui.LoginPanel;
import ui.viewcontroller.ViewController;

public class BusinessPanel extends UserPanel{

	private TaskButton entrucking=new TaskButton("新建装车单");
	private TaskButton receiveAndSend=new TaskButton("接收和派件");
	private TaskButton payment=new TaskButton("新建收款单");
	private TaskButton vehicle=new TaskButton("车辆信息管理");
	private TaskButton driver=new TaskButton("司机信息管理");
	private TaskButton exit = new TaskButton("退出");
	
	JButton addVehi=new JButton("添加车辆信息");
	JButton delVehi=new JButton("删除车辆信息");
	JButton modVehi=new JButton("修改车辆信息");
	JButton findVehi=new JButton("查询车辆信息");
	JButton addDriv=new JButton("添加司机信息");
	JButton delDriv=new JButton("删除司机信息");
	JButton modDriv=new JButton("修改司机信息");
	JButton findDriv=new JButton("查询司机信息");
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 17);
	
	public BusinessPanel(ViewController viewController) {
		super(viewController);
		// TODO Auto-generated constructor stub
		//初始化组件
		initUI();
		//给按钮添加事件监听
		addListener();
	}
    
	private void initUI(){
		this.entrucking.setBounds(0, UserImagePanel.USER_PANEL_H, TaskPanel.BUTTON_W, TaskPanel.BUTTON_H);
		this.entrucking.setFont(WORD_FONT);
		this.receiveAndSend.setBounds(0, this.entrucking.getY() + TaskPanel.BUTTON_H + TaskPanel.BUTTON_GAP,
				TaskPanel.BUTTON_W, TaskPanel.BUTTON_H);
		this.receiveAndSend.setFont(WORD_FONT);
		this.payment.setBounds(0, this.receiveAndSend.getY() + TaskPanel.BUTTON_H + TaskPanel.BUTTON_GAP, 
				TaskPanel.BUTTON_W, TaskPanel.BUTTON_H);
		this.payment.setFont(WORD_FONT);
		this.vehicle.setBounds(0, this.payment.getY() + TaskPanel.BUTTON_H + TaskPanel.BUTTON_GAP, 
				TaskPanel.BUTTON_W, TaskPanel.BUTTON_H);
		this.vehicle.setFont(WORD_FONT);
		this.driver.setBounds(0, this.vehicle.getY() + TaskPanel.BUTTON_H + TaskPanel.BUTTON_GAP, 
				TaskPanel.BUTTON_W, TaskPanel.BUTTON_H);
		this.driver.setFont(WORD_FONT);
		
		this.exit.setBounds(0, this.driver.getY() + TaskPanel.BUTTON_H + TaskPanel.BUTTON_GAP, 
				TaskPanel.BUTTON_W, TaskPanel.BUTTON_H);
		this.exit.setFont(WORD_FONT);
		
		
		this.task.setLayout(null);
		this.task.add(entrucking);
		this.task.add(receiveAndSend);
		this.task.add(payment);
		this.task.add(vehicle);
		this.task.add(driver);
		this.task.add(exit);
	}
	
	private void addListener(){
		this.entrucking.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//设置当前细节信息面板为不可见
				detail.setVisible(false);
				//设置细节信息面板显示订单输入界面
				detail = new EntruckingPanel();
				//将细节信息面板添加到主面板
				add(detail);
				//将子组件重新布局和重绘
				revalidate();
			}
		});
		
		//订单查询按钮
		this.payment.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//设置当前细节信息面板为不可见
				detail.setVisible(false);
				//设置细节信息面板显示订单查询界面
				detail = new PaymentPanel();
				//将细节信息面板添加到主面板
				add(detail);
				//将子组件重新布局
				revalidate();
			}
		});
		
		//纪录收件信息按钮
		this.receiveAndSend.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//设置当前细节信息面板为不可见
				detail.setVisible(false);
				//设置细节信息面板显示纪录收件信息界面
				detail = new ReceiveAndSendPanel();
				//将细节信息面板添加到主面板
				add(detail);
			}
		});
		
		//退出按钮
		this.exit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//设置面板不可见
				BusinessPanel.this.setVisible(false);
				//跳转到登录画面
				viewController.switchView(LoginPanel.class.getName());
			}
		});
		
		
	}
}
