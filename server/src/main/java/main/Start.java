package main;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import dataImpl.deliveryDataImpl.OrderDataImpl;
import dataService.deliveryDataService.OrderDataService;

public class Start {

	public static void main(String[] args) {
		
		try {
			OrderDataService order = new OrderDataImpl();
			OrderDataService stub = (OrderDataService) UnicastRemoteObject.exportObject(order, 0);
			Registry registry = LocateRegistry.getRegistry(1099);
			registry.bind("order", stub);
			System.out.println("Server is working...");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
