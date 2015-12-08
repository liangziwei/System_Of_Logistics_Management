package ui.financeui;

import java.awt.Font;
import java.awt.Image;
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
import ui.financeui.accountui.AddAccountPanel;
import ui.financeui.accountui.DeleteAccountPanel;
import ui.financeui.accountui.InquireAccountPanel;
import ui.financeui.accountui.ModifyAccountPanel;
import ui.financeui.costui.CostPanel;
import ui.financeui.originalInfoui.OriginalInfoPanel;
import ui.financeui.settlementui.SettleAllPanel;
import ui.financeui.settlementui.SettlePartPanel;
import ui.financeui.statisticsui.RunPanel;
import ui.financeui.statisticsui.ProfitPanel;
import ui.mainui.LoginPanel;
import ui.viewcontroller.ViewController;

@SuppressWarnings("serial")
public class FinancePanel extends UserPanel{
	
	private TaskButton cost = new TaskButton("");
	
	private JButton payment = new JButton("");
	
	private TaskButton settlement = new TaskButton("");
	
	private JButton receivable = new JButton("");
	
	private JButton allReceivable = new JButton("");
	
	private TaskButton account = new TaskButton("");
	
	private JButton addAccount = new JButton("");
	
	private JButton deleteAccount = new JButton("");
	
	private JButton modifyAccount = new JButton("");
	
	private JButton inquireAccount = new JButton("");
	
	private TaskButton statistics = new TaskButton("");
	
	private JButton costAndProfit = new JButton("");
	
	private JButton run = new JButton("");
	
	private TaskButton originalInfo = new TaskButton("");
	
	private TaskButton exit = new TaskButton("");
	
