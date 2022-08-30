package com.test.demo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CheckData {
   private static int ctr = 0;
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService service = null;
		
		try {
			service = Executors.newSingleThreadExecutor();
			Future<?> result = service.submit(()->{
				for(int i=0;i<1000 ;i++) {
					CheckData.ctr++;
				}
			});
			result.get(1,TimeUnit.SECONDS);
			System.out.println("Reached the data end");
			
			
		}catch(TimeoutException to) {
			
			
			System.out.println("Not reached in time for the results");
			
		}
		finally {
			
			if(service!=null) service.shutdown();
		}
		
		
	}
}
