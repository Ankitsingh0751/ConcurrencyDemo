package com.training.demos2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ScheduledExecutorDemo {
	public static void main(String[] args) {
		
		//ScheduledExecutorService
		//why are we pointing ref of ExecutorService 
		//Parent class ref can point to child class object
		//Object o = new Employee();
		//Animal animal = new Deer();
		//Liskov's substitution principle
		
		ExecutorService service = Executors.newSingleThreadScheduledExecutor();
		//if you have to call specific child class or child interface methods, then you downcast
		
		//schedule(Callable,delay ,TimeUnit) ;
		/**
		 * 
		 * ScheduledFuture  --Future
		 * getDelay() 
		 * 
		 * to schedule a  Callable --you can use schedule method(Callable , 5,TimeUnit.SECONDS);
		 * 
		 * 
		 * schedule(Runnable ,delay ,TimeUnit) ;
		 * 
		 * scheduleAtFixedRate(runnable , 10 ,5, TimeUnit.SECOND) ;
		 * 
		 * scheduleAtFixedDelay(runnable , long initialDelay , delay ,TimeUnit)
		   
		  * withdrawl --10 seconds , run the task , 5 seconds , then start another withdrawl 
		 * 
		 * 
		 * 
		 * 
		 */
		
		
	}

}
