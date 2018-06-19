package com.sanjeet.corejava.corejava.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
class SharedValue{
	public static int value=0;
	
}
class EvenPrint implements Runnable{
	private SharedValue value;
 private Lock lock=new ReentrantLock();
	@Override
	public void run() {
		while(value.value<=20){
		printEven(value.value);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		}
		
	}
	private void printEven(int count){
		
		if(count%2==0){
			lock.lock();
			System.out.println("Even =" +count);
			++value.value;
			lock.unlock();
		}
		
	}
	
}
class OddPrint implements Runnable{

	private SharedValue value;
	private Lock lock=new ReentrantLock();
	
	
	@Override
	public void run() {
		
		while(SharedValue.value<=20){
			printOdd(SharedValue.value);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			}
	private void printOdd(int count){
		
		if(count%2==1){
			lock.lock();
			System.out.println("odd =" +count );
			++SharedValue.value;
			lock.unlock();
		}
		

	}

	
}
public class OddEvenUsingLock {
public static void main(String[] args) {
	
	Thread t=new Thread(new OddPrint());
	Thread t1=new Thread(new EvenPrint());
	t.start();
	t1.start();
}
	
}
