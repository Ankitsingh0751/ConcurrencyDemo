package com.test.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ZooInfo {
	
	public static void main(String[] args) {
		
		ExecutorService service=null;
		Runnable task1=()->{
			
			System.out.println("printing zoo info");
			
		};
		
		Runnable task2=()->{for (int i=0;i<2;i++) {System.out.println("printing info"+i);}};
		try {
			service=Executors.newSingleThreadExecutor();
			System.out.println("begin");
			service.execute(task1);
            service.execute(task2);
            service.execute(task1);
            System.out.println("ending the program");
            
			
		}
		finally {
			if(service != null ) service.shutdown();
		}
	}

}
