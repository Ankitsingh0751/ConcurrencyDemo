package com.test.demo;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Coll1 {
	public static void main(String[] args) {
		
		var food=  new HashMap<String,Integer>();
		food.put("cow",1);
		food.put("penguin",2);
		food.put("tiger",3);
		var syncFood =  Collections.synchronizedMap(food);
		System.out.println(food);
		for(String key:syncFood.keySet()) {
			if(key.equals("cow"))
			food.remove(key);
			
		}
		System.out.println(food);
		
		
		Queue<Integer> data = new ConcurrentLinkedQueue<>();
		data.offer(31);
		data.offer(24);
		System.out.println(data.peek());
		System.out.println(data.poll());
		System.out.println(data);
		
		
		Set<String> animals =   new ConcurrentSkipListSet<>();
		animals.add("rabbit");
		animals.add("deer");
		
		System.out.println(animals.stream().collect(Collectors.joining("-------")));
		
		
		Map<String ,String> dietPlan = new ConcurrentSkipListMap<>();
		dietPlan.put("breakfast", "oatmeal");
		dietPlan.put("lunch", "jowar bhakri");
		
		dietPlan.entrySet().stream().forEach((e)->System.out.println(e.getKey()+""+e.getValue()));
		
		List<Integer> favNumbers= new CopyOnWriteArrayList<>(List.of(45,657,5,457,8));
		
		for(var num:favNumbers) {
			System.out.println(num);
			favNumbers.remove(num);
			
		}
		System.out.println(favNumbers.size());
		System.out.println(favNumbers);
		
		
		//LinkedBlockingQueue   -- offer and poll timeout
		
		
		try {
			
			var blockingQueue=new LinkedBlockingQueue<Integer>();
			blockingQueue.offer(34);
			blockingQueue.offer(23,3,TimeUnit.SECONDS);
			System.out.println(blockingQueue.poll());
			System.out.println(blockingQueue.poll(10,TimeUnit.MILLISECONDS));
			
			
		}
		catch(InterruptedException ie) {
			
			System.out.println("some interruption");
		}
		
		
		
	}

}
