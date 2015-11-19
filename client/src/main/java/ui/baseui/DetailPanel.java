package ui.baseui;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import ui.mainui.ExpressFrame;

/**
 * 详细任务信息面板的基类，设置了边界、大小与布局
 */
@SuppressWarnings("serial")
public class DetailPanel extends JScrollPane{
	
	/**
	 * 任务细节面板宽度
	 */
	protected static final int DETAIL_PANEL_W = ExpressFrame.FRAME_W - TaskPanel.TASK_PANEL_W - 10;
	
	/**
	 * 任务细节面板高度
	 */
	protected static final int DETAIL_PANEL_H = TaskPanel.TASK_PANEL_H;
	
	/**
	 * 放在JScrollPane里的容器，盛放子组件
	 */
	public JPanel container = new JPanel();
	
	protected static final int CONTAINER_W = 1200;
	
	protected static final int CONTAINER_H = 900;
	
	public DetailPanel() {
		this.setBounds(TaskPanel.TASK_PANEL_W, TitlePanel.TITLE_PANEL_H,
				DETAIL_PANEL_W, DETAIL_PANEL_H);
		this.setLayout(null);
		this.container.setLayout(null);
		this.container.setPreferredSize(new Dimension(CONTAINER_W, CONTAINER_H));
		this.setViewportView(this.container);
		
		this.getVerticalScrollBar().setUnitIncrement(15);
	}
}
