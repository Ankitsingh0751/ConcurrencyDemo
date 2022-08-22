package com.test.demo;

public class Account {
	
	private long id;
	private double balance;
	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + "]";
	}
	public Account(long id, double balance) {
		super();
		this.id = id;
		this.balance = balance;
	}
	
	public synchronized double withdrawl(double amt) throws LessFundsException{
		
		
		if(amt < balance) {
			this.balance -= amt;
			
		}
		else
			throw new LessFundsException("not enough funds");
		System.out.println("the balance is "+this.balance);
		
		return this.balance;
		
	}

	 private double deposit(double amt) {
		 return this.balance+=amt;
	 }
	 
	 private double transfer(Account a,double amt) throws LessFundsException {
		 
		 this.withdrawl(amt);
		 a.deposit(amt);
		 
		 return this.balance;
		 
	 }
}
