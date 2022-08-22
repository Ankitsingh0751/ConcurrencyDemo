package com.test.demo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Demo2 {
	public static void main(String[] args) {
		ExecutorService service=Executors.newSingleThreadExecutor();
		Future<?> future=service.submit(()->System.out.println("hello"));
		System.out.println(future.isDone());
		try {
			System.out.println(future.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
