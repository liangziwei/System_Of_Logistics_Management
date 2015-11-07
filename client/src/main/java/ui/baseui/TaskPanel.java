package ui.baseui;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class TaskPanel extends JScrollPane{
	
	protected UserImagePanel user = new UserImagePanel();

	/**
	 * 任务面板宽度
	 */
	public static final int TASK_PANEL_W = 250;
	
	/**
	 * 任务面板高度
	 */
	public static final int TASK_PANEL_H = 500;
	
	/**
	 *任务面板中按钮的宽度 
	 */
	public static final int BUTTON_W = TASK_PANEL_W - 20;
	
	/**
	 *任务面板中按钮的高度 
	 */
	public static final int BUTTON_H = 32;
	
	/**
	 *任务面板中按钮之间的距离
	 */
	public static final int BUTTON_GAP = 4;
	
	/**
	 * 具体任务按钮的宽度
	 */
	private static final int DETAIL_BUTTON_W = BUTTON_W - 30;
	
	/**
	 * 具体任务按钮的x坐标
	 */
	private static final int DETAIL_BUTTON_X = (BUTTON_W - DETAIL_BUTTON_W) >> 1;
	
	/**
	 *包含任务按钮的容器 
	 */
	public JPanel buttonContainer = new JPanel();
	
	private static final int CONTAINER_W = TASK_PANEL_W + 100;
	
	private static final int CONTAINER_H = 1000;
	
	public TaskPanel() {
		this.setBounds(0, TitlePanel.TITLE_PANEL_H, TASK_PANEL_W, TASK_PANEL_H);
		
		this.buttonContainer.setLayout(null);
		this.buttonContainer.setPreferredSize(new Dimension(CONTAINER_W, CONTAINER_H));
		this.buttonContainer.add(this.user);
		
		this.setViewportView(this.buttonContainer);
		this.getVerticalScrollBar().setUnitIncrement(12);
	}
	
	/**
	 * description:将任务面板中按钮所隐藏的具体任务展开，使按钮重新布局
	 * @param unfoldButton,要展开的按钮
	 * @param belowButtons, 要展开按钮的下面所有按钮
	 * @return 面板上的按钮重新布局
	 */
	public void showTaskDetail(TaskButton unfoldButton, List<TaskButton> belowButtons) {
		if(unfoldButton == null || belowButtons == null) return;
		
		//布局具体任务按钮
		List<JButton> detailButtons = unfoldButton.getDetailButtons();		//要展开的按钮
		int detailY = unfoldButton.getY();									//任务按钮的y坐标
		for(int i = 0; i < detailButtons.size(); i++) {
			detailY = detailY + BUTTON_H + BUTTON_GAP;
			detailButtons.get(i).setBounds(DETAIL_BUTTON_X, detailY, DETAIL_BUTTON_W, BUTTON_H);
			detailButtons.get(i).setVisible(true);
			this.buttonContainer.add(detailButtons.get(i));
		}
		//布局展开按钮下面的任务按钮
		int taskButtonY = detailY;
		for(int i = 0; i < belowButtons.size(); i++) {
			taskButtonY = taskButtonY + BUTTON_H + BUTTON_GAP;
			TaskButton below = belowButtons.get(i);
			if(below.isUnfold()) {		//如果当前按钮已经展开
				taskButtonY = this.showCurrentDetail(below, taskButtonY);
			}else {						//如果当前按钮没有展开
				below.setBounds(0, taskButtonY, BUTTON_W, BUTTON_H);
				this.buttonContainer.add(below);
			}
		}
		//刷新面板
		this.repaint();
	}
	
	/**
	 * description:将任务面板中按钮所展开的具体任务隐藏，使按钮重新布局
	 * @param foldButton,已经展开的按钮
	 * @param belowButtons, 已经展开按钮的下面所有按钮
	 * @return 面板上的按钮重新布局
	 */
	public void hideTaskDetail(TaskButton foldButton, List<TaskButton> belowButtons) {
		if(foldButton == null || belowButtons == null) return;
		
		//隐藏具体任务按钮
		List<JButton> detailButtons = foldButton.getDetailButtons();		//要展开的按钮
		for(int i = 0; i < detailButtons.size(); i++) {
			detailButtons.get(i).setVisible(false);
		}
		//布局展开按钮下面的任务按钮
		int taskButtonY = foldButton.getY();
		for(int i = 0; i < belowButtons.size(); i++) {
			taskButtonY = taskButtonY + BUTTON_H + BUTTON_GAP;
			TaskButton below = belowButtons.get(i);
			if(below.isUnfold()) {		//如果当前按钮已经展开
				this.hideCurrentDetail(below, taskButtonY);
			}else {						//如果当前按钮没有展开
				below.setBounds(0, taskButtonY, BUTTON_W, BUTTON_H);
				this.buttonContainer.add(below);
			}
		}
		//刷新面板
		this.repaint();
	}
	
	private int showCurrentDetail(TaskButton button, int currentY) {
		button.setBounds(0, currentY, BUTTON_W, BUTTON_H);
		List<JButton> details = button.getDetailButtons();
		for(int i = 0; i < details.size(); i++) {
			currentY = currentY + BUTTON_H + BUTTON_GAP;
			JButton detail = details.get(i);
			detail.setBounds(DETAIL_BUTTON_X, currentY, DETAIL_BUTTON_W, BUTTON_H);
		}
		return currentY;
	}
	
	private void hideCurrentDetail(TaskButton button, int currentY) {
		button.setBounds(0, currentY, BUTTON_W, BUTTON_H);
		List<JButton> details = button.getDetailButtons();
		for(int i = 0; i < details.size(); i++) {
			
		}
	}
}
