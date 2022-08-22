package com.test.demo;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class InvokeAll {
	public static void main(String[] args) {
		
ExecutorService service = null;
		
		try {
			service = Executors.newSingleThreadExecutor();
			System.out.println("Main thread execution begins");
			Callable<String> task1 = ()->"hello world !";
			Callable<Integer> task2=()->5;
			try {
				List<Future<String>> list = service.invokeAll(List.of(task1,task1));
				
			
			    for(Future <String> future1:list){
			    	System.out.println(future1.get());
			    }
			System.out.println("Ending the main thread");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
	}
		finally {
		if(service!=null)service.shutdown();	
		}
		}

}
