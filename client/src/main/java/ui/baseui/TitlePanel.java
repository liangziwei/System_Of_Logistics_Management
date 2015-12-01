package ui.baseui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
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
	
	private static Image BACKGROUND = new ImageIcon("picture/title.jpg").getImage();
	
	public TitlePanel() {
		this.repaint();
		this.setBounds(0, 0, TITLE_PANEL_W, TITLE_PANEL_H);
		this.setLayout(null);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(BACKGROUND, 0, 0, this.getWidth(), this.getHeight(), null);
	}
}
