package network;

import java.rmi.registry.Registry;

/**
 *RMI重连线程 
 */
public class Reconnect<T> implements Runnable{
	
	/**
	 *远程服务注册对象 
	 */
	private Registry registry;
	
	/**
	 *本地对象与远程服务对象绑定的关键字
	 */
	private String key;
	
	/**
	 *远程服务对象 
	 */
	private T service;
	
	public Reconnect(Registry registry, String key) {
		this.registry = registry;
		this.key = key;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		ConnectPanel panel = new ConnectPanel();
		ConnectDialog dialog = new ConnectDialog(panel);
		while(true) {
			try {
				//显示当前已连接次数
				panel.setNumber(panel.getNumber() + 1);
				panel.repaint();
				Thread.sleep(2000);
				//获取远程服务对象
				this.service = (T) this.registry.lookup(this.key);
				if(service != null) break;
			} catch (Exception e) {}
		}
		
		dialog.dispose();
	}
	
	/**
	 *获取远程服务对象 
	 */
	public T getService() {
		return this.service;
	}
}
