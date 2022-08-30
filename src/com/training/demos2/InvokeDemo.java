package com.training.demos2;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class Account{
	private long id;
	private double balance;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Account(long id, double balance) {
		super();
		this.id = id;
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + "]";
	}
	
	public double deposit(double amt) {
		return balance+=amt;
		
	}
	
	public double withdrawl(double amt) throws LessFundsException {
		if(amt > balance) {throw new LessFundsException("not enough funds");}
		else
			balance-=amt;
		return balance;
		
	}
	
	public double transferFunds(Account otherAccount,double amt) throws LessFundsException {
		this.withdrawl(amt);
		otherAccount.deposit(amt);
		return this.balance;
		
	}
}
public class InvokeDemo {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		ExecutorService service = null;
		System.out.println("starting main thread");
		try
		{service =  Executors.newSingleThreadExecutor();
		Account rishi= new Account(22323,34000);
		Account divya = new Account(45454,20000);
		
		Callable<Double> task = ()-> rishi.transferFunds(divya, 1000);
		
		//List<Future<Double>> list = service.invokeAll(List.of(task,task,task) , 2,TimeUnit.SECONDS);
		

		Double result = service.invokeAny(List.of(task,task,task) , 2,TimeUnit.SECONDS);
		
		System.out.println(result);
		/**
		 * 
		 * invokeAll() method waits indefinitely for tasks to complete
		 * 
		 * invokeAny(List of tasks , it waits for 1st task to complete , once one task is complete ,it cancels all pending tasks
		 * 
		 */
		
		
		/*
		 * for(Future<Double> futureObject : list) {
		 * System.out.println(futureObject.get(1,TimeUnit.SECONDS));
		 * 
		 * 
		 * }
		 */
		System.out.println("ending the main thread");
	}
		finally {
			
		if(service != null) {
			service.shutdown();
			
		}
		}
		}

}
