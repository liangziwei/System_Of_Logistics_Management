package ui.managerui;

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
import ui.financeui.statisticsui.ProfitPanel;
import ui.financeui.statisticsui.RunPanel;
import ui.mainui.LoginPanel;
import ui.managerui.approvalformui.ApprovalFormPanel;
import ui.managerui.makeconstantui.MakeDistancePanel;
import ui.managerui.makeconstantui.MakePricePanel;
import ui.managerui.organizationui.AddOrganization;
import ui.managerui.organizationui.DeleteOrganization;
import ui.managerui.organizationui.InquireOrganization;
import ui.managerui.organizationui.ModifyOrganization;
import ui.managerui.staffui.AddStaff;
import ui.managerui.staffui.DeleteStaff;
import ui.managerui.staffui.InquireStaff;
import ui.managerui.staffui.ModifyStaff;
import ui.viewcontroller.ViewController;

@SuppressWarnings("serial")
public class ManagerPanel extends UserPanel{

	private TaskButton approve = new TaskButton("");
	
	private TaskButton constant = new TaskButton("");
	
	private JButton city = new JButton("");
	
	private JButton price = new JButton("");
	
	private TaskButton organization = new TaskButton("");
	
	private JButton addOrg = new JButton("");
	
	private JButton deleteOrg = new JButton("");
	
	private JButton modifyOrg = new JButton("");
	
	private JButton inquireOrg = new JButton("");
	
	private TaskButton staff = new TaskButton("");
	
	private JButton addStaff = new JButton("");
	
	private JButton deleteStaff = new JButton("");
	
	private JButton modifyStaff = new JButton("");
	
	private JButton inquireStaff = new JButton("");
	
	private TaskButton statistics = new TaskButton("");
	
	private JButton run = new JButton("");
	
	private JButton costBenefit = new JButton("");
	
	private TaskButton exit = new TaskButton("");
	
