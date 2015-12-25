package ui.businessui;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import ui.baseui.LimpidButton;
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

@SuppressWarnings("serial")
public class BusinessPanel extends UserPanel{

	private LimpidButton entrucking=new LimpidButton("","picture/新建装车单.png");
	private TaskButton receiveAndSend=new TaskButton("","picture/接收与派件.png");
	private TaskButton payment=new TaskButton("","picture/新建收款单.png");
	private TaskButton vehicle=new TaskButton("","picture/车辆信息管理.png");
	private TaskButton driver=new TaskButton("","picture/司机信息管理.png");
	private TaskButton exit = new TaskButton("","picture/退出.png");
	
	LimpidButton receive=new LimpidButton("","picture/新建到达单.png");
	LimpidButton send=new LimpidButton("","picture/新建派件单.png");		
	LimpidButton addVehi=new LimpidButton("","picture/添加车辆信息.png");
	LimpidButton delVehi=new LimpidButton("","picture/删除车辆信息.png");
	LimpidButton modVehi=new LimpidButton("","picture/修改车辆信息.png");
	LimpidButton findVehi=new LimpidButton("","picture/查询车辆信息.png");
	LimpidButton addDriv=new LimpidButton("","picture/添加司机信息.png");
	LimpidButton delDriv=new LimpidButton("","picture/删除司机信息.png");
	LimpidButton modDriv=new LimpidButton("","picture/修改司机信息.png");
	LimpidButton findDriv=new LimpidButton("","picture/查询司机信息.png");
	
	List<TaskButton> receAndSendButtonList=new ArrayList<TaskButton>();
	List<TaskButton> vehiButtonList1=new ArrayList<TaskButton>();
	List<TaskButton> drivButtonList2=new ArrayList<TaskButton>();
	List<LimpidButton> receAndSendList=new ArrayList<LimpidButton>();
	List<LimpidButton> vehicleList=new ArrayList<LimpidButton>();
	List<LimpidButton> driverList=new ArrayList<LimpidButton>();
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 17);
	
	private static Image head = new ImageIcon("picture/营业厅业务员.jpg").getImage();
	
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
		this.task.user.repaint();
		this.task.user.setBackground(head);
		this.task.buttonContainer.add(entrucking);
		this.task.buttonContainer.add(receiveAndSend);
		this.task.buttonContainer.add(payment);
		this.task.buttonContainer.add(vehicle);
		this.task.buttonContainer.add(driver);
		
		this.task.buttonContainer.add(exit);
		
		this.task.buttonContainer.setOpaque(false);
		
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
//				detail.setVisible(false);
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
