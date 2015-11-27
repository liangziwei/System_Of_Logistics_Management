package ui.baseui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class TaskPanel extends JScrollPane{
	
	protected UserImagePanel user = new UserImagePanel();
	
	/**
	 *包含任务按钮的容器 
	 */
	public JPanel buttonContainer = new JPanel();

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
	
	private static final int CONTAINER_W = TASK_PANEL_W + 100;
	
	private static final int CONTAINER_H = 1000;
	
	private static Image BACKGROUND = new ImageIcon("picture/Tower.jpg").getImage();
		
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
	private void showTaskDetail(TaskButton unfoldButton, List<TaskButton> belowButtons) {
		if(unfoldButton == null || belowButtons == null) return;
	
		//要展开的任务按钮的y坐标
		int detailY = unfoldButton.getY();		
		//展开任务按钮以及附带的细节按钮
		detailY = this.showCurrentDetail(unfoldButton, detailY);
		
		//对下面的按钮重新布局
		int taskButtonY = detailY;
		for(int i = 0; i < belowButtons.size(); i++) {
			//计算要布局的按钮的y坐标
			taskButtonY = taskButtonY + BUTTON_H + BUTTON_GAP;
			//获得当前要布局的按钮
			TaskButton below = belowButtons.get(i);
			//如果当前按钮已经展开
			if(below.isUnfold()) {		
				//将当前按钮以及附带的按钮重新布局
				taskButtonY = this.showCurrentDetail(below, taskButtonY);
			//如果当前按钮没有展开	
			}else {				
				//将当前按钮重新布局
				below.setBounds(0, taskButtonY, BUTTON_W, BUTTON_H);
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
	private void hideTaskDetail(TaskButton foldButton, List<TaskButton> belowButtons) {
		if(foldButton == null || belowButtons == null) return;
		
		//隐藏任务按钮附属的细节按钮
		List<JButton> detailButtons = foldButton.getDetailButtons();		//要展开的按钮
		for(int i = 0; i < detailButtons.size(); i++) {
			detailButtons.get(i).setVisible(false);
		}
		
		//对下面的按钮重新布局
		int taskButtonY = foldButton.getY();
		for(int i = 0; i < belowButtons.size(); i++) {
			//计算要布局的按钮的y坐标
			taskButtonY = taskButtonY + BUTTON_H + BUTTON_GAP;
			//获得要布局的按钮
			TaskButton below = belowButtons.get(i);
			//如果当前按钮已经展开
			if(below.isUnfold()) {		
				//对按钮及其附属的细节按钮重新布局
				taskButtonY = this.showCurrentDetail(below, taskButtonY);
			}
			//如果当前按钮没有展开
			else {	
				//对当前按钮重新布局
				below.setBounds(0, taskButtonY, BUTTON_W, BUTTON_H);
			}
		}
		//刷新面板
		this.repaint();
	}
	
	/**
	 *展开任务按钮以及附带的细节按钮 
	 *@return int, 返回的是最后一个细节按钮的y坐标
	 */
	private int showCurrentDetail(TaskButton button, int currentY) {
		//对任务按钮进行布局
		button.setBounds(0, currentY, BUTTON_W, BUTTON_H);
		
		//对细节按钮进行布局
		List<JButton> details = button.getDetailButtons();
		for(int i = 0; i < details.size(); i++) {
			//计算要布局按钮的y坐标
			currentY = currentY + BUTTON_H + BUTTON_GAP;
			//获得要布局的按钮
			JButton detail = details.get(i);
			//重设按钮的边界
			detail.setBounds(DETAIL_BUTTON_X, currentY, DETAIL_BUTTON_W, BUTTON_H);
			//将按钮设为可见
			detail.setVisible(true);
			//将按钮加入面板
			this.buttonContainer.add(detail);
		}
		return currentY;
	}
	
	/**
	 * 对外提供的接口，当用户点击任务按钮后，对任务面板的按钮进行重新布局
	 */
	public void resetTaskButtons(TaskButton clickButton, List<TaskButton> belowButtons) {
		if(clickButton.isUnfold()) {		//如果当前按钮已经展开，隐藏当前按钮的细节
			clickButton.setUnfold(false);
			this.hideTaskDetail(clickButton, belowButtons);
		}else {								//如果当前按钮没有展开，展开当前按钮的细节
			clickButton.setUnfold(true);
			this.showTaskDetail(clickButton, belowButtons);
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(BACKGROUND, 0, 0, this.getWidth(), this.getHeight(), null);
	}
}
