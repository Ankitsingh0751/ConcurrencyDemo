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
		
		/**
		 * 
		 * ExecutorService service = newFixedThreadPool(4);
		 * 
		 * if there are 5 tasks , all the 4 threads are occupied in running 4 tasks
		 * 
		 * blockingqueue  -- tasks in the queue ,5th task will be added to the queue , will 
		 *
		 *wait for thread from the pool to be available 
		 *
		 *
		 *
		 *ExecutorService service = newCachedThreadPool();
		 *it does not create any blocking queue , 4 tasks -4 threads to run task
		 *
		 *5 th task  -- it will create 5th thread
		 *1000 tasks -- 1000 tasks
		 *tasks are time consuming and they might run for long, might not release the thread
		 *newCachedThreadPool() -- only suitable for task
		 *reusability is possible 
		 *
		 *
		 *
		 *
		 *
		 *
		 */
	}

}
