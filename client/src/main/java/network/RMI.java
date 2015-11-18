package network;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMI {
	
	private static Registry registry = null;
	
	static {
		try {
			registry = LocateRegistry.getRegistry("127.0.0.1");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param key,每个RMI的接口都绑定一个索引值，这里规定接口绑定的索引值为接口名称的第一个单词
	 *            如：OrderDataService 绑定 order, ReceiptDataService 绑定 receipt
	 * @param T,指的是需要返回的远程服务对象的类型，如果需要返回OrderDataService类型，则将
	 *          OrderDataService参数作为泛型参数传入
	 * @return T,返回远程服务对象
	 */
	@SuppressWarnings("unchecked")
	public static<T> T getDataService(String key) {
		T service = null;
		try {
			service = (T) registry.lookup(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return service;
	}
}
