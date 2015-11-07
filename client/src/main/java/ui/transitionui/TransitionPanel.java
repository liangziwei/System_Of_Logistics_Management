package ui.transitionui;

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

public class TransitionPanel extends UserPanel {

	private TaskButton Loading = new TaskButton("装运货物管理");

	private JButton AddLoading = new JButton("添加装运单");

	private JButton ModifyLoading = new JButton("修改装运单");

	private JButton FindLoading = new JButton("查询装运单");

	private TaskButton Transferring = new TaskButton("中转货物管理");

	private JButton AddTransferring = new JButton("添加中转单");

	private JButton ModifyTransferring = new JButton("修改中转单");

	private JButton FindTransferring = new JButton("查询中转单");

	private JButton SeeRepository = new JButton("查看库存信息");

	private TaskButton Receiving = new TaskButton("接受货物管理");

	private JButton AddReceiving = new JButton("添加接收单");

	private JButton ModifyReceiving = new JButton("修改接收单");

	private JButton FindReceiving = new JButton("查找接收单");

	private TaskButton exit = new TaskButton("退出");

	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 17);
	
	private List<JButton> DetailButtonLoading = new ArrayList<JButton>();
	
	private List<JButton> DetailButtonTransferring = new ArrayList<JButton>();
	
	private List<JButton> DetailButtonReceiving = new ArrayList<JButton>();
	
	private static final int BUTTON_WITH = TaskPanel.TASK_PANEL_W;

	private static final int BUTTON_HEIGHT = 32;

	private static final int BUTTON_GAP = 4;

	public TransitionPanel(ViewController viewController) {
		super(viewController);
		// TODO Auto-generated constructor stub
		initUI();
		addListenter();
		
		DetailButtonLoading.add(AddLoading);
		DetailButtonLoading.add(ModifyLoading);
		DetailButtonLoading.add(FindLoading);
		//要展开的按钮
		Loading.setDetailButtons(DetailButtonLoading);    //设置（添加）要展开的按钮
		
		DetailButtonReceiving.add(AddReceiving);
		DetailButtonReceiving.add(ModifyReceiving);
		DetailButtonReceiving.add(FindReceiving);
		//要展开的按钮
		Receiving.setDetailButtons(DetailButtonReceiving);    //设置（添加）要展开的按钮
		
		DetailButtonTransferring.add(AddTransferring);
		DetailButtonTransferring.add(ModifyTransferring);
		DetailButtonTransferring.add(FindTransferring);
		DetailButtonTransferring.add(SeeRepository);
		//要展开的按钮
		Transferring.setDetailButtons(DetailButtonTransferring);    //设置（添加）要展开的按钮
	}

	/**
	 * 
	 */
	private void initUI() {
		// 装运信息管理按钮
		this.Loading.setBounds(0, UserImagePanel.USER_PANEL_H, BUTTON_WITH, BUTTON_HEIGHT);
		this.Loading.setFont(WORD_FONT);
		// 中转信息管理按钮
		this.Transferring.setBounds(0, this.Loading.getY() + BUTTON_HEIGHT + BUTTON_GAP, BUTTON_WITH, BUTTON_HEIGHT);
		this.Transferring.setFont(WORD_FONT);
		// 接收信息管理按钮
		this.Receiving.setBounds(0, this.Transferring.getY() + BUTTON_HEIGHT + BUTTON_GAP, BUTTON_WITH, BUTTON_HEIGHT);
		this.Receiving.setFont(WORD_FONT);
		// 退出按钮
		this.exit.setBounds(0, this.Receiving.getY() + BUTTON_HEIGHT + BUTTON_GAP, BUTTON_WITH, BUTTON_HEIGHT);
		this.exit.setFont(WORD_FONT);
		// 面板添加按钮

		this.task.buttonContainer.add(Loading);
		this.task.buttonContainer.add(Transferring);
		this.task.buttonContainer.add(Receiving);
		this.task.buttonContainer.add(exit);

	}

	private void addListenter() {
		this.Loading.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//添加要展开按钮的下面的按钮
				List<TaskButton> BelowButton = new ArrayList<TaskButton>();
				BelowButton.add(Transferring);
				BelowButton.add(Receiving);
				BelowButton.add(exit);
				if(!Loading.isUnfold()) {
					task.showTaskDetail(Loading, BelowButton);
					Loading.setUnfold(true);
				}else {
					task.hideTaskDetail(Loading, BelowButton);
					Loading.setUnfold(false);
				}
//				repaint();
				// 将子组件重新布局和重绘
				// revalidate();
			}
		});

		this.Transferring.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//添加要展开按钮的下面的按钮
				List<TaskButton> BelowButton = new ArrayList<TaskButton>();
//				BelowButton.add(Transferring);
				BelowButton.add(Receiving);
				BelowButton.add(exit);
				if(!Transferring.isUnfold()) {
					task.showTaskDetail(Transferring, BelowButton);
					Transferring.setUnfold(true);
				}else {
					task.hideTaskDetail(Transferring, BelowButton);
					Transferring.setUnfold(false);
				}
			}
		});

		this.Receiving.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//添加要展开按钮的下面的按钮
				List<TaskButton> BelowButton = new ArrayList<TaskButton>();
				BelowButton.add(exit);
				if(!Receiving.isUnfold()) {
					task.showTaskDetail(Receiving, BelowButton);
					Receiving.setUnfold(true);
				}else {
					task.hideTaskDetail(Receiving, BelowButton);
					Receiving.setUnfold(false);
				}
			}
		});
		
		this.exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//设置面板
				TransitionPanel.this.setVisible(false);
				//跳转到登录画面
				viewController.switchView(LoginPanel.class.getName());
			}
		});
		//添加装运单的监听
		this.AddLoading.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		//修改装运单的监听
		this.ModifyLoading.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		//查询装运单的监听
		//添加中转单的监听
		//修改中转单的监听
		//查询中转单的监听
		//库存信息查询的监听
		//添加接收单的监听
		//修改接收单的监听
		//查询接收单的监听
	}
}
