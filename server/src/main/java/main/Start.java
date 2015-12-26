package main;

import UI.ServerFrame;
import network.RMI;

public class Start {

	public static void main(String[] args) {	
		//界面
		ServerFrame frame = new ServerFrame();
		try {
			RMI.initRMI();
			frame.setnote("服务器运行中...");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			frame.setnote("服务器无法正常启动");
		}
	
	}
}
