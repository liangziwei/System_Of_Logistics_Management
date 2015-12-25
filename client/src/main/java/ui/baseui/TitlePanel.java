package ui.baseui;

import javax.swing.JPanel;

import ui.mainui.ExpressFrame;

@SuppressWarnings("serial")
public class TitlePanel extends JPanel{

	/**
	 * 标题面板宽度
	 */
	protected static final int TITLE_PANEL_W = ExpressFrame.FRAME_W;
	
	/**
	 * 标题面板高度
	 */
	protected static final int TITLE_PANEL_H = 100;
	
	public TitlePanel() {
		this.repaint();
		this.setBounds(0, 0, TITLE_PANEL_W, TITLE_PANEL_H);
		this.setLayout(null);
	}
	
}
