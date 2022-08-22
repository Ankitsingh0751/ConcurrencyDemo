package com.training.demos;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicData {
	private AtomicBoolean coin = new AtomicBoolean(false);
	void flip() {
		coin.getAndSet(!coin.get());
	}
	   
   public static void main(String[] args) throws InterruptedException {
	   
	   var original = List.of(1,2,3,4,5);
	   var copy1 = new CopyOnWriteArrayList<Integer>(original);
	   for(Integer w : copy1)
	    copy1.remove(w);
	   
	   var copy4 = new ConcurrentLinkedQueue<Integer>(original);
	   for(Integer w : copy4)
	    copy4.remove(w);
	var luck= new AtomicData();
	ExecutorService s =  Executors.newCachedThreadPool();
	
	for(int i=0;i<100;i++) {
		s.execute(()->luck.flip());
	}
	   s.shutdown();
	   Thread.sleep(2000);
	   System.out.println(luck.coin.get());
}
}
