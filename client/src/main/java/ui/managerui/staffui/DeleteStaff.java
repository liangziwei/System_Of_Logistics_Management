package ui.managerui.staffui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

import businessLogic.businessLogicController.managerController.StaffManagementController;
import businessLogicService.managerBLService.StaffManagementBLService;
import ui.baseui.DetailPanel;
import ui.baseui.LimpidButton;
import ui.managerui.SearchPanel;
import vo.managerVO.StaffVO;

@SuppressWarnings("serial")
public class DeleteStaff extends DetailPanel{
	
	private StaffManagementBLService staff = new StaffManagementController();

	private SearchPanel staffId = new SearchPanel("人员编号", WORD_FONT, 0, 0, DETAIL_PANEL_W, DETAIL_PANEL_H / 6);
	
	private JScrollPane container = new JScrollPane();
	
	private LimpidButton delete = new LimpidButton("","picture/删除.png");
	
	private LimpidButton cancel = new LimpidButton("","picture/取消.png");
	
	private JLabel tip = new JLabel();
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 12);
	
	public DeleteStaff() {
		//添加搜索人员信息的面板
		this.add(this.staffId);
		//添加事件监听
		this.addListener();
		//人员信息面板
		this.container.setBounds(0, DETAIL_PANEL_H / 6, DETAIL_PANEL_W, DETAIL_PANEL_H / 6 * 5);
		this.container.getVerticalScrollBar().setUnitIncrement(15);
		this.container.setVisible(false);
		this.add(this.container);
		
		int buttonW = 80;
		int buttonH = 30;
		//删除按钮
		this.delete.setBounds(staffId.getWidth() >> 1, (int)(staffId.getHeight()* 0.1), buttonW, buttonH);
		this.delete.setFont(WORD_FONT);
		this.delete.setVisible(false);
		this.add(this.delete);
		//取消按钮
		this.cancel.setBounds(this.delete.getX() + (buttonW << 1), this.delete.getY(), buttonW, buttonH);
		this.cancel.setFont(WORD_FONT);
		this.cancel.setVisible(false);
		this.add(this.cancel);
		//提示标签
		this.tip.setBounds(buttonW, this.delete.getY(), buttonW << 1, buttonH);
		this.tip.setFont(WORD_FONT);
		tip.setForeground(Color.RED);
		this.add(this.tip);
	}

	private void addListener() {
		//确定查询按钮
		this.staffId.getOk().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//获得人员ID
				String id = staffId.getIdText();
				//查询人员信息
				StaffVO staffVO = staff.findStaff(id);
				//如果找不到该人员信息
				if(staffVO == null) {
					staffId.setText("该人员不存在", WORD_FONT, Color.RED);
					return ;
				}
				else {
					staffId.removeText();
				}
				//显示人员信息
				container.setVisible(true);
				container.setViewportView(new StaffInfoPanel().getStaffInfoPanel(staffVO));
				//询问是否确认删除
				tip.setText("确定要删除吗");
				//隐藏查询按钮
				staffId.setVisible(false);
				//显示删除按钮
				delete.setVisible(true);
				cancel.setVisible(true);
				//刷新面板
				repaint();
			}
		});
		//取消查询按钮
		this.staffId.getCancel().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//隐藏人员信息面板
				container.setVisible(false);
			}
		});
		//确定删除按钮
		this.delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//删除人员信息
				staff.deleteStaff(staffId.getIdText());
				//返回查询界面
				backToInquire();
			}
		});
		//取消删除按钮
		this.cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//返回查询界面
				backToInquire();
			}
		});
	}
	
	private void backToInquire() {
		//隐藏删除按钮
		delete.setVisible(false);
		cancel.setVisible(false);
		//隐藏人员信息面板
		container.setVisible(false);
		//显示查询面板
		staffId.setVisible(true);
		//消除错误提示
		this.tip.setText("");
		
		repaint();
	}
}
