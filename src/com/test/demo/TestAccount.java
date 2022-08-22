package com.test.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestAccount {
public static void main(String[] args) {
	
	Account rishi =  new Account(12232,45000);
	
	ExecutorService service =  Executors.newFixedThreadPool(3);
	
	for(int i=0;i<3;i++) {
		final int j= i;
		service.submit(()->rishi.withdrawl(1000));
	
	}
	
	System.out.println(rishi.toString());
	
}
}
