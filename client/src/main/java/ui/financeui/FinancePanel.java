package ui.financeui;

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
import ui.financeui.accountui.AddAccountPanel;
import ui.financeui.accountui.DeleteAccountPanel;
import ui.financeui.accountui.InquireAccountPanel;
import ui.financeui.accountui.ModifyAccountPanel;
import ui.financeui.costui.CostPanel;
import ui.financeui.originalInfoui.OriginalBuildPanel;
import ui.financeui.originalInfoui.OriginalFindPanel;
import ui.financeui.originalInfoui.OriginalInfoPanel;
import ui.financeui.settlementui.SettleAllPanel;
import ui.financeui.settlementui.SettlePartPanel;
import ui.financeui.statisticsui.RunPanel;
import ui.financeui.statisticsui.ProfitPanel;
import ui.mainui.LoginPanel;
import ui.viewcontroller.ViewController;

@SuppressWarnings("serial")
public class FinancePanel extends UserPanel{
	
	private TaskButton cost = new TaskButton("","picture/成本管理.png");
	
	private LimpidButton payment = new LimpidButton("","picture/新建付款单.png");
	
	private TaskButton settlement = new TaskButton("","picture/结算管理.png");
	
	private LimpidButton receivable = new LimpidButton("","picture/营业厅当天收款单.png");
	
	private LimpidButton allReceivable = new LimpidButton("","picture/当天所有收款单.png");
	
	private TaskButton account = new TaskButton("","picture/账号管理.png");
	
	private LimpidButton addAccount = new LimpidButton("","picture/增加账号.png");
	
	private LimpidButton deleteAccount = new LimpidButton("","picture/删除账号.png");
	
	private LimpidButton modifyAccount = new LimpidButton("","picture/修改账号.png");
	
	private LimpidButton inquireAccount = new LimpidButton("","picture/查询账号.png");
	
	private TaskButton statistics = new TaskButton("","picture/成本经营统计分析.png");
	
	private LimpidButton costAndProfit = new LimpidButton("","picture/查看成本收益表.png");
	
	private LimpidButton run = new LimpidButton("","picture/查看经营情况表.png");
	
	private LimpidButton build = new LimpidButton("","picture/finance/AddOriginalInfo.png");
	
	private LimpidButton Find = new LimpidButton("","picture/finance/InquireOriginalInfo.png");
	
	private TaskButton originalInfo = new TaskButton("","picture/期初建账.png");
	
	private TaskButton exit = new TaskButton("","picture/退出.png");
	
	private Image head = new ImageIcon("picture/head/财务人员.png").getImage();
	
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
	
		//付款单按钮
		
		//将付款单按钮作为成本管理按钮的子按钮
		List<LimpidButton> costButtons = new ArrayList<LimpidButton>();
		costButtons.add(this.payment);
		this.cost.setDetailButtons(costButtons);
		
		//结算管理按钮（包括收款单按钮）
		this.settlement.setBounds(0, this.cost.getY() + gap, TaskPanel.BUTTON_W, TaskPanel.BUTTON_H);
		
		//将收款单按钮作为结算管理按钮的子按钮
		List<LimpidButton> settleButtons = new ArrayList<LimpidButton>();
		settleButtons.add(this.receivable);
		settleButtons.add(this.allReceivable);
		this.settlement.setDetailButtons(settleButtons);
		
		//账户管理按钮（增删改查账户）
		this.account.setBounds(0, this.settlement.getY() + gap, TaskPanel.BUTTON_W, TaskPanel.BUTTON_H);

		
		//将增删改查按钮作为账户管理按钮的子按钮
		List<LimpidButton> accountButtons = new ArrayList<LimpidButton>();
		accountButtons.add(this.addAccount);
		accountButtons.add(this.deleteAccount);
		accountButtons.add(this.modifyAccount);
		accountButtons.add(this.inquireAccount);
		this.account.setDetailButtons(accountButtons);
		
		//成本经营统计分析按钮
		this.statistics.setBounds(0, this.account.getY() + gap, TaskPanel.BUTTON_W, TaskPanel.BUTTON_H);
	
		//将成本收益和经营情况添加到成本经营统计分析
		List<LimpidButton> statisticsButtons = new ArrayList<LimpidButton>();
		statisticsButtons.add(this.costAndProfit);
		statisticsButtons.add(this.run);
		this.statistics.setDetailButtons(statisticsButtons);
		
		//期初建账按钮
		this.originalInfo.setBounds(0, this.statistics.getY() + gap, TaskPanel.BUTTON_W, TaskPanel.BUTTON_H);
		
		//期初建账的子按钮
		List<LimpidButton> originalInfoButtons = new ArrayList<LimpidButton>();
		originalInfoButtons.add(this.build);
		originalInfoButtons.add(this.Find);
		this.originalInfo.setDetailButtons(originalInfoButtons);
		
		//退出按钮
		this.exit.setBounds(0, this.originalInfo.getY() + gap, TaskPanel.BUTTON_W, TaskPanel.BUTTON_H);
		
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
				List<TaskButton> t = new ArrayList<TaskButton>();
				t.add(exit);
				task.resetTaskButtons(originalInfo, t);
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
		//期初建账
		this.build.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//设置当前细节信息面板为不可见
				detail.setVisible(false);
				//设置细节信息面板显示订单输入界面
				detail = new OriginalBuildPanel();
				//将细节信息面板添加到主面板
				add(detail);
				//将子组件重新布局和重绘
				revalidate();
			}
		});
		//账单查询
		this.Find.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//设置当前细节信息面板为不可见
				detail.setVisible(false);
				//设置细节信息面板显示订单输入界面
				detail = new OriginalFindPanel();
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
