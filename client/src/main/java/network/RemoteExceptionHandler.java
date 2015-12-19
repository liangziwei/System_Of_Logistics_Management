package network;

import java.rmi.registry.Registry;

public class RemoteExceptionHandler<T> {
	
	private static Registry registry;

	public RemoteExceptionHandler(String key) {
		//启动重连网络的线程
		Reconnect<T> reconnect = new Reconnect<T>(registry, key);
		Thread connectThread = new Thread(reconnect);
		connectThread.start();
	}
	
	public static void setRegistry(Registry r) {
		registry = r;
	}
	
}
