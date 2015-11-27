package ui.managerui.staffui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import businessLogic.businessLogicController.managerController.StaffManagementController;
import businessLogicService.managerBLService.StaffManagementBLService;
import ui.baseui.DetailPanel;
import ui.managerui.SearchPanel;
import vo.managerVO.StaffVO;

@SuppressWarnings("serial")
public class ModifyStaff extends DetailPanel{
	
	private StaffManagementBLService staff = new StaffManagementController();
	
	private SearchPanel staffId = new SearchPanel("人员编号", WORD_FONT, 0, 0, DETAIL_PANEL_W, DETAIL_PANEL_H / 6);
	
	private StaffInfoPanel staffInfo = null;
	
	private JButton modify = new JButton("修改");
	
	private JButton cancel = new JButton("取消");
	
	private JLabel tip = new JLabel();
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 12);
	
	private JScrollPane container = new JScrollPane();
	
	public ModifyStaff() {
		//添加搜索人员信息的面板
		this.add(this.staffId);
		//添加事件监听
		this.addListener();
		//人员信息面板
		this.container.setBounds(0, DETAIL_PANEL_H / 6, DETAIL_PANEL_W, DETAIL_PANEL_H / 6 * 5);
		this.container.getVerticalScrollBar().setUnitIncrement(15);
		this.add(this.container);
		
		int buttonW = (int) (staffId.getHeight() * 0.8);
		int buttonH = staffId.getHeight() >> 1;
		//修改按钮
		this.modify.setBounds(staffId.getWidth() >> 1, (int)(staffId.getHeight()* 0.1), buttonW, buttonH);
		this.modify.setFont(WORD_FONT);
		this.modify.setVisible(false);
		this.add(this.modify);
		//取消按钮
		this.cancel.setBounds(this.modify.getX() + (buttonW << 1), this.modify.getY(), buttonW, buttonH);
		this.cancel.setFont(WORD_FONT);
		this.cancel.setVisible(false);
		this.add(this.cancel);
		//提示标签
		this.tip.setBounds(buttonW, this.modify.getY(), buttonW << 1, buttonH);
		this.tip.setFont(WORD_FONT);
		tip.setForeground(Color.RED);
		this.add(this.tip);
	}
	
	private void addListener() {
		//确定查询按钮
		this.staffId.getOk().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//查询人员信息
				StaffVO staffVO = staff.findStaff(staffId.getIdText());
				//如果没有找到该人员信息
				if(staffVO == null) {
					staffId.setText("该人员不存在", WORD_FONT, Color.RED);
					return ;
				}
				else {
					staffId.removeText();
				}
				//显示人员信息
				container.setVisible(true);
				staffInfo = new StaffInfoPanel();
				container.setViewportView(staffInfo.getStaffInfoPanel(staffVO));
				//隐藏查询面板
				staffId.setVisible(false);
				//显示修改按钮
				modify.setVisible(true);
				cancel.setVisible(true);
				//询问是否确认修改
				tip.setText("确认修改吗");
				//刷新面板
				repaint();
			}
		});
		//取消查询按钮
		this.staffId.getCancel().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				container.setVisible(false);
			}
		});
		//确定修改按钮
		this.modify.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//保存修改
				staff.modifyStaff(staffInfo.createVO());
				//返回查询界面
				backToInquire();
			}
		});
		//取消修改按钮
		this.cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//返回查询界面
				backToInquire();
			}
		});
	}
	
	private void backToInquire() {
		//隐藏查询按钮
		modify.setVisible(false);
		cancel.setVisible(false);
		//隐藏人员信息面板
		container.setVisible(false);
		//显示查询面板
		staffId.setVisible(true);
		repaint();
	}
}

