package network;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class RMI {
	
	private static Registry registry = null;
	
	static {
		try {
			String ip=getConfig();
			registry = LocateRegistry.getRegistry(ip, 1099);
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
			new RemoteExceptionHandler<T>(key);
		}
		
		return service;
	}
	
	public static Registry getRegistry() {
		return registry;
	}
	
	/**
	 *从xml配置文件获得服务端IP地址 
	 */
	private static String getConfig(){
		String ip="127.0.0.1";
		try {  
            File f = new File("server.xml");  
            if (!f.exists()) {  
                System.out.println("  Error : Config file doesn't exist!");  
                System.exit(1);  
            }  
            SAXReader reader = new SAXReader();  
            Document doc;  
            doc = reader.read(f);  
            Element root = doc.getRootElement();  
            Element data;  
            Iterator<?> itr = root.elementIterator("VALUE");  
            data = (Element) itr.next();  
  
            ip = data.elementText("server").trim();  
             
  
        } catch (Exception ex) {  
            System.out.println("Error : " + ex.toString());
            return ip;
        }
		return ip;
	}
}
