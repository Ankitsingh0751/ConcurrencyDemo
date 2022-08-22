package com.test.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
//i++ ctr++ -- ctr read ,increment ,written 
//newCachedThreadPool
//newFixedThreadPool(int)
//newScheduledThreadPool(int) --scheduling tasks -- schedule(r) ,schedule(c) scheduleAtFixedRate() ,scheduleWithFixedDelay
public class FixedThreadPoolDemo {
	private AtomicInteger henCount=new AtomicInteger(0);
	//private int henCount = 0;
	private void countHenAndReport() {
		//System.out.println(++henCount);
		synchronized (this) {

			System.out.println(henCount.incrementAndGet());
		}
	}
	public static void main(String[] args) {
		
		ExecutorService service = null;
		try {
			service=Executors.newFixedThreadPool(10);
			FixedThreadPoolDemo demo1 = new FixedThreadPoolDemo();
			for(int i=0;i<5;i++) {
				 
					service.submit(()->demo1.countHenAndReport());
				
				
				
			}
			System.out.println("final count"+demo1.henCount.get());
		}
		finally {
			if (service!=null) service.shutdown();
		}
	}
	

}
