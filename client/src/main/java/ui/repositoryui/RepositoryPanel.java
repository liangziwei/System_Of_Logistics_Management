package ui.repositoryui;

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
import ui.repositoryui.inRep.AddInRepositoryPanel;
import ui.repositoryui.inRep.FindInRepositoryPanel;
import ui.repositoryui.inRep.ModifyInRepositoryPanel;
import ui.repositoryui.manageRep.CheckDeliveryPanel;
import ui.repositoryui.manageRep.LookRepsitoryPanel;
import ui.repositoryui.manageRep.RepositoryWarnPanel;
import ui.repositoryui.outRep.AddOutRepositoryPanel;
import ui.repositoryui.outRep.FindOutRepositoryPanel;
import ui.repositoryui.outRep.ModifyOutRepositoryPanel;
import ui.repositoryui.outRep.SeeTransferringListPanel;
import ui.viewcontroller.ViewController;

public class RepositoryPanel extends UserPanel {
	// TaskButton
	private TaskButton InRepository = new TaskButton("","picture/入库管理.png");
	private TaskButton OutRepository = new TaskButton("","picture/出库管理.png");
	private TaskButton LookRepository = new TaskButton("","picture/库存查看.png");
	private TaskButton CheckDelivery = new TaskButton("","picture/库存盘点.png");
	private TaskButton RepositoryWarn = new TaskButton("","picture/库存预警.png");
	private TaskButton exit = new TaskButton("","picture/退出.png");

	// 入库单相关按钮
	private LimpidButton AddInRepository = new LimpidButton("","picture/添加入库单.png");
	private LimpidButton ModifyInRepository = new LimpidButton("","picture/修改入库单.png");
	private LimpidButton FindInRepository = new LimpidButton("","picture/查询入库单.png");

	// 出库单相关按钮
	private LimpidButton AddOutRepository = new LimpidButton("","picture/添加出库单.png");
	private LimpidButton ModifyOutRepository = new LimpidButton("","picture/修改出库单.png");
	private LimpidButton FindOutRepository = new LimpidButton("","picture/查询出库单.png");

	private LimpidButton SeeTransferringList = new LimpidButton("","picture/查询中转单列表.png");
	
