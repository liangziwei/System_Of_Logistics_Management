package main;

import network.RMI;
import network.Reconnect;
import ui.mainui.ExpressFrame;
import ui.mainui.ExpressPanel;
import ui.viewcontroller.ViewController;

public class Start {

	public static void main(String[] args) {
		
		//主框架
		ExpressFrame frame = ExpressFrame.getInstance();
		//界面跳转控制器
		ViewController controller = new ViewController(frame);
		//主面板
		ExpressPanel panel = new ExpressPanel(controller);
		//主框架添加主面板
		frame.add(panel);
		//刷新面板
		frame.repaint();
		
		
		//每隔5秒检查一下网络连接是否正常
		Runnable connect = new Reconnect(RMI.getRegistry(), frame);
		Thread check = new Thread(connect);
		check.start();
	}
}
