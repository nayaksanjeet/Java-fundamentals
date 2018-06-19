package com.sanjeet.corejava.corejava.multithreading;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

 class ThreadLocalDemo1 implements Runnable{
	
	private static final AtomicInteger id=new AtomicInteger(0);
	private static ThreadLocal<Integer> tlocalId=new ThreadLocal<Integer>(){
		protected Integer initialValue() {
			return id.incrementAndGet();
		}
	};
	
	private static ThreadLocal<Date> threadTime=new ThreadLocal<Date>(){
		@SuppressWarnings("unused")
		protected Date intialValue(){
			return new Date();
		}
	};
	@Override
	public void run() {
		System.out.println("start "+tlocalId.get() +" "+threadTime.get());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end "+tlocalId.get()+" "+threadTime.get());
		
	}
	
	

}
 public class ThreadLocalDemo{
	 public static void main(String[] args) {
		Thread t=new Thread(new ThreadLocalDemo1());
		t.start();
		Thread t1=new Thread(new ThreadLocalDemo1());
		t1.start();
		Thread t2=new Thread(new ThreadLocalDemo1());
		t2.start();
	}
 } 
