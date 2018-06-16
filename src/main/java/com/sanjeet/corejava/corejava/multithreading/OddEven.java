package com.sanjeet.corejava.corejava.multithreading;



class SharedNumber {
	public int value=1;

	/*public SharedNumber(int value) {
		
		this.value = value;
	}
*/	
	
}

class OddPrinter implements Runnable {
	private SharedNumber shared;

	public OddPrinter(SharedNumber shared) {
		this.shared = shared;
	}

	public void run() {
		while (shared.value <= 20)
			printOdd(shared.value++);
	}

	private void printOdd(int value) {
		synchronized (shared) {
			if (value % 2 == 1) {
				
				System.out.println("Odd =" + value);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				shared.notifyAll();
			}
			try {
				shared.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class EvenPrinter implements Runnable {
	private SharedNumber shared;

	public EvenPrinter(SharedNumber shared) {
		this.shared = shared;
	}

	public void run() {
		while (shared.value <= 20) {
			printEven(shared.value++);

		}
	}

	private void printEven(int value){
		synchronized(shared){
			if(value%2==0){
				
				System.out.println("Even ="+value);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				shared.notifyAll();
			}
			try{
			shared.wait();
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}


public class OddEven {

	public static void main(String[] args) {
		SharedNumber sharedNumber=new SharedNumber();
		Thread t1=new Thread(new OddPrinter(sharedNumber),"OddPrinter");
		Thread t2=new Thread(new EvenPrinter(sharedNumber),"EvenPrinter");
		t1.start();
		t2.start();
		
	}
}
