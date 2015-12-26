package main;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

import UI.ServerFrame;
import network.RMI;

public class Start {

	public static void main(String[] args) {	
		//界面
		ServerFrame frame = new ServerFrame();
		try {
			RMI.initRMI();
			frame.setnote("连接成功");
			frame.connect.setEnabled(false);
		}catch (AlreadyBoundException | RemoteException e3) {
			// TODO: handle exception
			e3.printStackTrace();
			frame.setnote("连接出错，请稍后重新连接");
		}
	
	}
}
