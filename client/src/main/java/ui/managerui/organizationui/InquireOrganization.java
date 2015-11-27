package ui.managerui.organizationui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JSeparator;

import businessLogic.businessLogicController.managerController.OrganizationManagementController;
import businessLogicService.managerBLService.OrganizationManagementBLService;
import ui.baseui.DetailPanel;
import ui.managerui.SearchPanel;
import vo.managerVO.OrganizationVO;
import vo.managerVO.StaffVO;

@SuppressWarnings("serial")
public class InquireOrganization extends DetailPanel{
	
	private OrganizationManagementBLService organization = new OrganizationManagementController();

	private SearchPanel orgId = new SearchPanel("机构编号", WORD_FONT, 0, 0, DETAIL_PANEL_W, DETAIL_PANEL_H / 6);
	
	private JSeparator separator = new JSeparator();
	
	private OrganizationInfoPanel orgPanel = null;
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 12);
	
	public InquireOrganization() {
		//查询面板
		this.add(this.orgId);
		//查询面板与信息面板的分割线
		this.separator.setBounds(0, this.orgId.getHeight(), DETAIL_PANEL_W, 10);
		this.add(this.separator);
		//增加事件监听
		this.addListener();
	}
	
	private void addListener() {
		//确定查询按钮
		this.orgId.getOk().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//获得机构编号
				String id = orgId.getIdText();
				OrganizationVO vo = organization.findOrganization(id);
				//如果不存在该机构信息
				if(vo == null) {
					orgId.setText("该人员信息不存在", WORD_FONT, Color.RED);
					return ;
				}
				else {
					orgId.removeText();
				}
				//查询人员信息
				List<StaffVO> list = organization.getStaffInfos(id);
				//显示机构信息和人员信息
				orgPanel = new OrganizationInfoPanel(orgId.getX(), orgId.getHeight(),
						DETAIL_PANEL_W, DETAIL_PANEL_H * 5 / 6, list);
				orgPanel.setOrganizationInfo(vo);
				add(orgPanel);
				//刷新面板
				repaint();
			}
		});
		//取消查询按钮
		this.orgId.getCancel().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//隐藏机构信息显示面板
				if(orgPanel != null) {
					orgPanel.setVisible(false);
				}
			}
		});
	}
}
