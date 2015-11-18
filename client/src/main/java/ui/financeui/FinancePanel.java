package ui.financeui;

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
import ui.financeui.accountui.AddAccountPanel;
import ui.financeui.accountui.DeleteAccountPanel;
import ui.financeui.accountui.InquireAccountPanel;
import ui.financeui.accountui.ModifyAccountPanel;
import ui.financeui.costui.CostPanel;
import ui.financeui.originalInfoui.OriginalInfoPanel;
import ui.financeui.settlementui.SettlementPanel;
import ui.financeui.statisticsui.StatisticsPanel;
import ui.mainui.LoginPanel;
import ui.viewcontroller.ViewController;

@SuppressWarnings("serial")
public class FinancePanel extends UserPanel{
	
	private TaskButton cost = new TaskButton("成本管理");
	
	private JButton payment = new JButton("新建付款单");
	
	private TaskButton settlement = new TaskButton("结算管理");
	
	private JButton receivable = new JButton("查看营业厅收款单");
	
	private TaskButton account = new TaskButton("账号管理");
	
	private JButton addAccount = new JButton("增加账户");
	
	private JButton deleteAccount = new JButton("删除账户");
	
	private JButton modifyAccount = new JButton("修改账户");
	
	private JButton inquireAccount = new JButton("查询账户");
	
	private TaskButton statistics = new TaskButton("成本经营统计分析");
	
	private TaskButton originalInfo = new TaskButton("期初建账");
	
	private TaskButton exit = new TaskButton("退出");
	
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
		//付款单按钮
		this.payment.setFont(WORD_FONT);
		//将付款单按钮作为成本管理按钮的子按钮
		List<JButton> costButtons = new ArrayList<JButton>();
		costButtons.add(this.payment);
		this.cost.setDetailButtons(costButtons);
		
		//结算管理按钮（包括收款单按钮）
		this.settlement.setBounds(0, this.cost.getY() + gap, TaskPanel.BUTTON_W, TaskPanel.BUTTON_H);
		this.settlement.setFont(WORD_FONT);
		//收款单按钮
		this.receivable.setFont(WORD_FONT);
		//将收款单按钮作为结算管理按钮的子按钮
		List<JButton> settleButtons = new ArrayList<JButton>();
		settleButtons.add(this.receivable);
		this.settlement.setDetailButtons(settleButtons);
		
		//账户管理按钮（增删改查账户）
		this.account.setBounds(0, this.settlement.getY() + gap, TaskPanel.BUTTON_W, TaskPanel.BUTTON_H);
		this.account.setFont(WORD_FONT);
		//增加账户按钮
		this.addAccount.setFont(WORD_FONT);
		//删除账户按钮
		this.deleteAccount.setFont(WORD_FONT);
		//修改账户按钮
		this.modifyAccount.setFont(WORD_FONT);
		//查询账户按钮
		this.inquireAccount.setFont(WORD_FONT);
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
		//期初建账按钮
		this.originalInfo.setBounds(0, this.statistics.getY() + gap, TaskPanel.BUTTON_W, TaskPanel.BUTTON_H);
		this.originalInfo.setFont(WORD_FONT);
		//退出按钮
		this.exit.setBounds(0, this.originalInfo.getY() + gap, TaskPanel.BUTTON_W, TaskPanel.BUTTON_H);
		this.exit.setFont(WORD_FONT);
		//面板添加按钮
		this.task.buttonContainer.add(this.cost);
		this.task.buttonContainer.add(this.settlement);
		this.task.buttonContainer.add(this.account);
		this.task.buttonContainer.add(this.statistics);
		this.task.buttonContainer.add(this.originalInfo);
		this.task.buttonContainer.add(this.exit);
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
//				//设置当前细节信息面板为不可见
//				detail.setVisible(false);
//				//设置细节信息面板显示订单输入界面
//				detail = new AccountPanel();
//				//将细节信息面板添加到主面板
//				add(detail);
//				//将子组件重新布局和重绘
//				revalidate();
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
				//设置当前细节信息面板为不可见
				detail.setVisible(false);
				//设置细节信息面板显示订单输入界面
				detail = new StatisticsPanel();
				//将细节信息面板添加到主面板
				add(detail);
				//将子组件重新布局和重绘
				revalidate();
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
		this.receivable.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//设置当前细节信息面板为不可见
				detail.setVisible(false);
				//设置细节信息面板显示订单输入界面
				detail = new SettlementPanel();
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
		// TODO Auto-generated method stub
		
	}

	private void addOriginalInfoListener() {
		// TODO Auto-generated method stub
		
	}
}
