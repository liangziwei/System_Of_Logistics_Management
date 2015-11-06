package ui.baseui;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class UserImagePanel extends JPanel{

	/**
	 * 用户图像面板宽度
	 */
	protected static final int USER_PANEL_W = TaskPanel.TASK_PANEL_W;
	
	/**
	 * 用户图像面板高度
	 */
	public static final int USER_PANEL_H = 100;
	
	public UserImagePanel() {
		this.setBounds(0, 0, USER_PANEL_W, USER_PANEL_H);
		this.setLayout(null);
	}
}
