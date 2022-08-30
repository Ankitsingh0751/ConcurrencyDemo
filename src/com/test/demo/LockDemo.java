package com.test.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
	
	public static void printDetails(Lock lock) {
		
	try {
			lock.lock();
			for(int i=0;i<1000;i++);
			System.out.println("");
			System.out.println("in printDetails");
		
	         
	}
	catch(Exception e) {
		System.out.println("some exception");
	}
	finally {
			System.out.println("unlocking  the lock ");
			lock.unlock();
	}
	}
	public static void main(String[] args) {
		
		Lock lock=new ReentrantLock();
		new Thread(()->printDetails(lock)).start();
		if(lock.tryLock()) {
			try {
				
			System.out.println("lock objtained , entering the monitor for further process");
		}finally {
			
			lock.unlock();
		}}
		else {
			System.out.println("unable to acquire lock ,doing some other task");
			System.out.println("some other imp tasks ");
		}
		
	}

}
