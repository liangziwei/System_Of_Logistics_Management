package ui.repositoryui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;

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
	private TaskButton InRepository = new TaskButton("");
	private TaskButton OutRepository = new TaskButton("");
	private TaskButton LookRepository = new TaskButton("");
	private TaskButton CheckDelivery = new TaskButton("");
	private TaskButton RepositoryWarn = new TaskButton("");
	private TaskButton exit = new TaskButton("");

	// 入库单相关按钮
	private JButton AddInRepository = new JButton("");
	private JButton ModifyInRepository = new JButton("");
	private JButton FindInRepository = new JButton("");

	// 出库单相关按钮
	private JButton AddOutRepository = new JButton("");
	private JButton ModifyOutRepository = new JButton("");
	private JButton FindOutRepository = new JButton("");

	private JButton SeeTransferringList = new JButton("");


	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 17);

	private List<JButton> DetailButtonInRepository = new ArrayList<JButton>();

	private List<JButton> DetailButtonOutRepository = new ArrayList<JButton>();

	private static final int BUTTON_WITH = TaskPanel.BUTTON_W;

	private static final int BUTTON_HEIGHT = 32;

	private static final int BUTTON_GAP = 4;

	public RepositoryPanel(ViewController viewController) {
		super(viewController);
		// TODO Auto-generated constructor stub
		initUI();
		addListenter();
		
		//入库管理
		this.AddInRepository.setIcon(new ImageIcon("picture/添加入库单.png"));
		this.ModifyInRepository.setIcon(new ImageIcon("picture/修改入库单.png"));
		this.FindInRepository.setIcon(new ImageIcon("picture/查询入库单.png"));
		DetailButtonInRepository.add(AddInRepository);
		DetailButtonInRepository.add(ModifyInRepository);
		DetailButtonInRepository.add(FindInRepository);
		// 要展开的按钮
		InRepository.setDetailButtons(DetailButtonInRepository); // 设置（添加）要展开的按钮
		
		//出库管理
		this.AddOutRepository.setIcon(new ImageIcon("picture/添加出库单.png"));
		this.ModifyOutRepository.setIcon(new ImageIcon("picture/修改出库单.png"));
		this.FindOutRepository.setIcon(new ImageIcon("picture/查询出库单.png"));
		this.SeeTransferringList.setIcon(new ImageIcon("picture/查询中转单列表.png"));
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
		this.InRepository.setFont(WORD_FONT);
		this.InRepository.setIcon(new ImageIcon("picture/入库管理.png"));
		// 出库单相关操作按钮
		this.OutRepository.setBounds(0, this.InRepository.getY() + BUTTON_HEIGHT + BUTTON_GAP, BUTTON_WITH,
				BUTTON_HEIGHT);
		this.OutRepository.setFont(WORD_FONT);
		this.OutRepository.setIcon(new ImageIcon("picture/出库管理.png"));
		// 库存信息查看按钮
		this.LookRepository.setBounds(0, this.OutRepository.getY() + BUTTON_HEIGHT + BUTTON_GAP, BUTTON_WITH,
				BUTTON_HEIGHT);
		this.LookRepository.setFont(WORD_FONT);
		this.LookRepository.setIcon(new ImageIcon("picture/库存查看.png"));
		//库存信息盘点按钮
		this.CheckDelivery.setBounds(0, this.LookRepository.getY() + BUTTON_HEIGHT + BUTTON_GAP, BUTTON_WITH,
				BUTTON_HEIGHT);
		this.CheckDelivery.setFont(WORD_FONT);
		this.CheckDelivery.setIcon(new ImageIcon("picture/库存盘点.png"));
		//库存预警按钮
		this.RepositoryWarn.setBounds(0, this.CheckDelivery.getY() + BUTTON_HEIGHT + BUTTON_GAP, BUTTON_WITH,
				BUTTON_HEIGHT);
		this.RepositoryWarn.setFont(WORD_FONT);
		this.RepositoryWarn.setIcon(new ImageIcon("picture/库存预警.png"));
		// 退出按钮
		this.exit.setBounds(0, this.RepositoryWarn.getY() + BUTTON_HEIGHT + BUTTON_GAP, BUTTON_WITH, BUTTON_HEIGHT);
		this.exit.setFont(WORD_FONT);
		this.exit.setIcon(new ImageIcon("picture/退出.png"));
		// 面板添加按钮
		this.task.buttonContainer.add(InRepository);
		this.task.buttonContainer.add(OutRepository);
		this.task.buttonContainer.add(LookRepository);
		this.task.buttonContainer.add(CheckDelivery);
		this.task.buttonContainer.add(RepositoryWarn);
		this.task.buttonContainer.add(exit);
		this.task.buttonContainer.setOpaque(false);
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
