package com.test.demo;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream; 
    public class Flavors {
       private static int counter;
       public static void countIceCreamFlavors()  {
          counter = 0;
          Runnable task = () -> counter++;
          LongStream.range(1, 500)
             .forEach(m -> new Thread(task).run());
          System.out.println(counter);
       }
       
       public static void main(String[] args) {
		Flavors.countIceCreamFlavors();
		List<Integer> lions = new ArrayList<>(List.of(1,2,3));
	    List<Integer> tigers = new CopyOnWriteArrayList<>(lions);
	    Set<Integer> bears = new ConcurrentSkipListSet<>();
	    bears.addAll(lions);
	    for(Integer item: tigers) tigers.add(4); // x1
	    for(Integer item: bears) bears.add(5); // x2
	    System.out.println(lions.size() + " " + tigers.size() 
	       + " " + bears.size());
	    System.out.println(lions+""+bears+""+tigers);
	    
	    Integer i1 = List.of(1, 2, 3, 4, 5).stream().findAny().get();
	    synchronized(i1) { // y1
	       Integer i2 = List.of(6, 7, 8, 9, 10)
	          .parallelStream()
	          .sorted()
	          .findAny().get(); // y2
	       System.out.println(i1 + " " + i2);
	    }
	    ExecutorService service = null;
	    try {
	       service = Executors.newFixedThreadPool(4);
	       service.execute(() -> takeNap());
	       service.execute(() -> takeNap());
	       service.execute(() -> takeNap());
	    } 
	     finally {
	       if (service != null) service.shutdown();
	    }
	    try {
			service.awaitTermination(2, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println("DONE!");
	    
	    System.out.print(List.of("duck","flamingo","pelican")
	    	       .parallelStream().parallel()   // q1
	    	       .reduce("",
	    	          (c1, c2) -> c1 + " "+c2));  // q2
	    
	    
	    
	    
	    Object o1 = new Object();
	    Object o2 = new Object();
	    var service1 = Executors.newFixedThreadPool(2);
	    var f1 = service1.submit(() -> {
	       synchronized (o1) {
	          synchronized (o2) { System.out.print("Tortoise"); }
	       }
	    });
	    var f2 = service1.submit(() -> {
	       synchronized (o2) {
	          synchronized (o1) { System.out.print("Hare"); }
	       }
	    });
	    try {
			f1.get();
			 f2.get();
  	       
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
		
	}

	private static Object takeNap() {
		// TODO Auto-generated method stub
		try {
			System.out.println("nap");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}
    }