	private Image head = new ImageIcon("picture/总经理.jpg").getImage();
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 17);
	
	public ManagerPanel(ViewController viewController) {
		super(viewController);
		int gap = TaskPanel.BUTTON_H + TaskPanel.BUTTON_GAP;
		//审批单据按钮
		this.approve.setBounds(0, UserImagePanel.USER_PANEL_H, TaskPanel.BUTTON_W, TaskPanel.BUTTON_H);
		this.approve.setFont(WORD_FONT);
		this.approve.setIcon(new ImageIcon("picture/审批单据.png"));
		
		//制定常量按钮
		this.constant.setBounds(0, this.approve.getY() + gap, TaskPanel.BUTTON_W, TaskPanel.BUTTON_H);
		this.constant.setFont(WORD_FONT);	
		this.constant.setIcon(new ImageIcon("picture/制定常量.png"));
		this.city.setFont(WORD_FONT);
		this.city.setIcon(new ImageIcon("picture/城市距离.png"));
		this.price.setFont(WORD_FONT);
		this.price.setIcon(new ImageIcon("picture/价格常量.png"));		
		List<JButton> constantButtons = new ArrayList<JButton>();
		constantButtons.add(this.city);
		constantButtons.add(this.price);
		this.constant.setDetailButtons(constantButtons);
		
		//机构管理按钮
		this.organization.setBounds(0, this.constant.getY() + gap, TaskPanel.BUTTON_W, TaskPanel.BUTTON_H);
		this.organization.setFont(WORD_FONT);
		this.organization.setIcon(new ImageIcon("picture/机构管理.png"));
		this.addOrg.setFont(WORD_FONT);
		this.addOrg.setIcon(new ImageIcon("picture/增加机构信息.png"));
		this.deleteOrg.setFont(WORD_FONT);
		this.deleteOrg.setIcon(new ImageIcon("picture/删除机构信息.png"));
		this.modifyOrg.setFont(WORD_FONT); 
		this.modifyOrg.setIcon(new ImageIcon("picture/修改机构信息.png"));
		this.inquireOrg.setFont(WORD_FONT);
		this.inquireOrg.setIcon(new ImageIcon("picture/查询机构信息.png"));
		List<JButton> orgButtons = new ArrayList<JButton>();
		orgButtons.add(this.addOrg);
		orgButtons.add(this.deleteOrg);
		orgButtons.add(this.modifyOrg);
		orgButtons.add(this.inquireOrg);
		this.organization.setDetailButtons(orgButtons);
		
		//人员管理按钮
		this.staff.setBounds(0, this.organization.getY() + gap, TaskPanel.BUTTON_W, TaskPanel.BUTTON_H);
		this.staff.setFont(WORD_FONT);
		this.staff.setIcon(new ImageIcon("picture/人员管理.png"));
		this.addStaff.setFont(WORD_FONT);
		this.addStaff.setIcon(new ImageIcon("picture/增加人员信息.png"));
		this.deleteStaff.setFont(WORD_FONT);
		this.deleteStaff.setIcon(new ImageIcon("picture/删除人员信息.png"));
		this.modifyStaff.setFont(WORD_FONT);
		this.modifyStaff.setIcon(new ImageIcon("picture/修改人员信息.png"));
		this.inquireStaff.setFont(WORD_FONT);
		this.inquireStaff.setIcon(new ImageIcon("picture/查询人员信息.png"));
		List<JButton> staffButtons = new ArrayList<JButton>();
		staffButtons.add(this.addStaff);
		staffButtons.add(this.deleteStaff);
		staffButtons.add(this.modifyStaff);
		staffButtons.add(this.inquireStaff);
		this.staff.setDetailButtons(staffButtons);
		
		//成本经营统计分析按钮
		this.statistics.setBounds(0, this.staff.getY() + gap, TaskPanel.BUTTON_W, TaskPanel.BUTTON_H);
		this.statistics.setFont(WORD_FONT);
		this.statistics.setIcon(new ImageIcon("picture/成本经营统计分析.png"));
		this.run.setFont(WORD_FONT);
		this.run.setIcon(new ImageIcon("picture/查看经营情况表.png"));
		this.costBenefit.setFont(WORD_FONT);
		this.costBenefit.setIcon(new ImageIcon("picture/查看成本收益表.png"));
		List<JButton> statisticsButtons = new ArrayList<JButton>();
		statisticsButtons.add(this.costBenefit);
		statisticsButtons.add(this.run);
		this.statistics.setDetailButtons(statisticsButtons);
		
		//退出按钮
		this.exit.setBounds(0, this.statistics.getY() + gap, TaskPanel.BUTTON_W, TaskPanel.BUTTON_H);
		this.exit.setFont(WORD_FONT);
		this.exit.setIcon(new ImageIcon("picture/退出.png"));
		
		//面板添加按钮
		this.task.buttonContainer.add(this.approve);
		this.task.buttonContainer.add(this.constant);
		this.task.buttonContainer.add(this.organization);
		this.task.buttonContainer.add(this.staff);
		this.task.buttonContainer.add(this.statistics);
		this.task.buttonContainer.add(this.exit);
		this.task.buttonContainer.setOpaque(false);
				
		this.task.user.repaint();
		this.task.user.setBackground(head);
		
		//添加按钮按钮事件监听
		this.addListener();
		//添加制定常量细节按钮
		this.addConstListener();
		//添加机构信息管理细节按钮
		this.addOrgListener();
		//添加人员信息管理细节按钮
		this.addStaffListener();
		//添加成本经营分析细节按钮
		this.addProfitListener();
	}

	private void addListener() {
		//审批单据按钮
		this.approve.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//设置当前细节信息面板为不可见
				detail.setVisible(false);
				//设置细节信息面板显示订单输入界面
				detail = new ApprovalFormPanel();
				//将细节信息面板添加到主面板
				add(detail);
				//将子组件重新布局和重绘
				revalidate();
			}
		});
		//制定常量按钮
		this.constant.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				List<TaskButton> t = new ArrayList<TaskButton>();
				t.add(organization);
				t.add(staff);
				t.add(statistics);
				t.add(exit);
				
				task.resetTaskButtons(constant, t);
			}
		});
		
		
		//机构管理按钮
		this.organization.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				List<TaskButton> t = new ArrayList<TaskButton>();
				t.add(staff);
				t.add(statistics);
				t.add(exit);
				
				task.resetTaskButtons(organization, t);
			}
		});
		
		//人员管理按钮
		this.staff.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				List<TaskButton> t = new ArrayList<TaskButton>();
				t.add(statistics);
				t.add(exit);
				
				task.resetTaskButtons(staff, t);
			}
		});
		
		//成本经营统计分析按钮
		this.statistics.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				List<TaskButton> t = new ArrayList<TaskButton>();
				t.add(exit);
				
				task.resetTaskButtons(statistics, t);
			}
		});
		
		//退出按钮
		this.exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//设置当前面板为不可见
				setVisible(false);
				//跳转到登录面板
				viewController.switchView(LoginPanel.class.getName());
			}
		});
	}
	
	private void addConstListener() {
		//制定城市距离常量
		this.city.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//设置当前细节信息面板为不可见
				detail.setVisible(false);
				//设置细节信息面板显示订单输入界面
				detail = new MakeDistancePanel();
				//将细节信息面板添加到主面板
				add(detail);
				//将子组件重新布局和重绘
				revalidate();
			}
		});
		//制定价格常量
		this.price.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//设置当前细节信息面板为不可见
				detail.setVisible(false);
				//设置细节信息面板显示订单输入界面
				detail = new MakePricePanel();
				//将细节信息面板添加到主面板
				add(detail);
				//将子组件重新布局和重绘
				revalidate();
			}
		});
	}
	
	private void addOrgListener() {
		//增加机构信息按钮
		this.addOrg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//设置当前细节信息面板为不可见
				detail.setVisible(false);
				//设置细节信息面板显示订单输入界面
				detail = new AddOrganization();
				//将细节信息面板添加到主面板
				add(detail);
				//将子组件重新布局和重绘
				revalidate();
			}
		});
		//删除机构信息按钮
		this.deleteOrg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//设置当前细节信息面板为不可见
				detail.setVisible(false);
				//设置细节信息面板显示订单输入界面
				detail = new DeleteOrganization();
				//将细节信息面板添加到主面板
				add(detail);
				//将子组件重新布局和重绘
				revalidate();
			}
		});
		//修改机构信息按钮
		this.modifyOrg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//设置当前细节信息面板为不可见
				detail.setVisible(false);
				//设置细节信息面板显示订单输入界面
				detail = new ModifyOrganization();
				//将细节信息面板添加到主面板
				add(detail);
				//将子组件重新布局和重绘
				revalidate();
			}
		});
		//查询机构信息按钮
		this.inquireOrg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//设置当前细节信息面板为不可见
				detail.setVisible(false);
				//设置细节信息面板显示订单输入界面
				detail = new InquireOrganization();
				//将细节信息面板添加到主面板
				add(detail);
				//将子组件重新布局和重绘
				revalidate();
			}
		});
	}
	
	private void addStaffListener() {
		//增加人员信息按钮
		this.addStaff.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//设置当前细节信息面板为不可见
				detail.setVisible(false);
				//设置细节信息面板显示订单输入界面
				detail = new AddStaff();
				//将细节信息面板添加到主面板
				add(detail);
				//将子组件重新布局和重绘
				revalidate();
			}
		});
		//删除人员信息按钮
		this.deleteStaff.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//设置当前细节信息面板为不可见
				detail.setVisible(false);
				//设置细节信息面板显示订单输入界面
				detail = new DeleteStaff();
				//将细节信息面板添加到主面板
				add(detail);
				//将子组件重新布局和重绘
				revalidate();
			}
		});
		//修改人员信息按钮
		this.modifyStaff.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//设置当前细节信息面板为不可见
				detail.setVisible(false);
				//设置细节信息面板显示订单输入界面
				detail = new ModifyStaff();
				//将细节信息面板添加到主面板
				add(detail);
				//将子组件重新布局和重绘
				revalidate();
			}
		});
		//删除人员信息按钮
		this.inquireStaff.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//设置当前细节信息面板为不可见
				detail.setVisible(false);
				//设置细节信息面板显示订单输入界面
				detail = new InquireStaff();
				//将细节信息面板添加到主面板
				add(detail);
				//将子组件重新布局和重绘
				revalidate();
			}
		});
	}
	
	private void addProfitListener() {
		//查看经营情况表按钮
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
		//查看成本收益表按钮
		this.costBenefit.addActionListener(new ActionListener() {
			
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
	}
}
