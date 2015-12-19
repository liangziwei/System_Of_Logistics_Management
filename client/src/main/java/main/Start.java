package main;

import network.RMI;
import network.RemoteExceptionHandler;
import ui.mainui.ExpressFrame;
import ui.mainui.ExpressPanel;
import ui.viewcontroller.ViewController;

public class Start {

	public static void main(String[] args) {
		
		//主框架
		ExpressFrame frame = new ExpressFrame();
		//界面跳转控制器
		ViewController controller = new ViewController(frame);
		//主面板
		ExpressPanel panel = new ExpressPanel(controller);
		//主框架添加主面板
		frame.add(panel);
		//刷新面板
		frame.repaint();
		
		//初始化网络异常处理的成员变量
		RemoteExceptionHandler.setRegistry(RMI.getRegistry());
	}
}
