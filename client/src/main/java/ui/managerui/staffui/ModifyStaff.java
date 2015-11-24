package ui.managerui.staffui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;

import ui.baseui.DetailPanel;
import ui.managerui.SearchPanel;

@SuppressWarnings("serial")
public class ModifyStaff extends DetailPanel{
	
	private SearchPanel staffId = new SearchPanel("人员编号", WORD_FONT, 0, 0, DETAIL_PANEL_W, DETAIL_PANEL_H / 6);
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 12);
	
	private JScrollPane container = new JScrollPane();
	
	private AddStaff staffInfo = new AddStaff();
	
	public ModifyStaff() {
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
				
				
				// TODO test
				container.setViewportView(staffInfo.getStaffInfo(true));
			}
		});
		//取消按钮
		this.staffId.getCancel().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}

