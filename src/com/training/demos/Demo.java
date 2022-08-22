package com.training.demos;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Demo {
public static void main(String[] args) {
	

	
	Callable c=new Callable() {
		public Object run() {
			return 10;
		}

		@Override
		public Object call() throws Exception {
			// TODO Auto-generated method stub
			return null;
		}
		
		
		
	};
	var s=Executors.newScheduledThreadPool(1);
	
    Future f=s.submit(c);
    
    try {
		f.get();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ExecutionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    s.shutdown();
    System.out.println("Done");
}
	
}
