package com.training.demos2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExecutorServiceDemo1 {
	public static void main(String[] args) throws InterruptedException {
		
	
	ExecutorService service = null ;
	//when you implement Runnable interface  -- you are overriding public void run(){}
	Runnable r1 =  ()->System.out.println("hello world!!");
	
	Runnable r2 = ()-> {
		for(int i=0;i<5;i++) {
			System.out.println("value "+i);
		}
	};
	
	Callable <Integer> task1 = ()->5;
	Callable <String> task2 = ()->"hello";
	
	
	try {
		
		//1st step of getting service instance ---instantiating the service reference		
		service = Executors.newSingleThreadExecutor();
		
		System.out.println("begin");
		
		//2nd step is to execute the tasks-- Runnable 
		/*
		 * service.execute(r2); service.execute(r1); service.execute(r2);
		 */
        
		//public void run -- Future object which is capturing the return val get the null
		// Callable  public Future<Integer> call(){ return 5;
		//}
		Future <?> futureObject = service.submit(task2);
		try {
			//check whether task was done or cancelled or threw an exception
			//isDone returns true
			
			System.out.println("Completed task " +futureObject.isDone());
			System.out.println("Cancelled task " +futureObject.isCancelled());
			
						
			//this statement is going to block the main thread till the time Future returns the result , if the task is huge
			System.out.println("result of task submission is "+futureObject.get(1,TimeUnit.SECONDS));
		
			System.out.println("Completed task " +futureObject.isDone());
			System.out.println("Cancelled task " +futureObject.isCancelled());
			
			
		
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println("Ending the main thread ...");
    	//this will return true when we call shutdown
		
	}
	finally {
		//shutdown --service will wait for all pending tasks to be completed and then it will close
		//since your ExecutorService is not implementing AutoClosable interface , it can be used in try-with-resources
		
		if(service!=null) {
			service.shutdown(); //is waiting for all active tasks to be completed and then it will terminate although shut down will start
			
			
		if (service !=null) {
			
			service.awaitTermination(1, TimeUnit.SECONDS);
			
			if(service.isTerminated()) {
				System.out.println("Completed all tasks ");
			}
			else
				System.out.println("some task still running ");
		}	
	      // List <Runnable> list = service.shutdownNow(); //it immediately shuts down the service
	       //without waiting for completion of tasks
			//list of submitted tasks which were never started
		
			System.out.println(service.isShutdown());
			
			//this will return true when all tasks are completed
		System.out.println(service.isTerminated());
	
		//once you have shutdown the service,submitting new tasks to it will render RejectedExecutionException
			
		//service.execute(r1);
			
		}
		
		
		
	}
	
	}
}
