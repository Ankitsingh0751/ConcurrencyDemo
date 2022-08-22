package com.test.demo;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
public class LionPenManager {
   private void removeLions() {System.out.println("Removing lions");}
   private void cleanPen() {System.out.println("Cleaning the pen");}
   private void addLions() {System.out.println("Adding lions");}
   public void performTask(CyclicBarrier c1, CyclicBarrier c2) {
      try {
         removeLions();
         c1.await();
         cleanPen();
         c2.await();
         addLions();
      } catch (InterruptedException | BrokenBarrierException e) {
         // Handle checked exceptions here
      }
   }
   private static int doWork(int input) {
	   try {
	      Thread.sleep(5000);
	   } catch (InterruptedException e) {}
	   return input;
	}
   public static void main(String[] args) {
	   
	   long start = System.currentTimeMillis();
	   List.of(1,2,3,4,5)
	      .parallelStream()
	      .map(w -> doWork(w))
	      .forEach(s -> System.out.print(s + " "));
	    
	   System.out.println();
	   var timeTaken = (System.currentTimeMillis()-start)/1000;
	   System.out.println("Time: "+timeTaken+" seconds");
	   try {
		   var blockingQueue = new LinkedBlockingQueue<Integer>();
		   blockingQueue.offer(39);
		   blockingQueue.offer(3, 4, TimeUnit.SECONDS);
		   System.out.println(blockingQueue.poll());
		   System.out.println(blockingQueue.poll(10, TimeUnit.MILLISECONDS));
		} catch (InterruptedException e) {
		  System.out.println("interrupted");
		  
		}
	   List<Integer> favNumbers = 
			   new CopyOnWriteArrayList<>(List.of(4,3,42));
			for(var n: favNumbers) {
			   System.out.print(n + " ");
			   favNumbers.add(9);
			}
			System.out.println();
			System.out.println("Size: " + favNumbers.size());
			System.out.println(favNumbers);
      ExecutorService service = null;
      try {
         service = Executors.newFixedThreadPool(4);
         var manager = new LionPenManager();
         var c1 = new CyclicBarrier(4);
         var c2 = new CyclicBarrier(4, 
            () -> System.out.println("*** Pen Cleaned!"));
         for (int i = 0; i < 4; i++)
            service.submit(() -> manager.performTask(c1, c2));
      } finally {
         if (service != null) service.shutdown();
      }
   }
}