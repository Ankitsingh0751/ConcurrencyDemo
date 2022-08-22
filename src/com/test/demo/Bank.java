package com.test.demo;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;
    public class Bank {
       private Lock vault = new ReentrantLock();
       private int total = 0;
       public void deposit(int value) {
          try {
             vault.tryLock();
             total += value;
          } finally {
             vault.unlock();
          }
       }
       public static void main(String[] unused) {
          var bank = new Bank();
          IntStream.range(1, 10).parallel()
             .forEach(s -> bank.deposit(s));
          System.out.println(bank.total);
       
       
    
    
       ExecutorService service =   // w1
    	       Executors.newSingleThreadScheduledExecutor();
       
    	    ((ScheduledExecutorService) service).scheduleWithFixedDelay(() -> {
    	       System.out.println("Open Zoo");
    	      // w2
    	    }, 0, 1, TimeUnit.MINUTES);
    	    var result = service.submit(() ->   // w3
    	       System.out.println("Wake Staff"));
    	    try {
				System.out.println(result.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}   // w4
    
       
       
       
       
    	    var value1 = new AtomicLong(0);
    	    final long[] value2 = {0};
    	    IntStream.iterate(1, i -> 1).limit(100).parallel()
    	       .forEach(i -> value1.incrementAndGet());
    	    IntStream.iterate(1, i -> 1).limit(100).parallel()
    	       .forEach(i -> ++value2[0]);
    	    System.out.println(value1+" "+value2[0]);
    	    
    	    
    	    var data = List.of(2,5,1,9,8);
    	       data.stream().parallel()
    	          .mapToInt(s -> s)
    	          .peek(System.out::println)
    	          .forEachOrdered(System.out::println);
       
       }
       
    
    
    
    
    }