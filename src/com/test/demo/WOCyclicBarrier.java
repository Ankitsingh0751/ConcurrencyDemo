package com.test.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WOCyclicBarrier {
	private void ploughFields() {System.out.println("ploughing");}
	private void sowSeeds() {System.out.println("sowing seeds");}
	private void wateringFields() {System.out.println("watering fields");}
	
	public void performTask() {
		ploughFields();
		sowSeeds();
		wateringFields();
		
	}
    public static void main(String[] args) {
		ExecutorService service = null;
		try {
			service=Executors.newFixedThreadPool(3);
			var farmer=new WOCyclicBarrier();
			for(int i=0;i<3;i++) {
				service.submit(()->farmer.performTask());
			}
		}
		finally {
			if(service!=null) service.shutdown();
		}
	}
}