	private Image head = new ImageIcon("picture/财务人员.jpg").getImage();
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 17);

	public FinancePanel(ViewController viewController) {
		super(viewController);
		//初始化组件
		this.initUI();
		//给任务按钮添加事件监听
		this.addTaskListener();
		//成本管理监听
		this.addCostListener();
		//结算管理监听
		this.addSettlementListener();
		//账户管理监听
		this.addAccountListener();
		//成本经营统计分析监听
		this.addStatisticsListener();
		//期初建账监听
		this.addOriginalInfoListener();
	}
	
	private void initUI() {
		int gap = TaskPanel.BUTTON_H + TaskPanel.BUTTON_GAP;
		//成本管理按钮（包括新建付款单按钮）
		this.cost.setBounds(0, UserImagePanel.USER_PANEL_H, TaskPanel.BUTTON_W, TaskPanel.BUTTON_H);
		this.cost.setFont(WORD_FONT);
		this.cost.setIcon(new ImageIcon("picture/成本管理.png"));
		//付款单按钮
		this.payment.setFont(WORD_FONT);
		this.payment.setIcon(new ImageIcon("picture/新建付款单.png"));
		//将付款单按钮作为成本管理按钮的子按钮
		List<JButton> costButtons = new ArrayList<JButton>();
		costButtons.add(this.payment);
		this.cost.setDetailButtons(costButtons);
		
		//结算管理按钮（包括收款单按钮）
		this.settlement.setBounds(0, this.cost.getY() + gap, TaskPanel.BUTTON_W, TaskPanel.BUTTON_H);
		this.settlement.setFont(WORD_FONT);
		this.settlement.setIcon(new ImageIcon("picture/结算管理.png"));
		//当天收款单按钮
		this.receivable.setFont(WORD_FONT);
		this.receivable.setIcon(new ImageIcon("picture/营业厅当天收款单.png"));
		//所有收款单按钮
		this.allReceivable.setFont(WORD_FONT);
		this.allReceivable.setIcon(new ImageIcon("picture/当天所有收款单.png"));
		//将收款单按钮作为结算管理按钮的子按钮
		List<JButton> settleButtons = new ArrayList<JButton>();
		settleButtons.add(this.receivable);
		settleButtons.add(this.allReceivable);
		this.settlement.setDetailButtons(settleButtons);
		
		//账户管理按钮（增删改查账户）
		this.account.setBounds(0, this.settlement.getY() + gap, TaskPanel.BUTTON_W, TaskPanel.BUTTON_H);
		this.account.setFont(WORD_FONT);
		this.account.setIcon(new ImageIcon("picture/账号管理.png"));
		//增加账户按钮
		this.addAccount.setFont(WORD_FONT);
		this.addAccount.setIcon(new ImageIcon("picture/增加账号.png"));
		//删除账户按钮
		this.deleteAccount.setFont(WORD_FONT);
		this.deleteAccount.setIcon(new ImageIcon("picture/删除账号.png"));
		//修改账户按钮
		this.modifyAccount.setFont(WORD_FONT);
		this.modifyAccount.setIcon(new ImageIcon("picture/修改账号.png"));
		//查询账户按钮
		this.inquireAccount.setFont(WORD_FONT);
		this.inquireAccount.setIcon(new ImageIcon("picture/查询账号.png"));
		//将增删改查按钮作为账户管理按钮的子按钮
		List<JButton> accountButtons = new ArrayList<JButton>();
		accountButtons.add(this.addAccount);
		accountButtons.add(this.deleteAccount);
		accountButtons.add(this.modifyAccount);
		accountButtons.add(this.inquireAccount);
		this.account.setDetailButtons(accountButtons);
		
		//成本经营统计分析按钮
		this.statistics.setBounds(0, this.account.getY() + gap, TaskPanel.BUTTON_W, TaskPanel.BUTTON_H);
		this.statistics.setFont(WORD_FONT);
		this.statistics.setIcon(new ImageIcon("picture/成本经营统计分析.png"));
		//成本收益表按钮
		this.costAndProfit.setFont(WORD_FONT);
		this.costAndProfit.setIcon(new ImageIcon("picture/查看成本收益表.png"));
		//经营情况表按钮
		this.run.setFont(WORD_FONT);
		this.run.setIcon(new ImageIcon("picture/查看经营情况表.png"));
		//将成本收益和经营情况添加到成本经营统计分析
		List<JButton> statisticsButtons = new ArrayList<JButton>();
		statisticsButtons.add(this.costAndProfit);
		statisticsButtons.add(this.run);
		this.statistics.setDetailButtons(statisticsButtons);
		
		//期初建账按钮
		this.originalInfo.setBounds(0, this.statistics.getY() + gap, TaskPanel.BUTTON_W, TaskPanel.BUTTON_H);
		this.originalInfo.setFont(WORD_FONT);
		this.originalInfo.setIcon(new ImageIcon("picture/期初建账.png"));
		//退出按钮
		this.exit.setBounds(0, this.originalInfo.getY() + gap, TaskPanel.BUTTON_W, TaskPanel.BUTTON_H);
		this.exit.setFont(WORD_FONT);
		this.exit.setIcon(new ImageIcon("picture/退出.png"));
		//面板添加按钮
		this.task.buttonContainer.add(this.cost);
		this.task.buttonContainer.add(this.settlement);
		this.task.buttonContainer.add(this.account);
		this.task.buttonContainer.add(this.statistics);
		this.task.buttonContainer.add(this.originalInfo);
		this.task.buttonContainer.add(this.exit);
		
		this.task.buttonContainer.setOpaque(false);
		
		this.task.user.setBackground(head);
	}
	
	private void addTaskListener() {
		//成本管理按钮
		this.cost.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				List<TaskButton> t = new ArrayList<TaskButton>();
				t.add(settlement);
				t.add(account);
				t.add(statistics);
				t.add(originalInfo);
				t.add(exit);
				task.resetTaskButtons(cost, t);
			}
		});
		//结算管理按钮
		this.settlement.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				List<TaskButton> t = new ArrayList<TaskButton>();
				t.add(account);
				t.add(statistics);
				t.add(originalInfo);
				t.add(exit);
				task.resetTaskButtons(settlement, t);
			}
		});
		//账号管理按钮
		this.account.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				List<TaskButton> t = new ArrayList<TaskButton>();
				t.add(statistics);
				t.add(originalInfo);
				t.add(exit);
				task.resetTaskButtons(account, t);
			}
		});
		//成本经营统计分析按钮
		this.statistics.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				List<TaskButton> t = new ArrayList<TaskButton>();
				t.add(originalInfo);
				t.add(exit);
				task.resetTaskButtons(statistics, t);
			}
		});
		//期初建账按钮
		this.originalInfo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//设置当前细节信息面板为不可见
				detail.setVisible(false);
				//设置细节信息面板显示订单输入界面
				detail = new OriginalInfoPanel();
				//将细节信息面板添加到主面板
				add(detail);
				//将子组件重新布局和重绘
				revalidate();
			}
		});
		//退出按钮
		this.exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//设置面板不可见
				FinancePanel.this.setVisible(false);
				//跳转到登录画面
				viewController.switchView(LoginPanel.class.getName());
			}
		});
	}

	private void addCostListener() {
		this.payment.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//设置当前细节信息面板为不可见
				detail.setVisible(false);
				//设置细节信息面板显示订单输入界面
				detail = new CostPanel();
				//将细节信息面板添加到主面板
				add(detail);
				//将子组件重新布局和重绘
				revalidate();
			}
		});
	}

	private void addSettlementListener() {
		//查看一个营业厅的当天收款单
		this.receivable.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//设置当前细节信息面板为不可见
				detail.setVisible(false);
				//设置细节信息面板显示订单输入界面
				detail = new SettlePartPanel();
				//将细节信息面板添加到主面板
				add(detail);
				//将子组件重新布局和重绘
				revalidate();
			}
		});
		//查看所有营业厅的当天收款单
		this.allReceivable.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//设置当前细节信息面板为不可见
				detail.setVisible(false);
				//设置细节信息面板显示订单输入界面
				detail = new SettleAllPanel();
				//将细节信息面板添加到主面板
				add(detail);
				//将子组件重新布局和重绘
				revalidate();
			}
		});
	}

	private void addAccountListener() {
		//增加账户
		this.addAccount.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//设置当前细节信息面板为不可见
				detail.setVisible(false);
				//设置细节信息面板显示订单输入界面
				detail = new AddAccountPanel();
				//将细节信息面板添加到主面板
				add(detail);
				//将子组件重新布局和重绘
				revalidate();
			}
		});
		//删除账户
		this.deleteAccount.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//设置当前细节信息面板为不可见
				detail.setVisible(false);
				//设置细节信息面板显示订单输入界面
				detail = new DeleteAccountPanel();
				//将细节信息面板添加到主面板
				add(detail);
				//将子组件重新布局和重绘
				revalidate();
			}
		});
		//修改账户
		this.modifyAccount.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//设置当前细节信息面板为不可见
				detail.setVisible(false);
				//设置细节信息面板显示订单输入界面
				detail = new ModifyAccountPanel();
				//将细节信息面板添加到主面板
				add(detail);
				//将子组件重新布局和重绘
				revalidate();
			}
		});
		//查询账户
		this.inquireAccount.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//设置当前细节信息面板为不可见
				detail.setVisible(false);
				//设置细节信息面板显示订单输入界面
				detail = new InquireAccountPanel();
				//将细节信息面板添加到主面板
				add(detail);
				//将子组件重新布局和重绘
				revalidate();
			}
		});
	}

	private void addStatisticsListener() {
		//成本经营统计分析按钮
		this.costAndProfit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//设置当前细节信息面板为不可见
				detail.setVisible(false);
				//设置细节信息面板显示订单输入界面
				detail = new ProfitPanel();
				//将细节信息面板添加到主面板
				add(detail);
				//将子组件重新布局和重绘
				revalidate();
			}
		});
		//经营情况按钮
		this.run.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//设置当前细节信息面板为不可见
				detail.setVisible(false);
				//设置细节信息面板显示订单输入界面
				detail = new RunPanel();
				//将细节信息面板添加到主面板
				add(detail);
				//将子组件重新布局和重绘
				revalidate();
			}
		});
	}

	private void addOriginalInfoListener() {
		// TODO Auto-generated method stub
		
	}
}
