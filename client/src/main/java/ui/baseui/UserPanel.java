package ui.baseui;


import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import ui.mainui.ExpressFrame;
import ui.viewcontroller.ViewController;

@SuppressWarnings("serial")
public class UserPanel extends JPanel{
	
	protected ViewController viewController;
	
	protected TitlePanel title = new TitlePanel();

	protected TaskPanel task = new TaskPanel();
	
	protected DetailPanel detail = new DetailPanel();
	
	private Image background = new ImageIcon("picture/MainBackground.jpg").getImage();
	
	public UserPanel(ViewController viewController) {
		this.viewController = viewController;
		//主面板
		this.setBounds(0, 0, ExpressFrame.FRAME_W, ExpressFrame.FRAME_H);
		this.setLayout(null);
		
		this.title.setOpaque(false);
		this.detail.setOpaque(false);
		//将其他面板添加到主面板
		this.add(this.title);
		this.add(this.task);
		this.add(this.detail);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), null);
	}

}
