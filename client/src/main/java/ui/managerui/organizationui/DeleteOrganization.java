package ui.managerui.organizationui;

import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ui.baseui.DetailPanel;
import ui.managerui.SearchPanel;

@SuppressWarnings("serial")
public class DeleteOrganization extends DetailPanel{
	
	private SearchPanel orgId = new SearchPanel("机构编号", WORD_FONT, 0, 0, DETAIL_PANEL_W, DETAIL_PANEL_H / 6);
	
	private JScrollPane container = new JScrollPane();
	
	private JPanel infomation = new JPanel();
	
	private JTable Staff = null;
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 12);
	
	public DeleteOrganization() {
		this.add(this.orgId);
	}
}
