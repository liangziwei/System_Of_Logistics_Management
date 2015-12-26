package ui.transitionui;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import ui.baseui.LimpidButton;
import ui.baseui.TaskButton;
import ui.baseui.TaskPanel;
import ui.baseui.UserImagePanel;
import ui.baseui.UserPanel;
import ui.mainui.LoginPanel;
import ui.transitionui.loadingui.AddLoadingPanel;
import ui.transitionui.loadingui.FindLoadingPanel;
import ui.transitionui.loadingui.ModifyLoadingPanel;
import ui.transitionui.receivingui.AddReceivingPanel;
import ui.transitionui.receivingui.FindReceivingPanel;
import ui.transitionui.receivingui.ModifyReceivingPanel;
import ui.transitionui.transferringui.AddTransferringPanel;
import ui.transitionui.transferringui.FindTransferringPanel;
import ui.transitionui.transferringui.ModifyTransferringPanel;
import ui.transitionui.transferringui.SeeRepositoryPanel;
import ui.viewcontroller.ViewController;

public class TransitionPanel extends UserPanel {

	private TaskButton Loading = new TaskButton("","picture/装运货物管理.png");
	
	private LimpidButton AddLoading = new LimpidButton("","picture/添加装运单.png");

	private LimpidButton ModifyLoading = new LimpidButton("","picture/修改装运单.png");

	private LimpidButton FindLoading = new LimpidButton("","picture/查询装运单.png");

	private TaskButton Transferring = new TaskButton("","picture/中转货物管理.png");
	
	private LimpidButton AddTransferring = new LimpidButton("","picture/添加中转单.png");

	private LimpidButton ModifyTransferring = new LimpidButton("","picture/修改中转单.png");

	private LimpidButton FindTransferring = new LimpidButton("","picture/查询中转单.png");

	private LimpidButton SeeRepository = new LimpidButton("","picture/查看库存信息.png");
	
	private TaskButton Receiving = new TaskButton("","picture/接收货物管理.png");

	private LimpidButton AddReceiving = new LimpidButton("","picture/添加接收单.png");

	private LimpidButton ModifyReceiving = new LimpidButton("","picture/修改接收单.png");

	private LimpidButton FindReceiving = new LimpidButton("","picture/查询接收单.png");

	private TaskButton exit = new TaskButton("","picture/退出.png");
	
