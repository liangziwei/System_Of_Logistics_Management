package ui.baseui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
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
		setClose();
		this.repaint();
		this.setBounds(0, 0, TITLE_PANEL_W, TITLE_PANEL_H);
		this.setLayout(null);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(BACKGROUND, 0, 0, this.getWidth(), this.getHeight(), null);
	}
	
	public void setClose() {

		//最小化按钮
		JButton minButton=new JButton("-");
		minButton.setBounds(ExpressFrame.FRAME_W-70, 0, 30, 30);
		minButton.addActionListener(new ActionListener(){
			@Override
			  public void actionPerformed(ActionEvent e) {
				ExpressFrame.getInstance().setExtendedState(JFrame.ICONIFIED);
			  }
		});
		
		
		 //关闭按钮
		 JButton closeButton = new JButton("X");
//		 closeButton.setIcon(new ImageIcon("img/closeButton.png"));
		 closeButton.setBounds(ExpressFrame.FRAME_W-30, 0, 30, 30);
		 closeButton.addActionListener(new ActionListener() {
		  @Override
		  public void actionPerformed(ActionEvent e) {
		  System.exit(0);
		  }
		 });
		 this.add(closeButton);
		 this.add(minButton);  

		 }
	
}
