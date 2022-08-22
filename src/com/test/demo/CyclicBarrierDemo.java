package com.test.demo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {
	private void ploughFields() {System.out.println("ploughing");}
	private void sowSeeds() {System.out.println("sowing seeds");}
	private void wateringFields() {System.out.println("watering fields");}
	
	public void performTask(CyclicBarrier cb1,CyclicBarrier cb2) {
		try {
		ploughFields();
		cb1.await();
		sowSeeds();
		cb2.await();
		wateringFields();
		}catch(InterruptedException | BrokenBarrierException ne) {
			System.out.println(ne.getMessage());}
	}
    public static void main(String[] args) {
		ExecutorService service = null;
		try {
			service=Executors.newFixedThreadPool(3);
			var farmer=new CyclicBarrierDemo();
			var c1 = new CyclicBarrier(3);
			var c2 =new CyclicBarrier(3,()->System.out.println("seeds are sown!"));
			for(int i=0;i<3;i++) {
				service.submit(()->farmer.performTask(c1,c2));
			}
		}
		finally {
			if(service!=null) service.shutdown();
		}
	}
}