	private Image head = new ImageIcon("picture/head/中转中心业务员.png").getImage();

	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 17);
	
	private List<LimpidButton> DetailButtonLoading = new ArrayList<LimpidButton>();
	
	private List<LimpidButton> DetailButtonTransferring = new ArrayList<LimpidButton>();
	
	private List<LimpidButton> DetailButtonReceiving = new ArrayList<LimpidButton>();
	
	private static final int BUTTON_WITH = TaskPanel.BUTTON_W;

	private static final int BUTTON_HEIGHT = 32;

	private static final int BUTTON_GAP = 4;

	public TransitionPanel(ViewController viewController) {
		super(viewController);
		// TODO Auto-generated constructor stub
		initUI();
		addListenter();
		//装运货物管理
		DetailButtonLoading.add(AddLoading);
		DetailButtonLoading.add(ModifyLoading);
		DetailButtonLoading.add(FindLoading);
		//要展开的按钮
		Loading.setDetailButtons(DetailButtonLoading);    //设置（添加）要展开的按钮
		
		//接收货物管理
		DetailButtonReceiving.add(AddReceiving);
		DetailButtonReceiving.add(ModifyReceiving);
		DetailButtonReceiving.add(FindReceiving);
		//要展开的按钮
		Receiving.setDetailButtons(DetailButtonReceiving);    //设置（添加）要展开的按钮
		
		//中转货物管理
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
		
		// 中转信息管理按钮
		this.Transferring.setBounds(0, this.Loading.getY() + BUTTON_HEIGHT + BUTTON_GAP, BUTTON_WITH, BUTTON_HEIGHT);
		
		// 接收信息管理按钮
		this.Receiving.setBounds(0, this.Transferring.getY() + BUTTON_HEIGHT + BUTTON_GAP, BUTTON_WITH, BUTTON_HEIGHT);
	
		// 退出按钮
		this.exit.setBounds(0, this.Receiving.getY() + BUTTON_HEIGHT + BUTTON_GAP, BUTTON_WITH, BUTTON_HEIGHT);

		// 面板添加按钮

		this.task.buttonContainer.add(Loading);
		this.task.buttonContainer.add(Transferring);
		this.task.buttonContainer.add(Receiving);
		this.task.buttonContainer.add(exit);
		this.task.buttonContainer.setOpaque(false);
		
		this.task.user.setBackground(head);
	}

	private void addListenter() {
		//装运单管理监听
		this.Loading.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//添加要展开按钮的下面的按钮
				List<TaskButton> BelowButton = new ArrayList<TaskButton>();
				BelowButton.add(Transferring);
				BelowButton.add(Receiving);
				BelowButton.add(exit);
				
				task.resetTaskButtons(Loading, BelowButton);
//				repaint();
				// 将子组件重新布局和重绘
				// revalidate();
			}
		});

		this.Transferring.addActionListener(new ActionListener() {
			//中转单管理监听
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//添加要展开按钮的下面的按钮
				List<TaskButton> BelowButton = new ArrayList<TaskButton>();
//				BelowButton.add(Transferring);
				BelowButton.add(Receiving);
				BelowButton.add(exit);
				task.resetTaskButtons(Transferring, BelowButton);
			}
		});

		this.Receiving.addActionListener(new ActionListener() {
			//接收单管理监听
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//添加要展开按钮的下面的按钮
				List<TaskButton> BelowButton = new ArrayList<TaskButton>();
				BelowButton.add(exit);
				task.resetTaskButtons(Receiving, BelowButton);
			}
		});
		
		this.exit.addActionListener(new ActionListener() {
			//退出监听
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
				//设置当前的细节信息面板不可见
				detail.setVisible(false);
				//设置细节信息面板为将要显示的的界面
				detail = new AddLoadingPanel();
				//将细节信息添加到主面板
				add(detail);
				//重新布局
				revalidate();
				repaint();
			}
		});
		
		//修改装运单的监听
		this.ModifyLoading.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//设置当前的细节信息面板不可见
				detail.setVisible(false);
				//设置细节信息面板为将要显示的的界面
				detail = new ModifyLoadingPanel();
				//将细节信息添加到主面板
				add(detail);
				//重新布局
				revalidate();
			}
		});
		//查询装运单的监听
		this.FindLoading.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//设置当前的细节信息面板不可见
				detail.setVisible(false);
				//设置细节信息面板为将要显示的的界面
				detail = new FindLoadingPanel();
				//将细节信息添加到主面板
				add(detail);
				//重新布局
				revalidate();
			}
		});
		//添加中转单的监听
		this.AddTransferring.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//设置当前的细节信息面板不可见
				detail.setVisible(false);
				//设置细节信息面板为将要显示的的界面
				detail = new AddTransferringPanel();
				//将细节信息添加到主面板
				add(detail);
				//重新布局
				revalidate();
			}
		});
		//修改中转单的监听
		this.ModifyTransferring.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//设置当前的细节信息面板不可见
				detail.setVisible(false);
				//设置细节信息面板为将要显示的的界面
				detail = new ModifyTransferringPanel();
				//将细节信息添加到主面板
				add(detail);
				//重新布局
				revalidate();
			}
		});
		//查询中转单的监听
		this.FindTransferring.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//设置当前的细节信息面板不可见
				detail.setVisible(false);
				//设置细节信息面板为将要显示的的界面
				detail = new FindTransferringPanel();
				//将细节信息添加到主面板
				add(detail);
				//重新布局
				revalidate();
			}
		});
		//库存信息查询的监听
		this.SeeRepository.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//设置当前的细节信息面板不可见
				detail.setVisible(false);
				//设置细节信息面板为将要显示的的界面
				detail = new SeeRepositoryPanel();
				//将细节信息添加到主面板
				add(detail);
				//重新布局
				revalidate();
			}
		});
		//添加接收单的监听
		this.AddReceiving.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//设置当前的细节信息面板不可见
				detail.setVisible(false);
				//设置细节信息面板为将要显示的的界面
				detail = new AddReceivingPanel();
				//将细节信息添加到主面板
				add(detail);
				//重新布局
				revalidate();
			}
		});
		//修改接收单的监听
		this.ModifyReceiving.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//设置当前的细节信息面板不可见
				detail.setVisible(false);
				//设置细节信息面板为将要显示的的界面
				detail = new ModifyReceivingPanel();
				//将细节信息添加到主面板
				add(detail);
				//重新布局
				revalidate();
			}
		});
		//查询接收单的监听
		this.FindReceiving.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//设置当前的细节信息面板不可见
				detail.setVisible(false);
				//设置细节信息面板为将要显示的的界面
				detail = new FindReceivingPanel();
				//将细节信息添加到主面板
				add(detail);
				//重新布局
				revalidate();
			}
		});
	}
}
