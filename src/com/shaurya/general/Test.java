package com.shaurya.general;
public class Test {
    public static void main(String[] args) throws Exception {
    	Customer c = new Customer("Seema");
    	new Thread(()-> {c.withdraw(1000);}).start();;
    	new Thread(()-> {c.deposit(2000);}).start();;
    }
}

class Customer{
	int balance;
	String name;
	Customer(String name){
		this.balance = 0;
		this.name = name;
	}
	synchronized void deposit(int money) {
		System.out.println(name+" depostite money Rs"+money);
		balance+=money;
		notify();
		System.out.println(name+" notified other ");
	}
	
	synchronized void withdraw(int money) {
		System.out.println(name+" withdraw money Rs"+money);
		if(balance-money<0) {
			System.out.println("Running low balance\nPlease doposite money");
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("got intrupt");
			}
		}
		balance-=money;
		System.out.println("withdraw completed");
	}
}



