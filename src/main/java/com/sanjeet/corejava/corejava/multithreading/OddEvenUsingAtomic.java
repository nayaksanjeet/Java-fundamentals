package com.sanjeet.corejava.corejava.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

class Shared{
	public static AtomicInteger value=new AtomicInteger();
}
class OddResult implements Runnable{

	@Override
	public void run() {
		while(Shared.value.get()<20){
			printOdd(Shared.value.get());
		}
		
	}
	private void printOdd(int count){
		if(count%2==1)
		System.out.println("Odd : "+count);
		Shared.value.incrementAndGet();
	}
}
class EvenResult implements Runnable{

	@Override
	public void run() {
		while(Shared.value.get()<20){
			printEven(Shared.value.get());
		}
		
	}
	private void printEven(int count){
		if(count%2==0)
			System.out.println("Even : "+count);
		Shared.value.incrementAndGet();
	}
	
}
public class OddEvenUsingAtomic {

	public static void main(String[] args) {
		Thread t=new Thread(new OddResult());
		Thread t1=new Thread(new EvenResult());
		t.start();
		t1.start();
	}
}
