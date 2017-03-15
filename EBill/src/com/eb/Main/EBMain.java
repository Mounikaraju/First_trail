package com.eb.Main;

import com.eb.service.ConnectionService;

public class EBMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(new ConnectionService().generateBill(120,100,"Commerical"));
	}

}
