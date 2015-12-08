package ui.baseui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import ui.mainui.ExpressFrame;

/**
 * 详细任务信息面板的基类，设置了边界、大小与布局
 */
@SuppressWarnings("serial")
public class DetailPanel extends JPanel{
	
	/**
	 * 任务细节面板宽度
	 */
	protected static final int DETAIL_PANEL_W = ExpressFrame.FRAME_W - TaskPanel.TASK_PANEL_W - 6;
	
	/**
	 * 任务细节面板高度
	 */
	protected static final int DETAIL_PANEL_H = TaskPanel.TASK_PANEL_H;
	
	protected static final int CONTAINER_W = 750;
	
	protected static final int CONTAINER_H = 900;
	
	private static Image BACKGROUND = new ImageIcon("picture/detail.jpg").getImage();
	
	public DetailPanel() {
		this.repaint();
		this.setBounds(TaskPanel.TASK_PANEL_W, TitlePanel.TITLE_PANEL_H,
				DETAIL_PANEL_W, DETAIL_PANEL_H);
		this.setLayout(null);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(BACKGROUND, 0, 0, this.getWidth(), this.getHeight(), null);
	}
}
