package ui.baseui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
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
	
	private Image Background;
	
	@Override
	public void setBackground(Color bg) {
		// TODO Auto-generated method stub
		super.setBackground(null);
	}
	
	@Override
	public void setOpaque(boolean isOpaque) {
		// TODO Auto-generated method stub
		super.setOpaque(false);
	}
	
	public UserImagePanel() {
		this.repaint();
		this.setBounds(0, 0, USER_PANEL_W, USER_PANEL_H);
		this.setLayout(null);
	}

	public void setBackground(Image background) {
		Background = background;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(Background, 0, 0, this.getWidth(), this.getHeight(), null);
	}
}
