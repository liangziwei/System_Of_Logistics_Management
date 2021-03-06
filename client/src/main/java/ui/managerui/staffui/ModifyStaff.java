package ui.managerui.staffui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

import businessLogic.businessLogicController.managerController.OrganizationManagementController;
import businessLogic.businessLogicController.managerController.StaffManagementController;
import businessLogicService.managerBLService.OrganizationManagementBLService;
import businessLogicService.managerBLService.StaffManagementBLService;
import ui.baseui.DetailPanel;
import ui.baseui.LimpidButton;
import ui.managerui.SearchPanel;
import vo.managerVO.OrganizationVO;
import vo.managerVO.StaffVO;

@SuppressWarnings("serial")
public class ModifyStaff extends DetailPanel{
	
	private StaffManagementBLService staff = new StaffManagementController();
	
	private SearchPanel staffId = new SearchPanel("人员编号", WORD_FONT, 0, 0, DETAIL_PANEL_W, DETAIL_PANEL_H / 6);
	
	private StaffInfoPanel staffInfo = null;
	
	private LimpidButton modify = new LimpidButton("","picture/修改.png");
	
	private LimpidButton cancel = new LimpidButton("","picture/取消.png");
	
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
		this.container.setVisible(false);
		this.container.setOpaque(false);
		this.container.getViewport().setOpaque(false);
		this.add(this.container);
		
		int buttonW = 80;
		int buttonH = 30;
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
		this.tip.setBounds(buttonW, this.modify.getY(), (int)(buttonW * 3), buttonH);
		this.tip.setFont(WORD_FONT);
		tip.setForeground(Color.RED);
		this.add(this.tip);
		
		this.setOpaque(false);
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
				//验证用户修改是否合理
				AddStaff add = new AddStaff();
				tip.setText("");
				if(!staffInfo.getIdText().getText().equals(staffId.getIdText())) {//如果编号发生改变
					//验证修改后的编号是否已经存在
					StaffVO vo = staff.findStaff(staffInfo.getIdText().getText());
					if(vo != null) {
						tip.setText("该人员编号已经存在");
						repaint();
						return ;
					}
					//验证修改后的编号前6位表示的机构是否存在
					String temp = null;
					try {
						temp = staffInfo.getIdText().getText().substring(0, 6);
					}catch(IndexOutOfBoundsException ex) {
						tip.setText("人员编号前6位对应的机构不存在");
						repaint();
						return ;
					}
					OrganizationManagementBLService org = new OrganizationManagementController();
					OrganizationVO orgVO = org.findOrganization(temp);
					if(orgVO == null) {
						tip.setText("人员编号前6位对应的机构不存在");
						repaint();
						return ;
					}
				}else if(!add.verifyInput(staffInfo.getIdText(), staffInfo.getNameText(),
						staffInfo.getBirthText(), staffInfo.getSalaryText(), tip, true)) return ;
			    
				//保存修改
				staff.modifyStaff(staffInfo.createVO());
				//返回查询界面
				backToInquire(true);
			}
		});
		//取消修改按钮
		this.cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//返回查询界面
				backToInquire(false);
			}
		});
	}
	
	private void backToInquire(boolean isModify) {
		//隐藏查询按钮
		modify.setVisible(false);
		cancel.setVisible(false);
		//隐藏人员信息面板
		container.setVisible(false);
		//显示查询面板
		staffId.setVisible(true);
		//消除错误提示
		if(isModify) {
			tip.setBounds(10, this.staffId.getIDLabel().getY() + 30, 240, 30);
			this.tip.setForeground(Color.BLUE);
			this.tip.setText("修改成功");
		}else {
			tip.setBounds(80, this.modify.getY(), 240, 30);
			this.tip.setText("");
		}
		//消除用户输入的人员编号
		this.staffId.clearIdText();
		
		repaint();
	}
	
}

