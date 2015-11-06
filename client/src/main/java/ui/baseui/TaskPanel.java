package ui.baseui;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TaskPanel extends JPanel{
	
	protected UserImagePanel user = new UserImagePanel();

	/**
	 * 任务面板宽度
	 */
	public static final int TASK_PANEL_W = 250;
	
	/**
	 * 任务面板高度
	 */
	public static final int TASK_PANEL_H = 500;
	
	public TaskPanel() {
		this.setBounds(0, TitlePanel.TITLE_PANEL_H, TASK_PANEL_W, TASK_PANEL_H);
		this.setLayout(null);
		
		this.add(this.user);
	}
}
