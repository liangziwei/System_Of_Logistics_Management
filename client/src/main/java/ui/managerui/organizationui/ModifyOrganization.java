package ui.managerui.organizationui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;

import businessLogic.businessLogicController.managerController.OrganizationManagementController;
import businessLogicService.managerBLService.OrganizationManagementBLService;
import ui.baseui.DetailPanel;
import ui.managerui.SearchPanel;
import vo.managerVO.OrganizationVO;
import vo.managerVO.StaffVO;

@SuppressWarnings("serial")
public class ModifyOrganization extends DetailPanel{
	
	private OrganizationManagementBLService organization = new OrganizationManagementController();

	private SearchPanel orgId = new SearchPanel("机构编号", WORD_FONT, 0, 0, DETAIL_PANEL_W, DETAIL_PANEL_H / 6);
	
	private JSeparator separator = new JSeparator();
	
	private OrganizationInfoPanel orgPanel = null;
	
	private JLabel tip = new JLabel();
	
	private JButton modify = new JButton("修改");
	
	private JButton cancel = new JButton("取消");
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 12);
	
	public ModifyOrganization() {
		//机构信息查询面板
		this.add(this.orgId);
		//查询面板与信息面板的分割线
		this.separator.setBounds(0, this.orgId.getHeight(), DETAIL_PANEL_W, 10);
		this.add(this.separator);

		int buttonW = (int) (orgId.getHeight() * 0.8);
		int buttonH = orgId.getHeight() >> 1;
		//修改按钮
		this.modify.setBounds(orgId.getWidth() >> 1, (int)(orgId.getHeight()* 0.1), buttonW, buttonH);
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
		//增加事件监听
		this.addListener();
	}
	
	private void addListener() {
		//确定查询按钮
		this.orgId.getOk().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//获得用户输入的机构编号
				String id = orgId.getIdText();
				//查询机构信息
				OrganizationVO vo = organization.findOrganization(id);
				//如果没有找到机构信息
				if(vo == null) {
					//提示用户没有该机构信息
					orgId.setText("没有该机构信息", WORD_FONT, Color.RED);
					//刷新面板
					repaint();
					return ;
				}
				else {
					orgId.removeText();
				}
				//查询人员信息
				List<StaffVO> list = organization.getStaffInfos(id);
				//显示机构信息和人员信息
				if(orgPanel != null) orgPanel.setVisible(false);
				orgPanel = new OrganizationInfoPanel(orgId.getX(), orgId.getHeight(),
						DETAIL_PANEL_W, DETAIL_PANEL_H * 5 / 6, list);
				orgPanel.setOrganizationInfo(vo);
				orgPanel.disableStaffInfo();
				add(orgPanel);
				//询问是否确认修改
				tip.setText("确定要修改吗");
				//隐藏查询按钮
				orgId.setVisible(false);
				//显示修改按钮
				modify.setVisible(true);
				cancel.setVisible(true);
				//刷新面板
				repaint();
			}
		});
		//取消查询按钮
		this.orgId.getCancel().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//隐藏机构和人员信息面板
				orgPanel.setVisible(false);
			}
		});
		//确定删除按钮
		this.modify.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//保存对机构信息的修改
				OrganizationVO vo = orgPanel.createOrganizationVO();
				organization.modifyOrganization(vo);
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
		modify.setVisible(false);
		cancel.setVisible(false);
		//隐藏人员信息面板
		orgPanel.setVisible(false);
		//显示查询面板
		orgId.setVisible(true);
		repaint();
	}
}
