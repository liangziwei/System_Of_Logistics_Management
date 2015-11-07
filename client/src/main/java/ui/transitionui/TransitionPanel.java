package ui.transitionui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	private static final int BUTTON_WITH = TaskPanel.TASK_PANEL_W;

	private static final int BUTTON_HEIGHT = 32;

	private static final int BUTTON_GAP = 4;

	public TransitionPanel(ViewController viewController) {
		super(viewController);
		// TODO Auto-generated constructor stub
		initUI();
		addListenter();
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

		// 装运单添加按钮
		// this.AddLoading.setBounds(0, this.Loading.getY(), BUTTON_WITH+10,
		// BUTTON_HEIGHT);
		// this.AddLoading.setFont(WORD_FONT);
		// // 装运单修改按钮
		// this.ModifyLoading.setBounds(0, this.AddLoading.getY(),
		// BUTTON_WITH+10, BUTTON_HEIGHT);
		// this.ModifyLoading.setFont(WORD_FONT);
		// // 装运单查询按钮
		// this.FindLoading.setBounds(0, this.ModifyLoading.getY(),
		// BUTTON_WITH+10, BUTTON_HEIGHT);
		// this.FindLoading.setFont(WORD_FONT);

		// this.AddLoading.setVisible(false);
		// this.ModifyLoading.setVisible(false);
		// this.FindLoading.setVisible(false);

		this.task.buttonContainer.add(Loading);
		this.task.buttonContainer.add(Transferring);
		this.task.buttonContainer.add(Receiving);
		this.task.buttonContainer.add(exit);
		// this.task.add(AddLoading);
		// this.task.add(ModifyLoading);
		// this.task.add(FindLoading);
	}

	private void addListenter() {
		this.Loading.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				repaint();

				Loading.setLocation(0, UserImagePanel.USER_PANEL_H);
				// 装运单添加按钮
				AddLoading.setBounds(0, Loading.getY() + BUTTON_HEIGHT + BUTTON_GAP, BUTTON_WITH - 30, BUTTON_HEIGHT);
				AddLoading.setFont(WORD_FONT);
				// 装运单修改按钮
				ModifyLoading.setBounds(0, AddLoading.getY() + BUTTON_HEIGHT + BUTTON_GAP, BUTTON_WITH - 30,
						BUTTON_HEIGHT);
				ModifyLoading.setFont(WORD_FONT);
				// 装运单查询按钮
				FindLoading.setBounds(0, ModifyLoading.getY() + BUTTON_HEIGHT + BUTTON_GAP, BUTTON_WITH - 30,
						BUTTON_HEIGHT);
				FindLoading.setFont(WORD_FONT);

				task.add(AddLoading);
				task.add(ModifyLoading);
				task.add(FindLoading);

				AddLoading.setVisible(true);
				ModifyLoading.setVisible(true);
				FindLoading.setVisible(true);

				Transferring.setLocation(0, FindLoading.getY() + BUTTON_HEIGHT + BUTTON_GAP);
				Receiving.setLocation(0, Transferring.getY() + BUTTON_HEIGHT + BUTTON_GAP);
				exit.setLocation(0, Receiving.getY() + BUTTON_HEIGHT + BUTTON_GAP);

				repaint();
				// 将子组件重新布局和重绘
				// revalidate();
			}
		});

		this.Transferring.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				repaint();

				Loading.setLocation(0, UserImagePanel.USER_PANEL_H);
				Transferring.setLocation(0, Loading.getY() + BUTTON_HEIGHT + BUTTON_GAP);

				AddTransferring.setBounds(0, Transferring.getY() + BUTTON_HEIGHT + BUTTON_GAP, BUTTON_WITH - 30,
						BUTTON_HEIGHT);
				AddTransferring.setFont(WORD_FONT);
				// 装运单修改按钮
				ModifyTransferring.setBounds(0, AddTransferring.getY() + BUTTON_HEIGHT + BUTTON_GAP, BUTTON_WITH - 30,
						BUTTON_HEIGHT);
				ModifyTransferring.setFont(WORD_FONT);
				// 装运单查询按钮
				FindTransferring.setBounds(0, ModifyTransferring.getY() + BUTTON_HEIGHT + BUTTON_GAP, BUTTON_WITH - 30,
						BUTTON_HEIGHT);
				FindTransferring.setFont(WORD_FONT);

				SeeRepository.setBounds(0, FindTransferring.getY() + BUTTON_HEIGHT + BUTTON_GAP, BUTTON_WITH - 30,
						BUTTON_HEIGHT);
				SeeRepository.setFont(WORD_FONT);

				task.add(AddTransferring);
				task.add(ModifyTransferring);
				task.add(FindTransferring);
				task.add(SeeRepository);

				Receiving.setLocation(0, SeeRepository.getY() + BUTTON_HEIGHT + BUTTON_GAP);
				exit.setLocation(0, Receiving.getY() + BUTTON_HEIGHT + BUTTON_GAP);

				repaint();
			}
		});

		this.Receiving.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				repaint();
				Loading.setLocation(0, UserImagePanel.USER_PANEL_H);
				Transferring.setLocation(0, Loading.getY() + BUTTON_HEIGHT + BUTTON_GAP);
				Receiving.setLocation(0, Transferring.getY() + BUTTON_HEIGHT + BUTTON_GAP);

				AddReceiving.setBounds(0, Receiving.getY() + BUTTON_HEIGHT + BUTTON_GAP, BUTTON_WITH - 30,
						BUTTON_HEIGHT);
				AddReceiving.setFont(WORD_FONT);
				// 装运单修改按钮
				ModifyReceiving.setBounds(0, AddReceiving.getY() + BUTTON_HEIGHT + BUTTON_GAP, BUTTON_WITH - 30,
						BUTTON_HEIGHT);
				ModifyReceiving.setFont(WORD_FONT);
				// 装运单查询按钮
				FindReceiving.setBounds(0, ModifyReceiving.getY() + BUTTON_HEIGHT + BUTTON_GAP, BUTTON_WITH - 30,
						BUTTON_HEIGHT);
				FindReceiving.setFont(WORD_FONT);

				task.add(AddReceiving);
				task.add(ModifyReceiving);
				task.add(FindReceiving);

				exit.setLocation(0, FindReceiving.getY() + BUTTON_HEIGHT + BUTTON_GAP);
				repaint();
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
