package ui.managerui.organizationui;

import java.awt.Font;

import ui.baseui.DetailPanel;
import ui.managerui.SearchPanel;

@SuppressWarnings("serial")
public class InquireOrganization extends DetailPanel{

	private SearchPanel orgId = new SearchPanel("机构编号", WORD_FONT, 0, 0, DETAIL_PANEL_W, DETAIL_PANEL_H / 6);
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 12);
	
	public InquireOrganization() {
		this.add(this.orgId);
	}
}
