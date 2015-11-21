package ui.managerui;

import java.awt.Font;

import javax.swing.JButton;

import ui.baseui.TaskButton;
import ui.baseui.TaskPanel;
import ui.baseui.UserImagePanel;
import ui.baseui.UserPanel;
import ui.viewcontroller.ViewController;

@SuppressWarnings("serial")
public class ManagerPanel extends UserPanel{

	private TaskButton approve = new TaskButton("审批单据");
	
	private TaskButton constant = new TaskButton("制定常量");
	
	private JButton city = new JButton("城市距离");
	
	private JButton price = new JButton("价格常量");
	
	private TaskButton organization = new TaskButton("机构管理");
	
	private TaskButton staff = new TaskButton("人员管理");
	
	private TaskButton statistics = new TaskButton("成本经营统计分析");
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 17);
	
	public ManagerPanel(ViewController viewController) {
		super(viewController);
		//审批单据按钮
		this.approve.setBounds(0, UserImagePanel.USER_PANEL_H, TaskPanel.BUTTON_W, TaskPanel.BUTTON_H);
		this.approve.setFont(WORD_FONT);
		//制定常量按钮
//		this.constant.setBounds(0, UserImagePanel.USER_PANEL_H, TaskPanel.BUTTON_W, TaskPanel.BUTTON_H);
		
		//机构管理按钮
		//人员管理按钮
		//成本经营统计分析按钮
		//面板添加按钮
		this.task.buttonContainer.add(this.approve);
		this.task.buttonContainer.add(this.constant);
		this.task.buttonContainer.add(this.organization);
		this.task.buttonContainer.add(this.staff);
		this.task.buttonContainer.add(this.statistics);
	}

	
}
