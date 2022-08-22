package com.test.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduleDemo {
	public static void main(String[] args) {
		
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		
		Runnable task1 = ()->System.out.println("welcome to scheduled task");
		Runnable task2=()->System.out.println("hi again");
		
		ScheduledFuture<?> result1=  service.scheduleAtFixedRate(task1,1,1,TimeUnit.SECONDS);
		ScheduledFuture<?> result2 = service.scheduleWithFixedDelay(task2,0,1,TimeUnit.MINUTES);
		
		
	}

}
