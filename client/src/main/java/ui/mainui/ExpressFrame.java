package ui.mainui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import ui.viewcontroller.ViewController;

@SuppressWarnings("serial")
public class ExpressFrame extends JFrame{

	/**
	 * 主框架宽度
	 */
	public static final int FRAME_W = 1000;
	
	/**
	 * 主框架高度
	 */
	public static final int FRAME_H = 600;
	
	public ExpressFrame() {
		//主框架
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(FRAME_W, FRAME_H);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setFrameAtCenter(this);
	}
	
	public static void main(String[] args) {
		//主框架
		ExpressFrame frame = new ExpressFrame();
		//界面跳转控制器
		ViewController controller = new ViewController(frame);
		//主面板
		ExpressPanel panel = new ExpressPanel(controller);
		//主框架添加主面板
		frame.add(panel);
	}
	
	private void setFrameAtCenter(JFrame frame) {
		Toolkit kit=Toolkit.getDefaultToolkit();
	    Dimension screenSize=kit.getScreenSize();
	    int screenWidth=(int) screenSize.getWidth();
	    int screenHeight=(int) screenSize.getHeight();
	    frame.setLocation(screenWidth-frame.getWidth()>>1,
	    		(screenHeight-frame.getHeight()>>1)-32);
	}
}