	private Image head = new ImageIcon("picture/中转中心仓库管理员.jpg").getImage();


	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 17);

	private List<LimpidButton> DetailButtonInRepository = new ArrayList<LimpidButton>();

	private List<LimpidButton> DetailButtonOutRepository = new ArrayList<LimpidButton>();

	private static final int BUTTON_WITH = TaskPanel.BUTTON_W;

	private static final int BUTTON_HEIGHT = 32;

	private static final int BUTTON_GAP = 4;

	public RepositoryPanel(ViewController viewController) {
		super(viewController);
		// TODO Auto-generated constructor stub
		initUI();
		addListenter();
		
		//入库管理
		
		DetailButtonInRepository.add(AddInRepository);
		DetailButtonInRepository.add(ModifyInRepository);
		DetailButtonInRepository.add(FindInRepository);
		// 要展开的按钮
		InRepository.setDetailButtons(DetailButtonInRepository); // 设置（添加）要展开的按钮
		
		//出库管理
		
		DetailButtonOutRepository.add(AddOutRepository);
		DetailButtonOutRepository.add(ModifyOutRepository);
		DetailButtonOutRepository.add(FindOutRepository);

		DetailButtonOutRepository.add(SeeTransferringList);
		// 要展开的按钮
		OutRepository.setDetailButtons(DetailButtonOutRepository); // 设置（添加）要展开的按钮

	}

	private void initUI() {
		// 入库单相关操作按钮
		this.InRepository.setBounds(0, UserImagePanel.USER_PANEL_H, BUTTON_WITH, BUTTON_HEIGHT);
		
		// 出库单相关操作按钮
		this.OutRepository.setBounds(0, this.InRepository.getY() + BUTTON_HEIGHT + BUTTON_GAP, BUTTON_WITH,
				BUTTON_HEIGHT);
		
		// 库存信息查看按钮
		this.LookRepository.setBounds(0, this.OutRepository.getY() + BUTTON_HEIGHT + BUTTON_GAP, BUTTON_WITH,
				BUTTON_HEIGHT);
	
		//库存信息盘点按钮
		this.CheckDelivery.setBounds(0, this.LookRepository.getY() + BUTTON_HEIGHT + BUTTON_GAP, BUTTON_WITH,
				BUTTON_HEIGHT);
	
		//库存预警按钮
		this.RepositoryWarn.setBounds(0, this.CheckDelivery.getY() + BUTTON_HEIGHT + BUTTON_GAP, BUTTON_WITH,
				BUTTON_HEIGHT);
		
		// 退出按钮
		this.exit.setBounds(0, this.RepositoryWarn.getY() + BUTTON_HEIGHT + BUTTON_GAP, BUTTON_WITH, BUTTON_HEIGHT);
		
		// 面板添加按钮
		this.task.buttonContainer.add(InRepository);
		this.task.buttonContainer.add(OutRepository);
		this.task.buttonContainer.add(LookRepository);
		this.task.buttonContainer.add(CheckDelivery);
		this.task.buttonContainer.add(RepositoryWarn);
		this.task.buttonContainer.add(exit);
		this.task.buttonContainer.setOpaque(false);
		
		this.task.user.setBackground(head);
	}

	private void addListenter() {
		this.InRepository.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//添加要展开按钮的下面的按钮
				List<TaskButton> BelowButton = new ArrayList<TaskButton>();
				BelowButton.add(OutRepository);
				BelowButton.add(LookRepository);
				BelowButton.add(CheckDelivery);
				BelowButton.add(RepositoryWarn);
				BelowButton.add(exit);
				
				task.resetTaskButtons(InRepository, BelowButton);
			}
		});
		
		this.OutRepository.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//添加要展开按钮的下面的按钮
				List<TaskButton> BelowButton = new ArrayList<TaskButton>();
				BelowButton.add(LookRepository);
				BelowButton.add(CheckDelivery);
				BelowButton.add(RepositoryWarn);
				BelowButton.add(exit);
				
				task.resetTaskButtons(OutRepository, BelowButton);
			}
		});
		
		this.LookRepository.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//设置当前的细节信息面板不可见
				detail.setVisible(false);
				//设置细节信息面板为将要显示的的界面
				detail = new LookRepsitoryPanel();
				//将细节信息添加到主面板
				add(detail);
				//重新布局
				revalidate();
			}
		});
		
		this.CheckDelivery.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//设置当前的细节信息面板不可见
				detail.setVisible(false);
				//设置细节信息面板为将要显示的的界面
				detail = new CheckDeliveryPanel();
				//将细节信息添加到主面板
				add(detail);
				//重新布局
				revalidate();
			}
		});
		
		this.RepositoryWarn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//设置当前的细节信息面板不可见
				detail.setVisible(false);
				//设置细节信息面板为将要显示的的界面
				detail = new RepositoryWarnPanel();
				//将细节信息添加到主面板
				add(detail);
				//重新布局
				revalidate();
			}
		});
		
		this.exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//设置面板
				RepositoryPanel.this.setVisible(false);
				//跳转到登录画面
				viewController.switchView(LoginPanel.class.getName());
			}
		});
		
		this.AddInRepository.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//设置当前的细节信息面板不可见
				detail.setVisible(false);
				//设置细节信息面板为将要显示的的界面
				detail = new AddInRepositoryPanel();
				//将细节信息添加到主面板
				add(detail);
				//重新布局
				revalidate();
			}
		});
		
		this.ModifyInRepository.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//设置当前的细节信息面板不可见
				detail.setVisible(false);
				//设置细节信息面板为将要显示的的界面
				detail = new ModifyInRepositoryPanel();
				//将细节信息添加到主面板
				add(detail);
				//重新布局
				revalidate();
			}
		});
		
		this.FindInRepository.addActionListener(new  ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//设置当前的细节信息面板不可见
				detail.setVisible(false);
				//设置细节信息面板为将要显示的的界面
				detail = new FindInRepositoryPanel();
				//将细节信息添加到主面板
				add(detail);
				//重新布局
				revalidate();
			}
		});
		
		this.AddOutRepository.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//设置当前的细节信息面板不可见
				detail.setVisible(false);
				//设置细节信息面板为将要显示的的界面
				detail = new AddOutRepositoryPanel();
				//将细节信息添加到主面板
				add(detail);
				//重新布局
				revalidate();
			}
		});
		
		this.ModifyOutRepository.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//设置当前的细节信息面板不可见
				detail.setVisible(false);
				//设置细节信息面板为将要显示的的界面
				detail = new ModifyOutRepositoryPanel();
				//将细节信息添加到主面板
				add(detail);
				//重新布局
				revalidate();
			}
		});
		
		this.FindOutRepository.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//设置当前的细节信息面板不可见
				detail.setVisible(false);
				//设置细节信息面板为将要显示的的界面
				detail = new FindOutRepositoryPanel();
				//将细节信息添加到主面板
				add(detail);
				//重新布局
				revalidate();
			}
		});

		this.SeeTransferringList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//设置当前的细节信息面板不可见
				detail.setVisible(false);
				//设置细节信息面板为将要显示的的界面
				detail = new SeeTransferringListPanel();
				//将细节信息添加到主面板
				add(detail);
				//重新布局
				revalidate();
			}
		});
	}
}
