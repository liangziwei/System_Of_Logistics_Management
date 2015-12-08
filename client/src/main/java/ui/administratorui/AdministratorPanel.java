package ui.administratorui;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import ui.baseui.LimpidButton;
import ui.baseui.TaskButton;
import ui.baseui.TaskPanel;
import ui.baseui.UserImagePanel;
import ui.baseui.UserPanel;
import ui.mainui.LoginPanel;
import ui.viewcontroller.ViewController;

public class AdministratorPanel extends UserPanel{

	private LimpidButton addAdmin=new LimpidButton("","picture/添加账户.png");
	private LimpidButton deleAdmin=new LimpidButton("","picture/删除账户.png");
	private LimpidButton modAdmin=new LimpidButton("","picture/修改账户.png");
	private LimpidButton exit = new LimpidButton("","picture/退出.png");
	
	private Image head = new ImageIcon("picture/管理员.jpg").getImage();
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 17);
	
	public AdministratorPanel(ViewController viewController) {
		super(viewController);
		// TODO Auto-generated constructor stub
		//初始化组件
		initUI();
		//给按钮添加事件监听
		addListener();
	}

	private void initUI(){
		//添加账户
		this.addAdmin.setBounds(0, UserImagePanel.USER_PANEL_H, TaskPanel.BUTTON_W, TaskPanel.BUTTON_H);
		this.addAdmin.setFont(WORD_FONT);
//		this.addAdmin.setIcon(new ImageIcon("picture/添加账户.png"));
		//删除账户		
		this.deleAdmin.setBounds(0, this.addAdmin.getY() + TaskPanel.BUTTON_H + TaskPanel.BUTTON_GAP,
				TaskPanel.BUTTON_W, TaskPanel.BUTTON_H);
		this.deleAdmin.setFont(WORD_FONT);
//		this.deleAdmin.setIcon(new ImageIcon("picture/删除账户.png"));
		//修改账户
		this.modAdmin.setBounds(0, this.deleAdmin.getY() + TaskPanel.BUTTON_H + TaskPanel.BUTTON_GAP, 
				TaskPanel.BUTTON_W, TaskPanel.BUTTON_H);
		this.modAdmin.setFont(WORD_FONT);
//		this.modAdmin.setIcon(new ImageIcon("picture/修改账户.png"));
		//退出
		this.exit.setBounds(0, this.modAdmin.getY() + TaskPanel.BUTTON_H + TaskPanel.BUTTON_GAP, 
				TaskPanel.BUTTON_W, TaskPanel.BUTTON_H);
		this.exit.setFont(WORD_FONT);
//		this.exit.setIcon(new ImageIcon("picture/退出.png"));
		
		this.task.setLayout(null);
		this.task.add(addAdmin);
		this.task.add(deleAdmin);
		this.task.add(modAdmin);
		this.task.add(exit);
		
		this.task.user.setBackground(head);
	}
	
	private void addListener(){
		
		this.addAdmin.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//设置当前细节信息面板为不可见
				detail.setVisible(false);
				//设置细节信息面板显示订单输入界面
				detail = new AddAdminPanel();
				//将细节信息面板添加到主面板
				add(detail);
				//将子组件重新布局和重绘
				revalidate();
			}
		});
		
		this.deleAdmin.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//设置当前细节信息面板为不可见
				detail.setVisible(false);
				//设置细节信息面板显示订单输入界面
				detail = new DeleteAdminPanel();
				//将细节信息面板添加到主面板
				add(detail);
				//将子组件重新布局和重绘
				revalidate();
			}
		});

		this.modAdmin.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
				//设置当前细节信息面板为不可见
				detail.setVisible(false);
				//设置细节信息面板显示订单输入界面
				detail = new ModifyAdminPanel();
				//将细节信息面板添加到主面板
				add(detail);
				//将子组件重新布局和重绘
				revalidate();
			}
		});
		this.exit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//设置面板不可见
				AdministratorPanel.this.setVisible(false);
				//跳转到登录画面
				viewController.switchView(LoginPanel.class.getName());
			}
		});
	}
}
