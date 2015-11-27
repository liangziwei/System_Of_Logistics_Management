package ui.managerui.staffui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;

import businessLogic.businessLogicController.managerController.StaffManagementController;
import businessLogicService.managerBLService.StaffManagementBLService;
import ui.baseui.DetailPanel;
import ui.managerui.SearchPanel;
import vo.managerVO.StaffVO;

@SuppressWarnings("serial")
public class InquireStaff extends DetailPanel{
	
	private StaffManagementBLService staff = new StaffManagementController();

	private SearchPanel staffId = new SearchPanel("人员编号", WORD_FONT, 0, 0, DETAIL_PANEL_W, DETAIL_PANEL_H / 6);
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 12);
	
	private JScrollPane container = new JScrollPane();
	
	public InquireStaff() {
		//添加搜索人员信息的面板
		this.add(this.staffId);
		//添加事件监听
		this.addListener();
		//人员信息面板
		this.container.setBounds(0, DETAIL_PANEL_H / 6, DETAIL_PANEL_W, DETAIL_PANEL_H / 6 * 5);
		this.container.getVerticalScrollBar().setUnitIncrement(15);
		this.add(this.container);
	}

	private void addListener() {
		//确定按钮
		this.staffId.getOk().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StaffVO staffVO = staff.findStaff(staffId.getIdText());
				//如果不存在该人员信息
				if(staffVO == null) {
					staffId.setText("该人员信息不存在", WORD_FONT, Color.RED);
					return ;
				}
				else {
					staffId.removeText();
				}
				//显示人员信息显示面板
				container.setVisible(true);
				container.setViewportView(new StaffInfoPanel()
						.getStaffInfoPanel(staffVO));
				//刷新面板
				repaint();
			}
		});
		//取消按钮
		this.staffId.getCancel().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//隐藏人员信息显示面板
				container.setVisible(false);
			}
		});
	}
	
}
