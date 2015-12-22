package network;

import java.rmi.registry.Registry;

import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *RMI重连线程 
 */
public class Reconnect implements Runnable{
	
	/**
	 *远程服务注册对象 
	 */
	private Registry registry;
	
	/**
	 *程序界面主框架 
	 */
	private JFrame frame;
	
	public Reconnect(Registry registry, JFrame frame) {
		this.registry = registry;
		this.frame = frame;
	}

	@Override
	public void run() {
		while(true) {
			try {
				//每隔5秒测试一下网络是否畅通
				registry.lookup("test");
				Thread.sleep(5000);
			} catch (Exception e) {
				//网络出现异常时，显示网络重连提示框
				ConnectPanel panel = new ConnectPanel();
				JDialog dialog = new JDialog(frame, false);
				initDialog(dialog, panel);
				
				boolean flag = true;
				while(flag) {
					try {
						//显示当前已连接次数
						panel.setNumber(panel.getNumber() + 1);
						panel.repaint();
						//每隔2秒测试一下网络是否畅通
						registry.lookup("test");
						Thread.sleep(2000);
						flag = false;
					} catch (Exception e1) {}
				}
				dialog.dispose();
			}
		}
		
	}
	
	private void initDialog(JDialog dialog, ConnectPanel panel) {
		dialog.setSize(300, 200);
		dialog.setVisible(true);
		dialog.setAlwaysOnTop(true);
		dialog.setResizable(false);
		dialog.setTitle("网络正在重连");
		dialog.setLocationRelativeTo(null);
		dialog.add(panel);
	}
	
}
