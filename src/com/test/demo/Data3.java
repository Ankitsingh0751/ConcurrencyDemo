package com.test.demo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Data3 {
	public static void main(String[] args) throws InterruptedException {
		

		ExecutorService service = null;
		
		try {
			service = Executors.newSingleThreadExecutor();
		    Future<Integer> result = service.submit(()->30+30-80);
		    Future<String> result2 = service.submit(()->"hello");
		    Future<Float> result3 = service.submit(()->30.09f-20f);
		    Future<Integer> result4= service.submit(()->30+30);
		    try {
				System.out.println(result.get() +""+result2.get()+""+result3.get()+""+result4.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		finally {

			if(service!=null) service.shutdown();
		}
		if(service != null) {
			service.awaitTermination(1, TimeUnit.MINUTES);
			
			if(service.isTerminated())System.out.println("finished all tasks");

			else
				System.out.println("at least one of the tasks is still running hence isTerminated false");
		}
		}

}
