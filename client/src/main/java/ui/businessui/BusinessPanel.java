package ui.businessui;

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
import ui.businessui.driverui.AddDriverPanel;
import ui.businessui.driverui.DeleteDriverPanel;
import ui.businessui.driverui.FindDriverPanel;
import ui.businessui.driverui.ModifyDriverPanel;
import ui.businessui.entruckingui.EntruckingPanel;
import ui.businessui.paymentui.PaymentPanel;
import ui.businessui.receiveandsendui.ArrivalPanel;
import ui.businessui.receiveandsendui.SendPanel;
import ui.businessui.vehicleui.AddVehiclePanel;
import ui.businessui.vehicleui.DeleteVehiclePanel;
import ui.businessui.vehicleui.FindVehiclePanel;
import ui.businessui.vehicleui.ModifyVehiclePanel;
import ui.mainui.LoginPanel;
import ui.viewcontroller.ViewController;

public class BusinessPanel extends UserPanel{

	private TaskButton entrucking=new TaskButton("新建装车单");
	private TaskButton receiveAndSend=new TaskButton("接收和派件");
	private TaskButton payment=new TaskButton("新建收款单");
	private TaskButton vehicle=new TaskButton("车辆信息管理");
	private TaskButton driver=new TaskButton("司机信息管理");
	private TaskButton exit = new TaskButton("退出");
	
	JButton receive=new JButton("新建到达单");
	JButton send=new JButton("新建派件单");		
	JButton addVehi=new JButton("添加车辆信息");
	JButton delVehi=new JButton("删除车辆信息");
	JButton modVehi=new JButton("修改车辆信息");
	JButton findVehi=new JButton("查询车辆信息");
	JButton addDriv=new JButton("添加司机信息");
	JButton delDriv=new JButton("删除司机信息");
	JButton modDriv=new JButton("修改司机信息");
	JButton findDriv=new JButton("查询司机信息");
	
	List<TaskButton> receAndSendButtonList=new ArrayList<TaskButton>();
	List<TaskButton> vehiButtonList1=new ArrayList<TaskButton>();
	List<TaskButton> drivButtonList2=new ArrayList<TaskButton>();
	List<JButton> receAndSendList=new ArrayList<JButton>();
	List<JButton> vehicleList=new ArrayList<JButton>();
	List<JButton> driverList=new ArrayList<JButton>();
	
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
		
		this.receive.setFont(WORD_FONT);
		this.send.setFont(WORD_FONT);
		this.addVehi.setFont(WORD_FONT);
		this.delVehi.setFont(WORD_FONT);
		this.modVehi.setFont(WORD_FONT);
		this.findVehi.setFont(WORD_FONT);
		this.addDriv.setFont(WORD_FONT);
		this.delDriv.setFont(WORD_FONT);
		this.modDriv.setFont(WORD_FONT);
		this.findDriv.setFont(WORD_FONT);
		
		
		this.receAndSendList.add(receive);
		this.receAndSendList.add(send);
		
		this.vehicleList.add(addVehi);
		this.vehicleList.add(delVehi);
		this.vehicleList.add(modVehi);
		this.vehicleList.add(findVehi);

		this.driverList.add(addDriv);
		this.driverList.add(delDriv);
		this.driverList.add(modDriv);
		this.driverList.add(findDriv);
		
		this.receiveAndSend.setDetailButtons(receAndSendList);
		this.vehicle.setDetailButtons(vehicleList);
		this.driver.setDetailButtons(driverList);
		
		this.receAndSendButtonList.add(payment);
		this.receAndSendButtonList.add(vehicle);
		this.receAndSendButtonList.add(driver);
		this.receAndSendButtonList.add(exit);
		
		this.vehiButtonList1.add(driver);
		this.vehiButtonList1.add(exit);
		
		this.drivButtonList2.add(exit);
		
//		this.task.setLayout(null);
		this.task.buttonContainer.add(entrucking);
		this.task.buttonContainer.add(receiveAndSend);
		this.task.buttonContainer.add(payment);
		this.task.buttonContainer.add(vehicle);
		this.task.buttonContainer.add(driver);
		
		this.task.buttonContainer.add(exit);
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
//				detail.setVisible(false);
				task.resetTaskButtons(receiveAndSend, receAndSendButtonList);
			}
		});
		
		this.vehicle.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				detail.setVisible(false);
				task.resetTaskButtons(vehicle, vehiButtonList1);
			}
		});
		
		this.driver.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				task.resetTaskButtons(driver,drivButtonList2);
				
			}
		});
		
		this.receive.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				detail.setVisible(false);
				//设置细节信息面板显示订单查询界面
				detail = new ArrivalPanel();
				//将细节信息面板添加到主面板
				add(detail);
				//将子组件重新布局
				revalidate();
			}
			
		});
		
		this.send.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				detail.setVisible(false);
				//设置细节信息面板显示订单查询界面
				detail = new SendPanel();
				//将细节信息面板添加到主面板
				add(detail);
				//将子组件重新布局
				revalidate();
			}
			
		});
		
		this.addVehi.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				detail.setVisible(false);
				//设置细节信息面板显示订单查询界面
				detail = new AddVehiclePanel();
				//将细节信息面板添加到主面板
				add(detail);
				//将子组件重新布局
				revalidate();
			}
			
		});
		
		this.findVehi.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				detail.setVisible(false);
				//设置细节信息面板显示订单查询界面
				detail = new FindVehiclePanel();
				//将细节信息面板添加到主面板
				add(detail);
				//将子组件重新布局
				revalidate();
			}
			
		});
		
		this.delVehi.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				detail.setVisible(false);
				//设置细节信息面板显示订单查询界面
				detail = new DeleteVehiclePanel();
				//将细节信息面板添加到主面板
				add(detail);
				//将子组件重新布局
				revalidate();
			}
			
		});
		
		this.modVehi.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				detail.setVisible(false);
				//设置细节信息面板显示订单查询界面
				detail = new ModifyVehiclePanel();
				//将细节信息面板添加到主面板
				add(detail);
				//将子组件重新布局
				revalidate();
			}
			
		});
		
		this.addDriv.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				detail.setVisible(false);
				//设置细节信息面板显示订单查询界面
				detail = new AddDriverPanel();
				//将细节信息面板添加到主面板
				add(detail);
				//将子组件重新布局
				revalidate();
			}
			
		});
		
		this.findDriv.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				detail.setVisible(false);
				//设置细节信息面板显示订单查询界面
				detail = new FindDriverPanel();
				//将细节信息面板添加到主面板
				add(detail);
				//将子组件重新布局
				revalidate();
			}
			
		});
		
		this.delDriv.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				detail.setVisible(false);
				//设置细节信息面板显示订单查询界面
				detail = new DeleteDriverPanel();
				//将细节信息面板添加到主面板
				add(detail);
				//将子组件重新布局
				revalidate();
			}
			
		});
		this.modDriv.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				detail.setVisible(false);
				//设置细节信息面板显示订单查询界面
				detail = new ModifyDriverPanel();
				//将细节信息面板添加到主面板
				add(detail);
				//将子组件重新布局
				revalidate();
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
