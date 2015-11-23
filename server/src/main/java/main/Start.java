package main;

import mysql.Database;
import network.RMI;

public class Start {

	public static void main(String[] args) {	
		new Database(); 
		RMI.initRMI();		
	}
}
